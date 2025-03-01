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


import com.dao.ButieshenqingDao;
import com.entity.ButieshenqingEntity;
import com.service.ButieshenqingService;
import com.entity.vo.ButieshenqingVO;
import com.entity.view.ButieshenqingView;

@Service("butieshenqingService")
public class ButieshenqingServiceImpl extends ServiceImpl<ButieshenqingDao, ButieshenqingEntity> implements ButieshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ButieshenqingEntity> page = this.selectPage(
                new Query<ButieshenqingEntity>(params).getPage(),
                new EntityWrapper<ButieshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ButieshenqingEntity> wrapper) {
		  Page<ButieshenqingView> page =new Query<ButieshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ButieshenqingVO> selectListVO(Wrapper<ButieshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ButieshenqingVO selectVO(Wrapper<ButieshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ButieshenqingView> selectListView(Wrapper<ButieshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ButieshenqingView selectView(Wrapper<ButieshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
