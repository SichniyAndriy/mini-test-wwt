package test.bett.auth.domain.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import test.bett.auth.domain.model.dto.UserDto;
import test.bett.auth.domain.model.entity.User;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "password", source = "passwordHash")
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", source = "password")
    User toEntity(UserDto userDto);

}
