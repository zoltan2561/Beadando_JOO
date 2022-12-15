package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class FoxandhoundsApplication {

	public FoxandhoundsApplication() throws SQLException {
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FoxandhoundsApplication.class, args);
    GameService gameService = applicationContext.getBean(GameService.class);
    gameService.play();
	}

}
