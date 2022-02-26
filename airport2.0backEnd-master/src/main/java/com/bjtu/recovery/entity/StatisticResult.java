package com.bjtu.recovery.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author WuZhen
* @since 2020-03-01
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("STATISTIC_RESULT")
public class StatisticResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String inputname;
    private String model;
    private Integer flightnum;

    private Integer beallo;

    private Integer gatenum;

    private Integer neargatenum;

    private Integer allostate;

    private Integer timespend;

    private Integer haveallo;

    private String bridgerate;

    private Integer bridgenum;
    private String userid;

    @TableField("updateTime")
    private String updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getInputname() {
//        return inputname;
//    }
//
//    public void setInputname(String inputname) {
//        this.inputname = inputname;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public Integer getFlightnum() {
//        return flightnum;
//    }
//
//    public void setFlightnum(Integer flightnum) {
//        this.flightnum = flightnum;
//    }
//
//    public Integer getBeallo() {
//        return beallo;
//    }
//
//    public void setBeallo(Integer beallo) {
//        this.beallo = beallo;
//    }
//
//    public Integer getGatenum() {
//        return gatenum;
//    }
//
//    public void setGatenum(Integer gatenum) {
//        this.gatenum = gatenum;
//    }
//
//    public Integer getNeargatenum() {
//        return neargatenum;
//    }
//
//    public void setNeargatenum(Integer neargatenum) {
//        this.neargatenum = neargatenum;
//    }
//
//    public Integer getAllostate() {
//        return allostate;
//    }
//
//    public void setAllostate(Integer allostate) {
//        this.allostate = allostate;
//    }
//
//    public Integer getTimespend() {
//        return timespend;
//    }
//
//    public void setTimespend(Integer timespend) {
//        this.timespend = timespend;
//    }
//
//    public Integer getHaveallo() {
//        return haveallo;
//    }
//
//    public void setHaveallo(Integer haveallo) {
//        this.haveallo = haveallo;
//    }
//
//    public String getBridgerate() {
//        return bridgerate;
//    }
//
//    public void setBridgerate(String bridgerate) {
//        this.bridgerate = bridgerate;
//    }
//
//    public Integer getBridgenum() {
//        return bridgenum;
//    }
//
//    public void setBridgenum(Integer bridgenum) {
//        this.bridgenum = bridgenum;
//    }
//
//    public String getUserid() {
//        return userid;
//    }
//
//    public void setUserid(String userid) {
//        this.userid = userid;
//    }
//
//    public String getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(String updateTime) {
//        this.updateTime = updateTime;
//    }
}
