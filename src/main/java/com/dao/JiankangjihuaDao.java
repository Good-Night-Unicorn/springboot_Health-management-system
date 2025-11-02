package com.dao;

import com.entity.JiankangjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangjihuaVO;
import com.entity.view.JiankangjihuaView;


/**
 * 健康计划
 * 
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
public interface JiankangjihuaDao extends BaseMapper<JiankangjihuaEntity> {
	
	List<JiankangjihuaVO> selectListVO(@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);
	
	JiankangjihuaVO selectVO(@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);
	
	List<JiankangjihuaView> selectListView(@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);

	List<JiankangjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);

	
	JiankangjihuaView selectView(@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);
	

}
