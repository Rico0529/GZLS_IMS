package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.ZhaopinxinxiEntity;
import com.entity.view.ZhaopinxinxiView;

import com.service.ZhaopinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 招聘信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@RestController
@RequestMapping("/zhaopinxinxi")
public class ZhaopinxinxiController {
    @Autowired
    private ZhaopinxinxiService zhaopinxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			zhaopinxinxi.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();



		PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();

		PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhaopinxinxiEntity zhaopinxinxi){
       	EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhaopinxinxi, "zhaopinxinxi")); 
        return R.ok().put("data", zhaopinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaopinxinxiEntity zhaopinxinxi){
        EntityWrapper< ZhaopinxinxiEntity> ew = new EntityWrapper< ZhaopinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhaopinxinxi, "zhaopinxinxi")); 
		ZhaopinxinxiView zhaopinxinxiView =  zhaopinxinxiService.selectView(ew);
		return R.ok("查询招聘信息成功").put("data", zhaopinxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhaopinxinxiEntity zhaopinxinxi = zhaopinxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhaopinxinxi,deSens);
        return R.ok().put("data", zhaopinxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhaopinxinxiEntity zhaopinxinxi = zhaopinxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhaopinxinxi,deSens);
        return R.ok().put("data", zhaopinxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增招聘信息") 
    public R save(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.insert(zhaopinxinxi);
        return R.ok().put("data",zhaopinxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增招聘信息")
    @RequestMapping("/add")
    public R add(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.insert(zhaopinxinxi);
        return R.ok().put("data",zhaopinxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改招聘信息")
    public R update(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaopinxinxi);
        //全部更新
        zhaopinxinxiService.updateById(zhaopinxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除招聘信息")
    public R delete(@RequestBody Long[] ids){
        zhaopinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
