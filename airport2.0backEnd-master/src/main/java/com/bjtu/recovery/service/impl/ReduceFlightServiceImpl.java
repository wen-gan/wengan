package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.ReduceFlight;
import com.bjtu.recovery.mapper.GanttChartMapper;
import com.bjtu.recovery.mapper.ReduceFlightMapper;
import com.bjtu.recovery.service.IReduceFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-02-07
 */
@Service
public class ReduceFlightServiceImpl extends ServiceImpl<ReduceFlightMapper, ReduceFlight> implements IReduceFlightService {

    @Autowired
    private ReduceFlightMapper ReduceFlightMapper;

    @Override
    public List<ReduceFlight> getAlldata() {
        List<ReduceFlight> allData = ReduceFlightMapper.getAlldata();
        return allData;
    }

    @Override
    public List<ReduceFlight> getAll() {
        List<ReduceFlight> all = ReduceFlightMapper.getAll();
        return all;
    }

    @Override
    public List<ReduceFlight> getOne(String routepoint) {
        List<ReduceFlight> one = ReduceFlightMapper.getOne(routepoint);
        return one;
    }

    @Override
    public List<ReduceFlight> getAllEnsureSegmentInfo() {
        List<ReduceFlight> EnsureSegmentInfo = ReduceFlightMapper.getAllEnsureSegmentInfo();
        return EnsureSegmentInfo;
    }

    @Override
    public List<ReduceFlight> getAllDestinationInfo() {
        List<ReduceFlight> DestinationInfo = ReduceFlightMapper.getAllDestinationInfo();
        return DestinationInfo;
    }

    @Override
    public List<ReduceFlight> getAllSegmentInfo() {
        List<ReduceFlight> SegmentInfo = ReduceFlightMapper.getAllSegmentInfo();
        return SegmentInfo;
    }

    @Override
    public List<ReduceFlight> getAllByCode(String wayPoint) {
        List<ReduceFlight> all = ReduceFlightMapper.getAllByCode(wayPoint);
        return all;
    }

    @Override
    public int deleteByWayPoint(String wayPoint) {
        int info = ReduceFlightMapper.deleteByWayPoint(wayPoint);
        return info;
    }
}
