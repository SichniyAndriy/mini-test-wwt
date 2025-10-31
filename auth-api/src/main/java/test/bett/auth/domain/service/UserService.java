package test.bett.auth.domain.service;

import test.bett.auth.domain.model.dto.UserDto;

public interface UserService {

    void save(UserDto userDto);

    String check(UserDto userDto);

}
