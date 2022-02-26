package com.bjtu.recovery.controller;

import com.bjtu.recovery.service.ICostParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-14
 */

@Api(description = "成本数据接口")
@RestController
@RequestMapping("/cost-parameter")
public class CostParameterController {

    @Autowired
    private ICostParameterService ICostParameterService;

    /**
     * 查找成本信息（*）
     * @return
     */
    @ApiOperation(value = "查找成本信息", httpMethod = "GET")
    @RequestMapping("/selectCost")
    public List<Map<String, Object>> getallCost(){
        List<Map<String, Object>> costData = ICostParameterService.getOriginalData();
        return costData;
    }

    //插入成本数据
    @ApiOperation(value = "插入成本数据", httpMethod = "POST")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String insertTest(String costId, String name, String parameterValue, String instruction, String userId, String updateTime) {
        int row = ICostParameterService.test(costId, name, parameterValue, instruction, userId, updateTime);
        return "执行插入规则数据成功，" + "影响" + row + "行";
    }

    //测试更改
    @ApiOperation(value = "更改成本数据", httpMethod = "POST")
    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    @ResponseBody
    public String updateTest(String name, String parameterValue, String instruction, String userId, String updateTime, String costId) {
        int row = ICostParameterService.test2(name, parameterValue, instruction, userId, updateTime, costId);
        return "执行更改规则数据成功，" + "影响" + row + "行";
    }
}
