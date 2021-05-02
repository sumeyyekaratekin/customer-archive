package com.sumeyye.customerArchive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sumeyye.customerArchive.service.FileStorageService;
import com.sumeyye.customerArchive.message.*;
import com.sumeyye.customerArchive.model.File;

@RestController
@CrossOrigin("http://localhost:8081")
public class FileController {

    private final FileStorageService storageService;

    @Autowired
    public FileController(FileStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage>
    uploadFile(@RequestParam("customerId") Integer customerId,
               @RequestParam("file") MultipartFile file) {

        String message = "";
        try {
            message = storageService.store(file, customerId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = String.format("Dosya yüklenemedi : %s ", file.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles();

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        File file = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }
    @DeleteMapping("/files/{id}")
    public void deleteFile(@PathVariable String id) {
        storageService.deleteFile(id);
    }

}