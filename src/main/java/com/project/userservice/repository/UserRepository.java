package com.project.userservice.repository;

import com.project.userservice.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{username: '?0'}")
    public User findByUsername(String username);

    @Query(value="{_id: '?0'}")
    public User findByID(String id);

    @Query(value="{email: '?0'}")
    public  User findByEmail(String email);
}
