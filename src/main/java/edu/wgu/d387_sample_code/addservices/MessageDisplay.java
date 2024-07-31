package edu.wgu.d387_sample_code.addservices;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageDisplay implements Runnable {

    Locale locale;

    public MessageDisplay(Locale locale) {
        this.locale = locale;
    }

    public String getWelcomeMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle("translation",locale);
        return bundle.getString("welcome");
    }

    @Override
    public void run() {
        System.out.println( "Thread verification: " + getWelcomeMessage() + ", ThreadID: " + Thread.currentThread().getId() );
    }
}