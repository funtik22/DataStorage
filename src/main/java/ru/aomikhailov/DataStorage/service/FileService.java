package ru.aomikhailov.DataStorage.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.aomikhailov.DataStorage.model.File;

@Service
public interface FileService {
    public Long saveFile(@RequestBody File file);
    public File getFileById(@RequestBody Long id);
}
