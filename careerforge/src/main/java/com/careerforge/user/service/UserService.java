package com.careerforge.user.service;

import com.careerforge.user.dto.UserDto;
import java.util.UUID;

public interface UserService {
    UserDto getUserById(UUID id);
    UserDto getUserByEmail(String email);
    UserDto updateUser(UUID id, UserDto userDto);
    void deactivateUser(UUID id);
    void activateUser(UUID id);
}
