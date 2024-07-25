package ru.aomikhailov.DataStorage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Files")
public class File {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private LocalDateTime creation_date;
    private String description;
    private String fileBase64;
}
