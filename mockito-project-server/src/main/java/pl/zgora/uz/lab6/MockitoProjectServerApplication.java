package pl.zgora.uz.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories("pl.zgora.uz.lab6.interfaces")
public class MockitoProjectServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoProjectServerApplication.class, args);
	}

}
