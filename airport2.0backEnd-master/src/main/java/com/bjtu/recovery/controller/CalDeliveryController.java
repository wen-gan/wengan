package com.bjtu.recovery.controller;

import com.bjtu.recovery.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ModelDataController
 * @Description:
 * @Author 文淦
 * @Date 2022-02-07
 */

@Api(description = "计算数据发送接口")
@RestController
@RequestMapping("/getmodeldata")
public class CalDeliveryController {
    @Autowired
    private com.bjtu.recovery.service.IProblemFlightService IProblemFlightService;
    @Autowired
    private com.bjtu.recovery.service.IProblemAirportService IProblemAirportService;
    @Autowired
    private com.bjtu.recovery.service.IReduceFlightService IReduceFlightService;
    @Autowired
    private com.bjtu.recovery.service.IGanttChartService IGanttChartService;
    @Autowired
    private com.bjtu.recovery.service.IResultService IResultService;
    @Autowired
    private com.bjtu.recovery.service.IEvaluationResultService IEvaluationResultService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询问题航班
     * @param human
     * @return
     */
    @ApiOperation(value = "查询问题航班", httpMethod = "POST")
    @PostMapping(value = "/getFlightdata")
    public Boolean getAllFlight(@RequestBody JSONObject human) {
        try {
//            String filename = human.getString("filename");
//            String userid = human.getString("userId");
//            String airportname0= human.getString("airportname");
            String sampleId= human.getString("sampleId");
//            System.out.println("aaaa");
//            System.out.println(human.toString());

            //表格数据
            String problemflightstr = "";

//            String flightstr="";
//            String gatestr="";
//            String areaconflictstr="";
//            String airlimitstr="";
//            String priostr="";
//            String airlinebridgeratestr="";
//            String timeparameterstr="";
//            String parkingmdlstr="";
//            String ParkinggatePrioritystr="";

            List<ProblemFlight> problemflight_list = IProblemFlightService.getAll(sampleId);
//           String str2=gateinfo_list.toString().replace("(","{");
//            str2=str2.replace(")","}");
//            str2=str2.replace("GateInfo","");
            JSONArray arr=JSONArray.fromObject(problemflight_list);

            for(int i=0;i<arr.size();i++){
                Map<String,String> map=new LinkedHashMap<>();
                String id = arr.getJSONObject(i).getString("id");
                String date=arr.getJSONObject(i).getString("date");
                String guaranteed_route_id=arr.getJSONObject(i).getString("guaranteed_route_id");
                String leg_id=arr.getJSONObject(i).getString("leg_id");
                String designated_aircraft=arr.getJSONObject(i).getString("designated_aircraft");
                String aircraft_id=arr.getJSONObject(i).getString("aircraft_id");
                String destination=arr.getJSONObject(i).getString("destination");

                map.put("id",id);
                map.put("date",date);
                map.put("guaranteed_route_id",guaranteed_route_id);
                map.put("leg_id",leg_id);
                map.put("designated_aircraft",designated_aircraft);
                map.put("aircraft_id",aircraft_id);
                map.put("destination",destination);

                ObjectMapper json = new ObjectMapper();
                String sss=json.writeValueAsString(map);
                problemflightstr = problemflightstr + sss+ ",";
            }
            problemflightstr=problemflightstr.substring(0,problemflightstr.length()-1);
            problemflightstr='['+problemflightstr+']';
            problemflightstr="\"problemflight\":"+problemflightstr;

            //拼接字符串
//            String rulestr=areaconflictstr+","+parkingmdlstr+","+airlimitstr+","+airlinebridgeratestr+","+timeparameterstr+","+priostr+","+ParkinggatePrioritystr;
//            String rule="\"rule\":"+"{"+rulestr+"}";
            String str="{"+"\"success\":"+"true"+","+"\"code\":"+"\"1\","+"\"msg\":"+"\"数据获取成功!\","+"\"data\":"+"{"+"\"paramtype\":"+"\"默认\","+","+problemflightstr+"}"+"}";

            //模型一 贪心算法
            String url1 = "http://127.0.0.1:8000/proFlightRes";
            String res1 = restTemplate.postForObject(url1,str.getBytes("UTF-8"),String.class);
            JSONObject json1 = JSONObject.fromObject(res1);
            List<GanttChart> ResultArray1 = json1.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray1" + ResultArray1);
            int Ressum1 = IGanttChartService.insertRes(ResultArray1);
            System.out.println("Ressum1"+Ressum1);

//            List<Result> ResultArray1 = json1.getJSONObject("result").getJSONArray("data");
//            System.out.println("ResultArray1"+ResultArray1);
//            int Ressum1 = IResultService.insertRes(ResultArray1);
//            System.out.println("Ressum1"+Ressum1);
//            System.out.println(json1.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray1 = json1.getJSONObject("evaluation").getJSONArray("data");
//            int Evasum1 = IEvaluationResultService.insertEva(EvaluationResultArray1);

            //模型二 模拟退火算法
            String url2 = "http://localhost:8000/model2/";
            String res2 = restTemplate.postForObject(url2,str.getBytes("UTF-8"),String.class);
            JSONObject json2 = JSONObject.fromObject(res2);
            List<GanttChart> ResultArray2 = json2.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray2" + ResultArray2);
            int Ressum2 = IGanttChartService.insertRes(ResultArray2);
            System.out.println("Ressum2"+Ressum2);

//            List<Result> ResultArray2 = json2.getJSONObject("result").getJSONArray("data");
//            int Ressum2 = IResultService.insertRes(ResultArray2);
//            System.out.println(json2.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray2 = json2.getJSONObject("evaluation").getJSONArray("data");
//            System.out.println("-------------------------------------------------------------");
//            int Evasum2 = IEvaluationResultService.insertEva(EvaluationResultArray2);

            //模型三 列生成算法
            String url3 = "http://localhost:8000/model3/";
            String res3 = restTemplate.postForObject(url3,str.getBytes("UTF-8"),String.class);
            JSONObject json3 = JSONObject.fromObject(res3);
            List<GanttChart> ResultArray3 = json3.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray3" + ResultArray3);
            int Ressum3 = IGanttChartService.insertRes(ResultArray3);
            System.out.println("Ressum3"+Ressum3);

//            List<Result> ResultArray3 = json3.getJSONObject("result").getJSONArray("data");
//            int Ressum3 = IResultService.insertRes(ResultArray3);
//            System.out.println(json3.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray3 = json3.getJSONObject("evaluation").getJSONArray("data");
//            System.out.println("-------------------------------------------------------------");
//            int Evasum3 = IEvaluationResultService.insertEva(EvaluationResultArray3);

            //人工分配评价
            String url4 = "http://localhost:8000/eval/";
            List<GanttChart> ResultArray4 = human.getJSONArray("data");
            int Ressum4 = IGanttChartService.insertRes(ResultArray4);

//            List<Result> ResultArray4 = human.getJSONArray("data");
//            int Ressum4 = IResultService.insertRes(ResultArray4);
            // 返回的停机位不能是null
            JSONObject res = new JSONObject();
            res.put("success", true);
            res.put("code", "1");
            res.put("msg", "恢复完成!");
            res.put("data", ResultArray4);
            JSONObject js = new JSONObject();
            js.put("res",res);
            js.put("data",str);

            String res4 = restTemplate.postForObject(url4,js.toString().getBytes("UTF-8"),String.class);
            JSONObject json4 = JSONObject.fromObject(res4);
//            List<EvaluationResult> EvaluationResultArray4 = json4.getJSONArray("data");
//            int Evasum4 = IEvaluationResultService.insertEva(EvaluationResultArray4);

            if (Ressum4>0){
                return true;
            }else {
                return false;
            }
//            return Evasum4;//评价

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询问题机场
     * @param human
     * @return
     */
    @ApiOperation(value = "查询问题机场", httpMethod = "POST")
    @PostMapping(value = "/getAirportdata")
    public Boolean getAllAirport(@RequestBody JSONObject human) {
        try {
//            String filename = human.getString("filename");
//            String userid = human.getString("userId");
//            String airportname0= human.getString("airportname");
            String fourCode= human.getString("four_code");
//            System.out.println("aaaa");
//            System.out.println(human.toString());

            //表格数据
            String problemairportstr = "";

//            String flightstr="";
//            String gatestr="";
//            String areaconflictstr="";
//            String airlimitstr="";
//            String priostr="";
//            String airlinebridgeratestr="";
//            String timeparameterstr="";
//            String parkingmdlstr="";
//            String ParkinggatePrioritystr="";

            List<ProblemAirport> problemairport_list = IProblemAirportService.getAllByCode(fourCode);
//           String str2=gateinfo_list.toString().replace("(","{");
//            str2=str2.replace(")","}");
//            str2=str2.replace("GateInfo","");
            JSONArray arr=JSONArray.fromObject(problemairport_list);

            for(int i=0;i<arr.size();i++){
                Map<String,String> map=new LinkedHashMap<>();
                String id = arr.getJSONObject(i).getString("id");
                String date=arr.getJSONObject(i).getString("date");
                String apt_name=arr.getJSONObject(i).getString("apt_name");
                String four_code=arr.getJSONObject(i).getString("four_code");
                String influence_start_date=arr.getJSONObject(i).getString("influence_start_date");
                String influence_end_date=arr.getJSONObject(i).getString("influence_end_date");
                String dep_arr_choice=arr.getJSONObject(i).getString("dep_arr_choice");
                String guaranteed_route_id=arr.getJSONObject(i).getString("guaranteed_route_id");
                String leg_id=arr.getJSONObject(i).getString("leg_id");
                String designated_aircraft=arr.getJSONObject(i).getString("designated_aircraft");
                String aircraft_id=arr.getJSONObject(i).getString("aircraft_id");
                String destination=arr.getJSONObject(i).getString("destination");

                map.put("id",id);
                map.put("date",date);
                map.put("apt_name",apt_name);
                map.put("four_code",four_code);
                map.put("influence_start_date",influence_start_date);
                map.put("influence_end_date",influence_end_date);
                map.put("dep_arr_choice",dep_arr_choice);
                map.put("guaranteed_route_id",guaranteed_route_id);
                map.put("leg_id",leg_id);
                map.put("designated_aircraft",designated_aircraft);
                map.put("aircraft_id",aircraft_id);
                map.put("destination",destination);

                ObjectMapper json = new ObjectMapper();
                String sss=json.writeValueAsString(map);
                problemairportstr = problemairportstr + sss+ ",";
            }
            problemairportstr=problemairportstr.substring(0, problemairportstr.length()-1);
            problemairportstr='['+problemairportstr+']';
            problemairportstr="\"problemairport\":"+problemairportstr;

            //拼接字符串
//            String rulestr=areaconflictstr+","+parkingmdlstr+","+airlimitstr+","+airlinebridgeratestr+","+timeparameterstr+","+priostr+","+ParkinggatePrioritystr;
//            String rule="\"rule\":"+"{"+rulestr+"}";
            String str="{"+"\"success\":"+"true"+","+"\"code\":"+"\"1\","+"\"msg\":"+"\"数据获取成功!\","+"\"data\":"+"{"+"\"paramtype\":"+"\"默认\","+","+problemairportstr+"}"+"}";

            //模型一 贪心算法
            String url1 = "http://127.0.0.1:8000/proAirportRes";
            String res1 = restTemplate.postForObject(url1,str.getBytes("UTF-8"),String.class);
            JSONObject json1 = JSONObject.fromObject(res1);
            List<GanttChart> ResultArray1 = json1.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray1" + ResultArray1);
            int Ressum1 = IGanttChartService.insertRes(ResultArray1);
            System.out.println("Ressum1"+Ressum1);

//            List<Result> ResultArray1 = json1.getJSONObject("result").getJSONArray("data");
//            System.out.println("ResultArray1"+ResultArray1);
//            int Ressum1 = IResultService.insertRes(ResultArray1);
//            System.out.println("Ressum1"+Ressum1);
//            System.out.println(json1.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray1 = json1.getJSONObject("evaluation").getJSONArray("data");
//            int Evasum1 = IEvaluationResultService.insertEva(EvaluationResultArray1);

            //模型二 模拟退火算法
            String url2 = "http://localhost:8000/model2/";
            String res2 = restTemplate.postForObject(url2,str.getBytes("UTF-8"),String.class);
            JSONObject json2 = JSONObject.fromObject(res2);
            List<GanttChart> ResultArray2 = json2.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray2" + ResultArray2);
            int Ressum2 = IGanttChartService.insertRes(ResultArray2);
            System.out.println("Ressum2"+Ressum2);

//            List<Result> ResultArray2 = json2.getJSONObject("result").getJSONArray("data");
//            int Ressum2 = IResultService.insertRes(ResultArray2);
//            System.out.println(json2.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray2 = json2.getJSONObject("evaluation").getJSONArray("data");
//            System.out.println("-------------------------------------------------------------");
//            int Evasum2 = IEvaluationResultService.insertEva(EvaluationResultArray2);

            //模型三 列生成算法
            String url3 = "http://localhost:8000/model3/";
            String res3 = restTemplate.postForObject(url3,str.getBytes("UTF-8"),String.class);
            JSONObject json3 = JSONObject.fromObject(res3);
            List<GanttChart> ResultArray3 = json3.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray3" + ResultArray3);
            int Ressum3 = IGanttChartService.insertRes(ResultArray3);
            System.out.println("Ressum3"+Ressum3);

//            List<Result> ResultArray3 = json3.getJSONObject("result").getJSONArray("data");
//            int Ressum3 = IResultService.insertRes(ResultArray3);
//            System.out.println(json3.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray3 = json3.getJSONObject("evaluation").getJSONArray("data");
//            System.out.println("-------------------------------------------------------------");
//            int Evasum3 = IEvaluationResultService.insertEva(EvaluationResultArray3);

            //人工分配评价
            String url4 = "http://localhost:8000/eval/";
            List<GanttChart> ResultArray4 = human.getJSONArray("data");
            int Ressum4 = IGanttChartService.insertRes(ResultArray4);

//            List<Result> ResultArray4 = human.getJSONArray("data");
//            int Ressum4 = IResultService.insertRes(ResultArray4);
            // 返回的停机位不能是null
            JSONObject res = new JSONObject();
            res.put("success", true);
            res.put("code", "1");
            res.put("msg", "恢复完成!");
            res.put("data", ResultArray4);
            JSONObject js = new JSONObject();
            js.put("res",res);
            js.put("data",str);

            String res4 = restTemplate.postForObject(url4,js.toString().getBytes("UTF-8"),String.class);
            JSONObject json4 = JSONObject.fromObject(res4);
//            List<EvaluationResult> EvaluationResultArray4 = json4.getJSONArray("data");
//            int Evasum4 = IEvaluationResultService.insertEva(EvaluationResultArray4);

            if (Ressum4>0){
                return true;
            }else {
                return false;
            }
//            return Evasum4;//评价

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询调减航班
     * @param human
     * @return
     */
    @ApiOperation(value = "查询调减航班", httpMethod = "POST")
    @PostMapping(value = "/getReduceFlightdata")
    public Boolean getAllReduceFlight(@RequestBody JSONObject human) {
        try {
//            String filename = human.getString("filename");
//            String userid = human.getString("userId");
//            String airportname0= human.getString("airportname");
            String wayPoint= human.getString("way_point");
//            System.out.println("aaaa");
//            System.out.println(human.toString());

            //表格数据
            String reduceflightstr = "";

//            String flightstr="";
//            String gatestr="";
//            String areaconflictstr="";
//            String airlimitstr="";
//            String priostr="";
//            String airlinebridgeratestr="";
//            String timeparameterstr="";
//            String parkingmdlstr="";
//            String ParkinggatePrioritystr="";

            List<ReduceFlight> reduceflight_list = IReduceFlightService.getAllByCode(wayPoint);
//           String str2=gateinfo_list.toString().replace("(","{");
//            str2=str2.replace(")","}");
//            str2=str2.replace("GateInfo","");
            JSONArray arr=JSONArray.fromObject(reduceflight_list);

            for(int i=0;i<arr.size();i++){
                Map<String,String> map=new LinkedHashMap<>();
                String id = arr.getJSONObject(i).getString("id");
                String date=arr.getJSONObject(i).getString("date");
                String way_point=arr.getJSONObject(i).getString("way_point");
                String reduce_num=arr.getJSONObject(i).getString("reduce_num");
                String reduce_start_date=arr.getJSONObject(i).getString("reduce_start_date");
                String reduce_end_date=arr.getJSONObject(i).getString("reduce_end_date");
                String guaranteed_route_id=arr.getJSONObject(i).getString("guaranteed_route_id");
                String leg_id=arr.getJSONObject(i).getString("leg_id");
                String designated_aircraft=arr.getJSONObject(i).getString("designated_aircraft");
                String aircraft_id=arr.getJSONObject(i).getString("aircraft_id");
                String destination=arr.getJSONObject(i).getString("destination");

                map.put("id",id);
                map.put("date",date);
                map.put("way_point",way_point);
                map.put("reduce_num",reduce_num);
                map.put("reduce_start_date",reduce_start_date);
                map.put("reduce_end_date",reduce_end_date);
                map.put("guaranteed_route_id",guaranteed_route_id);
                map.put("leg_id",leg_id);
                map.put("designated_aircraft",designated_aircraft);
                map.put("aircraft_id",aircraft_id);
                map.put("destination",destination);

                ObjectMapper json = new ObjectMapper();
                String sss=json.writeValueAsString(map);
                reduceflightstr = reduceflightstr + sss+ ",";
            }
            reduceflightstr=reduceflightstr.substring(0, reduceflightstr.length()-1);
            reduceflightstr='['+reduceflightstr+']';
            reduceflightstr="\"problemairport\":"+reduceflightstr;

            //拼接字符串
//            String rulestr=areaconflictstr+","+parkingmdlstr+","+airlimitstr+","+airlinebridgeratestr+","+timeparameterstr+","+priostr+","+ParkinggatePrioritystr;
//            String rule="\"rule\":"+"{"+rulestr+"}";
            String str="{"+"\"success\":"+"true"+","+"\"code\":"+"\"1\","+"\"msg\":"+"\"数据获取成功!\","+"\"data\":"+"{"+"\"paramtype\":"+"\"默认\","+","+reduceflightstr+"}"+"}";

            //模型一 贪心算法
            String url1 = "http://127.0.0.1:8000/flightAdjSub";
            String res1 = restTemplate.postForObject(url1,str.getBytes("UTF-8"),String.class);
            JSONObject json1 = JSONObject.fromObject(res1);
            List<GanttChart> ResultArray1 = json1.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray1" + ResultArray1);
            int Ressum1 = IGanttChartService.insertRes(ResultArray1);
            System.out.println("Ressum1"+Ressum1);

//            List<Result> ResultArray1 = json1.getJSONObject("result").getJSONArray("data");
//            System.out.println("ResultArray1"+ResultArray1);
//            int Ressum1 = IResultService.insertRes(ResultArray1);
//            System.out.println("Ressum1"+Ressum1);
//            System.out.println(json1.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray1 = json1.getJSONObject("evaluation").getJSONArray("data");
//            int Evasum1 = IEvaluationResultService.insertEva(EvaluationResultArray1);

            //模型二 模拟退火算法
            String url2 = "http://localhost:8000/model2/";
            String res2 = restTemplate.postForObject(url2,str.getBytes("UTF-8"),String.class);
            JSONObject json2 = JSONObject.fromObject(res2);
            List<GanttChart> ResultArray2 = json2.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray2" + ResultArray2);
            int Ressum2 = IGanttChartService.insertRes(ResultArray2);
            System.out.println("Ressum2"+Ressum2);

//            List<Result> ResultArray2 = json2.getJSONObject("result").getJSONArray("data");
//            int Ressum2 = IResultService.insertRes(ResultArray2);
//            System.out.println(json2.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray2 = json2.getJSONObject("evaluation").getJSONArray("data");
//            System.out.println("-------------------------------------------------------------");
//            int Evasum2 = IEvaluationResultService.insertEva(EvaluationResultArray2);

            //模型三 列生成算法
            String url3 = "http://localhost:8000/model3/";
            String res3 = restTemplate.postForObject(url3,str.getBytes("UTF-8"),String.class);
            JSONObject json3 = JSONObject.fromObject(res3);
            List<GanttChart> ResultArray3 = json3.getJSONObject("result").getJSONArray("data");
            System.out.println("ResultArray3" + ResultArray3);
            int Ressum3 = IGanttChartService.insertRes(ResultArray3);
            System.out.println("Ressum3"+Ressum3);

//            List<Result> ResultArray3 = json3.getJSONObject("result").getJSONArray("data");
//            int Ressum3 = IResultService.insertRes(ResultArray3);
//            System.out.println(json3.getJSONObject("evaluation"));
//            List<EvaluationResult> EvaluationResultArray3 = json3.getJSONObject("evaluation").getJSONArray("data");
//            System.out.println("-------------------------------------------------------------");
//            int Evasum3 = IEvaluationResultService.insertEva(EvaluationResultArray3);

            //人工分配评价
            String url4 = "http://localhost:8000/eval/";
            List<GanttChart> ResultArray4 = human.getJSONArray("data");
            int Ressum4 = IGanttChartService.insertRes(ResultArray4);

//            List<Result> ResultArray4 = human.getJSONArray("data");
//            int Ressum4 = IResultService.insertRes(ResultArray4);
            // 返回的停机位不能是null
            JSONObject res = new JSONObject();
            res.put("success", true);
            res.put("code", "1");
            res.put("msg", "恢复完成!");
            res.put("data", ResultArray4);
            JSONObject js = new JSONObject();
            js.put("res",res);
            js.put("data",str);

            String res4 = restTemplate.postForObject(url4,js.toString().getBytes("UTF-8"),String.class);
            JSONObject json4 = JSONObject.fromObject(res4);
//            List<EvaluationResult> EvaluationResultArray4 = json4.getJSONArray("data");
//            int Evasum4 = IEvaluationResultService.insertEva(EvaluationResultArray4);

            if (Ressum4>0){
                return true;
            }else {
                return false;
            }
//            return Evasum4;//评价

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

