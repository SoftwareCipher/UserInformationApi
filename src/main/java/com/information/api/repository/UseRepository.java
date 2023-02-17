package com.information.api.repository;

import com.information.api.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UseRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.status = ?1")
    List<User> findUserIdAndStatus(boolean status);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE User u SET u.status = :status WHERE u.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") boolean status);

}
