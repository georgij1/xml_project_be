package com.xml_project_be.xml_project.xml_file;

import com.xml_project_be.xml_project.xml_file.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}