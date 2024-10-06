package esbet.start.playground.presentation.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
