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

import com.entity.LaodongbaozhangEntity;
import com.entity.view.LaodongbaozhangView;

import com.service.LaodongbaozhangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 劳动保障
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@RestController
@RequestMapping("/laodongbaozhang")
public class LaodongbaozhangController {
    @Autowired
    private LaodongbaozhangService laodongbaozhangService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LaodongbaozhangEntity laodongbaozhang,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<LaodongbaozhangEntity> ew = new EntityWrapper<LaodongbaozhangEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);



		PageUtils page = laodongbaozhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laodongbaozhang), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LaodongbaozhangEntity laodongbaozhang, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<LaodongbaozhangEntity> ew = new EntityWrapper<LaodongbaozhangEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = laodongbaozhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laodongbaozhang), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LaodongbaozhangEntity laodongbaozhang){
       	EntityWrapper<LaodongbaozhangEntity> ew = new EntityWrapper<LaodongbaozhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( laodongbaozhang, "laodongbaozhang")); 
        return R.ok().put("data", laodongbaozhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LaodongbaozhangEntity laodongbaozhang){
        EntityWrapper< LaodongbaozhangEntity> ew = new EntityWrapper< LaodongbaozhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( laodongbaozhang, "laodongbaozhang")); 
		LaodongbaozhangView laodongbaozhangView =  laodongbaozhangService.selectView(ew);
		return R.ok("查询劳动保障成功").put("data", laodongbaozhangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LaodongbaozhangEntity laodongbaozhang = laodongbaozhangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(laodongbaozhang,deSens);
        return R.ok().put("data", laodongbaozhang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LaodongbaozhangEntity laodongbaozhang = laodongbaozhangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(laodongbaozhang,deSens);
        return R.ok().put("data", laodongbaozhang);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增劳动保障") 
    public R save(@RequestBody LaodongbaozhangEntity laodongbaozhang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(laodongbaozhang);
        laodongbaozhangService.insert(laodongbaozhang);
        return R.ok().put("data",laodongbaozhang.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增劳动保障")
    @RequestMapping("/add")
    public R add(@RequestBody LaodongbaozhangEntity laodongbaozhang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(laodongbaozhang);
        laodongbaozhangService.insert(laodongbaozhang);
        return R.ok().put("data",laodongbaozhang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改劳动保障")
    public R update(@RequestBody LaodongbaozhangEntity laodongbaozhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(laodongbaozhang);
        //全部更新
        laodongbaozhangService.updateById(laodongbaozhang);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除劳动保障")
    public R delete(@RequestBody Long[] ids){
        laodongbaozhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
