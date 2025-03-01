package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaodongbaozhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaodongbaozhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaodongbaozhangView;


/**
 * 劳动保障
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface LaodongbaozhangService extends IService<LaodongbaozhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaodongbaozhangVO> selectListVO(Wrapper<LaodongbaozhangEntity> wrapper);
   	
   	LaodongbaozhangVO selectVO(@Param("ew") Wrapper<LaodongbaozhangEntity> wrapper);
   	
   	List<LaodongbaozhangView> selectListView(Wrapper<LaodongbaozhangEntity> wrapper);
   	
   	LaodongbaozhangView selectView(@Param("ew") Wrapper<LaodongbaozhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaodongbaozhangEntity> wrapper);

   	

}

