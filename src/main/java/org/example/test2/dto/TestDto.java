package org.example.test2.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TestDto {

    @NotNull(message = "not null")
    private Long id;

    @NotNull(message = "id not empty")
    private Long ss;
}
