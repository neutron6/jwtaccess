package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer> saveData(@RequestBody Customer customer){
        log.info("####Saving data for CUSTOMER : "+ customer.getCustName());
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @GetMapping("/getdata")
    public ResponseEntity<List<Customer>> getAllData(){
        log.info("####List Size : "+ customerServiceImpl.getAllData().size());
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer> updateData(@PathVariable int custId, @RequestBody Customer customer){
        //
        //404

        return ResponseEntity.ok(customerServiceImpl.updateData(customer));
    }

    @DeleteMapping("/deletedata/{custId}")
    public ResponseEntity<String> deleteData(@PathVariable int custId){
        customerServiceImpl.deleteData(custId);

        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @GetMapping("/validateadmin/{adminId}/{adminPass}")
    public Boolean validateAdmin(@PathVariable int adminId,@PathVariable String adminPass){
        return customerServiceImpl.validateAdmin(adminId,adminPass);
    }
}
