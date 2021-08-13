package com.simplify.marketplace.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A UserEmail.
 */
@Entity
@Table(name = "user_email")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class UserEmail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Column(name = "tag")
    private String tag;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = { "userEmails", "userPhones", "addresses" }, allowSetters = true)
    private CustomUser customUser;

    public UserEmail id(Long id) {
        this.id = id;
        return this;
    }

    public UserEmail email(String email) {
        this.email = email;
        return this;
    }

    public UserEmail isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public UserEmail isPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }

    public UserEmail tag(String tag) {
        this.tag = tag;
        return this;
    }

    public UserEmail customUser(CustomUser customUser) {
        this.setCustomUser(customUser);
        return this;
    }

    public UserEmail createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public UserEmail createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserEmail updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public UserEmail updatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
