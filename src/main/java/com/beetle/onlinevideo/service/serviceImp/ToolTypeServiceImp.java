package com.beetle.onlinevideo.service.serviceImp;

import com.beetle.onlinevideo.dao.ToolTypeDao;
import com.beetle.onlinevideo.service.ToolTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolTypeServiceImp implements ToolTypeService {

    @Autowired
    ToolTypeDao toolTypeDao;


    @Override
    public PageInfo selectAll() {

        return new PageInfo(toolTypeDao.selectAll());
    }
}
