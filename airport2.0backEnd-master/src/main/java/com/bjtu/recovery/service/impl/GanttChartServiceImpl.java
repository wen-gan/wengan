package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.GanttChart;
import com.bjtu.recovery.entity.Result;
import com.bjtu.recovery.entity.StatisticResult;
import com.bjtu.recovery.mapper.GanttChartMapper;
import com.bjtu.recovery.mapper.ProblemAirportMapper;
import com.bjtu.recovery.mapper.ResultMapper;
import com.bjtu.recovery.mapper.StatisticResultMapper;
import com.bjtu.recovery.service.IGanttChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-26
 */
@Service
public class GanttChartServiceImpl extends ServiceImpl<GanttChartMapper, GanttChart> implements IGanttChartService {

    @Autowired
    private GanttChartMapper GanttChartMapper;

    @Override
    public List<Map<String, Object>> getOriginalData() {
        return GanttChartMapper.getOriginalData();
    }

    @Override
    public List<GanttChart> getAllFlight() {
        return GanttChartMapper.getAllFlight();
    }

    @Override
    public List<GanttChart> getRecoveryData() {
        return GanttChartMapper.getRecoveryData();
    }

    @Override
    public List<GanttChart> getinfo1(String sample_id) {
        List<GanttChart> info = GanttChartMapper.getinfo1(sample_id);
        return info;
    }

    @Override
    public List getResultByModel(String model) {
        List result = GanttChartMapper.getResultByModel(model);
        return result;
    }

    @Override
    public List<GanttChart> getallResultByModel1() {
        return GanttChartMapper.getallResultByModel1();
    }

    @Override
    public List<GanttChart> getResultByModel1() {
        return GanttChartMapper.getResultByModel1();
    }

    @Override
    public List<GanttChart> getResultByModel1Orig() {
        return GanttChartMapper.getResultByModel1Orig();
    }

    @Override
    public List<GanttChart> getallResultByModel2() {
        return GanttChartMapper.getallResultByModel2();
    }

    @Override
    public List<GanttChart> getResultByModel2() {
        return GanttChartMapper.getResultByModel2();
    }

    @Override
    public List<GanttChart> getResultByModel2Orig() {
        return GanttChartMapper.getResultByModel2Orig();
    }

    @Override
    public List<GanttChart> getallResultByModel3() {
        return GanttChartMapper.getallResultByModel3();
    }

    @Override
    public List<GanttChart> getResultByModel3() {
        return GanttChartMapper.getResultByModel3();
    }

    @Override
    public List<GanttChart> getResultByModel3Orig() {
        return GanttChartMapper.getResultByModel3Orig();
    }

    @Override
    public int backinfo(String origAircraft, String origDepAirport,
                        String origArrAirport, String origDepTime,
                        String origArrTime, String origCrew,
                        String aircraft, String depAirport,
                        String arrAirport, String depTime,
                        String arrTime, String isRecovery,
                        String isCancelled, String isDelayed,
                        String isMerge, String isStraighten,
                        String isSwap, String isFerry,
                        String mergeList, String straightenList) {
        int info = GanttChartMapper.backinfo(origAircraft, origDepAirport,
                origArrAirport, origDepTime,
                origArrTime, origCrew,
                aircraft, depAirport,
                arrAirport, depTime,
                arrTime, isRecovery,
                isCancelled, isDelayed,
                isMerge, isStraighten,
                isSwap, isFerry,
                mergeList, straightenList);
        return info;
    }

    @Override
    public int insertRes(List<GanttChart> resultArray) {
        int sum = 0;
        for (int i = 0; i < resultArray.size(); i++) {
//          net.sf.json.JSONObject jsonObject = (net.sf.json.JSONObject) jsonArray.get(i);
            System.out.println("resultArray.get(i)" + resultArray.get(i));
            int row = GanttChartMapper.insert(resultArray.get(i));
            sum = sum + row;
        }
        return sum;
    }

    @Override
    public List<GanttChart> getCancelled() {
        return GanttChartMapper.getCancelled();
    }

    @Override
    public List<GanttChart> getDelayed() {
        return GanttChartMapper.getDelayed();
    }

    @Override
    public List<GanttChart> getFerry() {
        return GanttChartMapper.getFerry();
    }

    @Override
    public int updateinfo(String origAircraft, String origDepAirport, String origArrAirport, String origDepTime, String origArrTime, String origCrew, String aircraft, String depAirport, String arrAirport, String depTime, String arrTime, String isRecovery, String isCancelled, String isDelayed, String isMerge, String isStraighten, String isSwap, String isFerry, String mergeList, String straightenList, String sampleId) {
        int info = GanttChartMapper.updateinfo(origAircraft, origDepAirport, origArrAirport, origDepTime, origArrTime, origCrew,
                aircraft, depAirport, arrAirport, depTime, arrTime, isRecovery, isCancelled, isDelayed, isMerge, isStraighten, isSwap, isFerry, mergeList, straightenList, sampleId);
        return info;
    }

    @Override
    public int insertData(String flightNo,//String sampleId,
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
                          String userId, String updateTime) {
        int info = GanttChartMapper.insertData(flightNo,//sampleId,
                model, modelUpdateTime,
                origAircraft, origDepAirport,
                origArrAirport, origDepTime,
                origArrTime, origCrew,
                aircraft, depAirport,
                arrAirport, depTime,
                arrTime, isRecovery,
                isCancelled, isDelayed,
                isMerge, isStraighten,
                isSwap, isFerry,
                mergeList, straightenList,
                userId, updateTime);
        return info;
    }

    @Override
    public int updateData(String origAircraft, String sampleId) {
        int info = GanttChartMapper.updateData(origAircraft, sampleId);
        return info;
    }

    @Override
    public List<GanttChart> getMerge() {
        return GanttChartMapper.getMerge();
    }

    @Override
    public List<GanttChart> getStraighten() {
        return GanttChartMapper.getStraighten();
    }

    @Override
    public int deleteBySampleId(String sampleId) {
        int info = GanttChartMapper.deleteBySampleId(sampleId);
        return info;
    }

    @Override
    public List<GanttChart> getResults(String model) {
        return GanttChartMapper.getResultData(model);
    }

    @Override
    public void insertDataList(List<GanttChart> addList) {
        if (addList.size() > 0) {
            GanttChartMapper.insertDataList(addList);
        }

    }

    @Override
    public void updateDataList(List<GanttChart> updateList) {
        if (updateList.size() > 0) {
            GanttChartMapper.updateDataList(updateList);
        }

    }

    @Override
    public int airportresult(GanttChart sr) {
        int info = GanttChartMapper.insert(sr);
        return info;
    }

    @Override
    public void saveResult(GanttChart res) {
        if (res != null) {
            GanttChartMapper.insert(res);
        }
    }

    @Override
    public int insertResult(GanttChart ganttChart) {
        int info = GanttChartMapper.insertResult(ganttChart);
        return info;
    }

}