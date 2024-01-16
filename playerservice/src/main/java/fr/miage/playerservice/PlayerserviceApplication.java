package fr.miage.playerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PlayerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerserviceApplication.class, args);
	}

}
