package com.entity.vo;

import com.entity.YaopinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 药品信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-11-11 12:24:47
 */
public class YaopinxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 药品名称
	 */
	
	private String yaopinmingcheng;
		
	/**
	 * 药品类型
	 */
	
	private String yaopinleixing;
		
	/**
	 * 药品库存
	 */
	
	private Integer yaopinkucun;
		
	/**
	 * 药品图片
	 */
	
	private String yaopintupian;
		
	/**
	 * 适应症状
	 */
	
	private String shiyingzhengzhuang;
		
	/**
	 * 禁忌症状
	 */
	
	private String jinjizhengzhuang;
		
	/**
	 * 药品成分
	 */
	
	private String yaopinchengfen;
		
	/**
	 * 注意事项
	 */
	
	private String zhuyishixiang;
		
	/**
	 * 药品详情
	 */
	
	private String yaopinxiangqing;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 价格
	 */
	
	private Float price;
				
	
	/**
	 * 设置：药品名称
	 */
	 
	public void setYaopinmingcheng(String yaopinmingcheng) {
		this.yaopinmingcheng = yaopinmingcheng;
	}
	
	/**
	 * 获取：药品名称
	 */
	public String getYaopinmingcheng() {
		return yaopinmingcheng;
	}
				
	
	/**
	 * 设置：药品类型
	 */
	 
	public void setYaopinleixing(String yaopinleixing) {
		this.yaopinleixing = yaopinleixing;
	}
	
	/**
	 * 获取：药品类型
	 */
	public String getYaopinleixing() {
		return yaopinleixing;
	}
				
	
	/**
	 * 设置：药品库存
	 */
	 
	public void setYaopinkucun(Integer yaopinkucun) {
		this.yaopinkucun = yaopinkucun;
	}
	
	/**
	 * 获取：药品库存
	 */
	public Integer getYaopinkucun() {
		return yaopinkucun;
	}
				
	
	/**
	 * 设置：药品图片
	 */
	 
	public void setYaopintupian(String yaopintupian) {
		this.yaopintupian = yaopintupian;
	}
	
	/**
	 * 获取：药品图片
	 */
	public String getYaopintupian() {
		return yaopintupian;
	}
				
	
	/**
	 * 设置：适应症状
	 */
	 
	public void setShiyingzhengzhuang(String shiyingzhengzhuang) {
		this.shiyingzhengzhuang = shiyingzhengzhuang;
	}
	
	/**
	 * 获取：适应症状
	 */
	public String getShiyingzhengzhuang() {
		return shiyingzhengzhuang;
	}
				
	
	/**
	 * 设置：禁忌症状
	 */
	 
	public void setJinjizhengzhuang(String jinjizhengzhuang) {
		this.jinjizhengzhuang = jinjizhengzhuang;
	}
	
	/**
	 * 获取：禁忌症状
	 */
	public String getJinjizhengzhuang() {
		return jinjizhengzhuang;
	}
				
	
	/**
	 * 设置：药品成分
	 */
	 
	public void setYaopinchengfen(String yaopinchengfen) {
		this.yaopinchengfen = yaopinchengfen;
	}
	
	/**
	 * 获取：药品成分
	 */
	public String getYaopinchengfen() {
		return yaopinchengfen;
	}
				
	
	/**
	 * 设置：注意事项
	 */
	 
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
				
	
	/**
	 * 设置：药品详情
	 */
	 
	public void setYaopinxiangqing(String yaopinxiangqing) {
		this.yaopinxiangqing = yaopinxiangqing;
	}
	
	/**
	 * 获取：药品详情
	 */
	public String getYaopinxiangqing() {
		return yaopinxiangqing;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
			
}
