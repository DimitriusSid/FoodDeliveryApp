package by.food.delivery.app.userservice.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(max = 128)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "First name is required")
    @Size(max = 128)
    private String lastName;

    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+[0-9\\-\\s]*$", message = "Phone number should look like +XXX XXXXX...")
    @Size(max = 32)
    private String phoneNumber;

    @Column(name = "email")
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "Email must be valid")
    @Size(max = 128)
    private String email;

}
