package com.eloancn.bt.controller;

import com.alibaba.fastjson.JSON;
import com.eloancn.bt.entity.TenderBusDetail;
import com.eloancn.bt.service.TenderBusDetailService;
import com.example.entity.SUser;
import com.example.entity.Tender;
import com.example.service.SUserService;
import com.example.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//@Controller
@RequestMapping()
public class TenderBusDetailController {

    @Autowired
    SUserService sUserService;

    @Autowired
    TenderBusDetailService tenderService;


    @RequestMapping(value = "/tender", method = RequestMethod.GET)
    public String queryTender() {
        Tender tender = tenderService.queryTenderById(9033287);

        List<Tender> list = tenderService.queryTenderList(9033287);

        Integer count = tenderService.queryTenderListCount(9033287);

        List<Tender> listWhere = tenderService.queryTenderListByWhere(9033287,1,10);

        Integer countWhere = tenderService.queryTenderListCountByWhere(9033287);

        //Integer tSave = tenderService.save();

        //Integer tSaveBatch = tenderService.saveBatch();

        Integer updateCount=tenderService.updateTender(9033287);

        Integer deleteCount =tenderService.deleteTenderById(9033900);

        return JSON.toJSONString(deleteCount);
    }


    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public String getAll(){
        List<SUser> userList = sUserService.queryListResultByWhere();
        return "22"+userList.size();
    }

    @RequestMapping("/helloworld")
    public ModelAndView toJps(Model model1) {
        model1.addAttribute("welcome", "不建议使用jsp");

        ModelAndView model = new ModelAndView("welcome");
        model.addObject("welcome","123");
        return model;
    }

    @RequestMapping("/show2")
    public String getIndex() {
        return "index";
    }
}
