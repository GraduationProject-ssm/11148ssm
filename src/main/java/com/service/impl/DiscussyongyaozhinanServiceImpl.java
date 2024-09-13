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


import com.dao.DiscussyongyaozhinanDao;
import com.entity.DiscussyongyaozhinanEntity;
import com.service.DiscussyongyaozhinanService;
import com.entity.vo.DiscussyongyaozhinanVO;
import com.entity.view.DiscussyongyaozhinanView;

@Service("discussyongyaozhinanService")
public class DiscussyongyaozhinanServiceImpl extends ServiceImpl<DiscussyongyaozhinanDao, DiscussyongyaozhinanEntity> implements DiscussyongyaozhinanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyongyaozhinanEntity> page = this.selectPage(
                new Query<DiscussyongyaozhinanEntity>(params).getPage(),
                new EntityWrapper<DiscussyongyaozhinanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyongyaozhinanEntity> wrapper) {
		  Page<DiscussyongyaozhinanView> page =new Query<DiscussyongyaozhinanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyongyaozhinanVO> selectListVO(Wrapper<DiscussyongyaozhinanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyongyaozhinanVO selectVO(Wrapper<DiscussyongyaozhinanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyongyaozhinanView> selectListView(Wrapper<DiscussyongyaozhinanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyongyaozhinanView selectView(Wrapper<DiscussyongyaozhinanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
