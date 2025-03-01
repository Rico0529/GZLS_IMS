package com.dao;

import com.entity.ButiefafangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ButiefafangVO;
import com.entity.view.ButiefafangView;


/**
 * 补贴发放
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface ButiefafangDao extends BaseMapper<ButiefafangEntity> {
	
	List<ButiefafangVO> selectListVO(@Param("ew") Wrapper<ButiefafangEntity> wrapper);
	
	ButiefafangVO selectVO(@Param("ew") Wrapper<ButiefafangEntity> wrapper);
	
	List<ButiefafangView> selectListView(@Param("ew") Wrapper<ButiefafangEntity> wrapper);

	List<ButiefafangView> selectListView(Pagination page,@Param("ew") Wrapper<ButiefafangEntity> wrapper);

	
	ButiefafangView selectView(@Param("ew") Wrapper<ButiefafangEntity> wrapper);
	

}
