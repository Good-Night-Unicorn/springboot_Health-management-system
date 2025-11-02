package com.dao;

import com.entity.ZhinengchuandaishebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhinengchuandaishebeiVO;
import com.entity.view.ZhinengchuandaishebeiView;


/**
 * 智能穿戴设备
 * 
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
public interface ZhinengchuandaishebeiDao extends BaseMapper<ZhinengchuandaishebeiEntity> {
	
	List<ZhinengchuandaishebeiVO> selectListVO(@Param("ew") Wrapper<ZhinengchuandaishebeiEntity> wrapper);
	
	ZhinengchuandaishebeiVO selectVO(@Param("ew") Wrapper<ZhinengchuandaishebeiEntity> wrapper);
	
	List<ZhinengchuandaishebeiView> selectListView(@Param("ew") Wrapper<ZhinengchuandaishebeiEntity> wrapper);

	List<ZhinengchuandaishebeiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhinengchuandaishebeiEntity> wrapper);

	
	ZhinengchuandaishebeiView selectView(@Param("ew") Wrapper<ZhinengchuandaishebeiEntity> wrapper);
	

}
