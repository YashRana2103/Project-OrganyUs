package com.organyus.model;

import jakarta.annotation.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "projects")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private String projectId; // pk

    @NotBlank
    private String name;

    @NotBlank
    private String slug;

    @NotBlank
    private String desc;

    @NotNull
    private ObjectId deptId; //fk

    @NotNull
    private ObjectId pmId; // fk - Project Manager ID

    @NotNull
    private Date startDate;

    @NotNull
    private Date deadline;

    @NotNull
    private ObjectId createdBy; // fk - User ID of the creator

    @NotNull
    private List<ObjectId> assignedTo; // fk - List of User IDs assigned to the project

    private Status status = Status.NOT_STARTED;

    private Priority priority = Priority.MEDIUM;

    @NotNull
    private List<String> tags;

    @NotNull
    private List<String> notes;

    private Integer progress = 0;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public enum Status{
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED,
        ON_HOLD,
        CANCELLED
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }
}
