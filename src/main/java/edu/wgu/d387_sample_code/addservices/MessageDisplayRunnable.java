package edu.wgu.d387_sample_code.addservices;

import java.util.Locale;

public class MessageDisplayRunnable implements Runnable {
    private Locale locale;

    public MessageDisplayRunnable(MessageDisplay messageDisplay, Locale locale) {
        this.locale = locale;
    }

    @Override
    public void run() {
        String message = MessageDisplay.getWelcomeMessage(locale);
        System.out.println("Locale: " + locale + " - Message: " + message);
    }

    public static void main(String[] args) {
        MessageDisplay MessageDisplay = new MessageDisplay();
        Thread thread1 = new Thread(new MessageDisplayRunnable(MessageDisplay, new Locale("en", "US")));
        Thread thread2 = new Thread(new MessageDisplayRunnable(MessageDisplay, new Locale("fr", "CA")));

        thread1.start();
        thread2.start();
    }
}
