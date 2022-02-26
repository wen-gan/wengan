package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.AircraftInfo;
import com.bjtu.recovery.service.IAircraftInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-14
 */
@RestController
@RequestMapping("/aircraft_info")
public class AircraftInfoController {

    @Autowired
    private IAircraftInfoService IAircraftInfoService;

    /**
     * 查询aircraft_info表中的数据
     */
    @RequestMapping("/select")
    public List<AircraftInfo> getone(){
        List<AircraftInfo> list = IAircraftInfoService.getAll();
        return list;
    }

    /**
     * 查询aircraft_info表中的机场名称
     */
    @RequestMapping("/selectAirportName")
    public List<JSONObject> getName(@RequestParam String apt_name){

        List<JSONObject> list = IAircraftInfoService.getaircraft_infoByapt_name(apt_name);

        return list;
    }
}
