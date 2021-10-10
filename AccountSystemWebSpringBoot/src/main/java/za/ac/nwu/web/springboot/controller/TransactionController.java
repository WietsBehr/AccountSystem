package za.ac.nwu.web.springboot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.TransactionDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateTransactionFlow;
import za.ac.nwu.logic.flow.FetchTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final FetchTransactionFlow fetchTransactionFlow;
    private final CreateTransactionFlow createTransactionFlow;

    @Autowired
    public TransactionController(FetchTransactionFlow fetchTransactionFlow, CreateTransactionFlow createTransactionFlow) {
        this.fetchTransactionFlow = fetchTransactionFlow;
        this.createTransactionFlow = createTransactionFlow;
    }

    @GetMapping("getAll")
    @ApiOperation(value = "Gets all transactions", notes = "Returns the transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Balance value today returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<TransactionDto>>> getAll() {
        List<TransactionDto> transactions = fetchTransactionFlow.getAllTransactions();
        GeneralResponse<List<TransactionDto>> response = new GeneralResponse<>(true, transactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/createTransaction")
    @ApiOperation(value = "Creates a new transaction", notes = "Adds a new transaction to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The transaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<TransactionDto>> create(
            @ApiParam(value = "Request body to create new member", required = true)
            @RequestBody TransactionDto transactionDto){
        TransactionDto transactionResponse = createTransactionFlow.createT(transactionDto);
        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
