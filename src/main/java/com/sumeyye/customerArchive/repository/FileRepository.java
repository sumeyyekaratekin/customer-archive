package com.sumeyye.customerArchive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sumeyye.customerArchive.model.File;

import java.util.List;

public interface FileRepository extends JpaRepository <File, String> {
    List<File> findAllByCustomerId(Integer customerId);
}
