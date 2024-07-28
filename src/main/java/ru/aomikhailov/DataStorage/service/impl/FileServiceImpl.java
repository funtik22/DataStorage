package ru.aomikhailov.DataStorage.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.aomikhailov.DataStorage.model.File;
import ru.aomikhailov.DataStorage.repository.FileRepository;
import ru.aomikhailov.DataStorage.service.FileService;

import java.util.List;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository repository;

    @Override
    public Long saveFile(File file) {
        return repository.save(file).getId();
    }

    @Override
    public File getFileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<File> getAllFiles(PageRequest pageRequest) {
        Page<File> page = repository.findAll(pageRequest);
        return page.getContent();
    }
}
