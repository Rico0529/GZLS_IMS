package com.entity.view;

import com.entity.ShebaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 社保信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@TableName("shebaoxinxi")
public class ShebaoxinxiView  extends ShebaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShebaoxinxiView(){
	}
 
 	public ShebaoxinxiView(ShebaoxinxiEntity shebaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, shebaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
