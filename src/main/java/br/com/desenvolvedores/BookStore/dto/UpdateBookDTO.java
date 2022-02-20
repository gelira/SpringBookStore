package br.com.desenvolvedores.BookStore.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class UpdateBookDTO {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String author;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String genre;
}
