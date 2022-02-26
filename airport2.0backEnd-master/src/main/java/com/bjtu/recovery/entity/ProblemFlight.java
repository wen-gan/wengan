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
 * @since 2022-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("problem_flight")
public class ProblemFlight {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    private String guaranteedRouteId;
    private String legId;
    private String designatedAircraft;
    private String aircraftId;
    private String destination;
    private String instruction;
    private String userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGuaranteedRouteId() {
        return guaranteedRouteId;
    }

    public void setGuaranteedRouteId(String guaranteedRouteId) {
        this.guaranteedRouteId = guaranteedRouteId;
    }

    public String getLegId() {
        return legId;
    }

    public void setLegId(String legId) {
        this.legId = legId;
    }

    public String getDesignatedAircraft() {
        return designatedAircraft;
    }

    public void setDesignatedAircraft(String designatedAircraft) {
        this.designatedAircraft = designatedAircraft;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProblemFlight{" +
                "id=" + id +
                ", date=" + date +
                ", guaranteedRouteId='" + guaranteedRouteId + '\'' +
                ", legId='" + legId + '\'' +
                ", designatedAircraft='" + designatedAircraft + '\'' +
                ", aircraftId='" + aircraftId + '\'' +
                ", destination='" + destination + '\'' +
                ", instruction='" + instruction + '\'' +
                ", userId='" + userId + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
