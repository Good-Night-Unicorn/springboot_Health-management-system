package com.entity.view;

import com.entity.ZhinengchuandaishebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 智能穿戴设备
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
@TableName("zhinengchuandaishebei")
public class ZhinengchuandaishebeiView  extends ZhinengchuandaishebeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhinengchuandaishebeiView(){
	}
 
 	public ZhinengchuandaishebeiView(ZhinengchuandaishebeiEntity zhinengchuandaishebeiEntity){
 	try {
			BeanUtils.copyProperties(this, zhinengchuandaishebeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
