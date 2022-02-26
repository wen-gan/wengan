package com.bjtu.recovery.controller;


import com.bjtu.recovery.entity.StatisticResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WuZhen
 * @since 2020-03-01
 */
@RestController
@RequestMapping("/statistic-result")
public class StatisticResultController {
    @Autowired
    private com.bjtu.recovery.service.IStatisticResultService IStatisticResultService;


    //查询STATISTIC_RESULT的数据
    @RequestMapping("/select")
    public List<StatisticResult> getone(){
        List<StatisticResult> list = IStatisticResultService.getinfo();
        return list;
    }
    //直接向数据库表STATISTIC_RESULT插入数据
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody Object statisticresult) {

        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(statisticresult);
        int sum = 0;
        for (int i = 0; i < jsonArray.size(); i++) {
            net.sf.json.JSONObject jsonObject = (net.sf.json.JSONObject) jsonArray.get(i);
            int row = IStatisticResultService.insertinfo(
                    jsonObject.getInt("beallo"),
                    jsonObject.getInt("gatenum"),
                    jsonObject.getInt("neargatenum"),
                    jsonObject.getInt("allostate"),
                    jsonObject.getInt("timespend"),
                    jsonObject.getInt("bridgerate"),
                    jsonObject.getInt("bridgenum")

            );
            sum = sum + row;
        }
        return "插入成功，" + "影响" + sum + "行";
    }

}
