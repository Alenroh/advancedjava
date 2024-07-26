package edu.wgu.d387_sample_code.addservices;

import edu.wgu.d387_sample_code.addservices.MessageDisplay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/welcome")
public class WController {

    private final MessageDisplay messageDisplay;

    public WController() {
        this.messageDisplay = new MessageDisplay();
    }

    @GetMapping
    public String getWelcomeMessage(@RequestHeader(value = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = acceptLanguage != null ? Locale.forLanguageTag(acceptLanguage) : Locale.getDefault();
        return messageDisplay.getWelcomeMessage(locale);
    }
}
