package du20464813.foundation.bank.customer.client;

import du20464813.foundation.bank.customer.DTO.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class AccountServiceCustomerIdFallback implements AccountServiceCustomerIdClient{
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceCustomerIdFallback.class);
    @Override
    public List<AccountDTO> getAccountsByCustomerId(Long customerId) {
        logger.error("Fallback triggered: Account service is unavailable for customer ID {}", customerId);

        // Return an empty list (safe, non-breaking)
        return Collections.emptyList();
    }
}
