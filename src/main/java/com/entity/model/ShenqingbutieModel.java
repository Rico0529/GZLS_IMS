package com.entity.model;

import com.entity.ShenqingbutieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 申请补贴
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public class ShenqingbutieModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 补贴封面
	 */
	
	private String butiefengmian;
		
	/**
	 * 补贴资料
	 */
	
	private String butieziliao;
		
	/**
	 * 补贴金额
	 */
	
	private Double butiejine;
		
	/**
	 * 申请状态
	 */
	
	private String shenqingzhuangtai;
		
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
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
				
	
	/**
	 * 设置：补贴封面
	 */
	 
	public void setButiefengmian(String butiefengmian) {
		this.butiefengmian = butiefengmian;
	}
	
	/**
	 * 获取：补贴封面
	 */
	public String getButiefengmian() {
		return butiefengmian;
	}
				
	
	/**
	 * 设置：补贴资料
	 */
	 
	public void setButieziliao(String butieziliao) {
		this.butieziliao = butieziliao;
	}
	
	/**
	 * 获取：补贴资料
	 */
	public String getButieziliao() {
		return butieziliao;
	}
				
	
	/**
	 * 设置：补贴金额
	 */
	 
	public void setButiejine(Double butiejine) {
		this.butiejine = butiejine;
	}
	
	/**
	 * 获取：补贴金额
	 */
	public Double getButiejine() {
		return butiejine;
	}
				
	
	/**
	 * 设置：申请状态
	 */
	 
	public void setShenqingzhuangtai(String shenqingzhuangtai) {
		this.shenqingzhuangtai = shenqingzhuangtai;
	}
	
	/**
	 * 获取：申请状态
	 */
	public String getShenqingzhuangtai() {
		return shenqingzhuangtai;
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
