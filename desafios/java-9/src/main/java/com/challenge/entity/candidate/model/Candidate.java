package com.challenge.entity.candidate.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Candidate {

    @EmbeddedId
    private CandidateEntity candidateEntity;

    @Column
    @NotNull
    private Integer status;

    @CreatedDate
    @NotNull
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

}
