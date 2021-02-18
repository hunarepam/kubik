package by.hunar.kubik.converter;

import by.hunar.kubik.entity.UserEntity;
import by.hunar.kubik.exception.NotFoundException;
import by.hunar.kubik.model.User;
import by.hunar.kubik.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityConverter extends AutoRegisteredConverter<User, UserEntity> {

    private final UserRepository userRepository;

    public UserToUserEntityConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity convert(User source) {
        UserEntity result;
        Long userId = source.getId();
        if (userId == null) {
            result = new UserEntity();
        } else {
            result = userRepository.findById(userId)
                    .orElseThrow(() -> new NotFoundException(String.format("User %d not found", userId)));
        }
        result.setPassword(source.getPassword());
        result.setUsername(source.getUsername());

        return result;
    }
}
