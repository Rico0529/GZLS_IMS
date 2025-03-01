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
 * 社保信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("shebaoxinxi")
public class ShebaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShebaoxinxiEntity() {
		
	}
	
	public ShebaoxinxiEntity(T t) {
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
	 * 社保编号
	 */
					
	private String shebaobianhao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	/**
	 * 社保备注
	 */
					
	private String shebaobeizhu;
	
	
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
	 * 设置：社保编号
	 */
	public void setShebaobianhao(String shebaobianhao) {
		this.shebaobianhao = shebaobianhao;
	}
	/**
	 * 获取：社保编号
	 */
	public String getShebaobianhao() {
		return shebaobianhao;
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
