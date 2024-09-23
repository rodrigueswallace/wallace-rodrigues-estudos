package com.wallace.spring7.service;


import com.wallace.spring7.dto.PessoaDTO;
import com.wallace.spring7.dto.PessoaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Service
public class PessoaService {


    public PessoaResponseDTO verifyAge(PessoaDTO pessoa) {
        String message = pessoa.getAge() >= 18 ? "Entry Allowed" : "Entry Denied";

        return new PessoaResponseDTO(pessoa.getName(), message);
    }
}
