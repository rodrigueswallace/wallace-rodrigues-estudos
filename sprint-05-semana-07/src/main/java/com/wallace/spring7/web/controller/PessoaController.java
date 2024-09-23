package com.wallace.spring7.web.controller;


import com.wallace.spring7.dto.PessoaDTO;
import com.wallace.spring7.dto.PessoaResponseDTO;
import com.wallace.spring7.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> verifyAge(@RequestBody PessoaDTO pessoa){
        PessoaResponseDTO response = pessoaService.verifyAge(pessoa);
        return ResponseEntity.ok(response);
    }
}
