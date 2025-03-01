package com.dao;

import com.entity.LaodongbaozhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaodongbaozhangVO;
import com.entity.view.LaodongbaozhangView;


/**
 * 劳动保障
 * 
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
public interface LaodongbaozhangDao extends BaseMapper<LaodongbaozhangEntity> {
	
	List<LaodongbaozhangVO> selectListVO(@Param("ew") Wrapper<LaodongbaozhangEntity> wrapper);
	
	LaodongbaozhangVO selectVO(@Param("ew") Wrapper<LaodongbaozhangEntity> wrapper);
	
	List<LaodongbaozhangView> selectListView(@Param("ew") Wrapper<LaodongbaozhangEntity> wrapper);

	List<LaodongbaozhangView> selectListView(Pagination page,@Param("ew") Wrapper<LaodongbaozhangEntity> wrapper);

	
	LaodongbaozhangView selectView(@Param("ew") Wrapper<LaodongbaozhangEntity> wrapper);
	

}
