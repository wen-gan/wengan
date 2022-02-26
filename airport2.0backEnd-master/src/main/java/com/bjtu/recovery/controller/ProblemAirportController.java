package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.ProblemAirport;
import com.bjtu.recovery.service.IProblemAirportService;
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
 * 问题机场恢复接口名：problem-airport/allData
 * url：http://localhost:8866/problem-airport/allData
 */

@Api(description = "问题机场接口")
@RestController
@RequestMapping("/problem-airport")
@CrossOrigin
public class ProblemAirportController {

    @Autowired
    private IProblemAirportService IProblemAirportService;

    /**
     * 表格中所有信息
     * @return
     */
    @ApiOperation(value = "获取所有问题机场数据", httpMethod = "GET")
    @RequestMapping(value = "/allData", method = RequestMethod.GET)
    @CrossOrigin
    public List<ProblemAirport> getAlldata(){
        List<ProblemAirport> allData = IProblemAirportService.getAllData();
        return allData;
    }

    /**
     * 原始界面
     * 直接展示所有的问题航班
     * @return
     */
    @ApiOperation(value = "直接展示所有的问题航班", httpMethod = "GET")
    @RequestMapping("/index")
    public List<ProblemAirport> getAll(){
        List<ProblemAirport> allProblemApt = IProblemAirportService.getAll();
        return allProblemApt;
    }

    /**
     * 根据机场四字码查找问题航班（json格式）
     * @return
     */
//    @RequestMapping("/selectProblemAptByCode")
//    public List<ProblemAirport> getOne(@RequestBody Object problemAirport){
//        JSONObject jsonObject = JSONObject.fromObject(problemAirport);
//        List<ProblemAirport> list = IProblemAirportService.getOne(jsonObject.getString("four_code"));
//        System.out.println(list);
//        return list;
//    }

    /**
     * 根据机场四字码查找问题航班（网页直接出）
     * @return
     */
    @ApiOperation(value = "根据机场四字码查找问题航班", httpMethod = "GET")
    @RequestMapping("/selectProblemAptByCode")
    @ResponseBody
    public List<ProblemAirport> getOne(String problemAirport){
        List<ProblemAirport> list = IProblemAirportService.getOne(problemAirport);
        System.out.println(list);
        System.out.println(problemAirport);
        return list;
    }

    /**
     * 查询规则表中保障航段的数据
     * 保障航段
     * @return
     */
    @ApiOperation(value = "查询规则表中保障航段的数据", httpMethod = "GET")
    @RequestMapping("/selectEnsureSegment")
    public List<ProblemAirport> getEnsureSegment(){
        List<ProblemAirport> EnsureSegmentList = IProblemAirportService.getAllEnsureSegmentInfo();
        return EnsureSegmentList;
    }

    /**
     * 查询规则表中航后目的地的数据
     * 航班号 目的地机场
     * @return
     */
    @ApiOperation(value = "查询规则表中航后目的地的数据", httpMethod = "GET")
    @RequestMapping("/selectDestination")
    public List<ProblemAirport> getDestination(){
        List<ProblemAirport> DestinationList = IProblemAirportService.getAllDestinationInfo();
        return DestinationList;
    }

    /**
     * 查询规则表中指定航段的数据
     * 航段 飞机号
     * @return
     */
    @ApiOperation(value = "查询规则表中指定航段的数据", httpMethod = "GET")
    @RequestMapping("/selectSegment")
    public List<ProblemAirport> getSegment(){
        List<ProblemAirport> SegmentList = IProblemAirportService.getAllSegmentInfo();
        return SegmentList;
    }

    /**
     * 根据机场四字码删除问题机场数据
     * @param fourCode
     * @return
     */
    @ApiOperation(value = "根据机场四字码删除问题机场数据", httpMethod = "GET")
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String fourCode){
//        JSONObject jsonObject = JSONObject.fromObject(ruleId);
        int row = IProblemAirportService.deleteByFourCode(fourCode);
        return "执行删除规则数据成功，" + "影响" + row + "行";
    }

    /**
     * 基于问题机场数据进行计算
     * 贪心算法
     * @return
     */
//    @RequestMapping("/calGreedy")
//    public void calculateGreedy(){
//
//    }

    /**
     * 基于问题机场数据进行计算
     * 模拟退火算法
     * @return
     */
//    @RequestMapping("/calSA")
//    public void calculateSA(){
//
//    }

    /**
     * 基于问题机场数据进行计算
     * 列生成算法
     * @return
     */
//    @RequestMapping("/calColumn")
//    public void calculateColumn(){
//
//    }

}
