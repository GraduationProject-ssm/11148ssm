package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YongyaozhinanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YongyaozhinanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YongyaozhinanView;


/**
 * 用药指南
 *
 * @author 
 * @email 
 * @date 2020-11-11 12:24:47
 */
public interface YongyaozhinanService extends IService<YongyaozhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YongyaozhinanVO> selectListVO(Wrapper<YongyaozhinanEntity> wrapper);
   	
   	YongyaozhinanVO selectVO(@Param("ew") Wrapper<YongyaozhinanEntity> wrapper);
   	
   	List<YongyaozhinanView> selectListView(Wrapper<YongyaozhinanEntity> wrapper);
   	
   	YongyaozhinanView selectView(@Param("ew") Wrapper<YongyaozhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YongyaozhinanEntity> wrapper);
   	
}

