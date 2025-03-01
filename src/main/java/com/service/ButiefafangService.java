package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ButiefafangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ButiefafangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ButiefafangView;


/**
 * 补贴发放
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ButiefafangService extends IService<ButiefafangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ButiefafangVO> selectListVO(Wrapper<ButiefafangEntity> wrapper);
   	
   	ButiefafangVO selectVO(@Param("ew") Wrapper<ButiefafangEntity> wrapper);
   	
   	List<ButiefafangView> selectListView(Wrapper<ButiefafangEntity> wrapper);
   	
   	ButiefafangView selectView(@Param("ew") Wrapper<ButiefafangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ButiefafangEntity> wrapper);

   	

}

