package com.challenge.entity.submission.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Submission {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @Column
    @NotNull
    private Float score;

    @CreatedDate
    @NotNull
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

}
