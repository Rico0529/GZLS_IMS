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


import com.dao.FafangbutieDao;
import com.entity.FafangbutieEntity;
import com.service.FafangbutieService;
import com.entity.vo.FafangbutieVO;
import com.entity.view.FafangbutieView;

@Service("fafangbutieService")
public class FafangbutieServiceImpl extends ServiceImpl<FafangbutieDao, FafangbutieEntity> implements FafangbutieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FafangbutieEntity> page = this.selectPage(
                new Query<FafangbutieEntity>(params).getPage(),
                new EntityWrapper<FafangbutieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FafangbutieEntity> wrapper) {
		  Page<FafangbutieView> page =new Query<FafangbutieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FafangbutieVO> selectListVO(Wrapper<FafangbutieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FafangbutieVO selectVO(Wrapper<FafangbutieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FafangbutieView> selectListView(Wrapper<FafangbutieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FafangbutieView selectView(Wrapper<FafangbutieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
