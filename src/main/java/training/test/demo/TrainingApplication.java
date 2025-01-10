package training.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TrainingApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TrainingApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

}
