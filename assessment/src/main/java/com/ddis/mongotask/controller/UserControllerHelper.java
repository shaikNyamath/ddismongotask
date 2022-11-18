package com.ddis.mongotask.controller;

import com.ddis.mongotask.dto.UserResponseDTO;
import com.ddis.mongotask.entities.User;
import com.ddis.mongotask.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserControllerHelper {
    @Autowired
    UserRepo userRepo;
    public List<UserResponseDTO> getUserResponseDTOS() {
        List<User> userList = userRepo.findAll();
        Map<String,Long> cityMap = new HashMap<>();
        for(User u : userList)  {
            if(cityMap.get(u.getCity())==null) {
                cityMap.put(u.getCity(),1L);
            }
            else {
                cityMap.put(u.getCity(),cityMap.get(u.getCity())+1);
            }
        }
        List<UserResponseDTO> result = new ArrayList<>();
        for(Map.Entry<String,Long> map : cityMap.entrySet()) {
            UserResponseDTO response = new UserResponseDTO();
            response.setCity(map.getKey());
            response.setUserCount(map.getValue());
            result.add(response);
        }
        return result;
    }

}
