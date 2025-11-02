package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhinengchuandaishebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhinengchuandaishebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhinengchuandaishebeiView;


/**
 * 智能穿戴设备
 *
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
public interface ZhinengchuandaishebeiService extends IService<ZhinengchuandaishebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhinengchuandaishebeiVO> selectListVO(Wrapper<ZhinengchuandaishebeiEntity> wrapper);
   	
   	ZhinengchuandaishebeiVO selectVO(@Param("ew") Wrapper<ZhinengchuandaishebeiEntity> wrapper);
   	
   	List<ZhinengchuandaishebeiView> selectListView(Wrapper<ZhinengchuandaishebeiEntity> wrapper);
   	
   	ZhinengchuandaishebeiView selectView(@Param("ew") Wrapper<ZhinengchuandaishebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhinengchuandaishebeiEntity> wrapper);

   	

}

