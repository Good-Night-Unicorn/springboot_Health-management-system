package com.entity.model;

import com.entity.JiankangjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康计划
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
public class JiankangjihuaModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private Integer nianling;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 健康评星
	 */
	
	private String jiankangpingxing;
		
	/**
	 * 疾病风险
	 */
	
	private String jibingfengxian;
		
	/**
	 * 健康评估
	 */
	
	private String jiankangpinggu;
		
	/**
	 * 健康建议
	 */
	
	private String jiankangjianyi;
		
	/**
	 * 健康方案
	 */
	
	private String jiankangfangan;
		
	/**
	 * 医生工号
	 */
	
	private String yishenggonghao;
		
	/**
	 * 医生姓名
	 */
	
	private String yishengxingming;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：健康评星
	 */
	 
	public void setJiankangpingxing(String jiankangpingxing) {
		this.jiankangpingxing = jiankangpingxing;
	}
	
	/**
	 * 获取：健康评星
	 */
	public String getJiankangpingxing() {
		return jiankangpingxing;
	}
				
	
	/**
	 * 设置：疾病风险
	 */
	 
	public void setJibingfengxian(String jibingfengxian) {
		this.jibingfengxian = jibingfengxian;
	}
	
	/**
	 * 获取：疾病风险
	 */
	public String getJibingfengxian() {
		return jibingfengxian;
	}
				
	
	/**
	 * 设置：健康评估
	 */
	 
	public void setJiankangpinggu(String jiankangpinggu) {
		this.jiankangpinggu = jiankangpinggu;
	}
	
	/**
	 * 获取：健康评估
	 */
	public String getJiankangpinggu() {
		return jiankangpinggu;
	}
				
	
	/**
	 * 设置：健康建议
	 */
	 
	public void setJiankangjianyi(String jiankangjianyi) {
		this.jiankangjianyi = jiankangjianyi;
	}
	
	/**
	 * 获取：健康建议
	 */
	public String getJiankangjianyi() {
		return jiankangjianyi;
	}
				
	
	/**
	 * 设置：健康方案
	 */
	 
	public void setJiankangfangan(String jiankangfangan) {
		this.jiankangfangan = jiankangfangan;
	}
	
	/**
	 * 获取：健康方案
	 */
	public String getJiankangfangan() {
		return jiankangfangan;
	}
				
	
	/**
	 * 设置：医生工号
	 */
	 
	public void setYishenggonghao(String yishenggonghao) {
		this.yishenggonghao = yishenggonghao;
	}
	
	/**
	 * 获取：医生工号
	 */
	public String getYishenggonghao() {
		return yishenggonghao;
	}
				
	
	/**
	 * 设置：医生姓名
	 */
	 
	public void setYishengxingming(String yishengxingming) {
		this.yishengxingming = yishengxingming;
	}
	
	/**
	 * 获取：医生姓名
	 */
	public String getYishengxingming() {
		return yishengxingming;
	}
			
}
