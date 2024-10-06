package esbet.start.playground.application.port.in.user;

import esbet.start.playground.domain.model.User;

import java.util.UUID;

public interface FindUserUseCase {
    User findUserById(String id);
}
