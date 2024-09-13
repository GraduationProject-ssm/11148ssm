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

import com.entity.YongyaozhinanEntity;
import com.entity.view.YongyaozhinanView;

import com.service.YongyaozhinanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 用药指南
 * 后端接口
 * @author 
 * @email 
 * @date 2020-11-11 12:24:47
 */
@RestController
@RequestMapping("/yongyaozhinan")
public class YongyaozhinanController {
    @Autowired
    private YongyaozhinanService yongyaozhinanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YongyaozhinanEntity yongyaozhinan, HttpServletRequest request){

        EntityWrapper<YongyaozhinanEntity> ew = new EntityWrapper<YongyaozhinanEntity>();
    	PageUtils page = yongyaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yongyaozhinan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YongyaozhinanEntity yongyaozhinan, HttpServletRequest request){
        EntityWrapper<YongyaozhinanEntity> ew = new EntityWrapper<YongyaozhinanEntity>();
    	PageUtils page = yongyaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yongyaozhinan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YongyaozhinanEntity yongyaozhinan){
       	EntityWrapper<YongyaozhinanEntity> ew = new EntityWrapper<YongyaozhinanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yongyaozhinan, "yongyaozhinan")); 
        return R.ok().put("data", yongyaozhinanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YongyaozhinanEntity yongyaozhinan){
        EntityWrapper< YongyaozhinanEntity> ew = new EntityWrapper< YongyaozhinanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yongyaozhinan, "yongyaozhinan")); 
		YongyaozhinanView yongyaozhinanView =  yongyaozhinanService.selectView(ew);
		return R.ok("查询用药指南成功").put("data", yongyaozhinanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        YongyaozhinanEntity yongyaozhinan = yongyaozhinanService.selectById(id);
        return R.ok().put("data", yongyaozhinan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        YongyaozhinanEntity yongyaozhinan = yongyaozhinanService.selectById(id);
        return R.ok().put("data", yongyaozhinan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YongyaozhinanEntity yongyaozhinan = yongyaozhinanService.selectById(id);
        if(type.equals("1")) {
        	yongyaozhinan.setThumbsupnum(yongyaozhinan.getThumbsupnum()+1);
        } else {
        	yongyaozhinan.setCrazilynum(yongyaozhinan.getCrazilynum()+1);
        }
        yongyaozhinanService.updateById(yongyaozhinan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YongyaozhinanEntity yongyaozhinan, HttpServletRequest request){
    	yongyaozhinan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yongyaozhinan);

        yongyaozhinanService.insert(yongyaozhinan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YongyaozhinanEntity yongyaozhinan, HttpServletRequest request){
    	yongyaozhinan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yongyaozhinan);

        yongyaozhinanService.insert(yongyaozhinan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YongyaozhinanEntity yongyaozhinan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yongyaozhinan);
        yongyaozhinanService.updateById(yongyaozhinan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yongyaozhinanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YongyaozhinanEntity> wrapper = new EntityWrapper<YongyaozhinanEntity>();
		if(map.get("remindstart")!=null && !map.get("remindstart").toString().equals("")) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null && !map.get("remindend").toString().equals("")) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yongyaozhinanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
