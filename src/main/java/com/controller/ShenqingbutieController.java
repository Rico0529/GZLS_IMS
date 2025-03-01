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

import com.entity.ShenqingbutieEntity;
import com.entity.view.ShenqingbutieView;

import com.service.ShenqingbutieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 申请补贴
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@RestController
@RequestMapping("/shenqingbutie")
public class ShenqingbutieController {
    @Autowired
    private ShenqingbutieService shenqingbutieService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingbutieEntity shenqingbutie,
                @RequestParam(required = false) Double butiejinestart,
                @RequestParam(required = false) Double butiejineend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shenqingbutie.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingbutieEntity> ew = new EntityWrapper<ShenqingbutieEntity>();
                if(butiejinestart!=null) ew.ge("butiejine", butiejinestart);
                if(butiejineend!=null) ew.le("butiejine", butiejineend);



		PageUtils page = shenqingbutieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingbutie), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingbutieEntity shenqingbutie, 
                @RequestParam(required = false) Double butiejinestart,
                @RequestParam(required = false) Double butiejineend,
		HttpServletRequest request){
        EntityWrapper<ShenqingbutieEntity> ew = new EntityWrapper<ShenqingbutieEntity>();
                if(butiejinestart!=null) ew.ge("butiejine", butiejinestart);
                if(butiejineend!=null) ew.le("butiejine", butiejineend);

		PageUtils page = shenqingbutieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingbutie), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingbutieEntity shenqingbutie){
       	EntityWrapper<ShenqingbutieEntity> ew = new EntityWrapper<ShenqingbutieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingbutie, "shenqingbutie")); 
        return R.ok().put("data", shenqingbutieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingbutieEntity shenqingbutie){
        EntityWrapper< ShenqingbutieEntity> ew = new EntityWrapper< ShenqingbutieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingbutie, "shenqingbutie")); 
		ShenqingbutieView shenqingbutieView =  shenqingbutieService.selectView(ew);
		return R.ok("查询申请补贴成功").put("data", shenqingbutieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingbutieEntity shenqingbutie = shenqingbutieService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shenqingbutie,deSens);
        return R.ok().put("data", shenqingbutie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingbutieEntity shenqingbutie = shenqingbutieService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shenqingbutie,deSens);
        return R.ok().put("data", shenqingbutie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增申请补贴") 
    public R save(@RequestBody ShenqingbutieEntity shenqingbutie, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingbutie);
        shenqingbutieService.insert(shenqingbutie);
        return R.ok().put("data",shenqingbutie.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增申请补贴")
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingbutieEntity shenqingbutie, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingbutie);
        shenqingbutieService.insert(shenqingbutie);
        return R.ok().put("data",shenqingbutie.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改申请补贴")
    public R update(@RequestBody ShenqingbutieEntity shenqingbutie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingbutie);
        //全部更新
        shenqingbutieService.updateById(shenqingbutie);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除申请补贴")
    public R delete(@RequestBody Long[] ids){
        shenqingbutieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
