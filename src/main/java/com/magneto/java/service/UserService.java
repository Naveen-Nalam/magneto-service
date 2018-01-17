package com.magneto.java.service;

import com.magneto.java.model.UserinfoResponse;
import com.magneto.java.model.UserinforRequest;

public interface UserService
{
    public UserinfoResponse createUser(UserinforRequest request);
}
