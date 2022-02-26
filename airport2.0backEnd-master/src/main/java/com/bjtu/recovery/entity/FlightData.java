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
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("flight_info")
public class FlightData {
    private Integer id;
    private String flightNo;
    private String planeNo;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date flightDate;
    private String depAirport;
    private String arrAirport;
    private String depCode;
    private String arrCode;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fltPtd;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fltPta;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fltEtd;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fltEta;

}
