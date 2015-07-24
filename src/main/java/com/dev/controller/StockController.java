package com.dev.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class StockController {

	@Autowired
	private StockService service;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveOwnership(@RequestParam String companyList) {
		List<String> companies = new ArrayList<String>(
				Arrays.asList(companyList.split(",")));
		String stockPrice;
		try {
			stockPrice = service.getStockPrice(companies);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>(stockPrice, HttpStatus.OK);
	}

	@RequestMapping(value = "/save-company-details", method = RequestMethod.POST)
	public ResponseEntity<?> saveCompanyDetails() {
		log.info("Saving company details at {}", new Date());
		service.saveCompanyDetails(null);
		return new ResponseEntity<String>("Company details saved for : ",
				HttpStatus.OK);
	}

}
