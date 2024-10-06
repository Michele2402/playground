package esbet.start.playground.application.port.out.user;

import esbet.start.playground.domain.model.User;

public interface AuthPortOut {
    void register(User user);

    //User login(String email, String password);
}
