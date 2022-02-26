package com.bjtu.recovery.service;

import com.bjtu.recovery.entity.ModeInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WuZhen
 * @since 2020-03-01
 */
public interface IModeInfoService extends IService<ModeInfo> {
    List<ModeInfo> getinfo();

}
