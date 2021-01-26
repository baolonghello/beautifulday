package com.eloancn.bt.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eloancn.bt.entity.TenderBusDetail;
import com.eloancn.bt.dao.TenderBusDetailMapper;
/**
 * 业务层接口
 * @ClassName:  TenderBusDetailService   
 * @Description:TODO 
 * @author: 系统自动生成     
 *
 */
@Service
public class TenderBusDetailService {


    @Autowired
    private TenderBusDetailMapper tenderBusDetailMapper;

    public TenderBusDetail queryTenderBusDetailById(Integer id) {
        return tenderBusDetailMapper.querySingleResultById(id);
    }

    public List<TenderBusDetail> queryTenderBusDetailList(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<TenderBusDetail> list = tenderBusDetailMapper.queryListResult(paramMap);
        return list;
    }

    public Integer queryTenderBusDetailListCount(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return tenderBusDetailMapper.queryListResultCount(paramMap);
    }

    public List<TenderBusDetail> queryTenderBusDetailListByWhere(Integer id, Integer pageNo, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageSize", pageSize);
        return tenderBusDetailMapper.queryListResultByWhere(paramMap);
    }

    public Integer queryTenderBusDetailListCountByWhere(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        return tenderBusDetailMapper.queryListResultCountByWhere(paramMap);
    }

    public Integer save(TenderBusDetail tenderBusDetail) {
        return tenderBusDetailMapper.save(tenderBusDetail);
    }

    public Integer saveTenderBusDetailBatch(List<TenderBusDetail> tenderBusDetails) {
        return tenderBusDetailMapper.saveBatch(tenderBusDetails);
    }

    public Integer updateTenderBusDetail(Integer id) {
        TenderBusDetail tenderBusDetail = this.queryTenderBusDetailById(id);
        return tenderBusDetailMapper.update(tenderBusDetail);
    }

    public Integer deleteTenderBusDetailById(Integer id) {
        return tenderBusDetailMapper.delete(id);
    }

}
