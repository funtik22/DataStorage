package ru.aomikhailov.DataStorage.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Files")
public class File {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Builder.Default
    private LocalDateTime creation = LocalDateTime.now();
    private String description;
    private String fileBase64;

}
