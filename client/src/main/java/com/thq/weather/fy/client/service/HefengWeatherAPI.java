package com.thq.weather.fy.client.service;

import com.thq.weather.fy.client.definition.caiyun.Caiyun;
import com.thq.weather.fy.client.definition.hefeng.Hefeng;
import feign.Headers;
import feign.RequestLine;

public interface HefengWeatherAPI {
	@Headers({"Content-Type: application/json","Accept: application/json"})
	@RequestLine("GET /")
	Hefeng forecast();
}
