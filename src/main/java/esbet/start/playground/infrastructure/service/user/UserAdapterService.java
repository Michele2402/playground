package esbet.start.playground.infrastructure.service.user;

import esbet.start.playground.application.port.out.user.AuthPortOut;
import esbet.start.playground.application.port.out.user.FindUserPortOut;
import esbet.start.playground.domain.model.User;
import esbet.start.playground.infrastructure.entity.UserEntity;
import esbet.start.playground.infrastructure.mapper.InfrastructureUserMapper;
import esbet.start.playground.infrastructure.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAdapterService implements AuthPortOut, FindUserPortOut {

    private final UserJpaRepository userJpaRepository;
    private final InfrastructureUserMapper infrastructureUserMapper;

    @Override
    public void register(User user) {
        userJpaRepository.save(infrastructureUserMapper.modelToEntity(user));
    }

    //public User login(String email, String password);

    @Override
    public Optional<User> findUserById(UUID id) {
        Optional<UserEntity> userEntity = userJpaRepository.findById(id);
        return userEntity.map(infrastructureUserMapper::entityToModel);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<UserEntity> userEntity = userJpaRepository.findByEmail(email);
        return userEntity.map(infrastructureUserMapper::entityToModel);
    }

    //public User getUserWithMoreThanTenOrders
}
