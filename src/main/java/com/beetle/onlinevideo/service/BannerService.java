package com.beetle.onlinevideo.service;

import com.github.pagehelper.PageInfo;



public interface  BannerService {

    //查询给定编号的 banner
    PageInfo selectBannerById(Integer...ids);

}
