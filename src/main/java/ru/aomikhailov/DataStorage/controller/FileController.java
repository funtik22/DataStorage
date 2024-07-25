package ru.aomikhailov.DataStorage.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.aomikhailov.DataStorage.model.File;
import ru.aomikhailov.DataStorage.service.FileService;

@RestController
@RequestMapping("/api/v1/dataStorage")
@AllArgsConstructor
public class FileController {

    private final FileService service;

    @PostMapping("save_file")
    public Long saveFile(@RequestBody File file){
        return service.saveFile(file);
    }

    @GetMapping("/{id}")
    public File getFileById(@PathVariable Long id){
        return service.getFileById(id);
    }
}
