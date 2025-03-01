package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenqingbutieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenqingbutieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingbutieView;


/**
 * 申请补贴
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ShenqingbutieService extends IService<ShenqingbutieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingbutieVO> selectListVO(Wrapper<ShenqingbutieEntity> wrapper);
   	
   	ShenqingbutieVO selectVO(@Param("ew") Wrapper<ShenqingbutieEntity> wrapper);
   	
   	List<ShenqingbutieView> selectListView(Wrapper<ShenqingbutieEntity> wrapper);
   	
   	ShenqingbutieView selectView(@Param("ew") Wrapper<ShenqingbutieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingbutieEntity> wrapper);

   	

}

