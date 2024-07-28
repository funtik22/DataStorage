package ru.aomikhailov.DataStorage.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import ru.aomikhailov.DataStorage.model.File;
import ru.aomikhailov.DataStorage.service.FileService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileControllerTest {
    @Mock
    private FileService fileService;

    @InjectMocks
    private FileController fileController;

    @Test
    public void saveFile_shouldCallService() {
        final Long id = 1L;
        final File file = mock(File.class);
        when(fileService.saveFile(file)).thenReturn(id);

        final Long result = fileController.saveFile(file);

        assertNotNull(result);
        verify(fileService).saveFile(file);
    }

    @Test
    public void getFileById_shouldCallService(){
        final Long id = 1L;
        final File file = mock(File.class);
        when(fileService.getFileById(id)).thenReturn(file);

        final File result = fileController.getFileById(id);

        assertNotNull(result);
        verify(fileService).getFileById(id);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void getAllFiles_shouldCallService(){
        final int page = 0, size = 10;
        var students = mock(List.class);
        when(fileService.getAllFiles(any(PageRequest.class))).thenReturn(students);

        final List<File> result = fileController.getAllFiles(page, size);

        assertNotNull(result);
        verify(fileService).getAllFiles(any(PageRequest.class));
    }
}
