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


import com.dao.ZhinengchuandaishebeiDao;
import com.entity.ZhinengchuandaishebeiEntity;
import com.service.ZhinengchuandaishebeiService;
import com.entity.vo.ZhinengchuandaishebeiVO;
import com.entity.view.ZhinengchuandaishebeiView;

@Service("zhinengchuandaishebeiService")
public class ZhinengchuandaishebeiServiceImpl extends ServiceImpl<ZhinengchuandaishebeiDao, ZhinengchuandaishebeiEntity> implements ZhinengchuandaishebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhinengchuandaishebeiEntity> page = this.selectPage(
                new Query<ZhinengchuandaishebeiEntity>(params).getPage(),
                new EntityWrapper<ZhinengchuandaishebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhinengchuandaishebeiEntity> wrapper) {
		  Page<ZhinengchuandaishebeiView> page =new Query<ZhinengchuandaishebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhinengchuandaishebeiVO> selectListVO(Wrapper<ZhinengchuandaishebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhinengchuandaishebeiVO selectVO(Wrapper<ZhinengchuandaishebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhinengchuandaishebeiView> selectListView(Wrapper<ZhinengchuandaishebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhinengchuandaishebeiView selectView(Wrapper<ZhinengchuandaishebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
