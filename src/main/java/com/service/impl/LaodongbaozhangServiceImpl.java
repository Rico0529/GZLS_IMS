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


import com.dao.LaodongbaozhangDao;
import com.entity.LaodongbaozhangEntity;
import com.service.LaodongbaozhangService;
import com.entity.vo.LaodongbaozhangVO;
import com.entity.view.LaodongbaozhangView;

@Service("laodongbaozhangService")
public class LaodongbaozhangServiceImpl extends ServiceImpl<LaodongbaozhangDao, LaodongbaozhangEntity> implements LaodongbaozhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaodongbaozhangEntity> page = this.selectPage(
                new Query<LaodongbaozhangEntity>(params).getPage(),
                new EntityWrapper<LaodongbaozhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaodongbaozhangEntity> wrapper) {
		  Page<LaodongbaozhangView> page =new Query<LaodongbaozhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LaodongbaozhangVO> selectListVO(Wrapper<LaodongbaozhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaodongbaozhangVO selectVO(Wrapper<LaodongbaozhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaodongbaozhangView> selectListView(Wrapper<LaodongbaozhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaodongbaozhangView selectView(Wrapper<LaodongbaozhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
