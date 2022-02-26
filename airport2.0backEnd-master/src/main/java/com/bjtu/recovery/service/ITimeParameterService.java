package com.bjtu.recovery.service;

import com.bjtu.recovery.entity.TimeParameter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ITimeParameterService extends IService<TimeParameter>{

    List<TimeParameter> getParameterInfo(String airportname, String userId);

    Integer insertinfo(String airportname,
                       String  paraname,
                       Double warningtime1,
                       Double warningtime2,
                       String userId,
                       String updateTime);

    Integer updateInfo(Integer id,
                       String airportname,
                       String  paraname,
                       Double warningtime1,
                       Double warningtime2,
                       String userId,
                       String updateTime);

    Integer batchDelete(Integer id);
}
