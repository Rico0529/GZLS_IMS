package com.entity.view;

import com.entity.LaodongbaozhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 劳动保障
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("laodongbaozhang")
public class LaodongbaozhangView  extends LaodongbaozhangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaodongbaozhangView(){
	}
 
 	public LaodongbaozhangView(LaodongbaozhangEntity laodongbaozhangEntity){
 	try {
			BeanUtils.copyProperties(this, laodongbaozhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
