package za.ac.nwu.web.springboot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateBalanceFlow;
import za.ac.nwu.logic.flow.FetchBalanceFlow;

import java.util.List;

@RestController
@RequestMapping("balance")
public class BalanceController {

    private final FetchBalanceFlow fetchBalanceFlow;
    private final CreateBalanceFlow createBalanceFlow;

    @Autowired
    public BalanceController(FetchBalanceFlow fetchBalanceFlow, CreateBalanceFlow createBalanceFlow){
        this.fetchBalanceFlow = fetchBalanceFlow;
        this.createBalanceFlow = createBalanceFlow;
    }

    @PostMapping("/createEntry")
    @ApiOperation(value = "Creates a new client", notes = "Adds a new client to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The client's balance was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<BalanceDto>> create(
            @ApiParam(value = "Request body to create new member", required = true)
            @RequestBody BalanceDto balanceDto){
        BalanceDto balanceResponse = createBalanceFlow.create(balanceDto);
        GeneralResponse<BalanceDto> response = new GeneralResponse<>(true, balanceResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    @ApiOperation(value = "Gets all the balances of today", notes = "Returns a list of balances")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Balance value today returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<BalanceDto>>> getAll(){
        List<BalanceDto> balances = fetchBalanceFlow.getAllBalances();
        GeneralResponse<List<BalanceDto>> response = new GeneralResponse<>(true, balances);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
