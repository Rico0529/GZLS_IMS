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

import com.entity.ShebaojiaofeiEntity;
import com.entity.view.ShebaojiaofeiView;

import com.service.ShebaojiaofeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 社保缴费
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@RestController
@RequestMapping("/shebaojiaofei")
public class ShebaojiaofeiController {
    @Autowired
    private ShebaojiaofeiService shebaojiaofeiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebaojiaofeiEntity shebaojiaofei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shebaojiaofei.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qiye")) {
			shebaojiaofei.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();



		PageUtils page = shebaojiaofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebaojiaofei), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebaojiaofeiEntity shebaojiaofei, 
		HttpServletRequest request){
        EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();

		PageUtils page = shebaojiaofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebaojiaofei), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebaojiaofeiEntity shebaojiaofei){
       	EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebaojiaofei, "shebaojiaofei")); 
        return R.ok().put("data", shebaojiaofeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebaojiaofeiEntity shebaojiaofei){
        EntityWrapper< ShebaojiaofeiEntity> ew = new EntityWrapper< ShebaojiaofeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebaojiaofei, "shebaojiaofei")); 
		ShebaojiaofeiView shebaojiaofeiView =  shebaojiaofeiService.selectView(ew);
		return R.ok("查询社保缴费成功").put("data", shebaojiaofeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebaojiaofeiEntity shebaojiaofei = shebaojiaofeiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebaojiaofei,deSens);
        return R.ok().put("data", shebaojiaofei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebaojiaofeiEntity shebaojiaofei = shebaojiaofeiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebaojiaofei,deSens);
        return R.ok().put("data", shebaojiaofei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增社保缴费") 
    public R save(@RequestBody ShebaojiaofeiEntity shebaojiaofei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebaojiaofei);
        shebaojiaofeiService.insert(shebaojiaofei);
        return R.ok().put("data",shebaojiaofei.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增社保缴费")
    @RequestMapping("/add")
    public R add(@RequestBody ShebaojiaofeiEntity shebaojiaofei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebaojiaofei);
        shebaojiaofeiService.insert(shebaojiaofei);
        return R.ok().put("data",shebaojiaofei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改社保缴费")
    public R update(@RequestBody ShebaojiaofeiEntity shebaojiaofei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebaojiaofei);
        //全部更新
        shebaojiaofeiService.updateById(shebaojiaofei);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除社保缴费")
    public R delete(@RequestBody Long[] ids){
        shebaojiaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_shebaojiaofei_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
            if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
                                        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
                        List<Map<String, Object>> result = shebaojiaofeiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
        }
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_shebaojiaofei_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
            if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
                                        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
                    for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = shebaojiaofeiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
}
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_shebaojiaofei_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("yColumn", yColumnName);
            params.put("timeStatType", timeStatType);
            EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                        if(tableName.equals("yonghu")) {
                ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                        if(tableName.equals("qiye")) {
                ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                        List<Map<String, Object>> result = shebaojiaofeiService.selectTimeStatValue(params, ew);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            return R.ok().put("data", result);
        }
    }
    
        /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        java.nio.file.Path path = java.nio.file.Paths.get("value_shebaojiaofei_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            String[] yColumnNames = yColumnNameMul.split(",");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("timeStatType", timeStatType);
            List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                        if(tableName.equals("yonghu")) {
                ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                        if(tableName.equals("qiye")) {
                ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                for(int i=0;i<yColumnNames.length;i++) {
                params.put("yColumn", yColumnNames[i]);
                List<Map<String, Object>> result = shebaojiaofeiService.selectTimeStatValue(params, ew);
                for(Map<String, Object> m : result) {
                    for(String k : m.keySet()) {
                        if(m.get(k) instanceof Date) {
                            m.put(k, sdf.format((Date)m.get(k)));
                        }
                    }
                }
                result2.add(result);
            }
            return R.ok().put("data", result2);
        }
    }
    
        /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("group_shebaojiaofei_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
            if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
                                        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
                        List<Map<String, Object>> result = shebaojiaofeiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }    
    
    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ShebaojiaofeiEntity shebaojiaofei, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            shebaojiaofei.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("qiye")) {
            shebaojiaofei.setQiyezhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ShebaojiaofeiEntity> ew = new EntityWrapper<ShebaojiaofeiEntity>();
        int count = shebaojiaofeiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebaojiaofei), params), params));
        return R.ok().put("data", count);
    }




}
