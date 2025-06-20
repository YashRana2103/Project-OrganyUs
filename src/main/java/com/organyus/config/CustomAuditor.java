package com.organyus.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomAuditor {
    private ObjectId id;
    private String name;

    // managed by @AllArgsConstructor
//    public CustomAuditor(ObjectId id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
