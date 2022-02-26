package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.ManualRecovery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-15
 */
@Repository
public interface ManualRecoveryMapper extends BaseMapper<ManualRecovery> {
    /**
     * 查询原始航班时刻表result
     * @return
     */
    @Select("select orig_aircraft,orig_dep_airport,orig_arr_airport,orig_dep_time,orig_arr_time from result")
    List<Map<String, Object>> getOriginalData();

    /**
     * 查询原始航班所有数据用户甘特图
     */
    @Select("select orig_aircraft,orig_dep_airport,orig_arr_airport,orig_dep_time,orig_arr_time from result")
    List<ManualRecovery> getAllFlight();

    /**
     * 查询恢复后的航班时刻表result
     * @return
     */
    @Select("select aircraft,dep_airport,arr_airport,dep_time,arr_time from result")
    List<Map<String, Object>> getRecoveryData();


    /**
     * 将调整后的航班数据传入结果表
     * @param aircraft
     * @param dep_airport
     * @param arr_airport
     * @param dep_time
     * @param arr_time
     * @return
     */
    @Insert("insert into result(aircraft,dep_airport,arr_airport,dep_time,arr_time) values(#{aircraft},#{dep_airport},#{arr_airport},#{dep_time}),#{arr_time})")
    int insertresultinfo(@Param("aircraft") String aircraft, @Param("dep_airport") String dep_airport,
                    @Param("arr_airport") String arr_airport, @Param("dep_time") String dep_time,
                    @Param("arr_time") String arr_time);

    /**
     * 根据模型筛选结果表的数据
     * @param model
     * @return
     */
    @Select("select aircraft,dep_airport,arr_airport,dep_time,arr_time from result where model=#{model}")
    List<ManualRecovery> getResultByModel(@Param("model") String model);

    /**
     * 根据甘特图的调整结果 更新结果表的数据
     * @param aircraft
     * @param dep_airport
     * @param arr_airport
     * @param dep_time
     * @param arr_time
     * @return
     */
    @Update({"update result set aircraft= #{aircraft},dep_airport=#{dep_airport},arr_airport=#{arr_airport},dep_time=#{dep_time},arr_time=#{arr_time} where id= #{id}"})
    int updateResultinfo(@Param("aircraft") String aircraft, @Param("dep_airport") String dep_airport,
                   @Param("arr_airport") String arr_airport, @Param("dep_time") String dep_time,
                   @Param("arr_time") String arr_time);
}
