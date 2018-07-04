package com.n26.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.api.exceptions.InvalidEpochException;
import com.n26.api.models.AddTransactionRequestModel;
import com.n26.api.models.StatisticsModel;
import com.n26.api.services.StatisticsService;

@RestController
public class StatisticsController {

	@Autowired
	private StatisticsService statsService;

	
	/*
	 * 201 gets returned when the addition is successful
	 * otherwise 204 from ExceptionHandler Advice
	 */
	@PostMapping(value = "/transactions")
	@ResponseBody
	public ResponseEntity<String> addTransaction(@RequestBody AddTransactionRequestModel addTxnModel)
			throws InvalidEpochException {

		statsService.addTransaction(addTxnModel);

		return new ResponseEntity<String>("", HttpStatus.CREATED);
	}
	
	/*
	 * 200 Response Code in case of successful Stats Calculation
	 * Get the last 60 seconds of statistics data
	 */
	@GetMapping(value = "/statistics")
	public ResponseEntity<StatisticsModel> getCurrentStatistics() {
		StatisticsModel responseModel = statsService.getCurrentStatistics();
		return new ResponseEntity<StatisticsModel>(responseModel, HttpStatus.OK);
	}

}
