package com.algodomain.controllers;

import com.algodomain.models.DTC;
import com.algodomain.models.Product;
import com.algodomain.repos.DTCRepo;
import com.algodomain.services.DTCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DTCController {
    @Autowired
    DTCService dtcService;

    //DTC = Discount Taxes and Charges Table

    //for getting list of DTCs
    @GetMapping("/getDTCs")
    public List<DTC> getDTC(){
        return dtcService.getAllDTC();
    }

    //for getting DTC by id
    @GetMapping("/getDTC/{id}")
    public DTC getDTCById(@PathVariable int id){
        return dtcService.getDTC(id);
    }

    //for adding DTC to table
    @PostMapping("/addDTC")
    public DTC addDTC(@RequestBody DTC dtc){
        return dtcService.addDTC(dtc);
    }


    //for updating DTC
    @PutMapping("/updateDTC")
    public DTC updateDTC(@RequestBody DTC dtc){
        return dtcService.updateDTC(dtc);
    }

    //for deleting DTC
    @DeleteMapping("/deleteDTC/{id}")
    public String deleteDTC(@PathVariable("id") int id){
        return dtcService.deleteDTC(id);
    }
}
