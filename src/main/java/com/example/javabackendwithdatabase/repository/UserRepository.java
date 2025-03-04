package com.example.javabackendwithdatabase.repository;

import com.example.javabackendwithdatabase.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
