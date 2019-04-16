package com.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Country;
import com.hcl.repo.CountryDao;
//comment
@RestController
public class MainController {
	@Autowired
	CountryDao dao;

	@RequestMapping("/save")
	public String  saveCountry(Country c) {
		c.setId(1);
		c.setName("anu");
		c.setCode("india");
		dao.save(c);
		return "String saved successfully";
	}
	@RequestMapping("/list")
	public List<Country>  list() {
		List<Country> country = (List<Country>) dao.findAll();
		return country;
	}
	@RequestMapping("/fetch/{id}")
	public List<Country>  fetchbyid(@PathVariable int id) {
		List<Country> country =  dao.findById(id);
		return country;
	}
	@RequestMapping("/name/{name}")
	public List<Country>  fetchbyname(@PathVariable String name) {
		List<Country> country =  dao.findByName(name);
		return country;
	}
	@RequestMapping("/{id}")
	public List<Country>  fetchbyidgreaterthan(@PathVariable int id) {
		List<Country> country =  dao.findByIdGreaterThan(id);
		return country;
	}
/*	@RequestMapping("/find/{code}/{name}")
	public List<Country> findcodeandname(@PathVariable String code,@PathVariable String name){
		List<Country> country =  dao.findByCodeAndName(code,name);
		return country;
		
	}*/
	@RequestMapping("/find")
	public List<Country> findrequest(@RequestParam String code,@RequestParam String name){
		List<Country> country =  dao.findByCodeAndName(code,name);
		return country;
		
	}
}
