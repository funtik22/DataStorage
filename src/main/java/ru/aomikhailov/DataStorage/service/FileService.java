package ru.aomikhailov.DataStorage.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.aomikhailov.DataStorage.model.File;

import java.util.List;

@Service
public interface FileService {
    public Long saveFile(File file);
    public File getFileById(Long id);
    public List<File> getAllFiles(PageRequest pageRequest);
}
