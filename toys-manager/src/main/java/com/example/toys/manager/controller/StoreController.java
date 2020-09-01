package com.example.toys.manager.controller;

import java.util.Optional;

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

import com.example.toys.manager.model.Store;
import com.example.toys.manager.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/storeManager")
@Api("Store Manager Micro service for Demo")
public class StoreController {
	@Autowired
	private StoreService storeService;

	@ApiOperation(value = "get stores list", notes = "api to get the list of all the stores", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@GetMapping(value = "/v1")
	public ResponseEntity<Object> getAllStores() {
		return new ResponseEntity<>(storeService.getAllStores(), HttpStatus.OK);
	}

	@ApiOperation(value = "get store by id", notes = "api to get the the stores by id", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@GetMapping(value = "/v1/{storeId}")
	public ResponseEntity<Object> getStoreById(
			@ApiParam(required = true, name = "storeId", value = "Id of the store you want to fetch") @PathVariable("storeId") final int storeId) {
		return new ResponseEntity<>(storeService.getStoreById(storeId), HttpStatus.OK);
	}

	@ApiOperation(value = "create the store", notes = "api to create the store", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@PostMapping(value = "/v1")
	public ResponseEntity<Object> createStore(
			@ApiParam(required = true, name = "store", value = "New Connection") @RequestBody final Store store) {
		return new ResponseEntity<>(storeService.create(store), HttpStatus.OK);
	}

	@ApiOperation(value = "update the store", notes = "api to update the store by id", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@PutMapping(value = "/v1/{storeId}")
	public ResponseEntity<Object> getAllStores(
			@ApiParam(required = true, name = "store", value = "New Connection") @RequestBody final Store store,
			@ApiParam(required = true, name = "storeId", value = "Id of the store you want to fetch") @PathVariable("storeId") final int storeId) {

		try {
			return new ResponseEntity<>(storeService.updateStoreById(store, storeId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}

	}

	@ApiOperation(value = "delete store by id", notes = "api to delete the the stores by id", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = String.class) })
	@DeleteMapping(value = "/v1/{storeId}")
	public ResponseEntity<Object> deleteStoreById(
			@ApiParam(required = true, name = "storeId", value = "Id of the store you want to fetch") @PathVariable("storeId") final int storeId) {
		storeService.delete(storeId);
		return new ResponseEntity<>("Store deleted successfully.....", HttpStatus.OK);
	}

}
