package com.challenge.endpoints;
import com.challenge.entity.Company;
import com.challenge.exceptions.EntityNotFound;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Company>(companyService.findById(id)
                .orElseThrow(() -> new EntityNotFound("Company")), HttpStatus.OK);
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<List<Company>> findByAccelerationId(@RequestParam Long accelerationId){
        return new ResponseEntity<List<Company>>(companyService.findByAccelerationId(accelerationId), HttpStatus.OK);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<List<Company>> findByUserId(@RequestParam Long userId){
        return new ResponseEntity<List<Company>>(companyService.findByUserId(userId), HttpStatus.OK);
    }
}
