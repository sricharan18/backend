package com.simplify.marketplace.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.time.LocalDate;

/**
 * A Address.
 */
@Entity
@Table(name = "address")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line_1")
    private String line1;

    @Column(name = "line_2")
    private String line2;

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
    @JsonIgnoreProperties(value = { "locationPrefrences", "employment" }, allowSetters = true)
    private Location location;

    @ManyToOne
    @JsonIgnoreProperties(value = { "userEmails", "userPhones", "addresses" }, allowSetters = true)
    private CustomUser customUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address id(Long id) {
        this.id = id;
        return this;
    }

    public String getLine1() {
        return this.line1;
    }

    public Address line1(String line1) {
        this.line1 = line1;
        return this;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return this.line2;
    }

    public Address line2(String line2) {
        this.line2 = line2;
        return this;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getTag() {
        return this.tag;
    }

    public Address tag(String tag) {
        this.tag = tag;
        return this;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Location getLocation() {
        return this.location;
    }

    public Address location(Location location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CustomUser getCustomUser() {
        return this.customUser;
    }

    public Address customUser(CustomUser customUser) {
        this.setCustomUser(customUser);
        return this;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Address createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public Address createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public Address updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedAt() {
        return this.updatedAt;
    }

    public Address updatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }    


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        return id != null && id.equals(((Address) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Address{" +
            "id=" + getId() +
            ", line1='" + getLine1() + "'" +
            ", line2='" + getLine2() + "'" +
            ", tag='" + getTag() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
