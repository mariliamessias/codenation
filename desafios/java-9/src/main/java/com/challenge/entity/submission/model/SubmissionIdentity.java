package com.challenge.entity.submission.model;

import com.challenge.entity.challenge.model.Challenge;
import com.challenge.entity.user.model.User;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class SubmissionIdentity {

    @ManyToOne
    @NotNull
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenges;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", nullable = false)
    private User users;
}
