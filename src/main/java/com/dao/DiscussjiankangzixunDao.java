package com.dao;

import com.entity.DiscussjiankangzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiankangzixunVO;
import com.entity.view.DiscussjiankangzixunView;


/**
 * 健康资讯评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-18 10:54:01
 */
public interface DiscussjiankangzixunDao extends BaseMapper<DiscussjiankangzixunEntity> {
	
	List<DiscussjiankangzixunVO> selectListVO(@Param("ew") Wrapper<DiscussjiankangzixunEntity> wrapper);
	
	DiscussjiankangzixunVO selectVO(@Param("ew") Wrapper<DiscussjiankangzixunEntity> wrapper);
	
	List<DiscussjiankangzixunView> selectListView(@Param("ew") Wrapper<DiscussjiankangzixunEntity> wrapper);

	List<DiscussjiankangzixunView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiankangzixunEntity> wrapper);

	
	DiscussjiankangzixunView selectView(@Param("ew") Wrapper<DiscussjiankangzixunEntity> wrapper);
	

}
