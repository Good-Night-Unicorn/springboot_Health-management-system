package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
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

import com.entity.ZhinengchuandaishebeiEntity;
import com.entity.view.ZhinengchuandaishebeiView;

import com.service.ZhinengchuandaishebeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 智能穿戴设备
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
@RestController
@RequestMapping("/zhinengchuandaishebei")
public class ZhinengchuandaishebeiController {
    @Autowired
    private ZhinengchuandaishebeiService zhinengchuandaishebeiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhinengchuandaishebeiEntity zhinengchuandaishebei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zhinengchuandaishebei.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ZhinengchuandaishebeiEntity> ew = new EntityWrapper<ZhinengchuandaishebeiEntity>();


        //查询结果
		PageUtils page = zhinengchuandaishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhinengchuandaishebei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhinengchuandaishebeiEntity zhinengchuandaishebei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhinengchuandaishebeiEntity> ew = new EntityWrapper<ZhinengchuandaishebeiEntity>();

        //查询结果
		PageUtils page = zhinengchuandaishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhinengchuandaishebei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhinengchuandaishebeiEntity zhinengchuandaishebei){
       	EntityWrapper<ZhinengchuandaishebeiEntity> ew = new EntityWrapper<ZhinengchuandaishebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhinengchuandaishebei, "zhinengchuandaishebei")); 
        return R.ok().put("data", zhinengchuandaishebeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhinengchuandaishebeiEntity zhinengchuandaishebei){
        EntityWrapper< ZhinengchuandaishebeiEntity> ew = new EntityWrapper< ZhinengchuandaishebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhinengchuandaishebei, "zhinengchuandaishebei")); 
		ZhinengchuandaishebeiView zhinengchuandaishebeiView =  zhinengchuandaishebeiService.selectView(ew);
		return R.ok("查询智能穿戴设备成功").put("data", zhinengchuandaishebeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhinengchuandaishebeiEntity zhinengchuandaishebei = zhinengchuandaishebeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhinengchuandaishebei,deSens);
        return R.ok().put("data", zhinengchuandaishebei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhinengchuandaishebeiEntity zhinengchuandaishebei = zhinengchuandaishebeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhinengchuandaishebei,deSens);
        return R.ok().put("data", zhinengchuandaishebei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhinengchuandaishebeiEntity zhinengchuandaishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhinengchuandaishebei);
        zhinengchuandaishebeiService.insert(zhinengchuandaishebei);
        return R.ok().put("data",zhinengchuandaishebei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhinengchuandaishebeiEntity zhinengchuandaishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhinengchuandaishebei);
        zhinengchuandaishebeiService.insert(zhinengchuandaishebei);
        return R.ok().put("data",zhinengchuandaishebei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhinengchuandaishebeiEntity zhinengchuandaishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhinengchuandaishebei);
        //全部更新
        zhinengchuandaishebeiService.updateById(zhinengchuandaishebei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhinengchuandaishebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
