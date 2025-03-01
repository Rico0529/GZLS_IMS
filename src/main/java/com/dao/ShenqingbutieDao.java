package com.dao;

import com.entity.ShenqingbutieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenqingbutieVO;
import com.entity.view.ShenqingbutieView;


/**
 * 申请补贴
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ShenqingbutieDao extends BaseMapper<ShenqingbutieEntity> {
	
	List<ShenqingbutieVO> selectListVO(@Param("ew") Wrapper<ShenqingbutieEntity> wrapper);
	
	ShenqingbutieVO selectVO(@Param("ew") Wrapper<ShenqingbutieEntity> wrapper);
	
	List<ShenqingbutieView> selectListView(@Param("ew") Wrapper<ShenqingbutieEntity> wrapper);

	List<ShenqingbutieView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingbutieEntity> wrapper);

	
	ShenqingbutieView selectView(@Param("ew") Wrapper<ShenqingbutieEntity> wrapper);
	

}
