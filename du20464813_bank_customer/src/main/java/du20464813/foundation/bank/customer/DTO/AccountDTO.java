package du20464813.foundation.bank.customer.DTO;

import du20464813.foundation.bank.customer.Entity.AccountType;
import du20464813.foundation.bank.customer.Entity.OwnershipType;

import java.math.BigDecimal;

public class AccountDTO {
    private Long id;
    private Long customerId;

    private String accountNumber;
    private AccountType accountType;
    private OwnershipType ownershipType;

    private String BranchCode;
    private BigDecimal balance;

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String branchCode) {
        BranchCode = branchCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public OwnershipType getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(OwnershipType ownershipType) {
        this.ownershipType = ownershipType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
