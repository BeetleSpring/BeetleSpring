package com.beetle.onlinevideo.service;

import com.github.pagehelper.PageInfo;

public interface ToolService {

    public PageInfo selectAll(Integer pageNum,Integer pageSize);

    public PageInfo selectToolByTypeId(Integer typeId,Integer pageNum,Integer pageSize);
}
