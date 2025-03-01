package com.entity.vo;

import com.entity.ButieshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 补贴申请
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
public class ButieshenqingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目封面
	 */
	
	private String xiangmufengmian;
		
	/**
	 * 项目资料
	 */
	
	private String xiangmuziliao;
		
	/**
	 * 申请资金
	 */
	
	private Double shenqingzijin;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shenqingshijian;
		
	/**
	 * 申请内容
	 */
	
	private String shenqingneirong;
		
	/**
	 * 申请详情
	 */
	
	private String shenqingxiangqing;
		
	/**
	 * 企业账号
	 */
	
	private String qiyezhanghao;
		
	/**
	 * 负责人姓名
	 */
	
	private String fuzerenxingming;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：项目封面
	 */
	 
	public void setXiangmufengmian(String xiangmufengmian) {
		this.xiangmufengmian = xiangmufengmian;
	}
	
	/**
	 * 获取：项目封面
	 */
	public String getXiangmufengmian() {
		return xiangmufengmian;
	}
				
	
	/**
	 * 设置：项目资料
	 */
	 
	public void setXiangmuziliao(String xiangmuziliao) {
		this.xiangmuziliao = xiangmuziliao;
	}
	
	/**
	 * 获取：项目资料
	 */
	public String getXiangmuziliao() {
		return xiangmuziliao;
	}
				
	
	/**
	 * 设置：申请资金
	 */
	 
	public void setShenqingzijin(Double shenqingzijin) {
		this.shenqingzijin = shenqingzijin;
	}
	
	/**
	 * 获取：申请资金
	 */
	public Double getShenqingzijin() {
		return shenqingzijin;
	}
				
	
	/**
	 * 设置：申请时间
	 */
	 
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
				
	
	/**
	 * 设置：申请内容
	 */
	 
	public void setShenqingneirong(String shenqingneirong) {
		this.shenqingneirong = shenqingneirong;
	}
	
	/**
	 * 获取：申请内容
	 */
	public String getShenqingneirong() {
		return shenqingneirong;
	}
				
	
	/**
	 * 设置：申请详情
	 */
	 
	public void setShenqingxiangqing(String shenqingxiangqing) {
		this.shenqingxiangqing = shenqingxiangqing;
	}
	
	/**
	 * 获取：申请详情
	 */
	public String getShenqingxiangqing() {
		return shenqingxiangqing;
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
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
