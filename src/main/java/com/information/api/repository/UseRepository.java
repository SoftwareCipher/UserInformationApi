package com.information.api.repository;

import com.information.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UseRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.status = ?1")
    List<User> findUserIdAndStatus(boolean status);

}
