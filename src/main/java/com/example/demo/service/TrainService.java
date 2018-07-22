package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Train;
import com.example.demo.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	TrainRepository trainRepository;
	public Map<String, Object> insertTrainData(Train train){
		Map<String, Object> result = new HashMap<>();
		train = trainRepository.save(train);
		if(train != null) {
			result.put("train", train);
		}
		else {
			result.put("ResponseMessage", "error");
		}
		return result;
	}
	
	public Map<String, Object> getTrainList(String sourceStation, String destinationStation){
		Map<String, Object> result = new HashMap<>();
		List<Train>trainList=trainRepository.findByStations(sourceStation, destinationStation);
        if(trainList != null) {
        	result.put("trainList", trainList);
        }else {
        	result.put("message", "train not found");
        }
		return result;
	}
}
