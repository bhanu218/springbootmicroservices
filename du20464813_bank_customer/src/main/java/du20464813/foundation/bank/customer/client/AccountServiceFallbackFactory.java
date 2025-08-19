package du20464813.foundation.bank.customer.client;

import du20464813.foundation.bank.customer.DTO.AccountDTO;
import du20464813.foundation.bank.customer.DTO.AccountTransferRequestDTO;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceFallbackFactory implements FallbackFactory<AccountServiceClient> {
    @Override
    public AccountServiceClient create(Throwable cause) {
        return new AccountServiceClient() {

            @Override
            public String transferFund(AccountTransferRequestDTO accountTransferRequestDTO) {
                // Log the cause or return a custom message
                return "Fallback: Unable to transfer funds at the moment. Please try again later.";
            }

            @Override
            public String add(AccountDTO accountDTO) {
                return "Fallback: Unable to add account at the moment. Please try again later.";
            }
        };
    }
}
