package kr.ac.jejunu.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Component
@Slf4j
public class ImageUploader{
// http://localhost:8080/user/minihome/update
    public String save(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        File path = new File("./src/main/resources/static/img/"+ multipartFile.getOriginalFilename());

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(multipartFile.getBytes());
        bufferedOutputStream.close();

        return "/img/"+path.getName();
    }

}
