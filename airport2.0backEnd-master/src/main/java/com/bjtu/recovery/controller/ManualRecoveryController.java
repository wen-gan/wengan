package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.ManualRecovery;
import com.bjtu.recovery.service.IManualRecoveryService;
import com.bjtu.recovery.service.IManualResultService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-14
 */
@RestController
@RequestMapping("/manual-recovery")
public class ManualRecoveryController {

    @Autowired
    private IManualRecoveryService IManualRecoveryService;

    @RequestMapping("/selectOriginal")
    public List<Map<String, Object>> getallresult(){
        List<Map<String, Object>> originalData = IManualRecoveryService.getOriginalData();
        return originalData;
    }

    @RequestMapping("/selectAllFlight")
    public List<ManualRecovery> getallFlight(){
        List<ManualRecovery> allData = IManualRecoveryService.getAllFlight();
        return allData;
    }

    @RequestMapping("/selectRecoveryData")
    public List<Map<String, Object>> getrecoveryData(){
        List<Map<String, Object>> recoveryData = IManualRecoveryService.getRecoveryData();
        return recoveryData;
    }


    @RequestMapping("/selectAllFlightByModel")
    public List getallFlightByModel(@RequestBody String model){
        List allFlight = IManualRecoveryService.getResultByModel(model);
        return allFlight;
    }

    //差insertresultinfo和updateResultinfo
//    @RequestMapping(value = "/insertResultInfo", method = RequestMethod.POST)
//    public String insert(@RequestBody Object manualResult) {
//
//        return "插入成功，" + "影响" + sum + "行";
//    }
//
//    @RequestMapping(value = "/updateResultInfo", method = RequestMethod.POST)
//    public int update(@RequestBody Object manualResult){
//        System.out.println(manualResult);
//        JSONObject jsonObject = JSONObject.fromObject(manualResult);
//        int accept= IManualResultService.updateinfo(
//                jsonObject.getString("parkinggate"),
//                jsonObject.getInt("allostate"),
//                jsonObject.getInt("id")
//        );
//        System.out.println("状态接收成功");
//        return accept ;
//    }

}
