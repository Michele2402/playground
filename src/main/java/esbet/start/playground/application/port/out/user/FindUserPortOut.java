package esbet.start.playground.application.port.out.user;

import esbet.start.playground.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface FindUserPortOut {

    Optional<User> findUserById(UUID id);

    Optional<User> findUserByEmail(String email);
}
