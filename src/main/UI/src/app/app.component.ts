import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { WelcomeService } from './welcome.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private readonly baseURL: string = 'http://localhost:8080';
  private readonly getUrl: string = `${this.baseURL}/room/reservation/v1/`;
  private readonly postUrl: string = `${this.baseURL}/room/reservation/v1`;

  public submitted: boolean = false;
  public roomsearch!: FormGroup;
  public rooms!: Room[];
  private request!: ReserveRoomRequest;
  private currentCheckInVal!: string;
  private currentCheckOutVal!: string;
  convertedTimes: string = '';

  // Observable properties
  welcomeMessageFrench$!: Observable<string>;
  welcomeMessageEnglish$!: Observable<string>;
  announcePresentation$!: Observable<string>;

  constructor(private httpClient: HttpClient, private welcomeService: WelcomeService) {}

  ngOnInit() {
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    this.roomsearch.valueChanges.subscribe(x => {
      this.currentCheckInVal = x.checkin;
      this.currentCheckOutVal = x.checkout;
    });

    this.welcomeMessageFrench$ = this.welcomeService.getWelcomeMessage('fr');
    this.welcomeMessageEnglish$ = this.welcomeService.getWelcomeMessage('en');
    this.announcePresentation$ = this.welcomeService.getAnnouncePresentation();

    this.getConvertedTimes();
  }

  getConvertedTimes(): void {
    this.httpClient.get('/api/time/convert', { responseType: 'text' }).subscribe(
      (data: string) => {
        this.convertedTimes = data;
      },
      (error: any) => {
        console.error('Error fetching converted times', error);
      }
    );
  }

  onSubmit({ value, valid }: { value: Roomsearch, valid: boolean }) {
    if (valid) {
      this.getAllRooms().subscribe(
        rooms => {
          this.rooms = <Room[]>rooms;
          this.rooms.forEach(room => {
            room.priceEUR = (parseFloat(room.price) * 0.85).toFixed(2); // Example conversion rate
            room.priceCAD = (parseFloat(room.price) * 1.25).toFixed(2); // Example conversion rate
          });
        }
      );
    }
  }

  reserveRoom(roomId: string) {
    this.request = new ReserveRoomRequest(roomId, this.currentCheckInVal, this.currentCheckOutVal);
    this.createReservation(this.request);
  }

  private createReservation(body: ReserveRoomRequest) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.httpClient.post(this.postUrl, body, { headers })
      .subscribe(res => console.log(res));
  }

  private getAllRooms(): Observable<any> {
    const params = `?checkin=${this.currentCheckInVal}&checkout=${this.currentCheckOutVal}`;
    return this.httpClient.get(this.getUrl + params, { responseType: 'json' });
  }
}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}

export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
  priceCAD?: string;
  priceEUR?: string;
}

export class ReserveRoomRequest {
  constructor(
    public roomId: string,
    public checkin: string,
    public checkout: string
  ) {}
}
