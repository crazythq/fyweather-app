package com.thq.weather.fy.client.controller;

import com.thq.weather.fy.client.definition.Constants;
import com.thq.weather.fy.client.definition.caiyun.Caiyun;
import com.thq.weather.fy.client.service.CaiyunWeatherAPI;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;

public class CaiyunController {

	public static void main(String[] args) {
		String longitude = "113.5767";
		String latitude = "22.2707";
		String url = String.format("https://api.caiyunapp.com/v2/%s/%s,%s", Constants.CAIYUN_KEY, longitude, latitude);
		CaiyunWeatherAPI api = Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.options(new Request.Options(1000, 3500))
				.retryer(new Retryer.Default(5000, 5000, 3))
				.target(CaiyunWeatherAPI.class, url);
		Caiyun caiyun = api.forecast();
		System.out.println(caiyun);
	}
}
