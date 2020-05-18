package ru.itis.restbrieflib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.restbrieflib.models.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findOneByStorageFileName(String storageFileName);
}
