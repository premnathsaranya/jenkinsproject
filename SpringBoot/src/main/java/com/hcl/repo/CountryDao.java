package com.hcl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.model.Country;

public interface CountryDao extends CrudRepository<Country, Integer> {

	List<Country> findById(int id);

	List<Country> findByName(String name);

	List<Country> findByIdGreaterThan(int id);

	//@Query(value="SELECT t FROM Country t where t.code=?1 AND t.name=?2")
	@Query(value="SELECT t FROM Country t where t.code=:code AND t.name=:name")
	List<Country> findByCodeAndName(@Param("code") String code,@Param("name") String name);

}
