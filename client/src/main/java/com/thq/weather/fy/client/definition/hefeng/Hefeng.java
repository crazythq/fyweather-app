package com.thq.weather.fy.client.definition.hefeng;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class Hefeng {

	@JsonProperty("HeWeather6")
	List<HeWeather6> list;

}
