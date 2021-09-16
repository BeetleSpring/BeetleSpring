package com.beetle.onlinevideo.dao;

import com.beetle.onlinevideo.entity.Tool;

import java.util.HashMap;
import java.util.List;

public interface ToolDao {

    //查询所有tool数据
    public List<Tool> selectAll();

   public List<Tool> selectToolByTypeId(HashMap map);

    public Integer insert(Tool tool);
}
