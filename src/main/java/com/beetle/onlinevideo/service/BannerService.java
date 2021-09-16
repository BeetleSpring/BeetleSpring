package com.beetle.onlinevideo.service;

import com.beetle.onlinevideo.entity.Banner;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BannerService {

    //查询给定编号的 banner
    public PageInfo selectBannerById(Integer...ids);

}
