package com.entity.view;

import com.entity.FafangbutieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 发放补贴
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
@TableName("fafangbutie")
public class FafangbutieView  extends FafangbutieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FafangbutieView(){
	}
 
 	public FafangbutieView(FafangbutieEntity fafangbutieEntity){
 	try {
			BeanUtils.copyProperties(this, fafangbutieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
