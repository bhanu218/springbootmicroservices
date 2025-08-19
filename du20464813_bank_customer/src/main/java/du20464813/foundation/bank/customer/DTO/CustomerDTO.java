package du20464813.foundation.bank.customer.DTO;

import du20464813.foundation.bank.customer.Entity.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Gender gender;
    private LocalDate dateOfBirth;
    private CustomerStatus status;

    private List<AccountDTO> accountDTO;




}
