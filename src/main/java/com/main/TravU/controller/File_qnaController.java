package com.main.TravU.controller;

import com.main.TravU.service.qna.File_qnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class File_qnaController {
    private final File_qnaService service;


}
