package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.ProblemFlight;
import com.bjtu.recovery.mapper.ProblemFlightMapper;
import com.bjtu.recovery.service.IProblemFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-26
 */
@Service
public class ProblemFlightServiceImpl extends ServiceImpl<ProblemFlightMapper, ProblemFlight> implements IProblemFlightService {

    @Autowired
    private ProblemFlightMapper ProblemFlightMapper;

    @Override
    public List<ProblemFlight> getAlldata() {
        List<ProblemFlight> allData = ProblemFlightMapper.getAlldata();
        return allData;
    }

    @Override
    public List<ProblemFlight> getAllEnsureSegmentInfo() {
        List<ProblemFlight> EnsureSegmentInfo = ProblemFlightMapper.getAllEnsureSegmentInfo();
        return EnsureSegmentInfo;
    }

    @Override
    public List<ProblemFlight> getAllDestinationInfo() {
        List<ProblemFlight> DestinationInfo = ProblemFlightMapper.getAllDestinationInfo();
        return DestinationInfo;
    }

    @Override
    public List<ProblemFlight> getAllSegmentInfo() {
        List<ProblemFlight> SegmentInfo = ProblemFlightMapper.getAllSegmentInfo();
        return SegmentInfo;
    }

    @Override
    public List<ProblemFlight> getAll(String id) {
        List data = ProblemFlightMapper.getAll(id);
        return data;
    }
}
