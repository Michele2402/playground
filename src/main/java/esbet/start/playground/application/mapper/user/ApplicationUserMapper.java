package esbet.start.playground.application.mapper.user;

import esbet.start.playground.domain.model.User;
import esbet.start.playground.presentation.request.user.RegisterUserRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApplicationUserMapper {

    public User registerRequestToModel(RegisterUserRequest request) {
        return User.builder()
                .id(UUID.randomUUID())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
