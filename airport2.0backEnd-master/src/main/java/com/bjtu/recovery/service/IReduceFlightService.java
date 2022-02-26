package com.bjtu.recovery.service;

import com.bjtu.recovery.entity.ReduceFlight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 */
public interface IReduceFlightService {
    List<ReduceFlight> getAlldata();

    List<ReduceFlight> getAll();

    List<ReduceFlight> getOne(String wayPoint);

    List<ReduceFlight> getAllEnsureSegmentInfo();

    List<ReduceFlight> getAllDestinationInfo();

    List<ReduceFlight> getAllSegmentInfo();

    List<ReduceFlight> getAllByCode(String wayPoint);

    int deleteByWayPoint(String wayPoint);
}
