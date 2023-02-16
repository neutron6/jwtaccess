package com.csi.controller.service2;


import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class AdminUserDetailService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals("rushikesh")){
            return new User("rushikesh","123",new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("user not found*");
        }

    }
}
