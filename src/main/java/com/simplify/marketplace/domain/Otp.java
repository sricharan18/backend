package com.simplify.marketplace.domain;

import com.simplify.marketplace.domain.enumeration.OtpStatus;
import com.simplify.marketplace.domain.enumeration.OtpType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Otp.
 */
@Entity
@Table(name = "otp")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Otp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "context_id")
    private String contextId;

    @Column(name = "otp")
    private Integer otp;

    @Column(name = "email")
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "phone")
    private Integer phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private OtpType type;

    @Column(name = "expiry_time")
    private LocalDate expiryTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OtpStatus status;

    public Otp id(Long id) {
        this.id = id;
        return this;
    }

    public Otp contextId(String contextId) {
        this.contextId = contextId;
        return this;
    }

    public Otp otp(Integer otp) {
        this.otp = otp;
        return this;
    }

    public Otp email(String email) {
        this.email = email;
        return this;
    }

    public Otp isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public Otp phone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public Otp type(OtpType type) {
        this.type = type;
        return this;
    }

    public Otp expiryTime(LocalDate expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }

    public Otp status(OtpStatus status) {
        this.status = status;
        return this;
    }

    public Otp createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Otp createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
