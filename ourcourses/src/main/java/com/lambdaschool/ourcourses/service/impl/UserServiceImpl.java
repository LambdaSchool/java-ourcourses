package com.lambdaschool.ourcourses.service.impl;

import com.lambdaschool.ourcourses.model.User;
import com.lambdaschool.ourcourses.repository.Userrepository;
import com.lambdaschool.ourcourses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService
{

    @Autowired
    private Userrepository userrepos;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException
    {
        User user = userrepos.findByUsername(userId);
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }

    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {
        userrepos.deleteById(id);
    }

    @Override
    public User save(User user)
    {
        return userrepos.save(user);
    }
}
