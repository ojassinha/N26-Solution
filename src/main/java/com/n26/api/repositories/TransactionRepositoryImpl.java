package com.n26.api.repositories;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import com.n26.api.models.AddTransactionRequestModel;
import com.n26.api.models.StatisticsModel;
import com.n26.api.utils.DateUtils;

@Repository
@ApplicationScope
public class TransactionRepositoryImpl implements TransactionRepository {

	private static final Logger logger = LogManager.getLogger(TransactionRepositoryImpl.class);

	final static List<AddTransactionRequestModel> list = new CopyOnWriteArrayList<AddTransactionRequestModel>();

	static StatisticsModel model = new StatisticsModel(0, 0, 0, 0, 0);

	/*
	 * Adds the new data to the transaction collections and then calculates the 
	 * statistics based on the last 60 sec of data
	 */
	@Override
	public void addTransactionData(AddTransactionRequestModel addTxnRequestModel) {
		
		addDataIntoStats(addTxnRequestModel);
		newStreamUpdate();
	}
	
	/*
	 * Gets the latest statistics data from the pool after refreshing it 
	 * for the last 60 sec
	 */
	@Override
	public StatisticsModel getTransactionDataForSixtySeconds() {
		newStreamUpdate();
		return model;
	}
	
	private static void addDataIntoStats(AddTransactionRequestModel addTxnRequestModel){
		list.add(addTxnRequestModel);
	}
	
	/*
	 * Refreshes the statistics data based on stream
	 */
	private static void newStreamUpdate(){
		
		DoubleSummaryStatistics doubleStats = list.stream()
				.filter(s -> !DateUtils.dateIsOlderThanSixtySeconds(s.getTimestamp()))
				.collect(Collectors.toList())
				.stream()
				.collect(Collectors
				.summarizingDouble(p -> p.getAmount()));
		
		model = new StatisticsModel(doubleStats.getSum(),
				doubleStats.getAverage(),
				doubleStats.getMin(),
				doubleStats.getMax(), 
				doubleStats.getCount());
		
		logger.info(model.toString());
	}

}
