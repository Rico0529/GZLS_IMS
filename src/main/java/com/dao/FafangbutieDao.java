package com.dao;

import com.entity.FafangbutieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FafangbutieVO;
import com.entity.view.FafangbutieView;


/**
 * 发放补贴
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
public interface FafangbutieDao extends BaseMapper<FafangbutieEntity> {
	
	List<FafangbutieVO> selectListVO(@Param("ew") Wrapper<FafangbutieEntity> wrapper);
	
	FafangbutieVO selectVO(@Param("ew") Wrapper<FafangbutieEntity> wrapper);
	
	List<FafangbutieView> selectListView(@Param("ew") Wrapper<FafangbutieEntity> wrapper);

	List<FafangbutieView> selectListView(Pagination page,@Param("ew") Wrapper<FafangbutieEntity> wrapper);

	
	FafangbutieView selectView(@Param("ew") Wrapper<FafangbutieEntity> wrapper);
	

}
