package org.example.test2.controller;

import lombok.RequiredArgsConstructor;
import org.example.test2.service.TranslationService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TranslationService translationService;

    @GetMapping("/translate")
    public ResponseEntity<String> getTranslation() {
        String translation = translationService.translate();
        return ResponseEntity.ok(translation);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(){

        CategoryDto dto = new CategoryDto();
        dto.setNameEn("englsh");
        dto.setNameRu("rus");
        dto.setNameUz("uzb");

        return ResponseEntity.ok(dto);
    }
}
