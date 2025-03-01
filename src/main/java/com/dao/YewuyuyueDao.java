package com.dao;

import com.entity.YewuyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YewuyuyueVO;
import com.entity.view.YewuyuyueView;


/**
 * 业务预约
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface YewuyuyueDao extends BaseMapper<YewuyuyueEntity> {
	
	List<YewuyuyueVO> selectListVO(@Param("ew") Wrapper<YewuyuyueEntity> wrapper);
	
	YewuyuyueVO selectVO(@Param("ew") Wrapper<YewuyuyueEntity> wrapper);
	
	List<YewuyuyueView> selectListView(@Param("ew") Wrapper<YewuyuyueEntity> wrapper);

	List<YewuyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<YewuyuyueEntity> wrapper);

	
	YewuyuyueView selectView(@Param("ew") Wrapper<YewuyuyueEntity> wrapper);
	

}
