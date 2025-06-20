package com.organyus.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {
    @Id
    private ObjectId id;

//    private ObjectId departmentId;

//    private ObjectId roleId;

    @NotBlank
    private String fullName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String passwordHash;

//    @NotBlank
    private String contactNumber;

    private enum Status{
        active, inactive, terminated
    }
}
