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


import com.dao.ShebaojiaofeiDao;
import com.entity.ShebaojiaofeiEntity;
import com.service.ShebaojiaofeiService;
import com.entity.vo.ShebaojiaofeiVO;
import com.entity.view.ShebaojiaofeiView;

@Service("shebaojiaofeiService")
public class ShebaojiaofeiServiceImpl extends ServiceImpl<ShebaojiaofeiDao, ShebaojiaofeiEntity> implements ShebaojiaofeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebaojiaofeiEntity> page = this.selectPage(
                new Query<ShebaojiaofeiEntity>(params).getPage(),
                new EntityWrapper<ShebaojiaofeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebaojiaofeiEntity> wrapper) {
		  Page<ShebaojiaofeiView> page =new Query<ShebaojiaofeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShebaojiaofeiVO> selectListVO(Wrapper<ShebaojiaofeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebaojiaofeiVO selectVO(Wrapper<ShebaojiaofeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebaojiaofeiView> selectListView(Wrapper<ShebaojiaofeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebaojiaofeiView selectView(Wrapper<ShebaojiaofeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShebaojiaofeiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShebaojiaofeiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShebaojiaofeiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
