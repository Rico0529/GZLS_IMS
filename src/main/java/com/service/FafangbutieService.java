package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FafangbutieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FafangbutieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FafangbutieView;


/**
 * 发放补贴
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
public interface FafangbutieService extends IService<FafangbutieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FafangbutieVO> selectListVO(Wrapper<FafangbutieEntity> wrapper);
   	
   	FafangbutieVO selectVO(@Param("ew") Wrapper<FafangbutieEntity> wrapper);
   	
   	List<FafangbutieView> selectListView(Wrapper<FafangbutieEntity> wrapper);
   	
   	FafangbutieView selectView(@Param("ew") Wrapper<FafangbutieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FafangbutieEntity> wrapper);

   	

}

