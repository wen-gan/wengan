package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.GanttChart;
import com.bjtu.recovery.entity.GateInfo;
import com.bjtu.recovery.entity.Result;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-26
 */
@Repository
public interface GanttChartMapper extends BaseMapper<GanttChart> {
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
    List<GanttChart> getAllFlight();

    /**
     * 查询恢复后的航班时刻表result
     * @return
     */
    @Select("select aircraft,dep_airport,arr_airport,dep_time,arr_time from result")
    List<GanttChart> getRecoveryData();

    /**
     * 根据算例id查找结果表数据（不是所有）
     * @param sample_id
     * @return
     */
    @Select("select orig_aircraft,orig_dep_airport,orig_arr_airport,orig_dep_time,orig_arr_time,orig_crew,aircraft,dep_airport,arr_airport,dep_time,arr_time,is_recovery,is_cancelled,is_delayed,is_merge,is_straighten,is_swap,is_ferry,merge_list,straighten_list from result where sample_id= #{sample_id}")
    List<GanttChart> getinfo1(@Param("sample_id") String sample_id);

    /**
     * 根据模型筛选结果表的数据
     * @param model
     * @return
     */
    @Select("select aircraft,dep_airport,arr_airport,dep_time,arr_time from result where model=#{model}")
    List<GanttChart> getResultByModel(@Param("model") String model);

    /**
     * 根据模型1筛选结果表的所有数据
     * @return
     */
    @Select("select sample_id,flight_no,model,model_update_time,orig_aircraft,orig_dep_airport,orig_arr_airport," +
            "orig_dep_time,orig_arr_time,orig_crew,aircraft,dep_airport,arr_airport,dep_time,arr_time," +
            "is_recovery,is_cancelled,is_delayed,is_merge,is_straighten,is_swap,is_ferry,merge_list," +
            "straighten_list,user_id,update_time from result where model='model1'")
    List<GanttChart> getallResultByModel1();

    /**
     * 根据模型1筛选结果表的数据
     * @return
     */
    @Select("select aircraft,dep_airport,arr_airport,dep_time,arr_time from result where model='model1'")
    List<GanttChart> getResultByModel1();

    /**
     * 根据模型1筛选结果表的数据
     * @return
     */
    @Select("select orig_aircraft,orig_dep_airport,orig_arr_airport,orig_dep_time,orig_arr_time from result where model='model1'")
    List<GanttChart> getResultByModel1Orig();

    /**
     * 根据模型2筛选结果表的所有数据
     * @return
     */
    @Select("select sample_id,flight_no,model,model_update_time,orig_aircraft,orig_dep_airport,orig_arr_airport," +
            "orig_dep_time,orig_arr_time,orig_crew,aircraft,dep_airport,arr_airport,dep_time,arr_time," +
            "is_recovery,is_cancelled,is_delayed,is_merge,is_straighten,is_swap,is_ferry,merge_list," +
            "straighten_list,user_id,update_time from result where model='model2'")
    List<GanttChart> getallResultByModel2();

    /**
     * 根据模型2筛选结果表的数据
     * @return
     */
    @Select("select aircraft,dep_airport,arr_airport,dep_time,arr_time from result where model='model2'")
    List<GanttChart> getResultByModel2();

    /**
     * 根据模型2筛选结果表的数据
     * @return
     */
    @Select("select orig_aircraft,orig_dep_airport,orig_arr_airport,orig_dep_time,orig_arr_time from result where model='model2'")
    List<GanttChart> getResultByModel2Orig();

    /**
     * 根据模型3筛选结果表的所有数据
     * @return
     */
    @Select("select sample_id,flight_no,model,model_update_time,orig_aircraft,orig_dep_airport,orig_arr_airport," +
            "orig_dep_time,orig_arr_time,orig_crew,aircraft,dep_airport,arr_airport,dep_time,arr_time," +
            "is_recovery,is_cancelled,is_delayed,is_merge,is_straighten,is_swap,is_ferry,merge_list," +
            "straighten_list,user_id,update_time from result where model='model3'")
    List<GanttChart> getallResultByModel3();

    /**
     * 根据模型3筛选结果表的数据
     * @return
     */
    @Select("select aircraft,dep_airport,arr_airport,dep_time,arr_time from result where model='model3'")
    List<GanttChart> getResultByModel3();

    /**
     * 根据模型3筛选结果表的数据
     * @return
     */
    @Select("select orig_aircraft,orig_dep_airport,orig_arr_airport,orig_dep_time,orig_arr_time from result where model='model3'")
    List<GanttChart> getResultByModel3Orig();

    //保存服务器返回的数据
    //保存人工恢复完成的结果的数据
    @Insert("insert into result(orig_aircraft,orig_dep_airport,orig_arr_airport,orig_dep_time,orig_arr_time,orig_crew,aircraft,dep_airport,arr_airport,dep_time,arr_time,is_recovery,is_cancelled,is_delayed,is_merge,is_straighten,is_swap,is_ferry,merge_list,straighten_list) " +
            "values(#{orig_aircraft},#{orig_dep_airport},#{orig_arr_airport},#{orig_dep_time},#{orig_arr_time},#{orig_crew},#{aircraft},#{dep_airport},#{arr_airport},#{dep_time},#{arr_time},#{is_recovery},#{is_cancelled},#{is_delayed},#{is_merge},#{is_straighten},#{is_swap},#{is_ferry},#{merge_list},#{straighten_list})")
    int backinfo(@Param("orig_aircraft") String origAircraft, @Param("orig_dep_airport") String origDepAirport,
                 @Param("orig_arr_airport") String origArrAirport, @Param("orig_dep_time") String origDepTime,
                 @Param("orig_arr_time") String origArrTime, @Param("orig_crew") String origCrew,
                 @Param("aircraft") String aircraft, @Param("dep_airport") String depAirport,
                 @Param("arr_airport") String arrAirport, @Param("dep_time") String depTime,
                 @Param("arr_time") String arrTime, @Param("is_recovery") String isRecovery,
                 @Param("is_cancelled") String isCancelled, @Param("is_delayed") String isDelayed,
                 @Param("is_merge") String isMerge, @Param("is_straighten") String isStraighten,
                 @Param("is_swap") String isSwap, @Param("is_ferry") String isFerry,
                 @Param("merge_list") String mergeList, @Param("straighten_list") String straightenList);

    /**
     * 查找到被取消的航班
     * @return
     */
    @Select("select is_cancelled from result where is_cancelled='1'")
    List<GanttChart> getCancelled();

    /**
     * 查找到被延误的航班
     * @return
     */
    @Select("select is_delayed from result where is_delayed='1'")
    List<GanttChart> getDelayed();

    /**
     * 查找到被合并的航班
     * @return
     */
    @Select("select is_merge from result where is_merge='1'")
    List<GanttChart> getMerge();

    /**
     * 查找到被拉直的航班
     * @return
     */
    @Select("select is_straighten from result where is_straighten='1'")
    List<GanttChart> getStraighten();

    /**
     * 查找到被调机的航班
     * @return
     */
    @Select("select is_ferry from result where is_ferry='1'")
    List<GanttChart> getFerry();

    /**
     * 人工恢复过程更新航班恢复的数据
     * @return
     */
    @Update({"update result set origAircraft= #{origAircraft},origDepAirport=#{origDepAirport},orig_arr_airport=#{orig_arr_airport}," +
            "orig_dep_time=#{orig_dep_time},orig_arr_time=#{orig_arr_time},orig_crew=#{orig_crew},aircraft=#{aircraft},dep_airport=#{dep_airport},arr_airport=#{arr_airport}," +
            "dep_time=#{dep_time},arr_time=#{arr_time},is_recovery=#{is_recovery},is_cancelled=#{is_cancelled},is_delayed=#{is_delayed},is_merge=#{is_merge},is_straighten=#{is_straighten}," +
            "is_swap=#{is_swap},is_ferry=#{is_ferry},merge_list=#{merge_list},straighten_list=#{straighten_list} where sample_id= #{sample_id}"})
    int updateinfo(@Param("orig_aircraft") String origAircraft, @Param("orig_dep_airport") String origDepAirport,
                   @Param("orig_arr_airport") String origArrAirport, @Param("orig_dep_time") String origDepTime,
                   @Param("orig_arr_time") String origArrTime, @Param("orig_crew") String origCrew,
                   @Param("aircraft") String aircraft, @Param("dep_airport") String depAirport,
                   @Param("arr_airport") String arrAirport, @Param("dep_time") String depTime,
                   @Param("arr_time") String arrTime, @Param("is_recovery") String isRecovery,
                   @Param("is_cancelled") String isCancelled, @Param("is_delayed") String isDelayed,
                   @Param("is_merge") String isMerge, @Param("is_straighten") String isStraighten,
                   @Param("is_swap") String isSwap, @Param("is_ferry") String isFerry,
                   @Param("merge_list") String mergeList, @Param("straighten_list") String straightenList,
                   @Param("sample_id") String sampleId);

    //测试
    @Insert("insert into result(flight_no,model,model_update_time," +//sample_id,#{sample_id},
            "orig_aircraft,orig_dep_airport,orig_arr_airport," +
            "orig_dep_time,orig_arr_time,orig_crew,aircraft," +
            "dep_airport,arr_airport,dep_time,arr_time," +
            "is_recovery,is_cancelled,is_delayed,is_merge," +
            "is_straighten,is_swap,is_ferry,merge_list,straighten_list,user_id,update_time) " +
            "values(#{flight_no},#{model},#{model_update_time}," +
            "#{orig_aircraft},#{orig_dep_airport},#{orig_arr_airport}," +
            "#{orig_dep_time},#{orig_arr_time},#{orig_crew},#{aircraft}," +
            "#{dep_airport},#{arr_airport},#{dep_time},#{arr_time}," +
            "#{is_recovery},#{is_cancelled},#{is_delayed},#{is_merge}," +
            "#{is_straighten},#{is_swap},#{is_ferry},#{merge_list},#{straighten_list}," +
            "#{user_id},#{update_time})")//@Param("sample_id") String sampleId,
    int insertData(@Param("flight_no") String flightNo,
             @Param("model") String model, @Param("model_update_time") String model_update_time,
             @Param("orig_aircraft") String origAircraft, @Param("orig_dep_airport") String origDepAirport,
             @Param("orig_arr_airport") String origArrAirport, @Param("orig_dep_time") String origDepTime,
             @Param("orig_arr_time") String origArrTime, @Param("orig_crew") String origCrew,
             @Param("aircraft") String aircraft, @Param("dep_airport") String depAirport,
             @Param("arr_airport") String arrAirport, @Param("dep_time") String depTime,
             @Param("arr_time") String arrTime, @Param("is_recovery") String isRecovery,
             @Param("is_cancelled") String isCancelled, @Param("is_delayed") String isDelayed,
             @Param("is_merge") String isMerge, @Param("is_straighten") String isStraighten,
             @Param("is_swap") String isSwap, @Param("is_ferry") String isFerry,
             @Param("merge_list") String mergeList, @Param("straighten_list") String straightenList,
             @Param("user_id") String userId, @Param("update_time") String updateTime);

    //测试2
    @Update({"UPDATE result set orig_aircraft= #{orig_aircraft} where sample_id= #{sample_id}"})
    int updateData(@Param("orig_aircraft") String origAircraft,@Param("sample_id") String sampleId);

    //按照算例Id来删除数据
    @Delete("DELETE FROM result WHERE sample_id = #{sample_id}")
    int deleteBySampleId(String sampleId);

    /**
     * 插入列表
     * @param addList 要插入的列表
     */
    void insertDataList(List<GanttChart> addList);

    /**
     * 更新列表
     * @param updateList 要更新的列表
     */
    void updateDataList(List<GanttChart> updateList);

    @Select("select * from result where model=#{model}")
    List<GanttChart> getResultData(@Param("model") String model);

    int insertResult(GanttChart ganttChart);
}
