package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YongyaozhinanDao;
import com.entity.YongyaozhinanEntity;
import com.service.YongyaozhinanService;
import com.entity.vo.YongyaozhinanVO;
import com.entity.view.YongyaozhinanView;

@Service("yongyaozhinanService")
public class YongyaozhinanServiceImpl extends ServiceImpl<YongyaozhinanDao, YongyaozhinanEntity> implements YongyaozhinanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YongyaozhinanEntity> page = this.selectPage(
                new Query<YongyaozhinanEntity>(params).getPage(),
                new EntityWrapper<YongyaozhinanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YongyaozhinanEntity> wrapper) {
		  Page<YongyaozhinanView> page =new Query<YongyaozhinanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YongyaozhinanVO> selectListVO(Wrapper<YongyaozhinanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YongyaozhinanVO selectVO(Wrapper<YongyaozhinanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YongyaozhinanView> selectListView(Wrapper<YongyaozhinanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YongyaozhinanView selectView(Wrapper<YongyaozhinanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
