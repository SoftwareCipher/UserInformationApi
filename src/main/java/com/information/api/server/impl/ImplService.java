package com.information.api.server.impl;

import com.information.api.entity.Status;
import com.information.api.entity.User;

public interface ImplService {
    void saveUser(User user);
    User getUserId(Long id);
    Status setStatusUser(Long id, String status);
}
