package du20464813.foundation.bank.customer.Controller;

import du20464813.foundation.bank.customer.DTO.AccountDTO;
import du20464813.foundation.bank.customer.DTO.AccountTransferRequestDTO;
import du20464813.foundation.bank.customer.DTO.CustomerDTO;
import du20464813.foundation.bank.customer.Entity.Customer;
import du20464813.foundation.bank.customer.Service.CustomerService;
import du20464813.foundation.bank.customer.Service.CustomerServiceImpl;
import du20464813.foundation.bank.customer.client.AccountServiceClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;



    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id){

        Customer cus=customerService.updateCustomer(customer,id);
        return ResponseEntity.ok(cus);
    }
    @GetMapping("/list")
    public ResponseEntity<List<CustomerDTO>> customerDetails(){
        List<CustomerDTO> dto=customerService.getDetails();

      return ResponseEntity.ok(dto);
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> transfer(@Validated @RequestBody AccountTransferRequestDTO accountTransferRequestDTO){
           return  customerServiceImpl.transfer(accountTransferRequestDTO);

    }
    @PostMapping("/add/account")
    public ResponseEntity<String> add(@RequestBody AccountDTO accountDTO){
        return customerServiceImpl.add(accountDTO);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){

        return customerServiceImpl.deleteBycustomerId(id);
    }

}
