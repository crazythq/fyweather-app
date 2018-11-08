package com.thq.weather.fy.client.definition.hefeng;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CityBasic {
	private String location; // 地区／城市名称
	private String cid; // 地区／城市ID
	private String lat; // 地区／城市纬度
	private String lon; // 地区／城市经度
	@JsonProperty("parent_city")
	private String parentCity; // 该地区／城市的上级城市
	@JsonProperty("admin_area")
	private String adminArea; // 该地区／城市所属行政区域
	private String cnty; // 该地区／城市所属国家名称
	private String tz; // 该地区／城市所在时区
	private String type; // 该地区／城市的属性，目前有city城市和scenic中国景点
}
