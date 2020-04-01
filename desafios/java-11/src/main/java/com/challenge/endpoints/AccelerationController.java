package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.exceptions.EntityNotFound;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    AccelerationService accelerationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Acceleration>(accelerationService.findById(id)
                .orElseThrow(()-> new EntityNotFound("Acceleration")), HttpStatus.OK);
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<List<Acceleration>> findByCompanyId(@RequestParam Long companyId){
        return new ResponseEntity<List<Acceleration>>( accelerationService.findByCompanyId(companyId), HttpStatus.OK);
    }

}
