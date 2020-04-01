package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.exceptions.EntityNotFound;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @Autowired
    CandidateMapper candidateMapper;

    @GetMapping(value = "/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findById(
            @PathVariable("userId") Long userId,
            @PathVariable("companyId") Long companyId,
            @PathVariable("accelerationId") Long accelerationId) {
        return new ResponseEntity<CandidateDTO>(candidateMapper.map(candidateService.findById(userId, companyId, accelerationId)
                .orElseThrow(() -> new EntityNotFound("Candidate"))),HttpStatus.OK);
    }

    @GetMapping(params = "companyId" )
    public ResponseEntity<List<CandidateDTO>> findByCandidateId(@RequestParam Long companyId){
        return new ResponseEntity<List<CandidateDTO>>(candidateMapper.map(candidateService.findByCompanyId(companyId)), HttpStatus.OK);
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<List<CandidateDTO>> findByAccelerationId(@RequestParam Long accelerationId){
        return new ResponseEntity<List<CandidateDTO>>(candidateMapper.map(candidateService.findByAccelerationId(accelerationId)), HttpStatus.OK);
    }

}