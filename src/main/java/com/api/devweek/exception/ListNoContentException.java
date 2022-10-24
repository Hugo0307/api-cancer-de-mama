package com.api.devweek.exception;

public class ListNoContentException extends RuntimeException {

    public ListNoContentException() {
        super("Não há conteúdo a ser exibido.");
    }
}
