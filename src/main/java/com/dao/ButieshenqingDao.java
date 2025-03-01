package com.dao;

import com.entity.ButieshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ButieshenqingVO;
import com.entity.view.ButieshenqingView;


/**
 * 补贴申请
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
public interface ButieshenqingDao extends BaseMapper<ButieshenqingEntity> {
	
	List<ButieshenqingVO> selectListVO(@Param("ew") Wrapper<ButieshenqingEntity> wrapper);
	
	ButieshenqingVO selectVO(@Param("ew") Wrapper<ButieshenqingEntity> wrapper);
	
	List<ButieshenqingView> selectListView(@Param("ew") Wrapper<ButieshenqingEntity> wrapper);

	List<ButieshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ButieshenqingEntity> wrapper);

	
	ButieshenqingView selectView(@Param("ew") Wrapper<ButieshenqingEntity> wrapper);
	

}
