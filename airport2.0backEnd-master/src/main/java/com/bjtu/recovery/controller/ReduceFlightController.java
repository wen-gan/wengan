package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.ReduceFlight;
import com.bjtu.recovery.service.IProblemAirportService;
import com.bjtu.recovery.service.IReduceFlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 * Swagger：http://localhost:8866/swagger-ui.html#/
 * 接口类型：GET请求
 * 航班调减接口名：reduce-flight/allData
 * url：http://localhost:8866/reduce-flight/allData
 */

@Api(description = "航班调减接口")
@RestController
@RequestMapping("/reduce-flight")
public class ReduceFlightController {
    @Autowired
    private IReduceFlightService IReduceFlightService;

    /**
     * 表格中所有数据信息
     * @return
     */
    @ApiOperation(value = "表格中所有数据信息", httpMethod = "GET")
    @RequestMapping("/allData")
    public List<ReduceFlight> getAlldata(){
        List<ReduceFlight> allData = IReduceFlightService.getAlldata();
        return allData;
    }

    /**
     * 原始界面
     * 直接展示所有的调减航班
     * @return
     */
    @ApiOperation(value = "直接展示所有的调减航班", httpMethod = "GET")
    @RequestMapping("/index")
    public List<ReduceFlight> getAll(){
        List<ReduceFlight> allReduceFlt = IReduceFlightService.getAll();
        return allReduceFlt;
    }

    /**
     * 根据航路点查找调减航班（json格式）
     * @return
     */
//    @RequestMapping("/selectReduceFltByRoutepoint")
//    public List<ReduceFlight> getOne(@RequestBody Object reduceFlight){
//        JSONObject jsonObject = JSONObject.fromObject(reduceFlight);
//        List<ReduceFlight> list = IReduceFlightService.getOne(jsonObject.getString("wayPoint"));
//        System.out.println(list);
//        return list;
//    }

    /**
     * 根据航路点查找调减航班（网页直接出）
     * @return
     */
    @ApiOperation(value = "根据航路点查找调减航班", httpMethod = "GET")
    @RequestMapping("/selectReduceFltByRoutepoint")
    @ResponseBody
    public List<ReduceFlight> getOne(String reduceFlight){
        List<ReduceFlight> list = IReduceFlightService.getOne(reduceFlight);
        System.out.println(reduceFlight);
        System.out.println(list);
        return list;
    }

    /**
     * 查询规则表中保障航段的数据
     * 保障航段
     * @return
     */
    @ApiOperation(value = "查询规则表中保障航段的数据", httpMethod = "GET")
    @RequestMapping("/selectEnsureSegment")
    public List<ReduceFlight> getEnsureSegment(){
        List<ReduceFlight> EnsureSegmentList = IReduceFlightService.getAllEnsureSegmentInfo();
        return EnsureSegmentList;
    }

    /**
     * 查询规则表中航后目的地的数据
     * 航班号 目的地机场
     * @return
     */
    @ApiOperation(value = "查询规则表中航后目的地的数据", httpMethod = "GET")
    @RequestMapping("/selectDestination")
    public List<ReduceFlight> getDestination(){
        List<ReduceFlight> DestinationList = IReduceFlightService.getAllDestinationInfo();
        return DestinationList;
    }

    /**
     * 查询规则表中指定航段的数据
     * 航段 飞机号
     * @return
     */
    @ApiOperation(value = "查询规则表中指定航段的数据", httpMethod = "GET")
    @RequestMapping("/selectSegment")
    public List<ReduceFlight> getSegment(){
        List<ReduceFlight> SegmentList = IReduceFlightService.getAllSegmentInfo();
        return SegmentList;
    }

    /**
     * 根据航路点删除调减航班
     * @param wayPoint
     * @return
     */
    @ApiOperation(value = "根据航路点删除调减航班", httpMethod = "GET")
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String wayPoint){
//        JSONObject jsonObject = JSONObject.fromObject(ruleId);
        int row = IReduceFlightService.deleteByWayPoint(wayPoint);
        return "执行删除规则数据成功，" + "影响" + row + "行";
    }

    /**
     * 基于问题机场数据进行计算
     * 贪心算法 model1
     * @return
     */
//    @RequestMapping("/calGreedy")
//    public void calculateGreedy(){
//
//    }

    /**
     * 基于问题机场数据进行计算
     * 模拟退火算法 model2
     * @return
     */
//    @RequestMapping("/calSA")
//    public void calculateSA(){
//
//    }

    /**
     * 基于问题机场数据进行计算
     * 列生成算法 model3
     * @return
     */
//    @RequestMapping("/calColumn")
//    public void calculateColumn(){
//
//    }
}
