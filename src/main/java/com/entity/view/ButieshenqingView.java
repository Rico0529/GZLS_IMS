package com.entity.view;

import com.entity.ButieshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 补贴申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
@TableName("butieshenqing")
public class ButieshenqingView  extends ButieshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ButieshenqingView(){
	}
 
 	public ButieshenqingView(ButieshenqingEntity butieshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, butieshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
