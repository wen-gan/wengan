package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.FlightData;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */
@Repository
public interface FlightDataMapper extends BaseMapper<FlightData> {
    /**
     * 查询FLIGHT_INFO表中所有数据
     * @return
     */
    @Select("select * from flight_info")
    List<FlightData> getinfo();

}
