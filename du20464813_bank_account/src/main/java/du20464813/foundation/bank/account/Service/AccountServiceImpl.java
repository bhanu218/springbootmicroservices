package du20464813.foundation.bank.account.Service;

import du20464813.foundation.bank.account.DTO.AccountDTO;
import du20464813.foundation.bank.account.Entity.Account;
import du20464813.foundation.bank.account.Entity.AccountResponse;
import du20464813.foundation.bank.account.Exception.InsufficientFundException;
import du20464813.foundation.bank.account.Exception.InvalidAccountNumberException;
import du20464813.foundation.bank.account.Exception.NotFoundException;
import du20464813.foundation.bank.account.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepo accountRepo;
    @Override
    public List<Account> list()  {
        List<Account> acc=accountRepo.findAll();
        if(acc.isEmpty() ){
            throw new NotFoundException("No record Found");
        }else{
            return acc;
        }

    }

    @Override
    public List<AccountDTO> getAccountsByCustomerId(Long customerId) {
        List<Account> accounts =accountRepo.findByCustomerId(customerId);
            if (accounts.isEmpty()){
                throw new NotFoundException("there is no customer Id found in database");
            }
        return accounts.stream().map(
                account ->{
                    AccountDTO accountDTO=new AccountDTO();
                    accountDTO.setAccountType(account.getAccountType());
                    accountDTO.setBalance(account.getBalance());
                    accountDTO.setOwnershipType(account.getOwnershipType());
                    accountDTO.setId(account.getId());
                    accountDTO.setAccountNumber(account.getAccountNumber());
                    accountDTO.setBranchCode(account.getBranchCode());
                    accountDTO.setCustomerId(account.getCustomerId());
                    return accountDTO;
                }
        ).collect(Collectors.toList());
    }




    @Override
    public AccountResponse addAccount(Account account) {
        try{
            if (account.getAccountNumber()==null) {
                return new AccountResponse(false, "Account number is required");
            }
            else if (account.getBranchCode()== null) {
                return new AccountResponse(false, "Account Branch code is required");
            }
                accountRepo.save(account);
                return new AccountResponse(true,"account is successfully created");

            }catch (Exception e){
            return new AccountResponse(false,e.getMessage());
        }
    }


    @Override
    public void funTransfer(Long fromAccountId, Long toAccountId, Double balance) {
        Account fromAccount= accountRepo.findById(fromAccountId).orElseThrow(()-> new NotFoundException("from account id is not found" +" "+ fromAccountId));
        Account toAccount=accountRepo.findById(toAccountId).orElseThrow(()->new NotFoundException("to account id is not found " + " "+ toAccountId));
        if(fromAccount.getBalance().compareTo(BigDecimal.valueOf(balance) )>=0){
            if(fromAccount.getAccountNumber().equalsIgnoreCase(toAccount.getAccountNumber())){
                throw new InvalidAccountNumberException("Account Number Invalid. Pleace check To account Number" +" " +toAccountId);
            }
            fromAccount.setBalance(fromAccount.getBalance().subtract(BigDecimal.valueOf(balance)));
            toAccount.setBalance(toAccount.getBalance().add(BigDecimal.valueOf(balance)));

        }else{
            throw new InsufficientFundException("Tranaction is failed due to insufficient balance in your account " + " "+fromAccountId);

        }
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);
    }

    public String deleteByCustomerId(Long customerId){
     List <Account> acc=accountRepo.findByCustomerId(customerId);
   if(acc.isEmpty()){
       throw new NotFoundException("there is no account for this customer" + customerId);
   }else {
       for (Account a : acc) {
           accountRepo.deleteById(a.getId());
       }
   }
   return "Your account was successfully deleted from the database";

    }


}
