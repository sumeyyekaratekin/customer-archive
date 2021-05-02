package com.sumeyye.customerArchive.service;

import com.sumeyye.customerArchive.message.ResponseFile;
import com.sumeyye.customerArchive.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    File getFile(String id);
    List<ResponseFile> getAllFiles();
    List<ResponseFile> getAllFilesByCustomerId(Integer customerId);
    String store(MultipartFile fileRequest, Integer customerId) throws IOException;
}
