package com.dao;

import com.entity.ShebaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebaoxinxiVO;
import com.entity.view.ShebaoxinxiView;


/**
 * 社保信息
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ShebaoxinxiDao extends BaseMapper<ShebaoxinxiEntity> {
	
	List<ShebaoxinxiVO> selectListVO(@Param("ew") Wrapper<ShebaoxinxiEntity> wrapper);
	
	ShebaoxinxiVO selectVO(@Param("ew") Wrapper<ShebaoxinxiEntity> wrapper);
	
	List<ShebaoxinxiView> selectListView(@Param("ew") Wrapper<ShebaoxinxiEntity> wrapper);

	List<ShebaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShebaoxinxiEntity> wrapper);

	
	ShebaoxinxiView selectView(@Param("ew") Wrapper<ShebaoxinxiEntity> wrapper);
	

}
