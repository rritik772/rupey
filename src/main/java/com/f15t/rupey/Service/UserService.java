package com.f15t.rupey.Service;

import com.f15t.rupey.DAO.Interface.UserDaoInterface;
import com.f15t.rupey.Entities.User;
import com.f15t.rupey.Response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserDaoInterface userDao;

    @Autowired
    UserService(UserDaoInterface userDao) {
        this.userDao = userDao;
    }

    public UserResponse createUser(UserResponse response) {
        User tmp = User.builder()
                .username(response.getUsername())
                .password(response.getPassword())
                .fullName(response.getFullName())
                .currency(response.getCurrency())
                .build();

        userDao.createUser(tmp);
        return response;
    }

    public UserResponse findUserByUsername(String username) {
        User tmp = userDao.findByUsername(username);
        return UserResponse.builder()
                .username(tmp.getUsername())
                .fullName(tmp.getFullName())
                .currency(tmp.getCurrency())
                .build();
    }

    public UserResponse updateUser(UserResponse response) {
        User tmp = User.builder()
                .username(response.getUsername())
                .password(response.getPassword())
                .fullName(response.getFullName())
                .currency(response.getCurrency())
                .build();

        userDao.updateUser(tmp);
        return response;
    }

    public Optional<UserResponse> deleteUser(UserResponse response) {
        if (response.getUserId().isEmpty())
            return Optional.empty();

        User tmp = User.builder()
                .userId(response.getUserId().get())
                .build();
        userDao.deleteUser(tmp);

        return Optional.of(response);
    }
}
