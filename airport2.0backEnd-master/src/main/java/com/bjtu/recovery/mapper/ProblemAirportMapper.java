package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.ProblemAirport;
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
public interface ProblemAirportMapper extends BaseMapper<ProblemAirport> {
    //查询问题机场表内所有数据
    @Select("select id,date,four_code,apt_name,influence_start_date,influence_end_date,dep_arr_choice,guaranteed_route_id,leg_id,designated_aircraft,aircraft_id,destination,user_id,update_time from problem_airport")
    List<ProblemAirport> getAllData();

    //查询规则表(问题机场)中所有机场数据
    @Select("select four_code,apt_name,influence_start_date,influence_end_date,dep_arr_choice from problem_airport")
    List<ProblemAirport> getAll();

    //按照机场四字码查找问题机场
    @Select("select four_code,apt_name,influence_start_date,influence_end_date,dep_arr_choice from problem_airport where four_code = #{four_code}")
    List<ProblemAirport> getOne(@Param("four_code") String four_code);

    //查询规则表(问题机场)中所有数据 保障航段（保障航段）
    @Select("select guaranteed_route_id from problem_airport")
    List<ProblemAirport> getAllEnsureSegmentInfo();

    //查询规则表(问题机场)中所有数据 航后目的地（飞机号+目的地机场）
    @Select("select designated_aircraft,destination from problem_airport")
    List<ProblemAirport> getAllDestinationInfo();

    //查询规则表(问题机场)中所有数据 指定航段飞机（指定航段+飞机号）
    @Select("select leg_id,designated_aircraft from problem_airport")
    List<ProblemAirport> getAllSegmentInfo();

    //按照机场四字码查找所有数据
    @Select("select four_code,apt_name,influence_start_date,influence_end_date,dep_arr_choice,guaranteed_route_id,leg_id,designated_aircraft,aircraft_id,destination from problem_airport where four_code = #{four_code}")
    List<ProblemAirport> getAllByCode(@Param("four_code") String four_code);

    //按照机场四字码来删除数据
    @Delete("DELETE FROM problem_airport WHERE four_code = #{four_code}")
    int deleteByFourCode(@Param("four_code") String fourCode);

}
