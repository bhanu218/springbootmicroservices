package du20464813.foundation.bank.customer.Repository;

import du20464813.foundation.bank.customer.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
