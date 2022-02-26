package com.bjtu.recovery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.recovery.entity.CostParameter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-14
 */
@Repository
public interface CostParameterMapper extends BaseMapper<CostParameter> {
    /**
     * 查找不同的成本值
     * @return
     */
    @Select("select name,parameter_value from cost_parameter")
    List<Map<String, Object>> getOriginalData();

    @Insert("INSERT into cost_parameter(cost_id,name,parameter_value,instruction,user_id,update_time) values(#{cost_id},#{name},#{parameter_value},#{instruction},#{user_id},#{update_time})")
    int test(@Param("cost_id")String costId, @Param("name")String name, @Param("parameter_value")String parameterValue,
             @Param("instruction")String instruction, @Param("user_id")String userId, @Param("update_time")String updateTime);

    //测试2
    @Update({"UPDATE cost_parameter set name= #{name},parameter_value= #{parameter_value},instruction= #{instruction},user_id= #{user_id},update_time= #{update_time} where cost_id= #{cost_id}"})
    int test2(@Param("name")String name, @Param("parameter_value")String parameterValue, @Param("instruction")String instruction,
              @Param("user_id")String userId, @Param("update_time")String updateTime, @Param("cost_id")String costId);
}
