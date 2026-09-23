package demoapp.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PalindromaData {
    @NotBlank(message = "La palabra no puede estar vacía")
    @Size(min = 2, max = 50, message = "La palabra debe tener entre 2 y 50 caracteres")
    String palabra;

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }
}