package esbet.start.playground.application.service.user;

import esbet.start.playground.application.mapper.user.ApplicationUserMapper;
import esbet.start.playground.application.port.in.user.AuthUseCase;
import esbet.start.playground.application.port.out.user.AuthPortOut;
import esbet.start.playground.application.port.out.user.FindUserPortOut;
import esbet.start.playground.application.utils.CheckTypeAttribute;
import esbet.start.playground.domain.exceptions.OperationNotAllowedException;
import esbet.start.playground.domain.model.User;
import esbet.start.playground.presentation.request.user.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAuthManagerService implements AuthUseCase {

    private final AuthPortOut authPortOut;
    private final FindUserPortOut findUserPortOut;

    private final ApplicationUserMapper applicationUserMapper;
    private final CheckTypeAttribute checkTypeAttribute;

    @Override
    public void register(RegisterUserRequest request) {
        validateRequest(request);

        Optional<User> optionalUser = findUserPortOut.findUserByEmail(request.getEmail());
        if (optionalUser.isPresent()) {
            log.error("User with email {} already exists!", request.getEmail());
            throw new OperationNotAllowedException("User with email " + request.getEmail() + " already exists!");
        }

        User user = applicationUserMapper.registerRequestToModel(request);

        authPortOut.register(user);

        log.info("User {} {} registered!", user.getFirstName(), user.getLastName());
    }

    //public User login(String email, String password);

    private void validateRequest(RegisterUserRequest request) {
        checkTypeAttribute.checkStringNullOrEmpty(request.getFirstName(), "First Name");
        checkTypeAttribute.checkStringNullOrEmpty(request.getLastName(), "Last Name");
        checkTypeAttribute.checkStringNullOrEmpty(request.getEmail(), "Email");
        checkTypeAttribute.checkStringNullOrEmpty(request.getPassword(), "Password");
    }
}
