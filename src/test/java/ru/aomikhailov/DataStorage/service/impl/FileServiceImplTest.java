package ru.aomikhailov.DataStorage.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.aomikhailov.DataStorage.model.File;
import ru.aomikhailov.DataStorage.repository.FileRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FileServiceImplTest {

    @Mock
    private FileRepository repository;

    @InjectMocks
    private FileServiceImpl fileService;

    @Test
    public void getFileById_shouldCallRepository(){
        final Long id = 1L;
        final File file = mock(File.class);
        when(repository.findById(id)).thenReturn(Optional.ofNullable(file));

        final File result = fileService.getFileById(id);

        assertNotNull(result);
        assertEquals(result, file);
        verify(repository).findById(id);
    }

    @Test
    public void saveFile_shouldCallRepository(){
        final File file = mock(File.class);
        when(repository.save(file)).thenReturn(file);

        final Long result = fileService.saveFile(file);

        assertNotNull(result);
        verify(repository).save(file);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void getAllFiles_shouldCallRepository(){
        final PageRequest pageRequest = PageRequest.of(1, 10,
                Sort.Direction.ASC, "creation");
        var students = mock(Page.class);
        when(repository.findAll(any(PageRequest.class))).thenReturn(students);


        final List<File> result = fileService.getAllFiles(pageRequest);

        assertNotNull(result);
        verify(repository).findAll(any(PageRequest.class));
    }
}
