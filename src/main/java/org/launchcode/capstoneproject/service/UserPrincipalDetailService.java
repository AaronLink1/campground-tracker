package org.launchcode.capstoneproject.service;

import org.launchcode.capstoneproject.models.User;
import org.launchcode.capstoneproject.models.UserPrincipal;
import org.launchcode.capstoneproject.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    private User user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = userDao.findByUsername(username);
        return new UserPrincipal(user);
    }
}

