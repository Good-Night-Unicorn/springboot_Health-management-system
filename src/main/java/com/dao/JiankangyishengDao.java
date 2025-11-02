package com.dao;

import com.entity.JiankangyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangyishengVO;
import com.entity.view.JiankangyishengView;


/**
 * 健康医生
 * 
 * @author 
 * @email 
 * @date 2025-04-18 10:53:59
 */
public interface JiankangyishengDao extends BaseMapper<JiankangyishengEntity> {
	
	List<JiankangyishengVO> selectListVO(@Param("ew") Wrapper<JiankangyishengEntity> wrapper);
	
	JiankangyishengVO selectVO(@Param("ew") Wrapper<JiankangyishengEntity> wrapper);
	
	List<JiankangyishengView> selectListView(@Param("ew") Wrapper<JiankangyishengEntity> wrapper);

	List<JiankangyishengView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangyishengEntity> wrapper);

	
	JiankangyishengView selectView(@Param("ew") Wrapper<JiankangyishengEntity> wrapper);
	

}
