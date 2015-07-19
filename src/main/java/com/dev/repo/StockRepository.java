package com.dev.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.domain.CompanyStock;


@Repository
public interface StockRepository extends CrudRepository<CompanyStock,String>{

	@Query("{'companyName' : {$in: ?0}}")
    public List<CompanyStock> findByCompanyName(final Collection<String> companyName);
}
