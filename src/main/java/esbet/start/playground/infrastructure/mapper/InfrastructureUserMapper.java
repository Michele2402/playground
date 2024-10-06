package esbet.start.playground.infrastructure.mapper;

import esbet.start.playground.domain.model.User;
import esbet.start.playground.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class InfrastructureUserMapper {

    public UserEntity modelToEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public User entityToModel(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}
