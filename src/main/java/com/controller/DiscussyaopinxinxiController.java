package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussyaopinxinxiEntity;
import com.entity.view.DiscussyaopinxinxiView;

import com.service.DiscussyaopinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 药品信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2020-11-11 12:24:48
 */
@RestController
@RequestMapping("/discussyaopinxinxi")
public class DiscussyaopinxinxiController {
    @Autowired
    private DiscussyaopinxinxiService discussyaopinxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyaopinxinxiEntity discussyaopinxinxi, HttpServletRequest request){

        EntityWrapper<DiscussyaopinxinxiEntity> ew = new EntityWrapper<DiscussyaopinxinxiEntity>();
    	PageUtils page = discussyaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyaopinxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyaopinxinxiEntity discussyaopinxinxi, HttpServletRequest request){
        EntityWrapper<DiscussyaopinxinxiEntity> ew = new EntityWrapper<DiscussyaopinxinxiEntity>();
    	PageUtils page = discussyaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyaopinxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyaopinxinxiEntity discussyaopinxinxi){
       	EntityWrapper<DiscussyaopinxinxiEntity> ew = new EntityWrapper<DiscussyaopinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyaopinxinxi, "discussyaopinxinxi")); 
        return R.ok().put("data", discussyaopinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyaopinxinxiEntity discussyaopinxinxi){
        EntityWrapper< DiscussyaopinxinxiEntity> ew = new EntityWrapper< DiscussyaopinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyaopinxinxi, "discussyaopinxinxi")); 
		DiscussyaopinxinxiView discussyaopinxinxiView =  discussyaopinxinxiService.selectView(ew);
		return R.ok("查询药品信息评论表成功").put("data", discussyaopinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyaopinxinxiEntity discussyaopinxinxi = discussyaopinxinxiService.selectById(id);
        return R.ok().put("data", discussyaopinxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyaopinxinxiEntity discussyaopinxinxi = discussyaopinxinxiService.selectById(id);
        return R.ok().put("data", discussyaopinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyaopinxinxiEntity discussyaopinxinxi, HttpServletRequest request){
    	discussyaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyaopinxinxi);

        discussyaopinxinxiService.insert(discussyaopinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyaopinxinxiEntity discussyaopinxinxi, HttpServletRequest request){
    	discussyaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyaopinxinxi);

        discussyaopinxinxiService.insert(discussyaopinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussyaopinxinxiEntity discussyaopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyaopinxinxi);
        discussyaopinxinxiService.updateById(discussyaopinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyaopinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null && !map.get("remindstart").toString().equals("")) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null && !map.get("remindend").toString().equals("")) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussyaopinxinxiEntity> wrapper = new EntityWrapper<DiscussyaopinxinxiEntity>();
		if(map.get("remindstart")!=null && !map.get("remindstart").toString().equals("")) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null && !map.get("remindend").toString().equals("")) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussyaopinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
