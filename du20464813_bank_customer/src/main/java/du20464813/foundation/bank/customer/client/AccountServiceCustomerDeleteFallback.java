package du20464813.foundation.bank.customer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceCustomerDeleteFallback implements AccountServiceCustomerDeleteClient{
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceCustomerIdFallback.class);

    @Override
    public String deleteCustomerById(Long customerId) {
        logger.error("Fallback triggered: Account service is unavailable for customer ID {}", customerId);

        return "please retry";
    }
}
