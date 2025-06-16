package com.zecss13.library.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotNull(message = "Category ID is required")
    private Long categoryId;
} 