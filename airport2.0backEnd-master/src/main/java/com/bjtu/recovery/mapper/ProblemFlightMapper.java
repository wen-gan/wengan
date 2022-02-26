package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.ProblemFlight;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-26
 */
@Repository
public interface ProblemFlightMapper extends BaseMapper<ProblemFlight> {
    //查询表格内所有数据
    @Select("select id,date,guaranteed_route_id,leg_id,designated_aircraft,aircraft_id,destination,instruction,user_id,update_time from problem_flight")
    List<ProblemFlight> getAlldata();

    //查询规则表中所有数据 保障航段（保障航段）
    @Select("select guaranteed_route_id from problem_flight")
    List<ProblemFlight> getAllEnsureSegmentInfo();

    //查询规则表中所有数据 航后目的地（飞机号+目的地机场）
    @Select("select designated_aircraft,destination from problem_flight")
    List<ProblemFlight> getAllDestinationInfo();

    //查询规则表中所有数据 指定航段飞机（指定航段+飞机号）
    @Select("select leg_id,designated_aircraft from problem_flight")
    List<ProblemFlight> getAllSegmentInfo();

    //查询计算接口所需的场景数据
    @Select("select id,date,guaranteed_route_id,leg_id,designated_aircraft,aircraft_id,destination from problem_flight where problem_flight.id = #{id}")
    List<ProblemFlight> getAll(@Param("id") String id);
}
