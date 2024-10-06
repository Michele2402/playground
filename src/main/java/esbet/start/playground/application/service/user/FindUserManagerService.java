package esbet.start.playground.application.service.user;

import esbet.start.playground.application.port.in.user.FindUserUseCase;
import esbet.start.playground.application.port.out.user.FindUserPortOut;
import esbet.start.playground.application.utils.CheckTypeAttribute;
import esbet.start.playground.domain.exceptions.ObjectNotFoundException;
import esbet.start.playground.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindUserManagerService implements FindUserUseCase {

    private final CheckTypeAttribute checkTypeAttribute;

    private final FindUserPortOut findUserPortOut;

    @Override
    public User findUserById(String id) {
        UUID uuid = checkTypeAttribute.checkUUIDNullOrInvalid(id, "id");

        Optional<User> user = findUserPortOut.findUserById(uuid);

        if(user.isEmpty()) {
            log.error("User not found");
            throw new ObjectNotFoundException("User not found");
        }

        return user.get();
    }

    //public User getUserByEmail

    //public User getUserWithMoreThanTenOrders
}
