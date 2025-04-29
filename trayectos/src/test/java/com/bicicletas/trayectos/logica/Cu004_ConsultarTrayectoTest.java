package com.bicicletas.trayectos.logica;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bicicletas.trayectos.dataAccess.TrayectosRepository;
import com.bicicletas.trayectos.dataAccess.UbicacionesRepository;
import com.bicicletas.trayectos.modelo.Trayecto;

import static org.junit.jupiter.api.Assertions.fail;

import jakarta.transaction.Transactional;  

@SpringBootTest
public class Cu004_ConsultarTrayectoTest {
    @Autowired
    TrayectosService servicio;

    @Autowired
    TrayectosRepository trayectos;

    @Autowired
    UbicacionesRepository ubicaciones;

    @Test
    @Transactional
    public void consultarTrayecto_OK() throws Exception {
        try {
            // Arrange: Prepara la prueba
            UUID idTrayecto = servicio.iniciarTrayecto(27.0, 14.0);
            servicio.finalizarTrayecto(idTrayecto, 28.0, 15.0);
            

            // Act: Ejecuta la operación que se debe probar
            Trayecto trayecto = servicio.consultarTrayecto(idTrayecto);

            // Assert: Revisa el resultado
            // Aquí puedes agregar aserciones para verificar el resultado esperado

        } catch (Exception e) {
            fail("Generó una excepción cuando no debía");
        }
    }

    @Test
    @Transactional
    public void consultarTrayectoNoExiste_FALLA() {
        try {
            // Arrange: Prepara la prueba
            UUID idTrayecto = UUID.randomUUID();

            // Act: Ejecuta la operación que se debe probar
            servicio.consultarTrayecto(idTrayecto);

            // Assert: Revisa el resultado
            fail("Se esperaba una excepción, pero no se lanzó ninguna");

        } catch (Exception e) {
            // Aquí puedes agregar aserciones para verificar el tipo de excepción lanzada
        }
    }
}
