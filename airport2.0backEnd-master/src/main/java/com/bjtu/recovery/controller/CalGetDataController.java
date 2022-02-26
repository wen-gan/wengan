package com.bjtu.recovery.controller;

import com.bjtu.recovery.annotation.PassToken;
import com.bjtu.recovery.entity.*;
import com.bjtu.recovery.service.IGanttChartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 */

@Api(description = "计算数据接收接口")
@RestController
@RequestMapping("/getalldata")
public class CalGetDataController {

    @Autowired
    private IGanttChartService IGanttChartService;
//    @Autowired
//    ResultController resultController = new ResultController();
//    @Autowired
//    StatisticResultController statisticResultController = new StatisticResultController();
    @Autowired
    GanttChartController GanttChartController = new GanttChartController();

    //查询
    @ApiOperation(value = "查询数据", httpMethod = "GET")
    @RequestMapping("/getdata")
    public String getAll(String sampleId) {
        try {
            /**
             * 查询所有的FlightInfo
             * 1.如果查询出来的list的几个字段都为空，保留
             * 2.如果查询出来的数据有空有非空，保留非空
             */

            List<GanttChart> back_list = IGanttChartService.getinfo1(sampleId);
            back_list.toString();
            System.out.println("wowowo" + back_list.toString());
            //将数据转为json数组
            JSONArray arr = JSONArray.fromObject(back_list);

            //各个表格数据
            String backstr = new String();

            for (int i = 0; i < arr.size(); i++) {
                Map<String, String> map = new LinkedHashMap<>();

                String origAircraft = arr.getJSONObject(i).getString("orig_aircraft");
                String origDepAirport = arr.getJSONObject(i).getString("orig_dep_airport");
                String origArrAirport = arr.getJSONObject(i).getString("orig_arr_airport");
                String origDepTime = arr.getJSONObject(i).getString("orig_dep_time");
                String origArrTime = arr.getJSONObject(i).getString("orig_arr_time");
                String origCrew = arr.getJSONObject(i).getString("orig_crew");
                String aircraft = arr.getJSONObject(i).getString("aircraft");
                String depAirport = arr.getJSONObject(i).getString("dep_airport");
                String arrAirport = arr.getJSONObject(i).getString("arr_airport");
                String depTime = arr.getJSONObject(i).getString("dep_time");
                String arrTime = arr.getJSONObject(i).getString("arr_time");
                String isRecovery = arr.getJSONObject(i).getString("is_recovery");
                String isCancelled = arr.getJSONObject(i).getString("is_cancelled");
                String isDelayed = arr.getJSONObject(i).getString("is_delayed");
                String isMerge = arr.getJSONObject(i).getString("is_merge");
                String isStraighten = arr.getJSONObject(i).getString("is_straighten");
                String isSwap = arr.getJSONObject(i).getString("is_swap");
                String isFerry = arr.getJSONObject(i).getString("is_ferry");
                String mergeList = arr.getJSONObject(i).getString("merge_list");
                String straightenList = arr.getJSONObject(i).getString("straighten_list");

                map.put("orig_aircraft", origAircraft);
                map.put("orig_dep_airport", origDepAirport);
                map.put("orig_arr_airport", origArrAirport);
                map.put("orig_dep_time", origDepTime);
                map.put("orig_arr_time", origArrTime);
                map.put("orig_crew", origCrew);
                map.put("aircraft", aircraft);
                map.put("dep_airport", depAirport);
                map.put("arr_airport", arrAirport);
                map.put("dep_time", depTime);
                map.put("arr_time", arrTime);
                map.put("is_recovery", isRecovery);
                map.put("is_cancelled", isCancelled);
                map.put("is_delayed", isDelayed);
                map.put("is_merge", isMerge);
                map.put("is_straighten", isStraighten);
                map.put("is_swap", isSwap);
                map.put("is_ferry", isFerry);
                map.put("merge_list", mergeList);
                map.put("straighten_list", straightenList);

                ObjectMapper json = new ObjectMapper();
                backstr = backstr + json.writeValueAsString(map) + ",";
            }

            backstr = backstr.substring(0, backstr.length() - 1);
            backstr = "\"flight\":" + '[' + backstr + ']';

            String inputdata = "{" + backstr  + "}";
            return inputdata;
            //    File file = new File(filePath);
            //   PrintStream ps = new PrintStream(new FileOutputStream(file));
            //    ps.println(inputdata);// 往文件里写入字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "inputdata";
    }

    //向服务器发送数据，并保存返回的数据
//    @ApiOperation(value = "向服务器发送数据，并保存返回的数据", httpMethod = "POST")
//    @RequestMapping(value = "/send", method = RequestMethod.POST)
//    @ResponseBody
//    public JSONObject rtPostObject(@RequestBody Object send) {//
//        JSONArray jsonArray = JSONArray.fromObject(send);
//
////        int modelname = Integer.parseInt(jsonArray.getJSONObject(0).getString("modelname"));
////        String filename = jsonArray.getJSONObject(0).getString("fileName");
//        String userId = jsonArray.getJSONObject(0).getString("userId");
//        System.out.println(userId);
//
//        String sampleId = jsonArray.getJSONObject(0).getString("sample_id");
//        System.out.println(sampleId);
//
//        //连接算法接口
////        RestTemplate restTemplate = new RestTemplate();
////        String url = "http://127.0.0.1:8000/proAirportRes";
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        //括号里是前端发送的字段
//        //TODO 修改了这个类的  getAll() 方法
////        String outputdata = getAll(sampleId);
////        System.out.println("outputdata：" + outputdata);
////        net.sf.json.JSONObject jsonObject = JSONObject.fromObject(outputdata);
////        System.out.println("jsonObject:" + jsonObject);
////        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
////        System.out.println(request);
//
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//
//        //把json格式的array转为list
//        JSONObject panda = new JSONObject();
////        JSONObject body = JSONObject.fromObject(response.getBody());
//
////        if (body.getString("state").equals("0")) {
////            panda.put("state", body.getString("state"));
////            if (body.getString("data").equals("分配失败，数据有误")) {
////                panda.put("data", body.getString("data"));
////                return panda;
////            } else if (body.getString("data").equals("测试模型无法计算，请选择模型二或三")) {
////                panda.put("data", body.getString("data"));
////                return panda;
////            }
////        }
//
//        System.out.println("response：");
//        System.out.println(response.getBody());
//
//        GanttChartController.update(response.getBody().toString());
//        System.out.println("HERE IN ONE");
//        System.out.println(response.getBody().toString());
//
//        StringBuilder sb = new StringBuilder(response.getBody());
//        String userIdCharSec = ",userId:" + "\"" + userId + "\"";
//        sb.insert(sb.length() - 1, userIdCharSec);
//        GanttChartController.airportresult(sb.toString());
//        //List<Map<String, Object>>注意对应296行public后面的类型,查村哪个调用哪个层如resultController
//        //TODO 修改了 ResultController的  getone() 方法
////        List<FlightInfoResultVO> cheng = resultController.getone(filename, modelname, userId);
////        List<StatisticResult> gong = statisticResultController.getone();
////        StatisticResult statisticResult = gong.get(0);
//
//        List<GanttChart> cheng = GanttChartController.getGanttChartBysampleid(sampleId);
//        //JSONObject panda=new JSONObject();
//        panda.put("result", cheng);
////        panda.put("statistic", statisticResult);
//        return panda;
//    }

//    @CrossOrigin(origins = "*")
//    @RequestMapping("/test22")
//    @ResponseBody
//    @PassToken
//    public void test2(@RequestBody JSONArray jsonArray) { // [{"key":"value","key1":"value1"},{"key":"value","key1":"value1"}] 这种格式
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        System.out.println(jsonArray);
//        for (int i = 0; i < jsonArray.size(); i++) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            JSONObject jsObject = jsonArray.getJSONObject(i); //JsonArray 转 JsonObject
//            Iterator it = jsObject.entrySet().iterator(); //jsonObject 转map
//            while (it.hasNext()) {
//                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
//                map.put(entry.getKey(), entry.getValue());
//            }
//            list.add(map);
//        }
//
//        System.out.println("---------------------------------------------------------");
//        for (int j = 0; j < list.size(); j++) {
//            System.out.println(list.get(j));
//        }
//    }

    @RequestMapping(value="/saveData")
    @ResponseBody
    @PassToken
    public void saveData(@RequestBody JSONObject jsonParam){ //{"key":"value","key1":"value1"} 这种格式
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = df.format(date);
//        System.out.println(now);

        System.out.println("result: "+jsonParam.get("result"));
//        System.out.println("model: "+jsonParam.get("model"));
        GanttChart ganttChart = new GanttChart();
        JSONObject result = (JSONObject) jsonParam.get("result");
//        System.out.println(result.size());
//        System.out.println(result.toString());
//        JSONObject res = (JSONObject) result.get("c88812c48b7b4696bd16b5c1ddd2e737");
//        System.out.println(res.getString("OrigAircraft"));

        String model = jsonParam.getString("model");
//        System.out.println(model);
        ganttChart.setModel(model);

        int row = new Integer(10);
//        for (JSONObject ress : result.) {
//
//        }

//        row = IGanttChartService.insertData("12","21", model,jsonParam.getString("datetime"),res.getString("OrigAircraft"),
//                res.getString("OrigDepAirport"),res.getString("OrigArrAirport"),res.getString("OrigDepTime"),res.getString("OrigArrTime"),
//                res.getString("OrigCrew"),res.getString("Aircraft"),res.getString("DepAirport"),res.getString("ArrAirport"),
//                res.getString("DepTime"),res.getString("ArrTime"),res.getString("IsRecovery"),res.getString("IsCancelled"),
//                res.getString("IsDelayed"),res.getString("IsMerge"),res.getString("IsStraighten"),res.getString("IsSwap"),
//                res.getString("IsFerry"),res.getString("MergeList"),res.getString("StraightenList"),"1",now);

        List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator it = result.entrySet().iterator(); //jsonObject 转map
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            map.put(entry.getKey(), entry.getValue());
        }
        res.add(map);

//        System.out.println(res.toString());
//        System.out.println(res.get(0).size());
        Map<String,Object> ress = res.get(0);
        Collection<Object> values = ress.values();
//        System.out.println(values);

        for (Object val : values){
//            System.out.println(val);
            Map<String,Object> re = (Map<String,Object>) val;
//            System.out.println((int) re.get("IsDelayed"));
            int isRecovery = (int) re.get("IsRecovery");
            String IsRecovery = isRecovery+"";
            int isCancelled = (int) re.get("IsCancelled");
            String IsCancelled = isCancelled+"";
            int isDelayed = (int) re.get("IsDelayed");
            String IsDelayed = isDelayed+"";
            int isMerge = (int) re.get("IsMerge");
            String IsMerge = isMerge+"";
            int isStraighten = (int) re.get("IsStraighten");
            String IsStraighten = isStraighten+"";
            int isSwap = (int) re.get("IsSwap");
            String IsSwap = isSwap+"";
            int isFerry = (int) re.get("IsFerry");
            String IsFerry = isFerry+"";

            Object OrigAircraft_ = re.get("OrigAircraft");
            String OrigAircraft = (String) OrigAircraft_;
            if (OrigAircraft.equals("")){
                OrigAircraft = "null";
            }
            Object OrigDepAirport_ = re.get("OrigDepAirport");
            String OrigDepAirport = (String) OrigDepAirport_;
            if (OrigDepAirport.equals("")){
                OrigDepAirport = "null";
            }
            Object OrigArrAirport_ = re.get("OrigArrAirport");
            String OrigArrAirport = (String) OrigArrAirport_;
            if (OrigArrAirport.equals("")){
                OrigArrAirport = "null";
            }
            Object OrigDepTime_ = re.get("OrigDepTime");
            String OrigDepTime = (String) OrigDepTime_;
            if (OrigDepTime.equals("")){
                OrigDepTime = "null";
            }
            Object OrigArrTime_ = re.get("OrigArrTime");
            String OrigArrTime = (String) OrigArrTime_;
            if (OrigArrTime.equals("")){
                OrigArrTime = "null";
            }
            Object Aircraft_ = re.get("Aircraft");
            String Aircraft = (String) Aircraft_;
            if (Aircraft.equals("")){
                Aircraft = "null";
            }
            Object DepAirport_ = re.get("DepAirport");
            String DepAirport = (String) DepAirport_;
            if (DepAirport.equals("")){
                DepAirport = "null";
            }
            Object ArrAirport_ = re.get("ArrAirport");
            String ArrAirport = (String) ArrAirport_;
            if (ArrAirport.equals("")){
                ArrAirport = "null";
            }
            Object DepTime_ = re.get("DepTime");
            String DepTime = (String) DepTime_;
            if (DepTime.equals("")){
                DepTime = "0000-00-00 00:00:00";
            }
            Object ArrTime_ = re.get("ArrTime");
            String ArrTime = (String) ArrTime_;
            if (ArrTime.equals("")){
                ArrTime = "0000-00-00 00:00:00";
            }
//            System.out.println(OrigAircraft+" "+OrigDepAirport+" "+OrigArrAirport+" "+OrigDepTime+" "+OrigArrTime+" "+Aircraft+" "+DepAirport+" "+ArrAirport+" "+DepTime+" "+ArrTime+
//                    " "+IsRecovery+" "+IsCancelled+" "+IsDelayed+" "+IsMerge+" "+IsStraighten+" "+IsSwap+" "+IsFerry);
            IGanttChartService.insertData("21", model,jsonParam.getString("datetime"),OrigAircraft,
                    OrigDepAirport,OrigArrAirport,OrigDepTime,OrigArrTime,
                    "null",Aircraft,DepAirport,ArrAirport,
                    DepTime,ArrTime,IsRecovery,IsCancelled,
                    IsDelayed,IsMerge,IsStraighten,IsSwap,
                    IsFerry,"null","null","test",now);
            resultList.add(re);//(String) re.get("MergeList")(String) re.get("StraightenList")(String) re.get("OrigCrew")
        }
        System.out.println(resultList.size());
        System.out.println("影响"+row+"行");

//        System.out.println(res.get(0).get("1f0d071690b145d791df7ac48364b9ab"));

//        ganttChart.setSampleId("11");
//        ganttChart.setFlightNo("20");
//        ganttChart.setModelUpdateTime("2021-01-24 12:30:00");
//        String OrigAircraft = res.getString("OrigAircraft");
//        System.out.println(OrigAircraft);
//        ganttChart.setOrigAircraft(res.getString("OrigAircraft"));
//        ganttChart.setOrigDepAirport(res.getString("OrigDepAirport"));
//        ganttChart.setOrigArrAirport(res.getString("OrigArrAirport"));
//        ganttChart.setOrigDepTime(res.getString("OrigDepTime"));
//        ganttChart.setOrigArrTime(res.getString("OrigArrTime"));
//        ganttChart.setOrigCrew(res.getString("OrigCrew"));
//        ganttChart.setAircraft(res.getString("Aircraft"));
//        ganttChart.setDepAirport(res.getString("DepAirport"));
//        ganttChart.setArrAirport(res.getString("ArrAirport"));
//        ganttChart.setDepTime(res.getString("DepTime"));
//        ganttChart.setArrTime(res.getString("ArrTime"));
//        ganttChart.setIsRecovery(res.getString("IsRecovery"));
//        ganttChart.setIsCancelled(res.getString("IsCancelled"));
//        ganttChart.setIsDelayed(res.getString("IsDelayed"));
//        ganttChart.setIsMerge(res.getString("IsMerge"));
//        ganttChart.setIsStraighten(res.getString("IsStraighten"));
//        ganttChart.setIsSwap(res.getString("IsSwap"));
//        ganttChart.setIsFerry(res.getString("IsFerry"));
//        ganttChart.setMergeList(res.getString("MergeList"));
//        ganttChart.setStraightenList(res.getString("StraightenList"));
//        ganttChart.setUserId("1");
//        ganttChart.setUpdateTime("2021-01-23 16:00:00");
//        IGanttChartService.insertResult(ganttChart);

    }

}