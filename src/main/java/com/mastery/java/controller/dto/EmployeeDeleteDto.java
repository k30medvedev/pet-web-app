package com.mastery.java.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Choose employee Id to delete", example = "1")
public class EmployeeDeleteDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
