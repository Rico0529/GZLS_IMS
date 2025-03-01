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


import com.dao.YewuyuyueDao;
import com.entity.YewuyuyueEntity;
import com.service.YewuyuyueService;
import com.entity.vo.YewuyuyueVO;
import com.entity.view.YewuyuyueView;

@Service("yewuyuyueService")
public class YewuyuyueServiceImpl extends ServiceImpl<YewuyuyueDao, YewuyuyueEntity> implements YewuyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YewuyuyueEntity> page = this.selectPage(
                new Query<YewuyuyueEntity>(params).getPage(),
                new EntityWrapper<YewuyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YewuyuyueEntity> wrapper) {
		  Page<YewuyuyueView> page =new Query<YewuyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YewuyuyueVO> selectListVO(Wrapper<YewuyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YewuyuyueVO selectVO(Wrapper<YewuyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YewuyuyueView> selectListView(Wrapper<YewuyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YewuyuyueView selectView(Wrapper<YewuyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
