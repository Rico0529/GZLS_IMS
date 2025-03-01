package com.entity.model;

import com.entity.FafangbutieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 发放补贴
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
public class FafangbutieModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目封面
	 */
	
	private String xiangmufengmian;
		
	/**
	 * 发放资金
	 */
	
	private Double fafangzijin;
		
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
	 * 企业账号
	 */
	
	private String qiyezhanghao;
		
	/**
	 * 负责人姓名
	 */
	
	private String fuzerenxingming;
				
	
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
	 * 设置：发放资金
	 */
	 
	public void setFafangzijin(Double fafangzijin) {
		this.fafangzijin = fafangzijin;
	}
	
	/**
	 * 获取：发放资金
	 */
	public Double getFafangzijin() {
		return fafangzijin;
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
			
}
