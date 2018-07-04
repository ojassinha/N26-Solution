package com.n26.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.api.models.AddTransactionRequestModel;
import com.n26.api.models.StatisticsModel;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
	
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}
	
	/*
	 * this is the minimal block of test code
	 */
	@Test
	public void canGiveOKStatus(){
		
		ResponseEntity<StatisticsModel> response = restTemplate.getForEntity("/statistics", StatisticsModel.class);
		
		//then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	/*
	 * Tests for incorrect and old epoch 
	 * Success
	 */
	@Test
	public void canValidateInCorrectEpoch(){
		ResponseEntity<?> response = restTemplate.postForEntity("/transactions",
				new AddTransactionRequestModel(20.0,1530699647000l)
				,AddTransactionRequestModel.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}

}
