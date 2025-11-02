package com.entity.model;

import com.entity.JiankangdanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康档案
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-18 10:53:59
 */
public class JiankangdanganModel  implements Serializable {
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
	 * 身高
	 */
	
	private String shengao;
		
	/**
	 * 体重
	 */
	
	private String tizhong;
		
	/**
	 * 血型
	 */
	
	private String xuexing;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 药物过敏
	 */
	
	private String yaowuguomin;
		
	/**
	 * 家族病史
	 */
	
	private String jiazubingshi;
		
	/**
	 * 既往病史
	 */
	
	private String jiwangbingshi;
		
	/**
	 * 住院记录
	 */
	
	private String zhuyuanjilu;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
				
	
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
	 * 设置：身高
	 */
	 
	public void setShengao(String shengao) {
		this.shengao = shengao;
	}
	
	/**
	 * 获取：身高
	 */
	public String getShengao() {
		return shengao;
	}
				
	
	/**
	 * 设置：体重
	 */
	 
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	
	/**
	 * 获取：体重
	 */
	public String getTizhong() {
		return tizhong;
	}
				
	
	/**
	 * 设置：血型
	 */
	 
	public void setXuexing(String xuexing) {
		this.xuexing = xuexing;
	}
	
	/**
	 * 获取：血型
	 */
	public String getXuexing() {
		return xuexing;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
				
	
	/**
	 * 设置：药物过敏
	 */
	 
	public void setYaowuguomin(String yaowuguomin) {
		this.yaowuguomin = yaowuguomin;
	}
	
	/**
	 * 获取：药物过敏
	 */
	public String getYaowuguomin() {
		return yaowuguomin;
	}
				
	
	/**
	 * 设置：家族病史
	 */
	 
	public void setJiazubingshi(String jiazubingshi) {
		this.jiazubingshi = jiazubingshi;
	}
	
	/**
	 * 获取：家族病史
	 */
	public String getJiazubingshi() {
		return jiazubingshi;
	}
				
	
	/**
	 * 设置：既往病史
	 */
	 
	public void setJiwangbingshi(String jiwangbingshi) {
		this.jiwangbingshi = jiwangbingshi;
	}
	
	/**
	 * 获取：既往病史
	 */
	public String getJiwangbingshi() {
		return jiwangbingshi;
	}
				
	
	/**
	 * 设置：住院记录
	 */
	 
	public void setZhuyuanjilu(String zhuyuanjilu) {
		this.zhuyuanjilu = zhuyuanjilu;
	}
	
	/**
	 * 获取：住院记录
	 */
	public String getZhuyuanjilu() {
		return zhuyuanjilu;
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
