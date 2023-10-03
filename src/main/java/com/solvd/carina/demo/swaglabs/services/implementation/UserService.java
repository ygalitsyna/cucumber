package com.solvd.carina.demo.swaglabs.services.implementation;

import com.solvd.carina.demo.swaglabs.model.User;
import com.solvd.carina.demo.swaglabs.services.interfaces.IUserService;
import com.solvd.carina.demo.swaglabs.utils.MyBatisDaoFactory;
import com.solvd.carina.demo.swaglabs.dao.interfaces.IUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService implements IUserService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public User getEntityById(Integer id) {
        User user;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            user = iUserDao.getEntityById(id);
        }
        return user;
    }
}
