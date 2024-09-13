package com.dao;

import com.entity.DiscussyongyaozhinanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyongyaozhinanVO;
import com.entity.view.DiscussyongyaozhinanView;


/**
 * 用药指南评论表
 * 
 * @author 
 * @email 
 * @date 2020-11-11 12:24:48
 */
public interface DiscussyongyaozhinanDao extends BaseMapper<DiscussyongyaozhinanEntity> {
	
	List<DiscussyongyaozhinanVO> selectListVO(@Param("ew") Wrapper<DiscussyongyaozhinanEntity> wrapper);
	
	DiscussyongyaozhinanVO selectVO(@Param("ew") Wrapper<DiscussyongyaozhinanEntity> wrapper);
	
	List<DiscussyongyaozhinanView> selectListView(@Param("ew") Wrapper<DiscussyongyaozhinanEntity> wrapper);

	List<DiscussyongyaozhinanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyongyaozhinanEntity> wrapper);
	
	DiscussyongyaozhinanView selectView(@Param("ew") Wrapper<DiscussyongyaozhinanEntity> wrapper);
	
}
