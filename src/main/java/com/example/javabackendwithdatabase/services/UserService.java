package com.example.javabackendwithdatabase.services;

import com.example.javabackendwithdatabase.mappers.UserDTOMapper;
import com.example.javabackendwithdatabase.models.dto.UserDTO;
import com.example.javabackendwithdatabase.models.entities.User;
import com.example.javabackendwithdatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDTOMapper userDtoMapper;

    public UserService(UserRepository userRepository, UserDTOMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User returnUser = userDtoMapper.dtoToUser(userDTO);
        return userDtoMapper.userToDTO(userRepository.save(returnUser));
    }

    public Boolean deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

}