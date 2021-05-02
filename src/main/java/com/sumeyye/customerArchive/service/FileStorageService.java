package com.sumeyye.customerArchive.service;

import com.sumeyye.customerArchive.message.ResponseFile;
import com.sumeyye.customerArchive.model.Customer;
import com.sumeyye.customerArchive.model.File;
import com.sumeyye.customerArchive.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FileStorageService {
    private final FileRepository fileRepository;
    private final CustomerService customerService;

    @Autowired
    public FileStorageService(FileRepository fileRepository, CustomerService customerService) {
        this.fileRepository = fileRepository;
        this.customerService = customerService;
    }

    public String store(MultipartFile fileRequest, Integer customerId) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(fileRequest.getOriginalFilename()));

        Customer customer = customerService.getCustomer(customerId);

        File file = new File(fileName, fileRequest.getContentType(), fileRequest.getBytes(), customer);
        fileRepository.save(file);
        return "Dosya yüklemesi başarılı, yüklenen dosya : " + fileRequest.getOriginalFilename();
    }

    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public List<ResponseFile> getAllFiles() {
        List<File> allFiles = fileRepository.findAll();
        return mapToResponseFileList(allFiles);
    }

    public List<ResponseFile> getAllFilesByCustomerId(Integer customerId) { //
        List<File> allFiles = fileRepository.findAllByCustomerId(customerId);
        return mapToResponseFileList(allFiles);
    }
    private List<ResponseFile> mapToResponseFileList(List<File> allFiles) {
        return allFiles.stream().map(this::mapToResponseFile).collect(Collectors.toList());
    }

    private ResponseFile mapToResponseFile(File dbFile) {
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/files/")
                .path(dbFile.getId())
                .toUriString();
        return new ResponseFile(
                dbFile.getName(),
                fileDownloadUri,
                dbFile.getType(),
                dbFile.getData().length,
                dbFile.getCustomer().getId()
        );
    }

}
