package com.entity.model;

import com.entity.JiankangshujuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康数据
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
public class JiankangshujuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 身高(m)
	 */
	
	private Double shengao;
		
	/**
	 * 体重(kg)
	 */
	
	private Double tizhong;
		
	/**
	 * 血压(mmHg)
	 */
	
	private Double xueya;
		
	/**
	 * 血糖(mmol/L)
	 */
	
	private Double xuetang;
		
	/**
	 * 心率(次)
	 */
	
	private Integer xinlv;
		
	/**
	 * BMI
	 */
	
	private Double shentizhiliang;
		
	/**
	 * 运动记录
	 */
	
	private String yundongjilu;
		
	/**
	 * 体检报告
	 */
	
	private String tijianbaogao;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
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
	 * 设置：身高(m)
	 */
	 
	public void setShengao(Double shengao) {
		this.shengao = shengao;
	}
	
	/**
	 * 获取：身高(m)
	 */
	public Double getShengao() {
		return shengao;
	}
				
	
	/**
	 * 设置：体重(kg)
	 */
	 
	public void setTizhong(Double tizhong) {
		this.tizhong = tizhong;
	}
	
	/**
	 * 获取：体重(kg)
	 */
	public Double getTizhong() {
		return tizhong;
	}
				
	
	/**
	 * 设置：血压(mmHg)
	 */
	 
	public void setXueya(Double xueya) {
		this.xueya = xueya;
	}
	
	/**
	 * 获取：血压(mmHg)
	 */
	public Double getXueya() {
		return xueya;
	}
				
	
	/**
	 * 设置：血糖(mmol/L)
	 */
	 
	public void setXuetang(Double xuetang) {
		this.xuetang = xuetang;
	}
	
	/**
	 * 获取：血糖(mmol/L)
	 */
	public Double getXuetang() {
		return xuetang;
	}
				
	
	/**
	 * 设置：心率(次)
	 */
	 
	public void setXinlv(Integer xinlv) {
		this.xinlv = xinlv;
	}
	
	/**
	 * 获取：心率(次)
	 */
	public Integer getXinlv() {
		return xinlv;
	}
				
	
	/**
	 * 设置：BMI
	 */
	 
	public void setShentizhiliang(Double shentizhiliang) {
		this.shentizhiliang = shentizhiliang;
	}
	
	/**
	 * 获取：BMI
	 */
	public Double getShentizhiliang() {
		return shentizhiliang;
	}
				
	
	/**
	 * 设置：运动记录
	 */
	 
	public void setYundongjilu(String yundongjilu) {
		this.yundongjilu = yundongjilu;
	}
	
	/**
	 * 获取：运动记录
	 */
	public String getYundongjilu() {
		return yundongjilu;
	}
				
	
	/**
	 * 设置：体检报告
	 */
	 
	public void setTijianbaogao(String tijianbaogao) {
		this.tijianbaogao = tijianbaogao;
	}
	
	/**
	 * 获取：体检报告
	 */
	public String getTijianbaogao() {
		return tijianbaogao;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
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
			
}
