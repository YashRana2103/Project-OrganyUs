package com.organyus.model;

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

@Document(collection = "tasks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private String taskId; // pk

    @NotBlank
    private String title;

    @NotBlank
    private String desc;

    @NotNull
    private ObjectId projectId; // fk - Project ID

    @NotNull
    private Date startDate;

    @NotNull
    private Date deadline;

    private Date completedAt;

    @NotNull
    private ObjectId createdBy; // fk - User ID of the creator

    @NotNull
    private List<ObjectId> assignedTo; // fk - List of User IDs assigned to the project

    private Status status = Status.NOT_STARTED;

    private Priority priority = Priority.MEDIUM;

    @NotNull
    private List<String> remarks; // List of remarks or comments on the task

    private Integer progress = 0;

    private List<String> attachments; // List of attachment URLs or file paths

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
