package com.n26.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.api.exceptions.InvalidEpochException;
import com.n26.api.models.AddTransactionRequestModel;
import com.n26.api.models.StatisticsModel;
import com.n26.api.repositories.TransactionRepository;
import com.n26.api.utils.DateUtils;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private TransactionRepository repository;

	@Override
	public synchronized boolean addTransaction(AddTransactionRequestModel addTxnRequestModel)
			throws InvalidEpochException {

		if(addTxnRequestModel == null){
			throw new InvalidEpochException();
		}
		
		if (isValidTransaction(addTxnRequestModel)) {
			repository.addTransactionData(addTxnRequestModel);
			return true;
		} else {
			throw new InvalidEpochException();
		}

	}

	@Override
	public boolean isValidTransaction(AddTransactionRequestModel addTxnRequestModel) {
		
		if(DateUtils.dateIsOlderThanSixtySeconds(addTxnRequestModel.getTimestamp())){
			return false;
		}
		
		return true;
	}

	@Override
	public synchronized StatisticsModel getCurrentStatistics() {
		return repository.getTransactionDataForSixtySeconds();
	}

}
