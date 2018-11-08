package com.thq.weather.fy.client.definition.hefeng;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HefengBasic {

	String location; //地区／城市名称
	String cid; //地区／城市ID
	String lat; //地区／城市纬度
	String lon; //地区／城市经度
	@JsonProperty("parent_city")
	String parentCity; //该地区／城市的上级城市
	@JsonProperty("admin_area")
	String adminArea; //该地区／城市所属行政区域
	String cnty; //该地区／城市所属国家名称
	String tz; //该地区／城市所在时区
}
