package du20464813.foundation.bank.customer.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
    @CreatedDate
    private LocalDate createdDate;
    @LastModifiedDate
    private LocalDate lastUpdatedDate;


}
