package edu.wgu.d387_sample_code.addservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/time")
public class TimeConvController {

    private final TimeConv timeConv;

    public TimeConvController() {
        this.timeConv = new TimeConv();
    }

    @GetMapping("/convert")
    public String getConvertedTimes() {
        ZonedDateTime currentTime = ZonedDateTime.now();
        return timeConv.convertTimes(currentTime);
    }
}
