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
 * 社保缴费
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("shebaojiaofei")
public class ShebaojiaofeiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShebaojiaofeiEntity() {
		
	}
	
	public ShebaojiaofeiEntity(T t) {
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
	 * 社保类型
	 */
					
	private String shebaoleixing;
	
	/**
	 * 社保图片
	 */
					
	private String shebaotupian;
	
	/**
	 * 社保价格
	 */
					
	private Double shebaojiage;
	
	/**
	 * 缴费日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiaofeiriqi;
	
	/**
	 * 缴费详情
	 */
					
	private String jiaofeixiangqing;
	
	/**
	 * 企业账号
	 */
					
	private String qiyezhanghao;
	
	/**
	 * 负责人姓名
	 */
					
	private String fuzerenxingming;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：社保类型
	 */
	public void setShebaoleixing(String shebaoleixing) {
		this.shebaoleixing = shebaoleixing;
	}
	/**
	 * 获取：社保类型
	 */
	public String getShebaoleixing() {
		return shebaoleixing;
	}
	/**
	 * 设置：社保图片
	 */
	public void setShebaotupian(String shebaotupian) {
		this.shebaotupian = shebaotupian;
	}
	/**
	 * 获取：社保图片
	 */
	public String getShebaotupian() {
		return shebaotupian;
	}
	/**
	 * 设置：社保价格
	 */
	public void setShebaojiage(Double shebaojiage) {
		this.shebaojiage = shebaojiage;
	}
	/**
	 * 获取：社保价格
	 */
	public Double getShebaojiage() {
		return shebaojiage;
	}
	/**
	 * 设置：缴费日期
	 */
	public void setJiaofeiriqi(Date jiaofeiriqi) {
		this.jiaofeiriqi = jiaofeiriqi;
	}
	/**
	 * 获取：缴费日期
	 */
	public Date getJiaofeiriqi() {
		return jiaofeiriqi;
	}
	/**
	 * 设置：缴费详情
	 */
	public void setJiaofeixiangqing(String jiaofeixiangqing) {
		this.jiaofeixiangqing = jiaofeixiangqing;
	}
	/**
	 * 获取：缴费详情
	 */
	public String getJiaofeixiangqing() {
		return jiaofeixiangqing;
	}
	/**
	 * 设置：企业账号
	 */
	public void setQiyezhanghao(String qiyezhanghao) {
		this.qiyezhanghao = qiyezhanghao;
	}
	/**
	 * 获取：企业账号
	 */
	public String getQiyezhanghao() {
		return qiyezhanghao;
	}
	/**
	 * 设置：负责人姓名
	 */
	public void setFuzerenxingming(String fuzerenxingming) {
		this.fuzerenxingming = fuzerenxingming;
	}
	/**
	 * 获取：负责人姓名
	 */
	public String getFuzerenxingming() {
		return fuzerenxingming;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
