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


import com.dao.ShebaoxinxiDao;
import com.entity.ShebaoxinxiEntity;
import com.service.ShebaoxinxiService;
import com.entity.vo.ShebaoxinxiVO;
import com.entity.view.ShebaoxinxiView;

@Service("shebaoxinxiService")
public class ShebaoxinxiServiceImpl extends ServiceImpl<ShebaoxinxiDao, ShebaoxinxiEntity> implements ShebaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebaoxinxiEntity> page = this.selectPage(
                new Query<ShebaoxinxiEntity>(params).getPage(),
                new EntityWrapper<ShebaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebaoxinxiEntity> wrapper) {
		  Page<ShebaoxinxiView> page =new Query<ShebaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShebaoxinxiVO> selectListVO(Wrapper<ShebaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebaoxinxiVO selectVO(Wrapper<ShebaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebaoxinxiView> selectListView(Wrapper<ShebaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebaoxinxiView selectView(Wrapper<ShebaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
