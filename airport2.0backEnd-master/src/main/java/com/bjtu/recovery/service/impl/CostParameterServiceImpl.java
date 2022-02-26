package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.CostParameter;
import com.bjtu.recovery.mapper.CostParameterMapper;
import com.bjtu.recovery.mapper.GanttChartMapper;
import com.bjtu.recovery.service.ICostParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-14
 */
@Service
public class CostParameterServiceImpl extends ServiceImpl<CostParameterMapper, CostParameter> implements ICostParameterService {

    @Autowired
    private CostParameterMapper CostParameterMapper;

    @Override
    public List<Map<String, Object>> getOriginalData() {
        return CostParameterMapper.getOriginalData();
    }

    @Override
    public int test(String costId, String name, String parameterValue, String instruction, String userId, String updateTime) {
        int info = CostParameterMapper.test(costId, name, parameterValue, instruction, userId, updateTime);
        return info;
    }

    @Override
    public int test2(String name, String parameterValue, String instruction, String userId, String updateTime, String costId) {
        int info = CostParameterMapper.test2(name, parameterValue, instruction, userId, updateTime, costId);
        return info;
    }

}
