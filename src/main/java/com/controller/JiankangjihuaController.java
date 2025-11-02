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

import com.entity.JiankangjihuaEntity;
import com.entity.view.JiankangjihuaView;

import com.service.JiankangjihuaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康计划
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
@RestController
@RequestMapping("/jiankangjihua")
public class JiankangjihuaController {
    @Autowired
    private JiankangjihuaService jiankangjihuaService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangjihuaEntity jiankangjihua,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiankangjihua.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiankangyisheng")) {
			jiankangjihua.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JiankangjihuaEntity> ew = new EntityWrapper<JiankangjihuaEntity>();


        //查询结果
		PageUtils page = jiankangjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangjihua), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiankangjihuaEntity jiankangjihua, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangjihuaEntity> ew = new EntityWrapper<JiankangjihuaEntity>();

        //查询结果
		PageUtils page = jiankangjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangjihua), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangjihuaEntity jiankangjihua){
       	EntityWrapper<JiankangjihuaEntity> ew = new EntityWrapper<JiankangjihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangjihua, "jiankangjihua")); 
        return R.ok().put("data", jiankangjihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangjihuaEntity jiankangjihua){
        EntityWrapper< JiankangjihuaEntity> ew = new EntityWrapper< JiankangjihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangjihua, "jiankangjihua")); 
		JiankangjihuaView jiankangjihuaView =  jiankangjihuaService.selectView(ew);
		return R.ok("查询健康计划成功").put("data", jiankangjihuaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangjihuaEntity jiankangjihua = jiankangjihuaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangjihua,deSens);
        return R.ok().put("data", jiankangjihua);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangjihuaEntity jiankangjihua = jiankangjihuaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangjihua,deSens);
        return R.ok().put("data", jiankangjihua);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangjihuaEntity jiankangjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangjihua);
        jiankangjihuaService.insert(jiankangjihua);
        return R.ok().put("data",jiankangjihua.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangjihuaEntity jiankangjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangjihua);
        jiankangjihuaService.insert(jiankangjihua);
        return R.ok().put("data",jiankangjihua.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangjihuaEntity jiankangjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangjihua);
        //全部更新
        jiankangjihuaService.updateById(jiankangjihua);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangjihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
