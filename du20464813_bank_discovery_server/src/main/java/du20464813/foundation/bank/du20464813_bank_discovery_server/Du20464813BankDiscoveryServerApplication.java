package du20464813.foundation.bank.du20464813_bank_discovery_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Du20464813BankDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Du20464813BankDiscoveryServerApplication.class, args);
	}

}
