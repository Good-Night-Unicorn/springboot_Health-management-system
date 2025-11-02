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

import com.entity.JiankangzixunEntity;
import com.entity.view.JiankangzixunView;

import com.service.JiankangzixunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 健康资讯
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-18 10:54:00
 */
@RestController
@RequestMapping("/jiankangzixun")
public class JiankangzixunController {
    @Autowired
    private JiankangzixunService jiankangzixunService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangzixunEntity jiankangzixun,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            jiankangzixun.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        //设置查询条件
        EntityWrapper<JiankangzixunEntity> ew = new EntityWrapper<JiankangzixunEntity>();


        //查询结果
		PageUtils page = jiankangzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangzixun), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiankangzixunEntity jiankangzixun, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangzixunEntity> ew = new EntityWrapper<JiankangzixunEntity>();

        //查询结果
		PageUtils page = jiankangzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangzixun), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangzixunEntity jiankangzixun){
       	EntityWrapper<JiankangzixunEntity> ew = new EntityWrapper<JiankangzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangzixun, "jiankangzixun")); 
        return R.ok().put("data", jiankangzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangzixunEntity jiankangzixun){
        EntityWrapper< JiankangzixunEntity> ew = new EntityWrapper< JiankangzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangzixun, "jiankangzixun")); 
		JiankangzixunView jiankangzixunView =  jiankangzixunService.selectView(ew);
		return R.ok("查询健康资讯成功").put("data", jiankangzixunView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangzixunEntity jiankangzixun = jiankangzixunService.selectById(id);
        if(null==jiankangzixun.getClicknum()){
            jiankangzixun.setClicknum(0);
        }
		jiankangzixun.setClicknum(jiankangzixun.getClicknum()+1);
		jiankangzixun.setClicktime(new Date());
		jiankangzixunService.updateById(jiankangzixun);
        jiankangzixun = jiankangzixunService.selectView(new EntityWrapper<JiankangzixunEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangzixun,deSens);
        return R.ok().put("data", jiankangzixun);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangzixunEntity jiankangzixun = jiankangzixunService.selectById(id);
        if(null==jiankangzixun.getClicknum()){
            jiankangzixun.setClicknum(0);
        }
		jiankangzixun.setClicknum(jiankangzixun.getClicknum()+1);
		jiankangzixun.setClicktime(new Date());
		jiankangzixunService.updateById(jiankangzixun);
        jiankangzixun = jiankangzixunService.selectView(new EntityWrapper<JiankangzixunEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangzixun,deSens);
        return R.ok().put("data", jiankangzixun);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangzixunEntity jiankangzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangzixun);
    	jiankangzixun.setUserid((Long)request.getSession().getAttribute("userId"));
        jiankangzixunService.insert(jiankangzixun);
        return R.ok().put("data",jiankangzixun.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangzixunEntity jiankangzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangzixun);
        jiankangzixunService.insert(jiankangzixun);
        return R.ok().put("data",jiankangzixun.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangzixunEntity jiankangzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangzixun);
        //全部更新
        jiankangzixunService.updateById(jiankangzixun);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangzixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiankangzixunEntity jiankangzixun, HttpServletRequest request,String pre){
        EntityWrapper<JiankangzixunEntity> ew = new EntityWrapper<JiankangzixunEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");

		PageUtils page = jiankangzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangzixun), params), params));
        return R.ok().put("data", page);
    }








}
