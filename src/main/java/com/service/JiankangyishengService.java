package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiankangyishengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiankangyishengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangyishengView;


/**
 * 健康医生
 *
 * @author 
 * @email 
 * @date 2025-04-18 10:53:59
 */
public interface JiankangyishengService extends IService<JiankangyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangyishengVO> selectListVO(Wrapper<JiankangyishengEntity> wrapper);
   	
   	JiankangyishengVO selectVO(@Param("ew") Wrapper<JiankangyishengEntity> wrapper);
   	
   	List<JiankangyishengView> selectListView(Wrapper<JiankangyishengEntity> wrapper);
   	
   	JiankangyishengView selectView(@Param("ew") Wrapper<JiankangyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangyishengEntity> wrapper);

   	

}

