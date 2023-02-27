package com.test.demo.Service;

import com.test.demo.Model.User;
import com.test.demo.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

//    @Override
//    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//
//        User user = userDao.findUser(id);
//
//        if( user == null ) {
//            throw new UsernameNotFoundException(id);
//        }
//        return user;
//    }
    public User findUser(String id){
        return userDao.findUser(id);
    }

    public User updateUser(User user){
        userDao.updateUser(user);
        return user;
    }

    public Boolean deleteUser(String id){
        userDao.deleteUser(id);
        return true;
    }
}
