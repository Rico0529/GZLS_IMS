package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YewuyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YewuyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YewuyuyueView;


/**
 * 业务预约
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface YewuyuyueService extends IService<YewuyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YewuyuyueVO> selectListVO(Wrapper<YewuyuyueEntity> wrapper);
   	
   	YewuyuyueVO selectVO(@Param("ew") Wrapper<YewuyuyueEntity> wrapper);
   	
   	List<YewuyuyueView> selectListView(Wrapper<YewuyuyueEntity> wrapper);
   	
   	YewuyuyueView selectView(@Param("ew") Wrapper<YewuyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YewuyuyueEntity> wrapper);

   	

}

