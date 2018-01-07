package com.majunwei.jbone.sys.service;

import com.majunwei.jbone.sys.dao.domain.RbacUserEntity;
import com.majunwei.jbone.sys.dao.repository.RbacUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    RbacUserRepository userRepository;

    public RbacUserEntity findByUserName(String username){
        return userRepository.findByUsername(username);
    }

}
