package com.challenge.entity.candidate.model;

import com.challenge.entity.aceleration.model.Acceleration;
import com.challenge.entity.company.model.Company;
import com.challenge.entity.user.model.User;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class CandidateEntity {

    @ManyToOne
    @NotNull
    @JoinColumn(name = "acceleration_id", nullable = false)
    private Acceleration accelerations;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "company_id", nullable = false)
    private Company companies;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", nullable = false)
    private User users;
}
