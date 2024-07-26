package edu.wgu.d387_sample_code.addservices;

import java.util.Locale;

public class MessageDisplayRunnable implements Runnable {
    private final MessageDisplay messageDisplay;
    private final Locale locale;

    public MessageDisplayRunnable(MessageDisplay messageDisplay, Locale locale) {
        this.messageDisplay = messageDisplay;
        this.locale = locale;
    }

    @Override
    public void run() {
        String message = MessageDisplay.getWelcomeMessage(locale);
        System.out.println("Welcome message for locale " + locale + ": " + message);
    }
}
