package com.simplify.marketplace.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Worker.
 */
@Entity
@Table(name = "worker")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "primary_phone")
    private String primaryPhone;

    @Column(name = "description")
    private String description;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @JsonIgnoreProperties(value = { "userEmails", "userPhones", "addresses" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private CustomUser customUser;

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<File> files = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "majorSubject", "minorSubject", "worker" }, allowSetters = true)
    private Set<Education> educations = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<Certificate> certificates = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "locations", "company", "worker" }, allowSetters = true)
    private Set<Employment> employments = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<Portfolio> portfolios = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<Refereces> refereces = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "locationPrefrences", "fieldValues", "subCategory", "worker" }, allowSetters = true)
    private Set<JobPreference> jobPreferences = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_worker__skill",
        joinColumns = @JoinColumn(name = "worker_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @JsonIgnoreProperties(value = { "workers" }, allowSetters = true)
    private Set<SkillsMaster> skills = new HashSet<>();

    public Worker id(Long id) {
        this.id = id;
        return this;
    }

    public Worker firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Worker middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Worker lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Worker primaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
        return this;
    }

    public Worker description(String description) {
        this.description = description;
        return this;
    }

    public Worker dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Worker isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public Worker customUser(CustomUser customUser) {
        this.setCustomUser(customUser);
        return this;
    }

    public Worker files(Set<File> files) {
        this.setFiles(files);
        return this;
    }

    public Worker addFile(File file) {
        this.files.add(file);
        file.setWorker(this);
        return this;
    }

    public Worker removeFile(File file) {
        this.files.remove(file);
        file.setWorker(null);
        return this;
    }

    public Worker educations(Set<Education> educations) {
        this.setEducations(educations);
        return this;
    }

    public Worker addEducation(Education education) {
        this.educations.add(education);
        education.setWorker(this);
        return this;
    }

    public Worker removeEducation(Education education) {
        this.educations.remove(education);
        education.setWorker(null);
        return this;
    }

    public Worker certificates(Set<Certificate> certificates) {
        this.setCertificates(certificates);
        return this;
    }

    public Worker addCertificate(Certificate certificate) {
        this.certificates.add(certificate);
        certificate.setWorker(this);
        return this;
    }

    public Worker removeCertificate(Certificate certificate) {
        this.certificates.remove(certificate);
        certificate.setWorker(null);
        return this;
    }

    public Worker employments(Set<Employment> employments) {
        this.setEmployments(employments);
        return this;
    }

    public Worker addEmployment(Employment employment) {
        this.employments.add(employment);
        employment.setWorker(this);
        return this;
    }

    public Worker removeEmployment(Employment employment) {
        this.employments.remove(employment);
        employment.setWorker(null);
        return this;
    }

    public Worker portfolios(Set<Portfolio> portfolios) {
        this.setPortfolios(portfolios);
        return this;
    }

    public Worker addPortfolio(Portfolio portfolio) {
        this.portfolios.add(portfolio);
        portfolio.setWorker(this);
        return this;
    }

    public Worker removePortfolio(Portfolio portfolio) {
        this.portfolios.remove(portfolio);
        portfolio.setWorker(null);
        return this;
    }

    public Worker refereces(Set<Refereces> refereces) {
        this.setRefereces(refereces);
        return this;
    }

    public Worker addRefereces(Refereces refereces) {
        this.refereces.add(refereces);
        refereces.setWorker(this);
        return this;
    }

    public Worker removeRefereces(Refereces refereces) {
        this.refereces.remove(refereces);
        refereces.setWorker(null);
        return this;
    }

    public Worker jobPreferences(Set<JobPreference> jobPreferences) {
        this.setJobPreferences(jobPreferences);
        return this;
    }

    public Worker addJobPreference(JobPreference jobPreference) {
        this.jobPreferences.add(jobPreference);
        jobPreference.setWorker(this);
        return this;
    }

    public Worker removeJobPreference(JobPreference jobPreference) {
        this.jobPreferences.remove(jobPreference);
        jobPreference.setWorker(null);
        return this;
    }

    public Worker skills(Set<SkillsMaster> skillsMasters) {
        this.setSkills(skillsMasters);
        return this;
    }

    public Worker addSkill(SkillsMaster skillsMaster) {
        this.skills.add(skillsMaster);
        skillsMaster.getWorkers().add(this);
        return this;
    }

    public Worker removeSkill(SkillsMaster skillsMaster) {
        this.skills.remove(skillsMaster);
        skillsMaster.getWorkers().remove(this);
        return this;
    }

    public Worker createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Worker createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Worker updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public Worker updatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
