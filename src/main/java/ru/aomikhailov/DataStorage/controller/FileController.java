package ru.aomikhailov.DataStorage.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.aomikhailov.DataStorage.model.File;
import ru.aomikhailov.DataStorage.service.FileService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dataStorage")
@AllArgsConstructor
public class FileController {

    private final FileService service;

    @PostMapping("save_file")
    public Long saveFile(@RequestBody File file) {
        return service.saveFile(file);
    }

    @GetMapping("/{id}")
    public File getFileById(@PathVariable Long id) {
        return service.getFileById(id);
    }

    @GetMapping("/files")
    public List<File> getAllFiles(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        return service.getAllFiles(PageRequest.of(page, size));
    }
}
