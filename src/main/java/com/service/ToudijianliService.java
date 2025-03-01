package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ToudijianliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ToudijianliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ToudijianliView;


/**
 * 投递简历
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ToudijianliService extends IService<ToudijianliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ToudijianliVO> selectListVO(Wrapper<ToudijianliEntity> wrapper);
   	
   	ToudijianliVO selectVO(@Param("ew") Wrapper<ToudijianliEntity> wrapper);
   	
   	List<ToudijianliView> selectListView(Wrapper<ToudijianliEntity> wrapper);
   	
   	ToudijianliView selectView(@Param("ew") Wrapper<ToudijianliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ToudijianliEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ToudijianliEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ToudijianliEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ToudijianliEntity> wrapper);



}

