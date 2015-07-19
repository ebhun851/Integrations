package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.domain.CompanyStock;
import com.dev.repo.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;
	
	public void saveCompanyDetails(CompanyStock company){
		
		CompanyStock companyStock = new CompanyStock();
		companyStock.setCompanyName("IBM");
		companyStock.setStockCode("IM");
		companyStock.setPrice("$44");
		repository.save(companyStock);
		
		companyStock.setCompanyName("NISUM");
		companyStock.setStockCode("NS");
		companyStock.setPrice("$20");
		repository.save(companyStock);
	}
	
	
	public String getStockPrice(List<String> companies) throws Exception {
		String stockPrice = "";

		List<CompanyStock> companyList = repository.findByCompanyName(companies);

		if (companyList.size() > 0) {
			stockPrice =companyList.get(0).getStockCode()+" : " +companyList.get(0).getPrice()
					+ " , " + companyList.get(1).getStockCode()+" : " +companyList.get(1).getPrice();
		} else {
			throw new Exception("Invalid company");
		}
		
		return stockPrice;
	}
}
