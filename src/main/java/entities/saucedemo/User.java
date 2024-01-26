package entities.saucedemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;
    private String status;
}
