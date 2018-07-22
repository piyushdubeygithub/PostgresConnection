package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Train;
import com.example.demo.service.TrainService;

@RestController
public class TrainController {
    @Autowired
	TrainService trainService;
	@RequestMapping(value="api/v1/insertTrainData", method = RequestMethod.POST)
	public Map<String, Object> insertTrainData(@RequestBody Train train){
		Map<String, Object> result = new HashMap<>();
		result = trainService.insertTrainData(train);
		return result;
	}
	
	@RequestMapping(value= "api/v1/getTrainList", method = RequestMethod.GET)
	public Map<String, Object> getTrainList(@RequestParam String sourceStation, @RequestParam String destinationStation){
		Map<String, Object> result = new HashMap<>();
		result = trainService.getTrainList(sourceStation, destinationStation);
		return result;
	}
}
