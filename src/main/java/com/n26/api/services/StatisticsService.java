package com.n26.api.services;

import com.n26.api.exceptions.InvalidEpochException;
import com.n26.api.models.AddTransactionRequestModel;
import com.n26.api.models.StatisticsModel;

public interface StatisticsService {
	
	public boolean addTransaction(AddTransactionRequestModel addTxnRequestModel) throws InvalidEpochException;
	
	public boolean isValidTransaction(AddTransactionRequestModel addTxnRequestModel);
	
	public StatisticsModel getCurrentStatistics();

}
