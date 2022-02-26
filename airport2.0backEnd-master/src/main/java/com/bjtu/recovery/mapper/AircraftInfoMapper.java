package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.AircraftInfo;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-14
 */
@Repository
public interface AircraftInfoMapper extends BaseMapper<AircraftInfo> {
    /**
     * 查询aircraft_info表中的所有数据
     */
    @Select("select * from aircraft_info")
    List<AircraftInfo> getAll();

    /**
     * 查询aircraft_info表的机场数据-根据机场名称
     * @return
     */
    @Select("SELECT * FROM `aircraft_info` WHERE aircraft_info.apt_name = #{apt_name}")
    List<JSONObject> getaircraft_infoByapt_name(@Param("apt_name") String apt_name);
}
