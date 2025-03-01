package com.entity.view;

import com.entity.ShebaojiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 社保缴费
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("shebaojiaofei")
public class ShebaojiaofeiView  extends ShebaojiaofeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShebaojiaofeiView(){
	}
 
 	public ShebaojiaofeiView(ShebaojiaofeiEntity shebaojiaofeiEntity){
 	try {
			BeanUtils.copyProperties(this, shebaojiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
