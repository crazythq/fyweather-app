package com.thq.weather.fy.client.definition.caiyun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Caiyun {

	String status;// ok
	@JsonProperty("server_time")
	String serverTime;
	@JsonProperty("api_version")
	String apiVersion;
	String unit;
	List<String> location;
	Map<String, Object> result;

}
