package com.bjtu.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjtu.recovery.entity.ProblemFlight;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-26
 */
public interface IProblemFlightService extends IService<ProblemFlight> {
    List<ProblemFlight> getAlldata();

    List<ProblemFlight> getAllEnsureSegmentInfo();

    List<ProblemFlight> getAllDestinationInfo();

    List<ProblemFlight> getAllSegmentInfo();

    List<ProblemFlight> getAll(String id);
}
