package com.dao;

import com.entity.ShebaojiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebaojiaofeiVO;
import com.entity.view.ShebaojiaofeiView;


/**
 * 社保缴费
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ShebaojiaofeiDao extends BaseMapper<ShebaojiaofeiEntity> {
	
	List<ShebaojiaofeiVO> selectListVO(@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);
	
	ShebaojiaofeiVO selectVO(@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);
	
	List<ShebaojiaofeiView> selectListView(@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);

	List<ShebaojiaofeiView> selectListView(Pagination page,@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);

	
	ShebaojiaofeiView selectView(@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebaojiaofeiEntity> wrapper);



}
