package com.bjtu.recovery.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("result")
public class GanttChart {

//    private Integer id;
    private String sampleId;
    private String flightNo;
    private String model;

    public String getModelUpdateTime() {
        return modelUpdateTime;
    }

    public void setModelUpdateTime(String modelUpdateTime) {
        this.modelUpdateTime = modelUpdateTime;
    }

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date modelUpdateTime;
    private String modelUpdateTime;
    private String origAircraft;
    private String origDepAirport;
    private String origArrAirport;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date origDepTime;
    private String origDepTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date origArrTime;
    private String origArrTime;
    private String origCrew;
    private String aircraft;
    private String depAirport;
    private String arrAirport;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date depTime;
    private String depTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date arrTime;
    private String arrTime;
    private String isRecovery;
    private String isCancelled;
    private String isDelayed;
    private String isMerge;
    private String isStraighten;
    private String isSwap;
    private String isFerry;
    private String mergeList;
    private String straightenList;
    private String userId;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date updateTime;
    private String updateTime;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public Date getModelUpdateTime() {
//        return modelUpdateTime;
//    }
//
//    public void setModelUpdateTime(Date modelUpdateTime) {
//        this.modelUpdateTime = modelUpdateTime;
//    }

    public String getOrigAircraft() {
        return origAircraft;
    }

    public void setOrigAircraft(String origAircraft) {
        this.origAircraft = origAircraft;
    }

    public String getOrigDepAirport() {
        return origDepAirport;
    }

    public void setOrigDepAirport(String origDepAirport) {
        this.origDepAirport = origDepAirport;
    }

    public String getOrigArrAirport() {
        return origArrAirport;
    }

    public void setOrigArrAirport(String origArrAirport) {
        this.origArrAirport = origArrAirport;
    }

//    public Date getOrigDepTime() {
//        return origDepTime;
//    }
//
//    public void setOrigDepTime(Date origDepTime) {
//        this.origDepTime = origDepTime;
//    }
//
//    public Date getOrigArrTime() {
//        return origArrTime;
//    }
//
//    public void setOrigArrTime(Date origArrTime) {
//        this.origArrTime = origArrTime;
//    }

    public String getOrigCrew() {
        return origCrew;
    }

    public void setOrigCrew(String origCrew) {
        this.origCrew = origCrew;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

//    public Date getDepTime() {
//        return depTime;
//    }
//
//    public void setDepTime(Date depTime) {
//        this.depTime = depTime;
//    }
//
//    public Date getArrTime() {
//        return arrTime;
//    }
//
//    public void setArrTime(Date arrTime) {
//        this.arrTime = arrTime;
//    }

    public String getIsRecovery() {
        return isRecovery;
    }

    public void setIsRecovery(String isRecovery) {
        this.isRecovery = isRecovery;
    }

    public String getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(String isCancelled) {
        this.isCancelled = isCancelled;
    }

    public String getIsDelayed() {
        return isDelayed;
    }

    public void setIsDelayed(String isDelayed) {
        this.isDelayed = isDelayed;
    }

    public String getIsMerge() {
        return isMerge;
    }

    public void setIsMerge(String isMerge) {
        this.isMerge = isMerge;
    }

    public String getIsStraighten() {
        return isStraighten;
    }

    public void setIsStraighten(String isStraighten) {
        this.isStraighten = isStraighten;
    }

    public String getIsSwap() {
        return isSwap;
    }

    public void setIsSwap(String isSwap) {
        this.isSwap = isSwap;
    }

    public String getIsFerry() {
        return isFerry;
    }

    public void setIsFerry(String isFerry) {
        this.isFerry = isFerry;
    }

    public String getMergeList() {
        return mergeList;
    }

    public void setMergeList(String mergeList) {
        this.mergeList = mergeList;
    }

    public String getStraightenList() {
        return straightenList;
    }

    public void setStraightenList(String straightenList) {
        this.straightenList = straightenList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrigDepTime() {
        return origDepTime;
    }

    public void setOrigDepTime(String origDepTime) {
        this.origDepTime = origDepTime;
    }

    public String getOrigArrTime() {
        return origArrTime;
    }

    public void setOrigArrTime(String origArrTime) {
        this.origArrTime = origArrTime;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

    @Override
    public String toString() {
        return "GanttChart{" +
//                "id=" + id +
                "sampleId='" + sampleId + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", model='" + model + '\'' +
                ", modelUpdateTime=" + modelUpdateTime +
                ", origAircraft='" + origAircraft + '\'' +
                ", origDepAirport='" + origDepAirport + '\'' +
                ", origArrAirport='" + origArrAirport + '\'' +
                ", origDepTime=" + origDepTime +
                ", origArrTime=" + origArrTime +
                ", origCrew='" + origCrew + '\'' +
                ", aircraft='" + aircraft + '\'' +
                ", depAirport='" + depAirport + '\'' +
                ", arrAirport='" + arrAirport + '\'' +
                ", depTime=" + depTime +
                ", arrTime=" + arrTime +
                ", isRecovery='" + isRecovery + '\'' +
                ", isCancelled='" + isCancelled + '\'' +
                ", isDelayed='" + isDelayed + '\'' +
                ", isMerge='" + isMerge + '\'' +
                ", isStraighten='" + isStraighten + '\'' +
                ", isSwap='" + isSwap + '\'' +
                ", isFerry='" + isFerry + '\'' +
                ", mergeList='" + mergeList + '\'' +
                ", straightenList='" + straightenList + '\'' +
                ", userId='" + userId + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
