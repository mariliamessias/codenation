package com.challenge.entity.challenge.model;

import com.challenge.entity.aceleration.model.Acceleration;
import com.challenge.entity.submission.model.Submission;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String slug;

    @CreatedDate
    @NotNull
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "submissionId.challenge", cascade = CascadeType.ALL)
    private Set<Submission> submissions;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private Set<Acceleration> accelerations;

}
