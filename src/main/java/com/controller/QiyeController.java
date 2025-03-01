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
import com.entity.TokenEntity;
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

import com.entity.QiyeEntity;
import com.entity.view.QiyeView;

import com.service.QiyeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 企业
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-21 11:29:59
 */
@RestController
@RequestMapping("/qiye")
public class QiyeController {
    @Autowired
    private QiyeService qiyeService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", username));
        if(u==null || !u.getMima().equals(EncryptUtil.desEncrypt(password))) {
			return R.error("账号或密码不正确");
		}
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"qiye",  "企业" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QiyeEntity qiye){
    	//ValidatorUtils.validateEntity(qiye);
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		qiye.setId(uId);
        qiye.setMima(EncryptUtil.desEncrypt(qiye.getMima()));
        qiyeService.insert(qiye);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        QiyeEntity u = qiyeService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima(EncryptUtil.desEncrypt("123456"));
        qiyeService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiyeEntity qiye,
		HttpServletRequest request){
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();



		PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiyeEntity qiye, 
		HttpServletRequest request){
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();

		PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiyeEntity qiye){
       	EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiye, "qiye")); 
        return R.ok().put("data", qiyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiyeEntity qiye){
        EntityWrapper< QiyeEntity> ew = new EntityWrapper< QiyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiye, "qiye")); 
		QiyeView qiyeView =  qiyeService.selectView(ew);
		return R.ok("查询企业成功").put("data", qiyeView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(qiye,deSens);
        return R.ok().put("data", qiye);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(qiye,deSens);
        return R.ok().put("data", qiye);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增企业") 
    public R save(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        if(qiyeService.selectCount(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()))>0) {
            return R.error("企业账号已存在");
        }
    	qiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qiye);
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		qiye.setId(new Date().getTime());
        qiye.setMima(EncryptUtil.desEncrypt(qiye.getMima()));
        qiyeService.insert(qiye);
        return R.ok().put("data",qiye.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增企业")
    @RequestMapping("/add")
    public R add(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        if(qiyeService.selectCount(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()))>0) {
            return R.error("企业账号已存在");
        }
    	qiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qiye);
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		qiye.setId(new Date().getTime());
        qiye.setMima(EncryptUtil.desEncrypt(qiye.getMima()));
        qiyeService.insert(qiye);
        return R.ok().put("data",qiye.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改企业")
    public R update(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiye);
        if(qiyeService.selectCount(new EntityWrapper<QiyeEntity>().ne("id", qiye.getId()).eq("qiyezhanghao", qiye.getQiyezhanghao()))>0) {
            return R.error("企业账号已存在");
        }
	QiyeEntity qiyeEntity = qiyeService.selectById(qiye.getId());
        if(StringUtils.isNotBlank(qiye.getMima()) && !qiye.getMima().equals(qiyeEntity.getMima())) {
            qiye.setMima(EncryptUtil.desEncrypt(qiye.getMima()));
        }
        //全部更新
        qiyeService.updateById(qiye);
    if(null!=qiye.getQiyezhanghao())
    {
        // 修改token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsername(qiye.getQiyezhanghao());
        tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", qiye.getId()));
    }


        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核企业")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QiyeEntity> list = new ArrayList<QiyeEntity>();
        for(Long id : ids) {
            QiyeEntity qiye = qiyeService.selectById(id);
            qiye.setSfsh(sfsh);
            qiye.setShhf(shhf);
            list.add(qiye);
        }
        qiyeService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除企业")
    public R delete(@RequestBody Long[] ids){
        qiyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
