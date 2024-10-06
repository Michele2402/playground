package esbet.start.playground.presentation.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserResponse {

    private String fullName;
    private String email;
}
