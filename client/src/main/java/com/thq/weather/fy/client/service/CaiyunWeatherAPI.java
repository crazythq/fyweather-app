package com.thq.weather.fy.client.service;

import com.thq.weather.fy.client.definition.caiyun.Caiyun;
import feign.Headers;
import feign.RequestLine;

public interface CaiyunWeatherAPI {
	@Headers({"Content-Type: application/json","Accept: application/json"})
	@RequestLine("GET /forecast")
	Caiyun forecast();
}
