package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiankangyishengDao;
import com.entity.JiankangyishengEntity;
import com.service.JiankangyishengService;
import com.entity.vo.JiankangyishengVO;
import com.entity.view.JiankangyishengView;

@Service("jiankangyishengService")
public class JiankangyishengServiceImpl extends ServiceImpl<JiankangyishengDao, JiankangyishengEntity> implements JiankangyishengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangyishengEntity> page = this.selectPage(
                new Query<JiankangyishengEntity>(params).getPage(),
                new EntityWrapper<JiankangyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangyishengEntity> wrapper) {
		  Page<JiankangyishengView> page =new Query<JiankangyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiankangyishengVO> selectListVO(Wrapper<JiankangyishengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiankangyishengVO selectVO(Wrapper<JiankangyishengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiankangyishengView> selectListView(Wrapper<JiankangyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangyishengView selectView(Wrapper<JiankangyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
