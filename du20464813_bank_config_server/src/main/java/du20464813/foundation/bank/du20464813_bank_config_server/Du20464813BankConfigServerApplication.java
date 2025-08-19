package du20464813.foundation.bank.du20464813_bank_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Du20464813BankConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Du20464813BankConfigServerApplication.class, args);
	}

}
