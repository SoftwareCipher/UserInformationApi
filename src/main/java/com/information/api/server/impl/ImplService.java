package com.information.api.server.impl;

import com.information.api.entity.Status;
import com.information.api.entity.User;

import java.util.List;

public interface ImplService {
    Long saveUser(User user);
    User getUserId(Long id);
    List<User> setStatusUser(boolean status);

    List<User> allUsers();
}
