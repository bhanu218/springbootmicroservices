package du20464813.foundation.bank.customer.client;

import du20464813.foundation.bank.customer.DTO.AccountDTO;
import du20464813.foundation.bank.customer.DTO.AccountTransferRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ACCOUNT", contextId = "account",fallbackFactory = AccountServiceFallbackFactory.class)
public interface AccountServiceClient {

    @PostMapping("/account/fund")
    public String transferFund(@RequestBody AccountTransferRequestDTO accountTransferRequestDTO);
    @PostMapping("/account/add")
    public String add(@RequestBody AccountDTO accountDTO);


}
