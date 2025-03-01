package com.entity.view;

import com.entity.ShenqingbutieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 申请补贴
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("shenqingbutie")
public class ShenqingbutieView  extends ShenqingbutieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingbutieView(){
	}
 
 	public ShenqingbutieView(ShenqingbutieEntity shenqingbutieEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingbutieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
