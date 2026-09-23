package demoapp;

import demoapp.service.PalindromaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PalindromaServiceTest {

    @Autowired
    private PalindromaService service;

    @Test
    public void serviceLoaded() throws Exception {
        assertThat(service).isNotNull();
    }

    @Test
    public void palabraPalindroma() throws Exception {
        assertThat(service.esPalindroma("reconocer")).isTrue();
    }

    @Test
    public void palabraNoPalindroma() throws Exception {
        assertThat(service.esPalindroma("hola")).isFalse();
    }

    @Test
    public void palindromaIgnorandoMayusculas() throws Exception {
        assertThat(service.esPalindroma("Reconocer")).isTrue();
    }

    @Test
    public void palindromaIgnorandoAcentos() throws Exception {
        assertThat(service.esPalindroma("¿Acaso hubo búhos acá?")).isTrue();
    }

    @Test
    public void palindromaIgnorandoEspacios() throws Exception {
        assertThat(service.esPalindroma("dabale arroz a la zorra el abad")).isTrue();
    }

    @Test
    public void palabraVacia() throws Exception {
        assertThat(service.esPalindroma("")).isFalse();
    }

    @Test
    public void palabraNula() throws Exception {
        assertThat(service.esPalindroma(null)).isFalse();
    }
}