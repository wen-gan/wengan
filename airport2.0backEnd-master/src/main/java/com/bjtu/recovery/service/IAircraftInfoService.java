package com.bjtu.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjtu.recovery.entity.AircraftInfo;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */
public interface IAircraftInfoService extends IService<AircraftInfo> {
    List<AircraftInfo> getAll();

    List<JSONObject> getaircraft_infoByapt_name(@Param("apt_name") String apt_name);
}
