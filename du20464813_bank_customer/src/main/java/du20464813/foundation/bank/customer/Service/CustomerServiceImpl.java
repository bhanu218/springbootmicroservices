package du20464813.foundation.bank.customer.Service;

import du20464813.foundation.bank.customer.DTO.AccountDTO;
import du20464813.foundation.bank.customer.DTO.AccountTransferRequestDTO;
import du20464813.foundation.bank.customer.DTO.CustomerDTO;
import du20464813.foundation.bank.customer.Entity.Customer;
import du20464813.foundation.bank.customer.Exception.AccountServiceException;
import du20464813.foundation.bank.customer.Exception.NotFoundException;
import du20464813.foundation.bank.customer.Repository.CustomerRepo;
import du20464813.foundation.bank.customer.client.AccountServiceClient;
import du20464813.foundation.bank.customer.client.AccountServiceCustomerDeleteClient;
import du20464813.foundation.bank.customer.client.AccountServiceCustomerIdClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private AccountServiceClient accountServiceClient;
    @Autowired
    private AccountServiceCustomerIdClient accountServiceCustomerIdClient;
    @Autowired
    private AccountServiceCustomerDeleteClient accountServiceCustomerDeleteClient;
    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Customer cust=customerRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Customer id is not found" + id));
        cust.setCustomerStatus(customer.getCustomerStatus());
        cust.setAddress(customer.getAddress());
        cust.setEmail(customer.getEmail());
        cust.setCreatedDate(cust.getCreatedDate());
        cust.setLastUpdatedDate(LocalDate.now());
        cust.setCity(customer.getCity());
        cust.setPhone(customer.getPhone());
        cust.setGender(customer.getGender());
        cust.setPostalCode(customer.getPostalCode());
        cust.setState(customer.getState());
        cust.setFirstName(customer.getFirstName());
        cust.setLastName(customer.getLastName());


        Customer updated=customerRepo.save(cust);

        return updated;

    }

    @Override
    public List<CustomerDTO> getDetails() {
           List<Customer> cust= customerRepo.findAll();
        return cust.stream().map(
                customer -> {
                    CustomerDTO dto = new CustomerDTO();
                    dto.setId(customer.getId());
                    dto.setFirstName(customer.getFirstName());
                    dto.setLastName(customer.getLastName());
                    dto.setGender(customer.getGender());
                    dto.setDateOfBirth(customer.getDateOfBirth());
                    dto.setCity(customer.getCity());
                    dto.setAddress(customer.getAddress());
                    dto.setState(customer.getState());
                    dto.setEmail(customer.getEmail());
                    dto.setPhone(customer.getPhone());
                    dto.setStatus(customer.getCustomerStatus());
                    try {
                        List<AccountDTO> accounts = accountServiceCustomerIdClient.getAccountsByCustomerId(customer.getId());
                        dto.setAccountDTO(accounts); // ✅ set account list
                    } catch (FeignException ex) {
                        // Optional: log and continue with empty account list
                        dto.setAccountDTO(new ArrayList<>());
                    }

                    return dto;}
        ).collect(Collectors.toList());

    }

    @Override
    public String deleteBycustomerId(Long id) {
        try {
            if(customerRepo.findById(id).isPresent()){
                customerRepo.deleteById(id);
                accountServiceCustomerDeleteClient.deleteCustomerById(id);

            } else{
                accountServiceCustomerDeleteClient.deleteCustomerById(id);
                return "customer not found";
            }
        }catch(FeignException ex) {
            throw new AccountServiceException(ex.status(), ex.contentUTF8());
        }


        return "customer account have been deleted form our bank";
    }

    public ResponseEntity<String> transfer(AccountTransferRequestDTO requestDTO){
        try {
            String result =accountServiceClient.transferFund(requestDTO);
            return ResponseEntity.ok(result);
        }catch (FeignException ex) {
            throw new AccountServiceException(ex.status(), ex.contentUTF8());
        }
    }
    public  ResponseEntity<String > add(AccountDTO accountDTO) {
        try {
            String result = accountServiceClient.add(accountDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (FeignException ex) {
            throw new AccountServiceException(ex.status(), ex.contentUTF8());
        }


    }
}


