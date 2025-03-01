package com.entity.vo;

import com.entity.ShebaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 社保信息
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public class ShebaoxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 社保文件
	 */
	
	private String shebaowenjian;
		
	/**
	 * 社保状态
	 */
	
	private String shebaozhuangtai;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 社保备注
	 */
	
	private String shebaobeizhu;
				
	
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
	 * 设置：社保文件
	 */
	 
	public void setShebaowenjian(String shebaowenjian) {
		this.shebaowenjian = shebaowenjian;
	}
	
	/**
	 * 获取：社保文件
	 */
	public String getShebaowenjian() {
		return shebaowenjian;
	}
				
	
	/**
	 * 设置：社保状态
	 */
	 
	public void setShebaozhuangtai(String shebaozhuangtai) {
		this.shebaozhuangtai = shebaozhuangtai;
	}
	
	/**
	 * 获取：社保状态
	 */
	public String getShebaozhuangtai() {
		return shebaozhuangtai;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
				
	
	/**
	 * 设置：社保备注
	 */
	 
	public void setShebaobeizhu(String shebaobeizhu) {
		this.shebaobeizhu = shebaobeizhu;
	}
	
	/**
	 * 获取：社保备注
	 */
	public String getShebaobeizhu() {
		return shebaobeizhu;
	}
			
}
