package com.thq.weather.fy.client.definition.hefeng;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HeWeather6 {

	private List<CityBasic> basic;
	// @JsonProperty("HeWeather6")
	// Map<String, Object> map;
	private String status;

}
