package du20464813.foundation.bank.customer.DTO;

import org.antlr.v4.runtime.misc.NotNull;

public class AccountTransferRequestDTO {
    @NotNull
    private Long fromAccountId;
    @NotNull
    private  Long toAccountId;
    @NotNull
    private  Double balance;

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
