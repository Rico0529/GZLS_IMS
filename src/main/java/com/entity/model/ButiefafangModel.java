package com.entity.model;

import com.entity.ButiefafangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 补贴发放
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public class ButiefafangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 补贴封面
	 */
	
	private String butiefengmian;
		
	/**
	 * 补贴金额
	 */
	
	private Double butiejine;
		
	/**
	 * 发放时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fafangshijian;
		
	/**
	 * 发放内容
	 */
	
	private String fafangneirong;
		
	/**
	 * 发放详情
	 */
	
	private String fafangxiangqing;
		
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
	 * 设置：发放时间
	 */
	 
	public void setFafangshijian(Date fafangshijian) {
		this.fafangshijian = fafangshijian;
	}
	
	/**
	 * 获取：发放时间
	 */
	public Date getFafangshijian() {
		return fafangshijian;
	}
				
	
	/**
	 * 设置：发放内容
	 */
	 
	public void setFafangneirong(String fafangneirong) {
		this.fafangneirong = fafangneirong;
	}
	
	/**
	 * 获取：发放内容
	 */
	public String getFafangneirong() {
		return fafangneirong;
	}
				
	
	/**
	 * 设置：发放详情
	 */
	 
	public void setFafangxiangqing(String fafangxiangqing) {
		this.fafangxiangqing = fafangxiangqing;
	}
	
	/**
	 * 获取：发放详情
	 */
	public String getFafangxiangqing() {
		return fafangxiangqing;
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
