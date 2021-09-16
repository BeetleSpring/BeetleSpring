package com.beetle.onlinevideo.dao;

import com.beetle.onlinevideo.entity.Banner;

import java.util.List;

public interface BannerDao {


    public List<Banner> selectBannerById(Integer[] ids);
}
