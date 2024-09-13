package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyongyaozhinanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyongyaozhinanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyongyaozhinanView;


/**
 * 用药指南评论表
 *
 * @author 
 * @email 
 * @date 2020-11-11 12:24:48
 */
public interface DiscussyongyaozhinanService extends IService<DiscussyongyaozhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyongyaozhinanVO> selectListVO(Wrapper<DiscussyongyaozhinanEntity> wrapper);
   	
   	DiscussyongyaozhinanVO selectVO(@Param("ew") Wrapper<DiscussyongyaozhinanEntity> wrapper);
   	
   	List<DiscussyongyaozhinanView> selectListView(Wrapper<DiscussyongyaozhinanEntity> wrapper);
   	
   	DiscussyongyaozhinanView selectView(@Param("ew") Wrapper<DiscussyongyaozhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyongyaozhinanEntity> wrapper);
   	
}

