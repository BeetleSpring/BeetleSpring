package com.beetle.onlinevideo.service.serviceImp;

import com.beetle.onlinevideo.dao.BannerDao;
import com.beetle.onlinevideo.service.BannerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BannerServiceImp implements BannerService {

    @Autowired
    BannerDao bannerDao;

    @Override
    public PageInfo selectBannerById(Integer... ids) {
       return new PageInfo(bannerDao.selectBannerById(ids));
    }
}
