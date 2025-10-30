package com.example.demo.dtos;

import java.util.Date;

public record BookDTO(
        String title,
        String summary,
        Date publishedDate
) {
}
