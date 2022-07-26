package com.dio.springsecurityjwt.repository;

import com.dio.springsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Integer> {
    //trazer um usuario pelo username
    // query sobreb objetos
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
    public User findByUsername(@Param("username") String username);

    //verificar se existe o usuario pelo username
    boolean existsByUsername(String username);
}