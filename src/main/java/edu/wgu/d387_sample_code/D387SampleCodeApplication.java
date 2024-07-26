package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.addservices.MessageDisplay;
import edu.wgu.d387_sample_code.addservices.MessageDisplayRunnable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		// Create instances of MessageDisplay
		MessageDisplay MessageDisplay = new MessageDisplay();

		// Define locales
		Locale enUS = Locale.forLanguageTag("en-US");
		Locale frCA = Locale.forLanguageTag("fr-CA");

		// Create and start threads
		Thread thread1 = new Thread(new MessageDisplayRunnable(MessageDisplay, enUS));
		Thread thread2 = new Thread(new MessageDisplayRunnable(MessageDisplay, frCA));

		thread1.start();
		thread2.start();
	}
}
