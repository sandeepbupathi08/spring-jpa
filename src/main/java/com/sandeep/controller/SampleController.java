package com.sandeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.dto.SampleDTO;
import com.sandeep.model.Address;
import com.sandeep.model.User;
import com.sandeep.service.SampleService;

@RestController
public class SampleController {

	@Autowired
	private SampleService sampleService;
	@RequestMapping(path="/testService")
	public List<User> findAllUsers(){
		return sampleService.findAllUsers();
	}
	
	@RequestMapping(path="/testService2")
	public Page<Address> findAllAddress(@RequestParam("pageNbr") int page,@RequestParam("pgSize") int pageSize){
		return sampleService.findAllAddress(new PageRequest(page, pageSize));
	}
	
	/*@RequestMapping(path="/testService3")
	public Page<Address> findAllAddress2(@RequestParam("pageNbr") int page,@RequestParam("pgSize") int pageSize){
		return sampleService.findNative(new PageRequest(page, pageSize));
	}*/
	
	@RequestMapping(path="/testService4")
	public Page<SampleDTO> findAllAddress4(@RequestParam("pageNbr") int page,@RequestParam("pgSize") int pageSize){
		return sampleService.getCustomPage(new PageRequest(page, pageSize));
	}
}