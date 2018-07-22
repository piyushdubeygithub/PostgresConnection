package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Train;

public interface TrainRepository extends JpaRepository<Train, Serializable> {

	@Query(value="select t.trainName from Train t where t.sourceStation=:sourceStation and t.destinationStation=:destinationStation")
	List<Train> findByStations(@Param(value="sourceStation") String sourceStation, @Param(value="destinationStation") String destinationStation);

	
}
