package com.dao;

import com.entity.YongyaozhinanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YongyaozhinanVO;
import com.entity.view.YongyaozhinanView;


/**
 * 用药指南
 * 
 * @author 
 * @email 
 * @date 2020-11-11 12:24:47
 */
public interface YongyaozhinanDao extends BaseMapper<YongyaozhinanEntity> {
	
	List<YongyaozhinanVO> selectListVO(@Param("ew") Wrapper<YongyaozhinanEntity> wrapper);
	
	YongyaozhinanVO selectVO(@Param("ew") Wrapper<YongyaozhinanEntity> wrapper);
	
	List<YongyaozhinanView> selectListView(@Param("ew") Wrapper<YongyaozhinanEntity> wrapper);

	List<YongyaozhinanView> selectListView(Pagination page,@Param("ew") Wrapper<YongyaozhinanEntity> wrapper);
	
	YongyaozhinanView selectView(@Param("ew") Wrapper<YongyaozhinanEntity> wrapper);
	
}
