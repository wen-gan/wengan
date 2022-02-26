package com.bjtu.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjtu.recovery.entity.CostParameter;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-14
 */
public interface ICostParameterService extends IService<CostParameter> {

    List<Map<String, Object>> getOriginalData();

    int test(String costId, String name, String parameterValue, String instruction, String userId, String updateTime);

    int test2(String name, String parameterValue, String instruction, String userId, String updateTime, String costId);
}
