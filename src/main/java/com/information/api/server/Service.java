package com.information.api.server;

import com.information.api.entity.Status;
import com.information.api.entity.User;
import com.information.api.repository.UseRepository;
import com.information.api.server.impl.ImplService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ImplService {

    UseRepository useRepository;

    @Autowired
    public Service(UseRepository useRepository) {
        this.useRepository = useRepository;
    }

    @Override
    public Long saveUser(User user) {
        user.setDate(LocalDateTime.now());
        return useRepository.saveAndFlush(user).getId();
    }

    @Override
    public User getUserId(Long id) {
        return useRepository.findById(id).get();
    }



    @Override
    public List<User> getStatusUser(boolean status) {
        return useRepository.findUserIdAndStatus(status);
    }

    @Override
    public Status setNewStatus(Long id, boolean oldStatus) {
        boolean newStatus;
        newStatus = !oldStatus;
        Status status = new Status(id, oldStatus, newStatus);
        useRepository.updateStatus(id, oldStatus);
        return status;
    }

    @Override
    public List<User> allUsers() {
        return useRepository.findAll();
    }
}
