package com.simplify.marketplace.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
/**
 * A DTO for the {@link com.simplify.marketplace.domain.Worker} entity.
 */
@Data
public class WorkerDTO implements Serializable {

    private Long id;

    @NotNull
    private String firstName;

    private String middleName;

    @NotNull
    private String lastName;

    private String primaryPhone;

    private String description;

    private LocalDate dateOfBirth;

    private Boolean isActive;

    private CustomUserDTO customUser;

    private String createdBy;

    private LocalDate createdAt;

    private String updatedBy;

    private LocalDate updatedAt;

    private Set<SkillsMasterDTO> skills = new HashSet<>();

   
}
