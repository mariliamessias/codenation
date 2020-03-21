package com.challenge.entity.user.model;

import com.challenge.entity.candidate.model.Candidate;
import com.challenge.entity.submission.model.Submission;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    @NotBlank
    @Column(nullable = false, length = 100)
    private String fullName;

    @Size(max = 100)
    @NotNull
    @NotBlank
    @Column(nullable = false, length = 100)
    @Email
    private String email;

    @Size(max = 50)
    @NotNull
    @NotBlank
    @Column(nullable = false, length = 50)
    private String nickname;

    @Size(max = 255)
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String password;

    @CreatedDate
    @NotNull
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "candidateId.user", cascade = CascadeType.ALL)
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "submissionId.user", cascade = CascadeType.ALL)
    private List<Submission> submissions;

}
