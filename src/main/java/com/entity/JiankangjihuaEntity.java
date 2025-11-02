package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 健康计划
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
@TableName("jiankangjihua")
public class JiankangjihuaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangjihuaEntity() {
		
	}
	
	public JiankangjihuaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
