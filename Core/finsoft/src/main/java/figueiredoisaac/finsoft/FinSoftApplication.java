package figueiredoisaac.finsoft;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinSoftApplication {

	Dotenv dotenv = Dotenv.configure().load();
	public static void main(String[] args) {
		SpringApplication.run(FinSoftApplication.class, args);
	}

}
