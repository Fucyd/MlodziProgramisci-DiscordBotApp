package pl.michalski.botapp;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class BotappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotappApplication.class, args);
	}

}
