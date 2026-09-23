package demoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PalindromaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getMuestraElFormulario() throws Exception {
        this.mockMvc.perform(get("/palindroma"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Comprobar si una palabra es palíndroma")));
    }

    @Test
    public void postPalabraPalindroma() throws Exception {
        this.mockMvc.perform(post("/palindroma")
                .param("palabra", "reconocer"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("SÍ es palíndroma")));
    }

    @Test
    public void postPalabraNoPalindroma() throws Exception {
        this.mockMvc.perform(post("/palindroma")
                .param("palabra", "hola"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("NO es palíndroma")));
    }

    @Test
    public void postPalabraVaciaMuestraErrorDeValidacion() throws Exception {
        this.mockMvc.perform(post("/palindroma")
                .param("palabra", ""))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("La palabra no puede estar vacía")));
    }

    @Test
    public void postPalabraDemasiadoCortaMuestraErrorDeValidacion() throws Exception {
        this.mockMvc.perform(post("/palindroma")
                .param("palabra", "a"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("La palabra debe tener entre 2 y 50 caracteres")));
    }
}