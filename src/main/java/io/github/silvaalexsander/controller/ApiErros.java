package io.github.silvaalexsander.controller;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    private List<String> erros;

    public ApiErros(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
