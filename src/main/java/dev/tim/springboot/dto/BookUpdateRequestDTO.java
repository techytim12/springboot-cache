package dev.tim.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequestDTO {

    private int id;
    private String author;
}
