package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FoxandhoundsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FoxandhoundsApplication.class, args);
    GameService gameService = applicationContext.getBean(GameService.class);
    gameService.play();
	}

}
