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

import com.entity.ButiefafangEntity;
import com.entity.view.ButiefafangView;

import com.service.ButiefafangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 补贴发放
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@RestController
@RequestMapping("/butiefafang")
public class ButiefafangController {
    @Autowired
    private ButiefafangService butiefafangService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ButiefafangEntity butiefafang,
                @RequestParam(required = false) Double butiejinestart,
                @RequestParam(required = false) Double butiejineend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			butiefafang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ButiefafangEntity> ew = new EntityWrapper<ButiefafangEntity>();
                if(butiejinestart!=null) ew.ge("butiejine", butiejinestart);
                if(butiejineend!=null) ew.le("butiejine", butiejineend);



		PageUtils page = butiefafangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, butiefafang), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ButiefafangEntity butiefafang, 
                @RequestParam(required = false) Double butiejinestart,
                @RequestParam(required = false) Double butiejineend,
		HttpServletRequest request){
        EntityWrapper<ButiefafangEntity> ew = new EntityWrapper<ButiefafangEntity>();
                if(butiejinestart!=null) ew.ge("butiejine", butiejinestart);
                if(butiejineend!=null) ew.le("butiejine", butiejineend);

		PageUtils page = butiefafangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, butiefafang), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ButiefafangEntity butiefafang){
       	EntityWrapper<ButiefafangEntity> ew = new EntityWrapper<ButiefafangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( butiefafang, "butiefafang")); 
        return R.ok().put("data", butiefafangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ButiefafangEntity butiefafang){
        EntityWrapper< ButiefafangEntity> ew = new EntityWrapper< ButiefafangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( butiefafang, "butiefafang")); 
		ButiefafangView butiefafangView =  butiefafangService.selectView(ew);
		return R.ok("查询补贴发放成功").put("data", butiefafangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ButiefafangEntity butiefafang = butiefafangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(butiefafang,deSens);
        return R.ok().put("data", butiefafang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ButiefafangEntity butiefafang = butiefafangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(butiefafang,deSens);
        return R.ok().put("data", butiefafang);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增补贴发放") 
    public R save(@RequestBody ButiefafangEntity butiefafang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(butiefafang);
        butiefafangService.insert(butiefafang);
        return R.ok().put("data",butiefafang.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增补贴发放")
    @RequestMapping("/add")
    public R add(@RequestBody ButiefafangEntity butiefafang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(butiefafang);
        butiefafangService.insert(butiefafang);
        return R.ok().put("data",butiefafang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改补贴发放")
    public R update(@RequestBody ButiefafangEntity butiefafang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(butiefafang);
        //全部更新
        butiefafangService.updateById(butiefafang);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除补贴发放")
    public R delete(@RequestBody Long[] ids){
        butiefafangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
