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
 * @since 2022-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("aircraft_info")
public class AircraftInfo {

    private Integer id;
    private String acbiRegno;
    private String acfType;
    private double acfBasic_weight;
    private String acfSpecial_opr_capacity;
    private Integer acfTotal_seats;
    private String acfStatus;
    private String createPeople;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private String updatePeople;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private char delFlag;
    private String content;

}
