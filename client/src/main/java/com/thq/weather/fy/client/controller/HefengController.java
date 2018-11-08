package com.thq.weather.fy.client.controller;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.thq.weather.fy.client.definition.Constants;
import com.thq.weather.fy.client.definition.hefeng.HeWeather6;
import com.thq.weather.fy.client.definition.hefeng.Hefeng;
import com.thq.weather.fy.client.service.CaiyunWeatherAPI;
import com.thq.weather.fy.client.service.HefengWeatherAPI;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HefengController {

	public static void main2(String[] args) {
		String longitude = "113.5767";
		String latitude = "22.2707";
		String url = String.format("https://search.heweather.com/top?group=cn&key=%s", Constants.HEFENG_KEY);
		System.out.println(url);
		HefengWeatherAPI api = Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.options(new Request.Options(1000, 3500))
				.retryer(new Retryer.Default(5000, 5000, 3))
				.target(HefengWeatherAPI.class, url);
		Hefeng hefeng = api.forecast();
		System.out.println(hefeng);
	}

	public static void main(String[] args) {
		// String str = "{\"HeWeather6\":[{\"basic\":[{\"cid\":\"CN101010100\",\"location\":\"北京\",\"parent_city\":\"北京\",\"admin_area\":\"北京\",\"cnty\":\"中国\",\"lat\":\"39.90498734\",\"lon\":\"116.4052887\",\"tz\":\"+8.00\",\"type\":\"city\"}]}]}";
		String str = "{\"HeWeather6\":[{\"basic\":[{\"cid\":\"CN101010100\",\"location\":\"北京\",\"parent_city\":\"北京\",\"admin_area\":\"北京\",\"cnty\":\"中国\",\"lat\":\"39.90498734\",\"lon\":\"116.4052887\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101020100\",\"location\":\"上海\",\"parent_city\":\"上海\",\"admin_area\":\"上海\",\"cnty\":\"中国\",\"lat\":\"31.23170662\",\"lon\":\"121.47264099\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101210101\",\"location\":\"杭州\",\"parent_city\":\"杭州\",\"admin_area\":\"浙江\",\"cnty\":\"中国\",\"lat\":\"30.28745842\",\"lon\":\"120.15357971\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101280101\",\"location\":\"广州\",\"parent_city\":\"广州\",\"admin_area\":\"广东\",\"cnty\":\"中国\",\"lat\":\"23.12517738\",\"lon\":\"113.28063965\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101280601\",\"location\":\"深圳\",\"parent_city\":\"深圳\",\"admin_area\":\"广东\",\"cnty\":\"中国\",\"lat\":\"22.54700089\",\"lon\":\"114.08594513\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101210701\",\"location\":\"温州\",\"parent_city\":\"温州\",\"admin_area\":\"浙江\",\"cnty\":\"中国\",\"lat\":\"28.00057411\",\"lon\":\"120.67211151\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101190101\",\"location\":\"南京\",\"parent_city\":\"南京\",\"admin_area\":\"江苏\",\"cnty\":\"中国\",\"lat\":\"32.04154587\",\"lon\":\"118.76741028\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101200101\",\"location\":\"武汉\",\"parent_city\":\"武汉\",\"admin_area\":\"湖北\",\"cnty\":\"中国\",\"lat\":\"30.5843544\",\"lon\":\"114.29856873\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101030100\",\"location\":\"天津\",\"parent_city\":\"天津\",\"admin_area\":\"天津\",\"cnty\":\"中国\",\"lat\":\"39.12559509\",\"lon\":\"117.19018555\",\"tz\":\"+8.00\",\"type\":\"city\"},{\"cid\":\"CN101190401\",\"location\":\"苏州\",\"parent_city\":\"苏州\",\"admin_area\":\"江苏\",\"cnty\":\"中国\",\"lat\":\"31.29937935\",\"lon\":\"120.61958313\",\"tz\":\"+8.00\",\"type\":\"city\"}],\"status\":\"ok\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Hefeng hefeng = mapper.readValue(str, Hefeng.class);
			System.out.println(hefeng);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
