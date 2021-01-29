package com.eloancn.bt.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eloancn.bt.entity.Tender;
import com.eloancn.bt.dao.TenderMapper;
/**
 * 业务层接口
 * @ClassName:  TenderService   
 * @Description:TODO 
 * @author: 系统自动生成     
 *
 */
@Service
public class TenderService {


    @Autowired
    private TenderMapper tenderMapper;

    public Tender queryTenderById(Integer id) {
        return tenderMapper.querySingleResultById(id);
    }

    public List<Tender> queryTenderList(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<Tender> list = tenderMapper.queryListResult(paramMap);
        return list;
    }

    public Integer queryTenderListCount(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return tenderMapper.queryListResultCount(paramMap);
    }

    public List<Tender> queryTenderListByWhere(Integer id, Integer pageNo, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageSize", pageSize);
        return tenderMapper.queryListResultByWhere(paramMap);
    }

    public Integer queryTenderListCountByWhere(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        return tenderMapper.queryListResultCountByWhere(paramMap);
    }

    public Integer save(Tender tender) {
        return tenderMapper.save(tender);
    }

    public Integer saveTenderBatch(List<Tender> tenders) {
        return tenderMapper.saveBatch(tenders);
    }

    public Integer updateTender(Integer id) {
        Tender tender = this.queryTenderById(id);
        return tenderMapper.update(tender);
    }

    public Integer deleteTenderById(Integer id) {
        return tenderMapper.delete(id);
    }

}
