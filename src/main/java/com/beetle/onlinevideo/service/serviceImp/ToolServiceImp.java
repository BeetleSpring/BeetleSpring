package com.beetle.onlinevideo.service.serviceImp;

import com.beetle.onlinevideo.dao.ToolDao;
import com.beetle.onlinevideo.service.ToolService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ToolServiceImp implements ToolService {

    @Autowired
    ToolDao toolDao;



    //查询所有tool数据

    public PageInfo selectAll(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo toolInfo = new PageInfo(toolDao.selectAll(),4);

        return toolInfo;
    }

    @Override
    public PageInfo selectToolByTypeId(Integer typeId, Integer pageNum, Integer pageSize) {
        HashMap map = new HashMap();
        map.put("typeId",typeId);

        PageHelper.startPage(pageNum, pageSize);
        PageInfo toolInfo =new PageInfo(toolDao.selectToolByTypeId(map));

        return toolInfo;
    }


}
