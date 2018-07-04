package com.n26.api.repositories;

import com.n26.api.models.AddTransactionRequestModel;
import com.n26.api.models.StatisticsModel;

public interface TransactionRepository {

	public void addTransactionData(AddTransactionRequestModel addTxnRequestModel);
	
	public StatisticsModel getTransactionDataForSixtySeconds();
}
