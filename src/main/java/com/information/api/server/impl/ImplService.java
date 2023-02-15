package com.information.api.server.impl;

import com.information.api.entity.Status;
import com.information.api.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ImplService {
    User saveUser(User user);
    User getUserId(Long id);
    Status setStatusUser(Long id, String status);
}
