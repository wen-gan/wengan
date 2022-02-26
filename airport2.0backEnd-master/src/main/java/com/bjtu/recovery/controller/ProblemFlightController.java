package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.ProblemFlight;
import com.bjtu.recovery.service.IProblemFlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-26
 * Swagger：http://localhost:8866/swagger-ui.html#/
 * 接口类型：GET请求
 * 问题机场恢复接口名：problem-flight/selectAlldata
 * url：http://localhost:8866/problem-flight/selectAlldata
 */

@Api(description = "问题航班接口")
@RestController
@RequestMapping("/problem-flight")
public class ProblemFlightController {

    @Autowired
    private IProblemFlightService IProblemFlightService;

    /**
     * 查询所有的表格内数据
     * @return
     */
    @ApiOperation(value = "查询所有的表格内数据", httpMethod = "GET")
    @RequestMapping("/selectAlldata")
    public List<ProblemFlight> getAlldata(){
        List<ProblemFlight> allData = IProblemFlightService.getAlldata();
        return allData;
    }

    /**
     * 查询规则表中保障航段的数据
     * 保障航段
     * @return
     */
    @ApiOperation(value = "查询规则表中保障航段的数据", httpMethod = "GET")
    @RequestMapping("/selectEnsureSegment")
    public List<ProblemFlight> getEnsureSegment(){
        List<ProblemFlight> EnsureSegmentList = IProblemFlightService.getAllEnsureSegmentInfo();
        return EnsureSegmentList;
    }

    /**
     * 查询规则表中航后目的地的数据
     * 飞机号 目的地机场
     * @return
     */
    @ApiOperation(value = "查询规则表中航后目的地的数据", httpMethod = "GET")
    @RequestMapping("/selectDestination")
    public List<ProblemFlight> getDestination(){
        List<ProblemFlight> DestinationList = IProblemFlightService.getAllDestinationInfo();
        return DestinationList;
    }

    /**
     * 查询规则表中指定航段的数据
     * 航段 飞机号
     * @return
     */
    @ApiOperation(value = "查询规则表中指定航段的数据", httpMethod = "GET")
    @RequestMapping("/selectSegment")
    public List<ProblemFlight> getSegment(){
        List<ProblemFlight> SegmentList = IProblemFlightService.getAllSegmentInfo();
        return SegmentList;
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
