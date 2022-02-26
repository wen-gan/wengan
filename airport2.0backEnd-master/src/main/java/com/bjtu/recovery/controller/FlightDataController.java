package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.FlightData;
import com.bjtu.recovery.service.IFlightDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 *
 * 接口类型：GET请求（航班原始数据）
 * 问题机场恢复接口名：flight/select
 * url：http://localhost:8866/flight/select
 */
@Api(description = "航班信息接口")
@RestController
@RequestMapping("/flight")
public class FlightDataController {

    @Autowired
    private IFlightDataService IFlightDataService;

    /**
     * 查询FLIGHT_INFO表中的数据
     * @return
     */
    @ApiOperation(value = "查询FLIGHT_INFO表中的数据", httpMethod = "GET")
    @RequestMapping("/select")
    public List<FlightData> getone(){

        List<FlightData> list = IFlightDataService.getinfo();

        return list;
    }
}
