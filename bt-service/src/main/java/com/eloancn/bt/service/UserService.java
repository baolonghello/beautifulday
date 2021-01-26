package com.eloancn.bt.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eloancn.bt.entity.User;
import com.eloancn.bt.dao.UserMapper;
/**
 * 业务层接口
 * @ClassName:  UserService   
 * @Description:TODO 
 * @author: 系统自动生成     
 *
 */
@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Integer id) {
        return userMapper.querySingleResultById(id);
    }

    public List<User> queryUserList(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<User> list = userMapper.queryListResult(paramMap);
        return list;
    }

    public Integer queryUserListCount(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return userMapper.queryListResultCount(paramMap);
    }

    public List<User> queryUserListByWhere(Integer id, Integer pageNo, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageSize", pageSize);
        return userMapper.queryListResultByWhere(paramMap);
    }

    public Integer queryUserListCountByWhere(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        return userMapper.queryListResultCountByWhere(paramMap);
    }

    public Integer save(User user) {
        return userMapper.save(user);
    }

    public Integer saveUserBatch(List<User> users) {
        return userMapper.saveBatch(users);
    }

    public Integer updateUser(Integer id) {
        User user = this.queryUserById(id);
        return userMapper.update(user);
    }

    public Integer deleteUserById(Integer id) {
        return userMapper.delete(id);
    }

}
