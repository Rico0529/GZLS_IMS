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
 * 发放补贴
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
@TableName("fafangbutie")
public class FafangbutieEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FafangbutieEntity() {
		
	}
	
	public FafangbutieEntity(T t) {
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
	 * 项目名称
	 */
					
	private String xiangmumingcheng;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 设置：项目名称
	 */
	public void setXiangmumingcheng(String xiangmumingcheng) {
		this.xiangmumingcheng = xiangmumingcheng;
	}
	/**
	 * 获取：项目名称
	 */
	public String getXiangmumingcheng() {
		return xiangmumingcheng;
	}
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
