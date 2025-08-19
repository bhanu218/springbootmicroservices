package du20464813.foundation.bank.account.Service;

import du20464813.foundation.bank.account.DTO.AccountDTO;
import du20464813.foundation.bank.account.Entity.Account;
import du20464813.foundation.bank.account.Entity.AccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {


    public AccountResponse addAccount(Account account);
    public void funTransfer(Long fromAccountId,Long toAccountId, Double balance);
    public List<Account> list();

    public List<AccountDTO> getAccountsByCustomerId(Long customerId);
    public String deleteByCustomerId(Long customerId);
}
