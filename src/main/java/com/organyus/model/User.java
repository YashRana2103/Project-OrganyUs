package com.organyus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.organyus.validation.annotation.SecurePassword;
import com.organyus.validation.annotation.ValidPhoneNumber;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId uid;

    @NotNull(message = "Department ID Can not be null")
    private ObjectId deptId;

    @NotNull(message = "Role ID Can not be null")
    private ObjectId rid;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters (A–Z or a–z)")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
//    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$",
//            message = "Email must be lowercase and valid format")
    @Indexed(unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Transient // Optional: It will not be stored in the database
//    Below comment is done by @SecurePassword annotation, so no need to repeat it here
//    @Size(min = 6, max = 64, message = "Password must be between 6 and 64 characters")
//    @Pattern(
//            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,64}$",
//            message = "Password must have at least 1 letter, 1 number, and 1 special character"
//    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // for not returning it in response accidentally
    @SecurePassword
    private String rawPwd;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // for not returning it in response accidentally
    private String hashPwd;

//    @NotBlank(message = "Phone number is required")
//    @Pattern(regexp = "\\d{10}", message = "Must be a valid 10-digit number")
//    private String phone;

    @ValidPhoneNumber
    private String phone;

    @Indexed
    @Builder.Default
    private State state = State.ACTIVE;

    @Indexed
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public enum State {
        ACTIVE, INACTIVE, TERMINATED
    }
}
