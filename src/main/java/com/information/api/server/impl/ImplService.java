package com.information.api.server.impl;

import com.information.api.entity.Status;
import com.information.api.entity.User;

import java.util.List;

public interface ImplService {
    Long saveUser(User user);
    User getUserId(Long id);
    Status setStatusUser(Long id, String status);

    List<User> allUsers();
}
