package ru.aomikhailov.DataStorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aomikhailov.DataStorage.model.File;

public interface FileRepository extends JpaRepository<File, Long> {
}
