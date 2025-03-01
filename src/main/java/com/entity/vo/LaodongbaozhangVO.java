package com.entity.vo;

import com.entity.LaodongbaozhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 劳动保障
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public class LaodongbaozhangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
