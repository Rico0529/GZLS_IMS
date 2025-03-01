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

import com.entity.ButieshenqingEntity;
import com.entity.view.ButieshenqingView;

import com.service.ButieshenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 补贴申请
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:30:00
 */
@RestController
@RequestMapping("/butieshenqing")
public class ButieshenqingController {
    @Autowired
    private ButieshenqingService butieshenqingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ButieshenqingEntity butieshenqing,
                @RequestParam(required = false) Double shenqingzijinstart,
                @RequestParam(required = false) Double shenqingzijinend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			butieshenqing.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ButieshenqingEntity> ew = new EntityWrapper<ButieshenqingEntity>();
                if(shenqingzijinstart!=null) ew.ge("shenqingzijin", shenqingzijinstart);
                if(shenqingzijinend!=null) ew.le("shenqingzijin", shenqingzijinend);



		PageUtils page = butieshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, butieshenqing), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ButieshenqingEntity butieshenqing, 
                @RequestParam(required = false) Double shenqingzijinstart,
                @RequestParam(required = false) Double shenqingzijinend,
		HttpServletRequest request){
        EntityWrapper<ButieshenqingEntity> ew = new EntityWrapper<ButieshenqingEntity>();
                if(shenqingzijinstart!=null) ew.ge("shenqingzijin", shenqingzijinstart);
                if(shenqingzijinend!=null) ew.le("shenqingzijin", shenqingzijinend);

		PageUtils page = butieshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, butieshenqing), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ButieshenqingEntity butieshenqing){
       	EntityWrapper<ButieshenqingEntity> ew = new EntityWrapper<ButieshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( butieshenqing, "butieshenqing")); 
        return R.ok().put("data", butieshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ButieshenqingEntity butieshenqing){
        EntityWrapper< ButieshenqingEntity> ew = new EntityWrapper< ButieshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( butieshenqing, "butieshenqing")); 
		ButieshenqingView butieshenqingView =  butieshenqingService.selectView(ew);
		return R.ok("查询补贴申请成功").put("data", butieshenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ButieshenqingEntity butieshenqing = butieshenqingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(butieshenqing,deSens);
        return R.ok().put("data", butieshenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ButieshenqingEntity butieshenqing = butieshenqingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(butieshenqing,deSens);
        return R.ok().put("data", butieshenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增补贴申请") 
    public R save(@RequestBody ButieshenqingEntity butieshenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(butieshenqing);
        butieshenqingService.insert(butieshenqing);
        return R.ok().put("data",butieshenqing.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增补贴申请")
    @RequestMapping("/add")
    public R add(@RequestBody ButieshenqingEntity butieshenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(butieshenqing);
        butieshenqingService.insert(butieshenqing);
        return R.ok().put("data",butieshenqing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改补贴申请")
    public R update(@RequestBody ButieshenqingEntity butieshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(butieshenqing);
        //全部更新
        butieshenqingService.updateById(butieshenqing);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核补贴申请")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ButieshenqingEntity> list = new ArrayList<ButieshenqingEntity>();
        for(Long id : ids) {
            ButieshenqingEntity butieshenqing = butieshenqingService.selectById(id);
            butieshenqing.setSfsh(sfsh);
            butieshenqing.setShhf(shhf);
            list.add(butieshenqing);
        }
        butieshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除补贴申请")
    public R delete(@RequestBody Long[] ids){
        butieshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
