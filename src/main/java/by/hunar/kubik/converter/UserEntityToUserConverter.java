package by.hunar.kubik.converter;

import by.hunar.kubik.entity.UserEntity;
import by.hunar.kubik.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserConverter extends AutoRegisteredConverter<UserEntity, User> {
    @Override
    public User convert(UserEntity source) {
        User user = new User();
        user.setId(source.getId());
        user.setPassword(source.getPassword());
        user.setUsername(source.getUsername());
        return user;
    }
}
