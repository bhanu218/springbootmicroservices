package du20464813.foundation.bank.customer.Service;

import du20464813.foundation.bank.customer.DTO.CustomerDTO;
import du20464813.foundation.bank.customer.Entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public Customer updateCustomer(Customer customer, Long id);
    public List<CustomerDTO> getDetails();
    public  String deleteBycustomerId(Long id);

}
