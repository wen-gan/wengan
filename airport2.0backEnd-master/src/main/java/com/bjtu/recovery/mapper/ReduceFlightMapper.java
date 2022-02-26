package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.ReduceFlight;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 */
@Repository
public interface ReduceFlightMapper extends BaseMapper<ReduceFlight> {
    //查询航班调减表中所有数据信息
    @Select("select id,date,way_point,reduce_num,reduce_start_date,reduce_end_date,guaranteed_route_id,leg_id,designated_aircraft,aircraft_id,destination,user_id,update_time from reduce_flight")
    List<ReduceFlight> getAlldata();

    //查询规则表(航班调减)中所有航班数据
    @Select("select way_point,reduce_num,reduce_start_date,reduce_end_date from reduce_flight")
    List<ReduceFlight> getAll();

    //按照航路点查找调减的航路点数据
    @Select("select way_point,reduce_num,reduce_start_date,reduce_end_date from reduce_flight where way_point = #{way_point}")
    List<ReduceFlight> getOne(@Param("way_point") String wayPoint);

    //查询规则表(航班调减)中所有数据 保障航段（保障航段）
    @Select("select guaranteed_route_id from reduce_flight")
    List<ReduceFlight> getAllEnsureSegmentInfo();

    //查询规则表(航班调减)中所有数据 航后目的地（飞机号+目的地机场）
    @Select("select designated_aircraft,destination from reduce_flight")
    List<ReduceFlight> getAllDestinationInfo();

    //查询规则表(航班调减)中所有数据 指定航段飞机（指定航段+飞机号）
    @Select("select leg_id,designated_aircraft from reduce_flight")
    List<ReduceFlight> getAllSegmentInfo();

    //按照航路点查找调减的航路点数据
    @Select("select way_point,reduce_num,reduce_start_date,reduce_end_date,guaranteed_route_id,leg_id,designated_aircraft,aircraft_id,destination from reduce_flight where way_point = #{way_point}")
    List<ReduceFlight> getAllByCode(@Param("way_point") String wayPoint);

    //按照航路点来删除数据
    @Delete("DELETE FROM reduce_flight WHERE way_point = #{way_point}")
    int deleteByWayPoint(@Param("way_point") String wayPoint);
}
