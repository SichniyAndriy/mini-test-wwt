package test.bett.auth.domain.service.impl;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.bett.auth.domain.exception.DatabaseAccessException;
import test.bett.auth.domain.exception.UserNotFoundException;
import test.bett.auth.domain.model.dto.UserDto;
import test.bett.auth.domain.model.entity.User;
import test.bett.auth.domain.model.mapper.UserMapper;
import test.bett.auth.domain.service.UserService;
import test.bett.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            @Autowired UserRepository userRepository,
            @Autowired UserMapper userMapper,
            @Autowired PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void save(UserDto userDto) {
        User newUser = User.builder()
                .id(UUID.randomUUID())
                .email(userDto.getEmail())
                .passwordHash(passwordEncoder.encode(userDto.getPassword()))
                .build();
        User saved = userRepository.save(newUser);
        if  (saved.getId() == null) {
            throw new DatabaseAccessException("User with email " + userDto.getEmail() + " not created");
        }
    }

    @Override
    public String check(UserDto userDto) {
        UserDto userDtoFromDB = getUserByEmail(userDto.getEmail());
        if (userDtoFromDB.getPassword().equals(passwordEncoder.encode(userDto.getPassword()))) {
            return userDtoFromDB.getId().toString();
        }
        throw new IllegalArgumentException("Wrong password");
    }

    private UserDto getUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser
                .map(userMapper::toDto)
                .orElseThrow(UserNotFoundException::new);
    }

}
