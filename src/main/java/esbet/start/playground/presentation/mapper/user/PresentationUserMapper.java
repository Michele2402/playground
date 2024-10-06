package esbet.start.playground.presentation.mapper.user;

import esbet.start.playground.domain.model.User;
import esbet.start.playground.presentation.response.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class PresentationUserMapper {

    public UserResponse modelToResponse(User user) {
        return UserResponse.builder()
                .fullName(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .build();
    }

}
