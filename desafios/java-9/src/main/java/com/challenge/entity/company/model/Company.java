package com.challenge.entity.company.model;

import com.challenge.entity.candidate.model.Candidate;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(mappedBy = "candidateId.company", cascade = CascadeType.ALL)
    private List<Candidate> candidates;
}

