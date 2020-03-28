package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {

    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        final Optional<Submission> firstById_challengeIdOrderByScoreDesc = submissionRepository.findFirstById_ChallengeIdOrderByScoreDesc(challengeId);

        if (firstById_challengeIdOrderByScoreDesc.isPresent()) {
            return BigDecimal.valueOf(firstById_challengeIdOrderByScoreDesc.get().getScore());
        } return BigDecimal.ZERO;

    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return submissionRepository.save(object);
    }
}
