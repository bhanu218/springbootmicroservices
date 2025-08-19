package du20464813.foundation.bank.customer.client;

import du20464813.foundation.bank.customer.DTO.AccountDTO;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACCOUNT", contextId = "account1",fallback = AccountServiceCustomerIdFallback.class)
@Retry(name = "ACCOUNT")
public interface AccountServiceCustomerIdClient {
    @GetMapping("/account/{customerId}")
    public List<AccountDTO> getAccountsByCustomerId(@PathVariable("customerId") Long customerId);

}
