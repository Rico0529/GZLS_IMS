package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ButieshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ButieshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ButieshenqingView;


/**
 * 补贴申请
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
public interface ButieshenqingService extends IService<ButieshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ButieshenqingVO> selectListVO(Wrapper<ButieshenqingEntity> wrapper);
   	
   	ButieshenqingVO selectVO(@Param("ew") Wrapper<ButieshenqingEntity> wrapper);
   	
   	List<ButieshenqingView> selectListView(Wrapper<ButieshenqingEntity> wrapper);
   	
   	ButieshenqingView selectView(@Param("ew") Wrapper<ButieshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ButieshenqingEntity> wrapper);

   	

}

