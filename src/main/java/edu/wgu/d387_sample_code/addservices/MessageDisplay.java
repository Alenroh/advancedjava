package edu.wgu.d387_sample_code.addservices;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageDisplay {
    public static String getWelcomeMessage(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("LanguageResources", locale);
        return bundle.getString("welcome.message");
    }
}
