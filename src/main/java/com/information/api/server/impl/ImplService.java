package com.information.api.server.impl;

import com.information.api.entity.Status;
import com.information.api.entity.User;

public interface ImplService {
    Long saveUser(User user);
    User getUserId(Long id);
    Status setStatusUser(Long id, String status);
}
