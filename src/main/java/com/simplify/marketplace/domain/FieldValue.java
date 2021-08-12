package com.simplify.marketplace.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.time.LocalDate;
/**
 * A FieldValue.
 */
@Entity
@Table(name = "field_value")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FieldValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

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
    private JobPreference jobpreference;

    @ManyToOne
    @JsonIgnoreProperties(value = { "fieldValues", "category" }, allowSetters = true)
    private Field field;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FieldValue id(Long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public FieldValue value(String value) {
        this.value = value;
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public JobPreference getJobpreference() {
        return this.jobpreference;
    }

    public FieldValue jobpreference(JobPreference jobPreference) {
        this.setJobpreference(jobPreference);
        return this;
    }

    public void setJobpreference(JobPreference jobPreference) {
        this.jobpreference = jobPreference;
    }

    public Field getField() {
        return this.field;
    }

    public FieldValue field(Field field) {
        this.setField(field);
        return this;
    }

    public void setField(Field field) {
        this.field = field;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }

    public FieldValue createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public FieldValue createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public FieldValue updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedAt() {
        return this.updatedAt;
    }

    public FieldValue updatedAt(LocalDate updatedAt) {
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
        if (!(o instanceof FieldValue)) {
            return false;
        }
        return id != null && id.equals(((FieldValue) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FieldValue{" +
            "id=" + getId() +
            ", value='" + getValue() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
