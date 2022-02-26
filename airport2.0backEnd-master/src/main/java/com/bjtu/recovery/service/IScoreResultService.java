package com.bjtu.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjtu.recovery.entity.ScoreResult;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Author:wangchunxia
 * @Date 2020/11/17 13:10
 */
public interface IScoreResultService extends IService<ScoreResult> {
    //2020.11.17 查询SCORE_RESULT的数据
    List<ScoreResult> getinfo();
}
