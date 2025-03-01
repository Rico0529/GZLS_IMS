package com.entity.view;

import com.entity.YewuyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 业务预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("yewuyuyue")
public class YewuyuyueView  extends YewuyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YewuyuyueView(){
	}
 
 	public YewuyuyueView(YewuyuyueEntity yewuyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, yewuyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
