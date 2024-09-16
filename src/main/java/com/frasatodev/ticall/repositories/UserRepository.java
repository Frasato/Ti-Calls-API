package com.frasatodev.ticall.repositories;

import com.frasatodev.ticall.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT * FROM tb_users WHERE username= :username AND password= :password", nativeQuery = true)
    Optional<User> findByUsernamePassword(@Param("username") String username, @Param("password") String password);

}