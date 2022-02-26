package com.bjtu.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjtu.recovery.entity.ManualRecovery;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-15
 */
public interface IManualRecoveryService extends IService<ManualRecovery> {
    List<Map<String, Object>> getOriginalData();

    List<ManualRecovery> getAllFlight();

    List<Map<String, Object>> getRecoveryData();

    int insertresultinfo(String aircraft,
                         String dep_airport, String arr_airport,
                         String dep_time, String arr_time);

    List<ManualRecovery> getResultByModel(String model);

    int updateResultinfo(String aircraft,
                         String dep_airport, String arr_airport,
                         String dep_time, String arr_time);
}
