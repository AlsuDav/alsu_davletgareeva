package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.models.FileInfo;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.FileInfoRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.service.FileStorageService;

import javax.servlet.http.HttpServletResponse;

/**
 * 01.12.2017
 * StorageController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class StorageController {
    @Autowired
    private FileInfoRepository fileInfoRepository;
    @Autowired
    private FileStorageService service;
    @Autowired
    private UsersRepository usersRepository;

    // страница, которая позволяет загружать файлы
    @GetMapping("/storage")
    public String getStoragePage() {
        return "file_upload";
    }

    // принимает файлы
    // MultipartFile - файл, который вы принимаете
    // ResponseEntity - класс, который позволяет отправить в ответе
    // не только тело, но и статус и заголовки ответа
    @PostMapping("/files")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        // сохраняем файл на диск
        String filePath = service.saveFile(file);
        // отправляем пользователю полный путь к этому файлу
        return ResponseEntity
                .ok()
                .body(filePath);
    }
    @PostMapping("/files/{user-id}")
    public ResponseEntity<String> handleFileUpload(@PathVariable("user-id")Long id,@RequestParam("file") MultipartFile file) {
        // сохраняем файл на диск
        String filePath = service.saveFile(file);
        //добавляем юзеру фото
        User user = usersRepository.findById(id).get();
        FileInfo fileInfo = fileInfoRepository.findOneByStorageFileName(filePath);
        user.setPhoto(fileInfo);
        usersRepository.save(user);
        // отправляем пользователю полный путь к этому файлу
        return ResponseEntity
                .ok()
                .body(filePath);
    }

    // URL-для получения файла
    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName,
                        HttpServletResponse response) {
        // запись файла в ответ
        service.writeFileToResponse(fileName, response);
    }
}
