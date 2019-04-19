package com.sample.api;


import com.sample.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "api/upload")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;


    @RequestMapping(method = RequestMethod.POST)
    public void handle(

            HttpServletResponse response,
            @RequestParam("file") MultipartFile file

    ){
        // ファイルが空の場合は HTTP 400 を返す。
        if (file.isEmpty()) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;

        }

        StringBuffer filePath = new StringBuffer("./uploadfile/" + file.getOriginalFilename());

        // アップロードされたファイルを保存。
        try {

            File uploadFile = new File(String.valueOf(filePath));

            byte[] bytes = file.getBytes();

            BufferedOutputStream uploadFileStream =
                    new BufferedOutputStream(new FileOutputStream(uploadFile));

            uploadFileStream.write(bytes);
            uploadFileStream.close();

        } catch (IOException e) {

            throw new RuntimeException("Error uploading file.", e);

        }
    }

}
