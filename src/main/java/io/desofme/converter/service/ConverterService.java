package io.desofme.converter.service;

import io.desofme.converter.dto.Base64Dto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ConverterService {
    public ResponseEntity<Resource> convertToPdf(Base64Dto base64Dto) {
        try {

            byte[] bytes = Base64.getDecoder().decode(base64Dto.getBase64());
            ByteArrayResource resource = new ByteArrayResource(bytes);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + "test.pdf" + "\"" )
                    .body(resource);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
