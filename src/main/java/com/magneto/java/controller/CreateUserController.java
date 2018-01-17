package com.magneto.java.controller;

import com.magneto.java.model.UserinfoResponse;
import com.magneto.java.model.UserinforRequest;
import com.magneto.java.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/api/user")
public class CreateUserController {

    private final Logger logger = LoggerFactory.getLogger(CreateUserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody UserinfoResponse createUser(@RequestBody UserinforRequest userinforRequest) {

        return userService.createUser(userinforRequest);

    }


    @RequestMapping(value = "/sam", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody String createUser() {

        String sa="sadasd" ;
        return "HAI";

    }
}
