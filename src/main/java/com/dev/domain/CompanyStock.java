package com.dev.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Document(collection = "CompanyStock")
public class CompanyStock {

	private String companyName;
	private String stockCode;
	private String price;
}
