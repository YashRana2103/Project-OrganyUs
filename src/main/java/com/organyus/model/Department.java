package com.organyus.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "departments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    private ObjectId deptId;

    @NotBlank
    private String name;

    @NotBlank
    private String slug;

    private String desc;

    private ObjectId deptHeadId;

    private State state = State.ACTIVE;

    @Indexed
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public enum State {
        ACTIVE,
        INACTIVE
    }
}
