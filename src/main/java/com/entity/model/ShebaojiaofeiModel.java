package com.entity.model;

import com.entity.ShebaojiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 社保缴费
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public class ShebaojiaofeiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
