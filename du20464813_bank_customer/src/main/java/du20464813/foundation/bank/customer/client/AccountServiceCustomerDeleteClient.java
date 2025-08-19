package du20464813.foundation.bank.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT", contextId = "accountDelete",fallback = AccountServiceCustomerIdFallback.class)
public interface AccountServiceCustomerDeleteClient {

    @DeleteMapping("/account/{customerId}")
    public  String deleteCustomerById(@PathVariable Long customerId);


}
