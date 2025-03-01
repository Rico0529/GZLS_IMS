package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ButiefafangDao;
import com.entity.ButiefafangEntity;
import com.service.ButiefafangService;
import com.entity.vo.ButiefafangVO;
import com.entity.view.ButiefafangView;

@Service("butiefafangService")
public class ButiefafangServiceImpl extends ServiceImpl<ButiefafangDao, ButiefafangEntity> implements ButiefafangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ButiefafangEntity> page = this.selectPage(
                new Query<ButiefafangEntity>(params).getPage(),
                new EntityWrapper<ButiefafangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ButiefafangEntity> wrapper) {
		  Page<ButiefafangView> page =new Query<ButiefafangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ButiefafangVO> selectListVO(Wrapper<ButiefafangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ButiefafangVO selectVO(Wrapper<ButiefafangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ButiefafangView> selectListView(Wrapper<ButiefafangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ButiefafangView selectView(Wrapper<ButiefafangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
