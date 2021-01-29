package com.eloancn.bt.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eloancn.bt.entity.SUser;
import com.eloancn.bt.dao.SUserMapper;
/**
 * 业务层接口
 * @ClassName:  SUserService   
 * @Description:TODO 
 * @author: 系统自动生成     
 *
 */
@Service
public class SUserService {


    @Autowired
    private SUserMapper sUserMapper;

    public SUser querySUserById(Integer id) {
        return sUserMapper.querySingleResultById(id);
    }

    public List<SUser> querySUserList(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<SUser> list = sUserMapper.queryListResult(paramMap);
        return list;
    }

    public Integer querySUserListCount(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return sUserMapper.queryListResultCount(paramMap);
    }

    public List<SUser> querySUserListByWhere(Integer id, Integer pageNo, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageSize", pageSize);
        return sUserMapper.queryListResultByWhere(paramMap);
    }

    public Integer querySUserListCountByWhere(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        return sUserMapper.queryListResultCountByWhere(paramMap);
    }

    public Integer save(SUser sUser) {
        return sUserMapper.save(sUser);
    }

    public Integer saveSUserBatch(List<SUser> sUsers) {
        return sUserMapper.saveBatch(sUsers);
    }

    public Integer updateSUser(Integer id) {
        SUser sUser = this.querySUserById(id);
        return sUserMapper.update(sUser);
    }

    public Integer deleteSUserById(Integer id) {
        return sUserMapper.delete(id);
    }

}
