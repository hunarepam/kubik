package by.hunar.kubik.service;

import by.hunar.kubik.entity.UserEntity;
import by.hunar.kubik.exception.NotFoundException;
import by.hunar.kubik.model.User;
import by.hunar.kubik.repository.UserRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;


    public UserService(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    public User getUserById(Long id) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            throw new NotFoundException(String.format("User %d not found", id));
        }
        return conversionService.convert(existingUser.get(), User.class);
    }

    public User upsert(User user) {
        UserEntity userEntity = conversionService.convert(user, UserEntity.class);
        userEntity = userRepository.save(userEntity);

        return conversionService.convert(userEntity, User.class);
    }
}
