package com.information.api.server;

import com.information.api.entity.Status;
import com.information.api.entity.User;
import com.information.api.repository.UseRepository;
import com.information.api.server.impl.ImplService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@org.springframework.stereotype.Service
public class Service implements ImplService {

    UseRepository useRepository;

    @Autowired
    public Service(UseRepository useRepository) {
        this.useRepository = useRepository;
    }

    @Override
    public User saveUser(User user) {
        user.setDate(LocalDateTime.now());
        return useRepository.saveAndFlush(user);
    }

    @Override
    public User getUserId(Long id) {
        return null;
    }

    @Override
    public Status setStatusUser(Long id, String status) {
        return null;
    }
}
