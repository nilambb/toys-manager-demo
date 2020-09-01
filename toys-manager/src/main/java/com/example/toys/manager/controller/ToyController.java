package com.example.toys.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.toys.manager.model.Toy;
import com.example.toys.manager.service.ToyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/toysManager")
@Api("Toys Manager Micro service for Demo")
public class ToyController {
	@Autowired
	private ToyService toyService;

	@ApiOperation(value = "get toys list", notes = "api to get the list of all the toys", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@GetMapping(value = "/v1")
	public ResponseEntity<Object> getAllToys() {
		return new ResponseEntity<>(toyService.getAllToys(), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "get store by id", notes = "api to get the the stores by id", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@GetMapping(value = "/v1/{toyId}")
	public ResponseEntity<Object> getStoreById(@ApiParam(required = true,
		      name = "toyId",
		      value = "Id of the toy you want to fetch") @PathVariable("toyId") final int toyId) {
		return new ResponseEntity<>(toyService.getToyById(toyId), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "create the toy", notes = "api to create the toy", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@PostMapping(value = "/v1")
	public ResponseEntity<Object> createStore(@ApiParam(required = true, name = "toy",
	          value = "New toy") @RequestBody final Toy toy) {
		return new ResponseEntity<>(toyService.create(toy), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "update the toy", notes = "api to update the toys by id", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@PutMapping(value = "/v1/{toyId}")
	public ResponseEntity<Object> getAllStores(@ApiParam(required = true, name = "toy",
	          value = "New Connection") @RequestBody final Toy toy,
			@ApiParam(required = true,
		      name = "toyId",
		      value = "Id of the store you want to fetch") @PathVariable("toyId") final int toyId) {
		try {
			return new ResponseEntity<>(toyService.updateToyById(toy, toyId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@ApiOperation(value = "delete toy by id", notes = "api to delete the the toy by id", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@DeleteMapping(value = "/v1/{toyId}")
	public ResponseEntity<Object> deleteStoreById(@ApiParam(required = true,
		      name = "toyId",
		      value = "Id of the toy you want to delete") @PathVariable("toyId") final int toyId) {
		toyService.delete(toyId);
		return new ResponseEntity<>("Toy deleted successfully.....", HttpStatus.OK);
	}
}
