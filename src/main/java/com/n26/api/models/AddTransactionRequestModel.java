package com.n26.api.models;

public class AddTransactionRequestModel {
	
	private double amount;
	
	private long timestamp;
	
	public AddTransactionRequestModel() {
	}

	public AddTransactionRequestModel(double amount, long timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "AddTransactionRequestModel [amount=" + amount + ", timestamp=" + timestamp + "]";
	}
	
	

}
