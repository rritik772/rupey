package com.f15t.rupey.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private Optional<Long> CategoryId;
    private String name;
    private String description;
    private boolean isDeleted;
    private String username;
}
