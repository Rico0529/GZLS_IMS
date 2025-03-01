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

import com.entity.ShebaoxinxiEntity;
import com.entity.view.ShebaoxinxiView;

import com.service.ShebaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 社保信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@RestController
@RequestMapping("/shebaoxinxi")
public class ShebaoxinxiController {
    @Autowired
    private ShebaoxinxiService shebaoxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebaoxinxiEntity shebaoxinxi,
		HttpServletRequest request){
        EntityWrapper<ShebaoxinxiEntity> ew = new EntityWrapper<ShebaoxinxiEntity>();



		PageUtils page = shebaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebaoxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebaoxinxiEntity shebaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShebaoxinxiEntity> ew = new EntityWrapper<ShebaoxinxiEntity>();

		PageUtils page = shebaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebaoxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebaoxinxiEntity shebaoxinxi){
       	EntityWrapper<ShebaoxinxiEntity> ew = new EntityWrapper<ShebaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebaoxinxi, "shebaoxinxi")); 
        return R.ok().put("data", shebaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebaoxinxiEntity shebaoxinxi){
        EntityWrapper< ShebaoxinxiEntity> ew = new EntityWrapper< ShebaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebaoxinxi, "shebaoxinxi")); 
		ShebaoxinxiView shebaoxinxiView =  shebaoxinxiService.selectView(ew);
		return R.ok("查询社保信息成功").put("data", shebaoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebaoxinxiEntity shebaoxinxi = shebaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebaoxinxi,deSens);
        return R.ok().put("data", shebaoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebaoxinxiEntity shebaoxinxi = shebaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebaoxinxi,deSens);
        return R.ok().put("data", shebaoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增社保信息") 
    public R save(@RequestBody ShebaoxinxiEntity shebaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebaoxinxi);
        shebaoxinxiService.insert(shebaoxinxi);
        return R.ok().put("data",shebaoxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增社保信息")
    @RequestMapping("/add")
    public R add(@RequestBody ShebaoxinxiEntity shebaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebaoxinxi);
        shebaoxinxiService.insert(shebaoxinxi);
        return R.ok().put("data",shebaoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改社保信息")
    public R update(@RequestBody ShebaoxinxiEntity shebaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebaoxinxi);
        //全部更新
        shebaoxinxiService.updateById(shebaoxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除社保信息")
    public R delete(@RequestBody Long[] ids){
        shebaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
