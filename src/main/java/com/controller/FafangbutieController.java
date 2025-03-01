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

import com.entity.FafangbutieEntity;
import com.entity.view.FafangbutieView;

import com.service.FafangbutieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 发放补贴
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
@RestController
@RequestMapping("/fafangbutie")
public class FafangbutieController {
    @Autowired
    private FafangbutieService fafangbutieService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FafangbutieEntity fafangbutie,
                @RequestParam(required = false) Double fafangzijinstart,
                @RequestParam(required = false) Double fafangzijinend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			fafangbutie.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FafangbutieEntity> ew = new EntityWrapper<FafangbutieEntity>();
                if(fafangzijinstart!=null) ew.ge("fafangzijin", fafangzijinstart);
                if(fafangzijinend!=null) ew.le("fafangzijin", fafangzijinend);



		PageUtils page = fafangbutieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fafangbutie), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FafangbutieEntity fafangbutie, 
                @RequestParam(required = false) Double fafangzijinstart,
                @RequestParam(required = false) Double fafangzijinend,
		HttpServletRequest request){
        EntityWrapper<FafangbutieEntity> ew = new EntityWrapper<FafangbutieEntity>();
                if(fafangzijinstart!=null) ew.ge("fafangzijin", fafangzijinstart);
                if(fafangzijinend!=null) ew.le("fafangzijin", fafangzijinend);

		PageUtils page = fafangbutieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fafangbutie), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FafangbutieEntity fafangbutie){
       	EntityWrapper<FafangbutieEntity> ew = new EntityWrapper<FafangbutieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fafangbutie, "fafangbutie")); 
        return R.ok().put("data", fafangbutieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FafangbutieEntity fafangbutie){
        EntityWrapper< FafangbutieEntity> ew = new EntityWrapper< FafangbutieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fafangbutie, "fafangbutie")); 
		FafangbutieView fafangbutieView =  fafangbutieService.selectView(ew);
		return R.ok("查询发放补贴成功").put("data", fafangbutieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FafangbutieEntity fafangbutie = fafangbutieService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(fafangbutie,deSens);
        return R.ok().put("data", fafangbutie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FafangbutieEntity fafangbutie = fafangbutieService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(fafangbutie,deSens);
        return R.ok().put("data", fafangbutie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增发放补贴") 
    public R save(@RequestBody FafangbutieEntity fafangbutie, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fafangbutie);
        fafangbutieService.insert(fafangbutie);
        return R.ok().put("data",fafangbutie.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增发放补贴")
    @RequestMapping("/add")
    public R add(@RequestBody FafangbutieEntity fafangbutie, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fafangbutie);
        fafangbutieService.insert(fafangbutie);
        return R.ok().put("data",fafangbutie.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改发放补贴")
    public R update(@RequestBody FafangbutieEntity fafangbutie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fafangbutie);
        //全部更新
        fafangbutieService.updateById(fafangbutie);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除发放补贴")
    public R delete(@RequestBody Long[] ids){
        fafangbutieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
