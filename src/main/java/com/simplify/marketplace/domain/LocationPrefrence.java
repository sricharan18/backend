package com.simplify.marketplace.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.time.LocalDate;
/**
 * A LocationPrefrence.
 */
@Entity
@Table(name = "location_prefrence")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LocationPrefrence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prefrence_order")
    private Integer prefrenceOrder;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = { "locationPrefrences", "fieldValues", "subCategory", "worker" }, allowSetters = true)
    private JobPreference worker;

    @ManyToOne
    @JsonIgnoreProperties(value = { "locationPrefrences", "employment" }, allowSetters = true)
    private Location location;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocationPrefrence id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getPrefrenceOrder() {
        return this.prefrenceOrder;
    }

    public LocationPrefrence prefrenceOrder(Integer prefrenceOrder) {
        this.prefrenceOrder = prefrenceOrder;
        return this;
    }

    public void setPrefrenceOrder(Integer prefrenceOrder) {
        this.prefrenceOrder = prefrenceOrder;
    }

    public JobPreference getWorker() {
        return this.worker;
    }

    public LocationPrefrence worker(JobPreference jobPreference) {
        this.setWorker(jobPreference);
        return this;
    }

    public void setWorker(JobPreference jobPreference) {
        this.worker = jobPreference;
    }

    public Location getLocation() {
        return this.location;
    }

    public LocationPrefrence location(Location location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LocationPrefrence)) {
            return false;
        }
        return id != null && id.equals(((LocationPrefrence) o).id);
    }
    public String getCreatedBy() {
        return this.createdBy;
    }

    public LocationPrefrence createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public LocationPrefrence createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public LocationPrefrence updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedAt() {
        return this.updatedAt;
    }

    public LocationPrefrence updatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }    

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LocationPrefrence{" +
            "id=" + getId() +
            ", prefrenceOrder=" + getPrefrenceOrder() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
