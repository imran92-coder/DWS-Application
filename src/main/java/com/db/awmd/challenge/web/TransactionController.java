package com.db.awmd.challenge.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.awmd.challenge.dto.TransferDto;
import com.db.awmd.challenge.service.TransactionService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bank")
@Slf4j
public class TransactionController {
	
	Logger log = LoggerFactory.getLogger(TransactionController.class);
    @Autowired
    private TransactionService transactionService;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "transaction done successfully"),
	    @ApiResponse(code = 4111, message = "account not registered with bank"),

	    @ApiResponse(code = 4333, message = "insufficient balence to transfer funds") })
    /**
     * this method provide function for a customer to transfer funds 
     * 
     * @param TransactionDto will provide account  information to transfer amount
     * @return ResponseEntity will give transfer status
     * 
     */
    @PutMapping(path = "/transfers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> transferAmount(@RequestBody @Valid TransferDto transferDto) {
	log.info("Transferring  account from Id {} to {}", transferDto.getAccountFromId(),
		transferDto.getAccountToId());
	return new ResponseEntity<>(transactionService.transferAmount(transferDto.getAccountToId(),
		transferDto.getAccountFromId(), transferDto.getAmount()), HttpStatus.OK);
    }
}
