package du20464813.foundation.bank.account.Controller;

import du20464813.foundation.bank.account.DTO.AccountDTO;
import du20464813.foundation.bank.account.DTO.TransferRequest;
import du20464813.foundation.bank.account.Entity.Account;
import du20464813.foundation.bank.account.Entity.AccountResponse;
import du20464813.foundation.bank.account.Service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @PostMapping("/add")
    public ResponseEntity<String> addingAcc(@RequestBody Account account){
        AccountResponse response=accountServiceImpl.addAccount(account);
        if(response.isSuccess()){
            return ResponseEntity.status(HttpStatus.CREATED).body(response.getMessage());
        }
       return ResponseEntity.badRequest().body(response.getMessage());
    }
    @PostMapping("/fund")
    public ResponseEntity<String> transferFund(@RequestBody TransferRequest request){

        accountServiceImpl.funTransfer(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getBalance()
        );
        return ResponseEntity.ok("successfully Transaction is completed");
    }

    @GetMapping("/list")
    public  ResponseEntity<List<Account>> accountList(){
         return ResponseEntity.ok().body(accountServiceImpl.list());

    }
    @GetMapping("/{customerId}")
    public ResponseEntity<List<AccountDTO>> getAccountByCustomerId(@PathVariable Long customerId){
        List<AccountDTO> account=accountServiceImpl.getAccountsByCustomerId(customerId);
        return ResponseEntity.ok().body(account);
    }

    @DeleteMapping("/{customerId}")
    public String deleteAccount(@PathVariable Long customerId){
        return accountServiceImpl.deleteByCustomerId(customerId);
    }



}
