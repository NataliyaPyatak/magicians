package ru.npyatak.magician;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ru.npyatak.magician.services.HarryPotterMagicianService;
import ru.npyatak.magician.services.MagicianService;
import ru.npyatak.magician.services.RussianFairyTaleMagicianService;

@SpringBootApplication
@EnableJpaRepositories("ru/npyatak/magician/repositiry")
@EntityScan("ru/npyatak/magician/model")
public class MagicianApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicianApplication.class, args);
	}

	/*@Bean
	public MagicianService getMagicianService()
	{
		return new HarryPotterMagicianService();
	}*/
}
