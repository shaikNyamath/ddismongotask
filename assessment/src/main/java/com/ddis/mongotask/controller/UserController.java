package com.ddis.mongotask.controller;

import com.ddis.mongotask.dto.UserDTO;
import com.ddis.mongotask.dto.UserResponseDTO;
import com.ddis.mongotask.entities.User;
import com.ddis.mongotask.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/ddis")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserControllerHelper userControllerHelper;
    private static ObjectMapper  om = new ObjectMapper();

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody UserDTO userDTO) {
        User user = om.convertValue(userDTO, User.class);
        userRepo.save(user);
    }
    @RequestMapping(value = "/user/filter", method = RequestMethod.GET)
    public List<User> getUserByStateCity(@RequestParam(value = "state") String state, @RequestParam(value = "city") String city) {
        List<User> userList = userRepo.findByStateAndCity(state, city);
        return userList;
    }

    @RequestMapping(value = "/user/city/stats", method = RequestMethod.GET)
    public List<UserResponseDTO> getUserByStateCity() {
        List<UserResponseDTO> result = userControllerHelper.getUserResponseDTOS();
        return result;
    }


}
