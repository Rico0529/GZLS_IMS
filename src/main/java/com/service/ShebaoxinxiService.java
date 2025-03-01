package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebaoxinxiView;


/**
 * 社保信息
 *
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ShebaoxinxiService extends IService<ShebaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebaoxinxiVO> selectListVO(Wrapper<ShebaoxinxiEntity> wrapper);
   	
   	ShebaoxinxiVO selectVO(@Param("ew") Wrapper<ShebaoxinxiEntity> wrapper);
   	
   	List<ShebaoxinxiView> selectListView(Wrapper<ShebaoxinxiEntity> wrapper);
   	
   	ShebaoxinxiView selectView(@Param("ew") Wrapper<ShebaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebaoxinxiEntity> wrapper);

   	

}

