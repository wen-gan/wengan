package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.ProblemAirport;
import com.bjtu.recovery.mapper.ProblemAirportMapper;
import com.bjtu.recovery.mapper.ProblemFlightMapper;
import com.bjtu.recovery.mapper.ReduceFlightMapper;
import com.bjtu.recovery.service.IProblemAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 */
@Service
public class ProblemAirportServiceImpl extends ServiceImpl<ProblemAirportMapper, ProblemAirport> implements IProblemAirportService {
    @Autowired
    private ProblemAirportMapper ProblemAirportMapper;

    @Override
    public List<ProblemAirport> getAllData() {
        List<ProblemAirport> allData = ProblemAirportMapper.getAllData();
        return allData;
    }

    @Override
    public List<ProblemAirport> getAll() {
        List<ProblemAirport> all = ProblemAirportMapper.getAll();
        return all;
    }

    @Override
    public List<ProblemAirport> getOne(String four_code) {
        List<ProblemAirport> one = ProblemAirportMapper.getOne(four_code);
        return one;
    }

    @Override
    public List<ProblemAirport> getAllEnsureSegmentInfo() {
        List<ProblemAirport> EnsureSegmentInfo = ProblemAirportMapper.getAllEnsureSegmentInfo();
        return EnsureSegmentInfo;
    }

    @Override
    public List<ProblemAirport> getAllDestinationInfo() {
        List<ProblemAirport> DestinationInfo = ProblemAirportMapper.getAllDestinationInfo();
        return DestinationInfo;
    }

    @Override
    public List<ProblemAirport> getAllSegmentInfo() {
        List<ProblemAirport> SegmentInfo = ProblemAirportMapper.getAllSegmentInfo();
        return SegmentInfo;
    }

    @Override
    public List<ProblemAirport> getAllByCode(String four_code) {
        List<ProblemAirport> all = ProblemAirportMapper.getAllByCode(four_code);
        return all;
    }

    @Override
    public int deleteByFourCode(String fourCode) {
        int info = ProblemAirportMapper.deleteByFourCode(fourCode);
        return info;
    }

}
