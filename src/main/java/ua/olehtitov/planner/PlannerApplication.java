package ua.olehtitov.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.RequiredArgsConstructor;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class PlannerApplication {
	private final SimpleEchoBot simpleEchoBot;

	public static void main(String[] args) {
		SpringApplication.run(PlannerApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		System.out.println(simpleEchoBot.getBotUsername());
		System.out.println(simpleEchoBot.getBotToken());
	}
}
