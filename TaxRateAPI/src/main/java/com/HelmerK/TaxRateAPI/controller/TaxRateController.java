package com.HelmerK.TaxRateAPI.controller;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public void postCan(@RequestBody CanadaTaxRateDTO rateDTO) {

		canSer.insertCan(rateDTO);

	}

	@PutMapping("/canrate")
	public void putCan(@RequestBody CanadaTaxRateDTO rate) {

		canSer.updateCan(rate);

	}

	@DeleteMapping("/canrate/{locationCode}")
	public void deleteCan(@PathVariable String locationCode) {

		canSer.deleteCan(locationCode);

	}

	// USA
	@GetMapping("/usrate/{locationCode}")
	public UsTaxRate getUs(@PathVariable String locationCode) {

		return usSer.getUs(locationCode);

	}

	@PostMapping("/usrate")
	public void postUs(@RequestBody UsTaxRate rate) {

		usSer.insertUs(rate);

	}

	@PutMapping("/usrate/{id}")
	public void putUs(@RequestBody UsTaxRate rate) {

		usSer.updateUs(rate);

	}

	@DeleteMapping("/usrate/{locationCode}")
	public void deleteUs(@PathVariable String locationCode) {

		usSer.deleteUs(locationCode);

	}

}
