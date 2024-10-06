package esbet.start.playground.domain.model;


import esbet.start.playground.domain.exceptions.ObjectDomainException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.regex.Pattern;

@Data
@Slf4j
public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Builder
    public User(UUID id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        validate(this);
    }

    private void validateName(String name) {
        if (name == null) {
            log.error("User name cannot be null!");
            throw new ObjectDomainException("User name cannot be null!");
        }
        if (name.isEmpty()) {
            log.error("User name cannot be empty!");
            throw new ObjectDomainException("User name cannot be empty!");
        }
        if (name.length() < 3 || name.length() > 30) {
            log.error("User name and surname must be between 3 and 30 characters!");
            throw new ObjectDomainException("User username must be between 3 and 30 characters!");
        }
    }

    private void validateEmail(String email) {
        if (email == null) {
            log.error("User email cannot be null!");
            throw new ObjectDomainException("User email cannot be null!");
        }
        if (email.isEmpty()) {
            log.error("User email cannot be empty!");
            throw new ObjectDomainException("User email cannot be empty!");
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (!pat.matcher(email).matches()) {
            log.error("User email format is invalid!");
            throw new ObjectDomainException("User email format is invalid!");
        }
    }

    private void validatePassword(String password) {
        if (password == null) {
            log.error("User password cannot be null!");
            throw new ObjectDomainException("User password cannot be null!");
        }
        if (password.isEmpty()) {
            log.error("User password cannot be empty!");
            throw new ObjectDomainException("User password cannot be empty!");
        }
    }

    private void validate (User user) {
        validateName(user.getFirstName());
        validateName(user.getLastName());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
    }
}
