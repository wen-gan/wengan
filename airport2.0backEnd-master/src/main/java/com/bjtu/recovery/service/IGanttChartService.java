package com.bjtu.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjtu.recovery.entity.GanttChart;
import com.bjtu.recovery.entity.Result;
import com.bjtu.recovery.entity.StatisticResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-26
 */
public interface IGanttChartService extends IService<GanttChart> {
    List<Map<String, Object>> getOriginalData();

    List<GanttChart> getAllFlight();

    List<GanttChart> getRecoveryData();

    List<GanttChart> getinfo1(String sample_id);

    List<GanttChart> getResultByModel(String model);

    List<GanttChart> getallResultByModel1();

    List<GanttChart> getResultByModel1();

    List<GanttChart> getResultByModel1Orig();

    List<GanttChart> getallResultByModel2();

    List<GanttChart> getResultByModel2();

    List<GanttChart> getResultByModel2Orig();

    List<GanttChart> getallResultByModel3();

    List<GanttChart> getResultByModel3();

    List<GanttChart> getResultByModel3Orig();

    int backinfo(String origAircraft, String origDepAirport,
                 String origArrAirport, String origDepTime,
                 String origArrTime, String origCrew,
                 String aircraft, String depAirport,
                 String arrAirport, String depTime,
                 String arrTime, String isRecovery,
                 String isCancelled, String isDelayed,
                 String isMerge, String isStraighten,
                 String isSwap, String isFerry,
                 String mergeList, String straightenList);

    int insertRes(List<GanttChart> resultArray);

    List<GanttChart> getCancelled();

    List<GanttChart> getDelayed();

    List<GanttChart> getMerge();

    List<GanttChart> getStraighten();

    List<GanttChart> getFerry();

    int updateinfo(String origAircraft, String origDepAirport,
                   String origArrAirport, String origDepTime,
                   String origArrTime, String origCrew,
                   String aircraft, String depAirport,
                   String arrAirport, String depTime,
                   String arrTime, String isRecovery,
                   String isCancelled, String isDelayed,
                   String isMerge, String isStraighten,
                   String isSwap, String isFerry,
                   String mergeList, String straightenList,
                   String sampleId);

    int insertData(String flightNo,//String sampleId,
             String model, String modelUpdateTime,
             String origAircraft, String origDepAirport,
             String origArrAirport, String origDepTime,
             String origArrTime, String origCrew,
             String aircraft, String depAirport,
             String arrAirport, String depTime,
             String arrTime, String isRecovery,
             String isCancelled, String isDelayed,
             String isMerge, String isStraighten,
             String isSwap, String isFerry,
             String mergeList, String straightenList,
             String userId, String updateTime);

    int updateData(String origAircraft, String sampleId);

    int deleteBySampleId(String sampleId);

    List<GanttChart> getResults(String model);

    /**
     * 插入新增数据列表
     * @param addList 要插入的列表
     */
    void insertDataList(List<GanttChart> addList);

    /**
     * 更新列表
     * @param updateList  要更新的列表
     */
    void updateDataList(List<GanttChart> updateList);

    int airportresult(GanttChart sr);

    void saveResult(GanttChart res);

    int insertResult(GanttChart ganttChart);
}
