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
 * 劳动保障
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("laodongbaozhang")
public class LaodongbaozhangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LaodongbaozhangEntity() {
		
	}
	
	public LaodongbaozhangEntity(T t) {
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
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 最新政策
	 */
					
	private String zuixinzhengce;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 保障内容
	 */
					
	private String baozhangneirong;
	
	/**
	 * 保障详情
	 */
					
	private String baozhangxiangqing;
	
	
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
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：最新政策
	 */
	public void setZuixinzhengce(String zuixinzhengce) {
		this.zuixinzhengce = zuixinzhengce;
	}
	/**
	 * 获取：最新政策
	 */
	public String getZuixinzhengce() {
		return zuixinzhengce;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：保障内容
	 */
	public void setBaozhangneirong(String baozhangneirong) {
		this.baozhangneirong = baozhangneirong;
	}
	/**
	 * 获取：保障内容
	 */
	public String getBaozhangneirong() {
		return baozhangneirong;
	}
	/**
	 * 设置：保障详情
	 */
	public void setBaozhangxiangqing(String baozhangxiangqing) {
		this.baozhangxiangqing = baozhangxiangqing;
	}
	/**
	 * 获取：保障详情
	 */
	public String getBaozhangxiangqing() {
		return baozhangxiangqing;
	}

}
