package com.bjtu.recovery.service;

import com.bjtu.recovery.entity.ProblemAirport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 */
public interface IProblemAirportService {
    List<ProblemAirport> getAllData();

    List<ProblemAirport> getAll();

    List<ProblemAirport> getOne(String four_code);

    List<ProblemAirport> getAllEnsureSegmentInfo();

    List<ProblemAirport> getAllDestinationInfo();

    List<ProblemAirport> getAllSegmentInfo();

    List<ProblemAirport> getAllByCode(String four_code);

    int deleteByFourCode(String fourCode);
}
