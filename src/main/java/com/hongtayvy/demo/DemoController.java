package com.hongtayvy.demo;

import com.hongtayvy.demo.dto.UserDTO;
import com.hongtayvy.demo.helper.DemoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {
    private final DemoService demoService;
    private final DemoHelper demoHelper;

    @Autowired
    public DemoController(DemoService demoService,
                          DemoHelper demoHelper){
        this.demoService = demoService;
        this.demoHelper = demoHelper;
    }

    @GetMapping(value = "/user")
    public List<UserDTO> getUsers(){
        return demoService.findUsers();
    }

    @GetMapping(value = "/user/{id}")
    public UserDTO gerUser(@PathVariable(name = "id") String id){
        int sanitizedId = demoHelper.sanitizedId(id);
        return demoService.findUser(sanitizedId);
    }

    @PutMapping
    public UserDTO updateUser(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "active") Boolean active
    ){
        int sanitizedId = demoHelper.sanitizedId(id);
        return demoService.updateUser(sanitizedId, active);
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        UserDTO sanitizedUserDTO = demoHelper.sanitizedRequestBody(userDTO);
        return demoService.saveUser(sanitizedUserDTO);
    }

    @DeleteMapping
    public String deleteUser(
            @RequestParam(name = "id") String id
    ){
        int sanitizedId = demoHelper.sanitizedId(id);
        demoService.deleteUser(sanitizedId);
        return "deleted user id: " + id;
    }

}
