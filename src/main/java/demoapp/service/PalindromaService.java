package demoapp.service;

import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class PalindromaService {

    public boolean esPalindroma(String palabra) {
        if (palabra == null) {
            return false;
        }
        String s = normaliza(palabra);
        return !s.isEmpty() && new StringBuilder(s).reverse().toString().equals(s);
    }

    private String normaliza(String s) {
        String sinAcentos = Normalizer.normalize(s.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return sinAcentos.replaceAll("[^a-z0-9]", "");
    }
}