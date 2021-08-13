package com.simplify.marketplace.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A SubjectMaster.
 */
@Entity
@Table(name = "subject_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class SubjectMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public SubjectMaster id(Long id) {
        this.id = id;
        return this;
    }

    public SubjectMaster subjectName(String subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    public SubjectMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public SubjectMaster createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public SubjectMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public SubjectMaster updatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
