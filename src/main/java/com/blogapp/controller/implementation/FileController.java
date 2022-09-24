package com.blogapp.controller.implementation;

import com.blogapp.dto.FileResponse;
import com.blogapp.service.definition.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/v1/file")
public class FileController {

//    private final FileService fileService;
//
//    @Value("${project.image}")
//    private String path;
//
//    public FileController(FileService fileService) {
//        this.fileService = fileService;
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<FileResponse> fileUpload(
//            @RequestParam("image")MultipartFile image) {
//
//        String fileName = null;
//        try {
//            fileName = fileService.uploadImage(image,path);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new FileResponse(null,"file not  uploded"), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>(new FileResponse(fileName,"file uploded"), HttpStatus.OK);
//    }

//    @GetMapping(value = "/images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
//    public void downloadImage(
//            @PathVariable String imageName,
//            HttpServletResponse response ) throws IOException {
//        InputStream inputStream = fileService.getResource(path,imageName);
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(inputStream,response.getOutputStream());
//
//    }
}
