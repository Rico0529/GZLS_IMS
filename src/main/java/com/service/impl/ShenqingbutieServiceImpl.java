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


import com.dao.ShenqingbutieDao;
import com.entity.ShenqingbutieEntity;
import com.service.ShenqingbutieService;
import com.entity.vo.ShenqingbutieVO;
import com.entity.view.ShenqingbutieView;

@Service("shenqingbutieService")
public class ShenqingbutieServiceImpl extends ServiceImpl<ShenqingbutieDao, ShenqingbutieEntity> implements ShenqingbutieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingbutieEntity> page = this.selectPage(
                new Query<ShenqingbutieEntity>(params).getPage(),
                new EntityWrapper<ShenqingbutieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingbutieEntity> wrapper) {
		  Page<ShenqingbutieView> page =new Query<ShenqingbutieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShenqingbutieVO> selectListVO(Wrapper<ShenqingbutieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingbutieVO selectVO(Wrapper<ShenqingbutieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingbutieView> selectListView(Wrapper<ShenqingbutieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingbutieView selectView(Wrapper<ShenqingbutieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
