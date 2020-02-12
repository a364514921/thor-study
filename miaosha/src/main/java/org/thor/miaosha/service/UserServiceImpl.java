package org.thor.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thor.miaosha.dao.UserDao;
import org.thor.miaosha.entity.User;

/**
 * @description:
 * @author: wangyiqiang
 * @date: 2020-02-12 上午7:38
 * @version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public int insert() {
        User user1 = new User().setAge(16).setUsername("小红");
        userDao.insert(user1);

        User user2 = new User().setAge(13);
        userDao.insert(user2);
        return user1.getId();
    }
}
