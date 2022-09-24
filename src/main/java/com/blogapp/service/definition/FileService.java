package com.blogapp.service.definition;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {

    String uploadImage(MultipartFile multipartFile ,String path) throws IOException;
    InputStream getResource(String path,String fileName) throws FileNotFoundException;
}
