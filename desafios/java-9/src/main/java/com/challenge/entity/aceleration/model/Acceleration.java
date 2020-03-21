package com.challenge.entity.aceleration.model;

import com.challenge.entity.candidate.model.Candidate;
import com.challenge.entity.challenge.model.Challenge;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

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

    @ManyToOne
    @NotNull
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenges;

    @CreatedDate
    @NotNull
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "candidateId.acceleration", cascade = CascadeType.ALL)
    private List<Candidate> candidates;

}
