package edu.wgu.d387_sample_code.addservices;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageDisplay {

    public static String getWelcomeMessage(Locale locale) {
        // Customize the base name according to your file paths
        String baseName = "C:/Users/Jules/IdeaProjects/d387-advanced-java/LanguageResources";
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        return bundle.getString("welcomeMessage");
    }
}
