package com.entity.vo;

import com.entity.ToudijianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 投递简历
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public class ToudijianliVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 技能要求
	 */
	
	private String jinengyaoqiu;
		
	/**
	 * 岗位薪资
	 */
	
	private Double gangweixinzi;
		
	/**
	 * 应聘岗位
	 */
	
	private String zhaopingangwei;
		
	/**
	 * 工作地点
	 */
	
	private String gongzuodidian;
		
	/**
	 * 投递时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date toudishijian;
		
	/**
	 * 投递详情
	 */
	
	private String toudixiangqing;
		
	/**
	 * 企业账号
	 */
	
	private String qiyezhanghao;
		
	/**
	 * 负责人姓名
	 */
	
	private String fuzerenxingming;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
				
	
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
	 * 设置：技能要求
	 */
	 
	public void setJinengyaoqiu(String jinengyaoqiu) {
		this.jinengyaoqiu = jinengyaoqiu;
	}
	
	/**
	 * 获取：技能要求
	 */
	public String getJinengyaoqiu() {
		return jinengyaoqiu;
	}
				
	
	/**
	 * 设置：岗位薪资
	 */
	 
	public void setGangweixinzi(Double gangweixinzi) {
		this.gangweixinzi = gangweixinzi;
	}
	
	/**
	 * 获取：岗位薪资
	 */
	public Double getGangweixinzi() {
		return gangweixinzi;
	}
				
	
	/**
	 * 设置：应聘岗位
	 */
	 
	public void setZhaopingangwei(String zhaopingangwei) {
		this.zhaopingangwei = zhaopingangwei;
	}
	
	/**
	 * 获取：应聘岗位
	 */
	public String getZhaopingangwei() {
		return zhaopingangwei;
	}
				
	
	/**
	 * 设置：工作地点
	 */
	 
	public void setGongzuodidian(String gongzuodidian) {
		this.gongzuodidian = gongzuodidian;
	}
	
	/**
	 * 获取：工作地点
	 */
	public String getGongzuodidian() {
		return gongzuodidian;
	}
				
	
	/**
	 * 设置：投递时间
	 */
	 
	public void setToudishijian(Date toudishijian) {
		this.toudishijian = toudishijian;
	}
	
	/**
	 * 获取：投递时间
	 */
	public Date getToudishijian() {
		return toudishijian;
	}
				
	
	/**
	 * 设置：投递详情
	 */
	 
	public void setToudixiangqing(String toudixiangqing) {
		this.toudixiangqing = toudixiangqing;
	}
	
	/**
	 * 获取：投递详情
	 */
	public String getToudixiangqing() {
		return toudixiangqing;
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
			
}
