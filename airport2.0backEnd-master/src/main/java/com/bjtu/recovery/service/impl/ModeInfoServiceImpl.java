package com.bjtu.recovery.service.impl;

import com.bjtu.recovery.entity.ModeInfo;
import com.bjtu.recovery.mapper.ModeInfoMapper;
import com.bjtu.recovery.service.IModeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WuZhen
 * @since 2020-03-01
 */
@Service
public class ModeInfoServiceImpl extends ServiceImpl<ModeInfoMapper, ModeInfo> implements IModeInfoService {
    @Autowired
    private ModeInfoMapper ModeInfoMapper;

    @Override
    public List<ModeInfo> getinfo() {
        List<ModeInfo> info = ModeInfoMapper.getinfo();
        return info;
    }
}
