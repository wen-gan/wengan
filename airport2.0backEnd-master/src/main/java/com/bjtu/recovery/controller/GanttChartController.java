package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.GanttChart;
import com.bjtu.recovery.entity.Result;
import com.bjtu.recovery.entity.StatisticResult;
import com.bjtu.recovery.entity.vo.TestFlightResult;
import com.bjtu.recovery.service.IGanttChartService;
import com.bjtu.recovery.service.IResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.bjtu.recovery.controller.ResultController.compareFlightIdAndFileName;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-14
 * Swagger：http://localhost:8866/swagger-ui.html#/
 * 接口类型：GET请求（查询原始航班信息）
 * 问题机场恢复接口名：gantt-chart/selectAllFlight
 * url：http://localhost:8866/gantt-chart/selectAllFlight
 *
 * 接口类型：POST请求（插入结果表数据）
 * 问题机场恢复接口名：gantt-chart/insertResultData
 * url：http://localhost:8866/gantt-chart/insertResultData
 *
 * 接口类型：POST请求（更新结果表数据）
 * 问题机场恢复接口名：gantt-chart/updateResultData
 * url：http://localhost:8866/gantt-chart/updateResultData
 *
 * 接口类型：GET请求（删除结果表数据）
 * 问题机场恢复接口名：gantt-chart/delete
 * url：http://localhost:8866/gantt-chart/delete
 *
 * 接口类型：GET请求（模型一结果表数据（所有））
 * 问题机场恢复接口名：gantt-chart/selectAllByModel1
 * url：http://localhost:8866/gantt-chart/selectAllByModel1
 *
 * 接口类型：GET请求（模型二结果表数据（所有））
 * 问题机场恢复接口名：gantt-chart/selectAllByModel2
 * url：http://localhost:8866/gantt-chart/selectAllByModel2
 *
 * 接口类型：GET请求（模型三结果表数据（所有））
 * 问题机场恢复接口名：gantt-chart/selectAllByModel3
 * url：http://localhost:8866/gantt-chart/selectAllByModel3
 */

@Api(description = "结果数据接口")
@RestController
@RequestMapping("/gantt-chart")
@SuppressWarnings({"all"})
public class GanttChartController {

    @Autowired
    private com.bjtu.recovery.service.IResultService IResultService;

    @Autowired
    private IGanttChartService IGanttChartService;

    /**
     * 查找原始航班信息（*）
     * @return
     */
    @ApiOperation(value = "查找原始航班信息", httpMethod = "GET")
    @RequestMapping("/selectOriginal")
    public List<Map<String, Object>> getallresult(){
        List<Map<String, Object>> originalData = IGanttChartService.getOriginalData();
        return originalData;
    }

    /**
     * 查找原始航班信息
     * @return
     */
    @ApiOperation(value = "查找原始航班信息", httpMethod = "GET")
    @RequestMapping("/selectAllFlight")
    public List<GanttChart> getallFlight(){
        List<GanttChart> allData = IGanttChartService.getAllFlight();
        return allData;
    }

    /**
     * 查找恢复航班信息
     * @return
     */
    @ApiOperation(value = "查找恢复航班信息", httpMethod = "GET")
    @RequestMapping("/selectRecoveryData")
    public List<GanttChart> getrecoveryData(){
        List<GanttChart> recoveryData = IGanttChartService.getRecoveryData();
        return recoveryData;
    }

    /**
     * 通过算例id查找数据（原始+恢复）
     * @param backinfo
     * @return
     */
    //服务器返回数据提取
    @ApiOperation(value = "通过算例id查找数据", httpMethod = "GET")
    @RequestMapping("/getGanttChartBysampleid")
    public List<GanttChart> getGanttChartBysampleid(@RequestBody Object backinfo){
        JSONObject jsonObject = JSONObject.fromObject(backinfo);
        List<GanttChart> list = IGanttChartService.getinfo1(jsonObject.getString("sample_id"));
        System.out.println(list);
        return list;
    }

    /**
     * 根据模型查找数据（json格式）
     * @param allFlight
     * @return
     */
//    @RequestMapping("/selectAllFlightByModel")
//    public List<GanttChart> getallFlightByModel(@RequestBody Object allFlight){
//        JSONObject jsonObject = JSONObject.fromObject(allFlight);
//        List<GanttChart> list = IGanttChartService.getResultByModel(jsonObject.getString("model"));
//        System.out.println(list);
//        return list;
//    }

    /**
     * 根据模型查找数据（网页直接出）
     * @param model
     * @return
     */
    @ApiOperation(value = "根据模型查找数据", httpMethod = "GET")
    @RequestMapping("/selectAllFlightByModel")
    @ResponseBody
    public List<GanttChart> getallFlightByModel(String model){
        List<GanttChart> list = IGanttChartService.getResultByModel(model);
        System.out.println(list);
        System.out.println(model);
        return list;
    }

    /**
     * 查找model1所有数据
     * @return
     */
    @ApiOperation(value = "查找model1所有数据", httpMethod = "GET")
    @RequestMapping("/selectAllByModel1")
    public List<GanttChart> getallByModel1(){
        List<GanttChart> allFlight = IGanttChartService.getallResultByModel1();
        return allFlight;
    }

    /**
     * 查找model1恢复数据
     * @return
     */
    @ApiOperation(value = "查找model1恢复数据", httpMethod = "GET")
    @RequestMapping("/selectAllFlightByModel1")
    public List<GanttChart> getallFlightByModel1(){
        List<GanttChart> allFlight = IGanttChartService.getResultByModel1();
        return allFlight;
    }

    /**
     * 查找model1原始数据
     * @return
     */
    @ApiOperation(value = "查找model1原始数据", httpMethod = "GET")
    @RequestMapping("/selectAllOrgiFlightByModel1")
    public List<GanttChart> getallOrgiFlightByModel1(){
        List<GanttChart> allFlight = IGanttChartService.getResultByModel1Orig();
        return allFlight;
    }

    /**
     * 查找model2所有数据
     * @return
     */
    @ApiOperation(value = "查找model2所有数据", httpMethod = "GET")
    @RequestMapping("/selectAllByModel2")
    public List<GanttChart> getallByModel2(){
        List<GanttChart> allFlight = IGanttChartService.getallResultByModel2();
        return allFlight;
    }

    /**
     * 查找model2恢复数据
     * @return
     */
    @ApiOperation(value = "查找model2恢复数据", httpMethod = "GET")
    @RequestMapping("/selectAllFlightByModel2")
    public List<GanttChart> getallFlightByModel2(){
        List<GanttChart> allFlight = IGanttChartService.getResultByModel2();
        return allFlight;
    }

    /**
     * 查找model2原始数据
     * @return
     */
    @ApiOperation(value = "查找model2原始数据", httpMethod = "GET")
    @RequestMapping("/selectAllOrgiFlightByModel2")
    public List<GanttChart> getallOrgiFlightByModel2(){
        List<GanttChart> allFlight = IGanttChartService.getResultByModel2Orig();
        return allFlight;
    }

    /**
     * 查找model3所有数据
     * @return
     */
    @ApiOperation(value = "查找model3所有数据", httpMethod = "GET")
    @RequestMapping("/selectAllByModel3")
    public List<GanttChart> getallByModel3(){
        List<GanttChart> allFlight = IGanttChartService.getallResultByModel3();
        return allFlight;
    }

    /**
     * 查找model3恢复数据
     * @return
     */
    @ApiOperation(value = "查找model3恢复数据", httpMethod = "GET")
    @RequestMapping("/selectAllFlightByModel3")
    public List<GanttChart> getallFlightByModel3(){
        List<GanttChart> allFlight = IGanttChartService.getResultByModel3();
        return allFlight;
    }

    /**
     * 查找model3原始数据
     * @return
     */
    @ApiOperation(value = "查找model3原始数据", httpMethod = "GET")
    @RequestMapping("/selectAllOrgiFlightByModel3")
    public List<GanttChart> getallOrgiFlightByModel3(){
        List<GanttChart> allFlight = IGanttChartService.getResultByModel3Orig();
        return allFlight;
    }

    //保存人工恢复数据到result数据库
    @ApiOperation(value = "保存人工恢复数据到result数据库", httpMethod = "POST")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String result) {
        JSONObject dada= JSONObject.fromObject(result);
        net.sf.json.JSONObject data = net.sf.json.JSONObject.fromObject(dada.getJSONObject("data"));//得到的是返回数据中的data部分
        JSONArray jsonArray= JSONArray.fromObject(data.getJSONArray("result"));//有更新没有插入
        System.out.println(jsonArray);

        int sum = 0;
        System.out.println(jsonArray.size());
        /*
                 String origAircraft, String origDepAirport,
                 String origArrAirport, String origDepTime,
                 String origArrTime, String origCrew,
                 String aircraft, String depAirport,
                 String arrAirport, String depTime,
                 String arrTime, String isRecovery,
                 String isCancelled, String isDelayed,
                 String isMerge, String isStraighten,
                 String isSwap, String isFerry,
                 String mergeList, String straightenList
         */
        for (int i = 0; i < jsonArray.size(); i++) {
            net.sf.json.JSONObject jsonObject = (net.sf.json.JSONObject) jsonArray.get(i);
            int row = IGanttChartService.backinfo(
                    jsonObject.getString("origAircraft"),
                    jsonObject.getString("origDepAirport"),
                    jsonObject.getString("origArrAirport"),
                    jsonObject.getString("origDepTime"),
                    jsonObject.getString("origArrTime"),
                    jsonObject.getString("origCrew"),
                    jsonObject.getString("aircraft"),
                    jsonObject.getString("depAirport"),
                    jsonObject.getString("arrAirport"),
                    jsonObject.getString("depTime"),
                    jsonObject.getString("arrTime"),
                    jsonObject.getString("isRecovery"),
                    jsonObject.getString("isCancelled"),
                    jsonObject.getString("isDelayed"),
                    jsonObject.getString("isMerge"),
                    jsonObject.getString("isStraighten"),
                    jsonObject.getString("isSwap"),
                    jsonObject.getString("isFerry"),
                    jsonObject.getString("mergeList"),
                    jsonObject.getString("straightenList")
//                    Integer.parseInt(jsonObject.getString("allostate")),
//                    Integer.parseInt(jsonObject.getString("flightid"))
            );
            System.out.println("----");
            sum = sum + row;

        }
        System.out.println(sum);
        return "插入成功，" + "影响" + sum + "行";
    }

    //更改航班恢复状态(parkinggate=你所选的值&id=你选的值）
    @ApiOperation(value = "更改航班恢复状态", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Object Result){
        System.out.println(Result);
        JSONObject jsonObject = JSONObject.fromObject(Result);
        int accept= IGanttChartService.updateinfo(
                jsonObject.getString("origAircraft"),
                jsonObject.getString("origDepAirport"),
                jsonObject.getString("origArrAirport"),
                jsonObject.getString("origDepTime"),
                jsonObject.getString("origArrTime"),
                jsonObject.getString("origCrew"),
                jsonObject.getString("aircraft"),
                jsonObject.getString("depAirport"),
                jsonObject.getString("arrAirport"),
                jsonObject.getString("depTime"),
                jsonObject.getString("arrTime"),
                jsonObject.getString("isRecovery"),
                jsonObject.getString("isCancelled"),
                jsonObject.getString("isDelayed"),
                jsonObject.getString("isMerge"),
                jsonObject.getString("isStraighten"),
                jsonObject.getString("isSwap"),
                jsonObject.getString("isFerry"),
                jsonObject.getString("mergeList"),
                jsonObject.getString("straightenList"),
                jsonObject.getString("sampleId")
        );
        if (accept > 1){
            System.out.println("状态接收成功");
        }else {
            System.out.println("状态接收失败");
        }

        return "执行更改限停区域和机位编号成功，" + "影响" + accept + "行";
    }

    /**
     * 数据统计界面
     * 取消航班数据（根据是否为1来判定）
     * @return
     */
    @ApiOperation(value = "取消航班数据", httpMethod = "GET")
    @RequestMapping("/selectCancelledFlight")
    public List<GanttChart> getcancelledFlight(){
        List<GanttChart> cancelledFlight = IGanttChartService.getCancelled();
        return cancelledFlight;
    }

    /**
     * 数据统计界面
     * 延误航班数据（根据是否为1来判定）
     * @return
     */
    @ApiOperation(value = "延误航班数据", httpMethod = "GET")
    @RequestMapping("/selectDelayedFlight")
    public List<GanttChart> getdelayedFlight(){
        List<GanttChart> delayedFlight = IGanttChartService.getDelayed();
        return delayedFlight;
    }

    /**
     * 数据统计界面
     * 调机航班数据（根据是否为1来判定）
     * @return
     */
    @ApiOperation(value = "调机航班数据", httpMethod = "GET")
    @RequestMapping("/selectFerryFlight")
    public List<GanttChart> getferryFlight(){
        List<GanttChart> ferryFlight = IGanttChartService.getFerry();
        return ferryFlight;
    }

    /**
     * 数据统计界面
     * 合并航班数据（根据是否为1来判定）
     * @return
     */
    @ApiOperation(value = "合并航班数据", httpMethod = "GET")
    @RequestMapping("/selectMergeFlight")
    public List<GanttChart> getmergeFlight(){
        List<GanttChart> mergeFlight = IGanttChartService.getMerge();
        return mergeFlight;
    }

    /**
     * 数据统计界面
     * 拉直航班数据（根据是否为1来判定）
     * @return
     */
    @ApiOperation(value = "拉直航班数据", httpMethod = "GET")
    @RequestMapping("/selectStraightenFlight")
    public List<GanttChart> getstraightenFlight(){
        List<GanttChart> straightenFlight = IGanttChartService.getStraighten();
        return straightenFlight;
    }

    //插入人工恢复完成后的数据
    @ApiOperation(value = "插入人工恢复完成后的数据", httpMethod = "POST")
    @RequestMapping(value = "/insertResultData", method = RequestMethod.POST)
    @ResponseBody
    public String insertData(String flightNo, String model, String modelUpdateTime,//String sampleId, sampleId,
                             String origAircraft, String origDepAirport, String origArrAirport, String origDepTime,
                             String origArrTime, String origCrew, String aircraft, String depAirport,
                             String arrAirport, String depTime, String arrTime, String isRecovery,
                             String isCancelled, String isDelayed, String isMerge, String isStraighten,
                             String isSwap, String isFerry, String mergeList, String straightenList, String userId, String updateTime) {
        int row = IGanttChartService.insertData(flightNo, model, modelUpdateTime, origAircraft, origDepAirport,
                origArrAirport, origDepTime, origArrTime, origCrew, aircraft, depAirport, arrAirport, depTime,
                arrTime, isRecovery, isCancelled, isDelayed, isMerge, isStraighten, isSwap, isFerry,
                mergeList, straightenList, userId, updateTime);
        return "执行插入规则数据成功，" + "影响" + row + "行";
    }

    //更改result结果表数据
    @ApiOperation(value = "更改result结果表数据", httpMethod = "POST")
    @RequestMapping(value = "/updateResultData", method = RequestMethod.POST)
    @ResponseBody
    public String updateData(String origAircraft, String sampleId) {
        int row = IGanttChartService.updateData(origAircraft, sampleId);
        return "执行更新规则数据成功，" + "影响" + row + "行";
    }

    //插入测试
    @ApiOperation(value = "插入测试", httpMethod = "POST")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String insertTest(@RequestBody Object conflictInfo) {
        try {
            net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(conflictInfo);

            int row = IGanttChartService.insertData(
//                    jsonObject.getString("sampleId"),
                    jsonObject.getString("flightNo"),
                    jsonObject.getString("model"),
                    jsonObject.getString("modelUpdateTime"),
                    jsonObject.getString("origAircraft"),
                    jsonObject.getString("origDepAirport"),
                    jsonObject.getString("origArrAirport"),
                    jsonObject.getString("origDepTime"),
                    jsonObject.getString("origArrTime"),
                    jsonObject.getString("origCrew"),
                    jsonObject.getString("aircraft"),
                    jsonObject.getString("depAirport"),
                    jsonObject.getString("arrAirport"),
                    jsonObject.getString("depTime"),
                    jsonObject.getString("arrTime"),
                    jsonObject.getString("isRecovery"),
                    jsonObject.getString("isCancelled"),
                    jsonObject.getString("isDelayed"),
                    jsonObject.getString("isMerge"),
                    jsonObject.getString("isStraighten"),
                    jsonObject.getString("isSwap"),
                    jsonObject.getString("isFerry"),
                    jsonObject.getString("mergeList"),
                    jsonObject.getString("straightenList"),
                    jsonObject.getString("userId"),
                    jsonObject.getString("updateTime")
            );

            return "执行插入数据成功，" + "影响" + row + "行";
        } catch (Exception e){
            System.out.println("插入信息错误：原因：" + e);
        }
        return null;
    };

    //更新测试
    @ApiOperation(value = "更新测试", httpMethod = "POST")
    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public String updateTest(@RequestBody Object areaInfo){
        try {
            JSONObject jsonObject = JSONObject.fromObject(areaInfo);

            int row = IGanttChartService.updateData(
                    jsonObject.getString("orig_aircraft"),
                    jsonObject.getString("sample_id"));

            return "执行更改成功，" + "影响" + row + "行";
        }catch (Exception e){
            System.out.println("修改信息错误：原因：" + e);
        }
        return null;
    }

    @ApiOperation(value = "删除操作", httpMethod = "GET")
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String sampleId){
//        JSONObject jsonObject = JSONObject.fromObject(ruleId);
        int row = IGanttChartService.deleteBySampleId(sampleId);
        return "执行删除结果数据成功，" + "影响" + row + "行";
    }


    //保存服务器返回的数据到result数据库
    @ApiOperation(value = "保存服务器返回的数据到result数据库", httpMethod = "POST")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String update(String result) {//@RequestBody
        JSONObject dada=JSONObject.fromObject(result);
        //得到的是返回数据中的data部分
        net.sf.json.JSONObject data = net.sf.json.JSONObject.fromObject(dada.getJSONObject("data"));
        //有更新没有插入
        String res = data.getString("result");
//        if(StringUtils.isBlank(res)){
//            //如果字符串为 "" 直接返回
//            return "no result data";
        //      }

//        log.info(res);
        JSONArray jsonArray=JSONArray.fromObject(res);

        //json转换成list
        List<GanttChart> dataList = new ArrayList<>();
        for (int i=0;i<jsonArray.size();i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            GanttChart r = (GanttChart)JSONObject.toBean(obj,GanttChart.class);
            dataList.add(r);
        }
        System.out.println(dataList.size());
        String model = dataList.get(0).getModel();
        //测试传回来的数据
        dataList.forEach(System.out::println);
        Map<String,GanttChart> infoMap = new HashMap<>(96);
        for(GanttChart r: dataList){
            String key = ""+r.getSampleId()+":"+r.getModel()+":"+r.getFlightNo();
            infoMap.put(key,r);
        }

        //查库 全表扫描
        List<GanttChart> results = IGanttChartService.getResults(model);

        //!!!!!!!!!!!!!!!!!
//        List<TestFlightResult> testFlightResultList = compareFlightIdAndFileName(dataList,IGanttChartService.getTestFlightResultList());
//        Map<String,TestFlightResult> testFlightResultMap = new HashMap<>(16);
//        for(TestFlightResult t:testFlightResultList){
//            testFlightResultMap.put(t.getFileName()+":"+t.getFlightId(),t);
//        }
        //!!!!!!!!!!!!!!!!!

//        测试查表查到的数据
//        results.forEach(System.out::println);
//      Filename:Model:Flightid
        Map<String,GanttChart> dbMap = new HashMap<>(96);
        for(GanttChart r:results){
            String key = r.getSampleId()+":"+r.getModel()+":"+r.getFlightNo();
            dbMap.put(key,r);
        }

        List<GanttChart> addList = new ArrayList<>();
        List<GanttChart> updateList = new ArrayList<>();
        for(String s:infoMap.keySet()){
            if(dbMap.containsKey(s)){
                //更新该Result数据表
                GanttChart updateRes = dbMap.get(s);
                updateRes.setIsRecovery(infoMap.get(s).getIsRecovery());
                updateRes.setIsCancelled(infoMap.get(s).getIsCancelled());
                updateRes.setIsDelayed(infoMap.get(s).getIsDelayed());
                updateRes.setIsMerge(infoMap.get(s).getIsMerge());
                updateRes.setIsStraighten(infoMap.get(s).getIsStraighten());
                updateRes.setIsSwap(infoMap.get(s).getIsSwap());
                updateRes.setIsFerry(infoMap.get(s).getIsFerry());
                updateRes.setMergeList(infoMap.get(s).getMergeList());
                updateRes.setStraightenList(infoMap.get(s).getStraightenList());
                updateRes.setUpdateTime(infoMap.get(s).getUpdateTime());
//                updateRes.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                //!!!!!!!!!!!!!!!!
//                if(testFlightResultMap.containsKey(updateRes.getFilename()+":"+updateRes.getFlightId())){
//                    updateRes.setUserId(testFlightResultMap.get(updateRes.getFilename()+":"+updateRes.getFlightId()).getUserId());
//                }

                //添加到addList
                updateList.add(updateRes);
            }else {
                GanttChart addRes = infoMap.get(s);
                addRes.setOrigAircraft(infoMap.get(s).getOrigAircraft());
                addRes.setOrigDepAirport(infoMap.get(s).getOrigDepAirport());
                addRes.setOrigArrAirport(infoMap.get(s).getOrigArrAirport());
                addRes.setOrigDepTime(infoMap.get(s).getOrigDepTime());
                addRes.setOrigArrTime(infoMap.get(s).getOrigArrTime());
                addRes.setOrigCrew(infoMap.get(s).getOrigCrew());
                addRes.setAircraft(infoMap.get(s).getAircraft());
                addRes.setDepAirport(infoMap.get(s).getDepAirport());
                addRes.setArrAirport(infoMap.get(s).getArrAirport());
                addRes.setDepTime(infoMap.get(s).getDepTime());
                addRes.setArrTime(infoMap.get(s).getArrTime());
                addRes.setIsRecovery(infoMap.get(s).getIsRecovery());
                addRes.setIsCancelled(infoMap.get(s).getIsCancelled());
                addRes.setIsDelayed(infoMap.get(s).getIsDelayed());
                addRes.setIsMerge(infoMap.get(s).getIsMerge());
                addRes.setIsStraighten(infoMap.get(s).getIsStraighten());
                addRes.setIsSwap(infoMap.get(s).getIsSwap());
                addRes.setIsFerry(infoMap.get(s).getIsFerry());
                addRes.setMergeList(infoMap.get(s).getMergeList());
                addRes.setStraightenList(infoMap.get(s).getStraightenList());
                addRes.setUserId(infoMap.get(s).getUserId());
                addRes.setUpdateTime(infoMap.get(s).getUpdateTime());
//                addRes.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                //!!!!!!!!!!!!!!!!
//                if(testFlightResultMap.containsKey(addRes.getFilename()+":"+addRes.getFlightId())){
//                    addRes.setUserId(testFlightResultMap.get(addRes.getFilename()+":"+addRes.getFlightId()).getUserId());
//                }
                addList.add(addRes);
            }
        }
        //插入没有问题
//        log.info("将会插入"+addList.size()+"条数据");
        IGanttChartService.insertDataList(addList);

//        log.info("将会更新"+updateList.size()+"条数据");
//        测试更新的数据
//        updateList.forEach(System.out::println);
        IGanttChartService.updateDataList(updateList);
        return "success";
    }


    //保存服务器返回的数据到statistic数据库
    //20-3-28-14:42 封装对象，改动了IStatisticResultService
    @RequestMapping(value = "/airportresult", method = RequestMethod.POST)
    @ResponseBody
    public String airportresult(String result) {//@RequestBody
        JSONObject dada = JSONObject.fromObject(result);
        //得到服务器返回的数据data

        net.sf.json.JSONObject data = net.sf.json.JSONObject.fromObject(dada.getJSONObject("data"));

        //得到服务器返回的数据statistic
        String userId = dada.getString("userId");
        System.out.println(userId);

        JSONObject jsonObject = data.getJSONObject("statistic");

        GanttChart sr = new GanttChart();

        String origAircraft=jsonObject.getString(jsonObject.getString("origAircraft"));
        String origDepAirport=jsonObject.getString(jsonObject.getString("origDepAirport"));
        String origArrAirport=jsonObject.getString(jsonObject.getString("origArrAirport"));
        String origDepTime=jsonObject.getString(jsonObject.getString("origDepTime"));
        String origArrTime=jsonObject.getString(jsonObject.getString("origArrTime"));
        String origCrew=jsonObject.getString(jsonObject.getString("origCrew"));
        String aircraft=jsonObject.getString(jsonObject.getString("aircraft"));
        String depAirport=jsonObject.getString(jsonObject.getString("depAirport"));
        String arrAirport=jsonObject.getString(jsonObject.getString("arrAirport"));
        String depTime=jsonObject.getString(jsonObject.getString("depTime"));
        String arrTime=jsonObject.getString(jsonObject.getString("arrTime"));
        String isRecovery=jsonObject.getString(jsonObject.getString("isRecovery"));
        String isCancelled=jsonObject.getString(jsonObject.getString("isCancelled"));
        String isDelayed=jsonObject.getString(jsonObject.getString("isDelayed"));
        String isMerge=jsonObject.getString(jsonObject.getString("isMerge"));
        String isStraighten=jsonObject.getString(jsonObject.getString("isStraighten"));
        String isSwap=jsonObject.getString(jsonObject.getString("isSwap"));
        String isFerry=jsonObject.getString(jsonObject.getString("isFerry"));
        String mergeList=jsonObject.getString(jsonObject.getString("mergeList"));
        String straightenList=jsonObject.getString(jsonObject.getString("straightenList"));
        String updateTime=jsonObject.getString(jsonObject.getString("updateTime"));

        sr.setOrigAircraft(origAircraft);
        sr.setOrigDepAirport(origDepAirport);
        sr.setOrigArrAirport(origArrAirport);
        sr.setOrigDepTime(origDepTime);
        sr.setOrigArrTime(origArrTime);
        sr.setOrigCrew(origCrew);
        sr.setAircraft(aircraft);
        sr.setDepAirport(depAirport);
        sr.setArrAirport(arrAirport);
        sr.setDepTime(depTime);
        sr.setArrTime(arrTime);
        sr.setIsRecovery(isRecovery);
        sr.setIsCancelled(isCancelled);
        sr.setIsDelayed(isDelayed);
        sr.setIsMerge(isMerge);
        sr.setIsStraighten(isStraighten);
        sr.setIsSwap(isSwap);
        sr.setIsFerry(isFerry);
        sr.setMergeList(mergeList);
        sr.setStraightenList(straightenList);
        sr.setUpdateTime(updateTime);
        IGanttChartService.airportresult(sr);
        return jsonObject.toString();
    }

}
