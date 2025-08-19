package du20464813.foundation.bank.account.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private Long customerId;  // Reference to Customer microservice
        @Column(unique = true,length = 12)
        private String accountNumber;
        @Enumerated(EnumType.STRING)
        private AccountType accountType; // SAVINGS, CURRENT

        @Enumerated(EnumType.STRING)
        private OwnershipType ownershipType; // INDIVIDUAL, JOINT

        private BigDecimal balance;
        private String branchCode;

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

        public String getAccountNumber() {
                return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
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

        public String getBranchCode() {
                return branchCode;
        }

        public void setBranchCode(String branchCode) {
                this.branchCode = branchCode;
        }
}
