package esbet.start.playground.application.port.in.user;

import esbet.start.playground.presentation.request.user.RegisterUserRequest;

public interface AuthUseCase {
    void register(RegisterUserRequest request);

    //public User login(String email, String password);
}
