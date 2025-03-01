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
 * 申请补贴
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("shenqingbutie")
public class ShenqingbutieEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShenqingbutieEntity() {
		
	}
	
	public ShenqingbutieEntity(T t) {
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
	 * 补贴名称
	 */
					
	private String butiemingcheng;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 设置：补贴名称
	 */
	public void setButiemingcheng(String butiemingcheng) {
		this.butiemingcheng = butiemingcheng;
	}
	/**
	 * 获取：补贴名称
	 */
	public String getButiemingcheng() {
		return butiemingcheng;
	}
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
