package com.projetopraticoDS.projetopraticoDS.controllers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarValidacao(MethodArgumentNotValidException exception) {
        Map<String, String> campos = new LinkedHashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error ->
                campos.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(criarResposta(HttpStatus.BAD_REQUEST, "Dados invalidos", campos));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> tratarJsonInvalido() {
        return ResponseEntity.badRequest()
                .body(criarResposta(HttpStatus.BAD_REQUEST, "JSON invalido ou campo com formato incorreto", null));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> tratarIntegridade() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(criarResposta(HttpStatus.CONFLICT, "Registro relacionado inexistente ou em uso", null));
    }

    private Map<String, Object> criarResposta(HttpStatus status, String mensagem, Map<String, String> campos) {
        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("timestamp", LocalDateTime.now());
        resposta.put("status", status.value());
        resposta.put("erro", status.getReasonPhrase());
        resposta.put("mensagem", mensagem);

        if (campos != null && !campos.isEmpty()) {
            resposta.put("campos", campos);
        }

        return resposta;
    }
}
