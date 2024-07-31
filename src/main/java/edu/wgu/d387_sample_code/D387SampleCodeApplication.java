package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.addservices.MessageDisplay;
import edu.wgu.d387_sample_code.addservices.TimeConv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);


		MessageDisplay welcomeMessageEnglish = new MessageDisplay(Locale.US);
		Thread englishWelcomeThread = new Thread(welcomeMessageEnglish);
		englishWelcomeThread.start();

		MessageDisplay welcomeMessageFrench = new MessageDisplay(Locale.CANADA_FRENCH);
		Thread frenchWelcomeThread = new Thread(welcomeMessageFrench);
		frenchWelcomeThread.start();

	}

}

