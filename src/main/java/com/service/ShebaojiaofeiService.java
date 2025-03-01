package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebaojiaofeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebaojiaofeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebaojiaofeiView;


/**
 * 社保缴费
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ShebaojiaofeiService extends IService<ShebaojiaofeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebaojiaofeiVO> selectListVO(Wrapper<ShebaojiaofeiEntity> wrapper);
   	
   	ShebaojiaofeiVO selectVO(@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);
   	
   	List<ShebaojiaofeiView> selectListView(Wrapper<ShebaojiaofeiEntity> wrapper);
   	
   	ShebaojiaofeiView selectView(@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebaojiaofeiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShebaojiaofeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShebaojiaofeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShebaojiaofeiEntity> wrapper);



}

