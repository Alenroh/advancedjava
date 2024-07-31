package edu.wgu.d387_sample_code.addservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@CrossOrigin(origins = "http://localhost:4200") // Needed for front end
@RestController
public class WController {

    @GetMapping("/welcome")
    public ResponseEntity<String> displayWelcome (@RequestParam("lang") String lang) { // Request the html lang parameter here
        Locale locale = Locale.forLanguageTag(lang); // create locale object based on lang parameter
        MessageDisplay messageDisplay = new MessageDisplay(locale); // create welcomeMessage to pull the corresponding lang
        return new ResponseEntity<String> (messageDisplay.getWelcomeMessage(), HttpStatus.OK);}}