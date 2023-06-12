package com.HelmerK.TaxRateAPI.controller;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HelmerK.TaxRateAPI.DTO.CanadaTaxRateDTO;
import com.HelmerK.TaxRateAPI.entity.CanadaTaxRate;
import com.HelmerK.TaxRateAPI.entity.UsTaxRate;
import com.HelmerK.TaxRateAPI.service.CanService;
import com.HelmerK.TaxRateAPI.service.UsService;

@RestController
@RequestMapping("/taxapi")
public class TaxRateController {
	
	@Autowired
	private CanService canSer;
    @Autowired
	private UsService usSer;


	// Canada
	@GetMapping("/canrate/{locationCode}")
	public CanadaTaxRateDTO getCan(@PathVariable String locationCode) {

		return canSer.getCan(locationCode);

	}

	@PostMapping("/canrate")
	public void postCan(@PathVariable CanadaTaxRate rate) {

//		canSer.insertCan(rate);

	}

	@PutMapping("/canrate/{id}")
	public void putCan(@PathVariable CanadaTaxRate rate) {

//		canSer.updateCan(rate);

	}

	@DeleteMapping("/canrate/{id}")
	public void deleteCan(@PathVariable CanadaTaxRate rate) {

		canSer.deleteCan(rate);

	}

	// USA
	@GetMapping("/usrate/{id}")
	public UsTaxRate getUs(@PathVariable String locationCode) {

		return usSer.getUs(locationCode);

	}

	@PostMapping("/usrate")
	public void postUs(@PathVariable UsTaxRate rate) {

//		usSer.insertUs(rate);

	}

	@PutMapping("/usrate/{id}")
	public void putUs(@PathVariable UsTaxRate rate) {

//		usSer.updateUs(rate);

	}

	@DeleteMapping("/usrate/{id}")
	public void deleteUs(@PathVariable UsTaxRate rate) {

		usSer.deleteUs(rate);

	}

}
