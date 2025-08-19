package du20464813.foundation.bank.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Du20464813BankCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Du20464813BankCustomerApplication.class, args);
	}

}
