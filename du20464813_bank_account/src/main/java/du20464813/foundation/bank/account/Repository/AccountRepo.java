package du20464813.foundation.bank.account.Repository;

import du20464813.foundation.bank.account.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
    List<Account> findByCustomerId(Long customerId);
}
