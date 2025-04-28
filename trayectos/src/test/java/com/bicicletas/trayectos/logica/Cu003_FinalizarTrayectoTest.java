package com.bicicletas.trayectos.logica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bicicletas.trayectos.dataAccess.TrayectosRepository;
import com.bicicletas.trayectos.dataAccess.UbicacionesRepository;
import com.bicicletas.trayectos.modelo.Trayecto;

import jakarta.transaction.Transactional;

@SpringBootTest
public class Cu003_FinalizarTrayectoTest {

    @Autowired
    TrayectosService servicio;

    @Autowired
    TrayectosRepository trayectos;

    @Autowired
    UbicacionesRepository ubicaciones;

    @Test
    @Transactional
    public void finalizarTrayecto_OK() {

        try {
            // Arrange: Prepara la prueba
            UUID idTrayecto = servicio.iniciarTrayecto(27.0, 14.0);

            // Act: Ejecuta la operación que se debe probar
            servicio.finalizarTrayecto(idTrayecto, 28.0, 15.0);

            // Assert: Revisa el resultado
            Trayecto trayecto = trayectos.findById(idTrayecto).get();
            assertEquals(false, trayecto.isEnProceso(), "El trayecto no se marcó como finalizado");

        } catch (Exception e) {
            fail("Generó una excepción cuando no debía");
        }

    }

    @Test
    @Transactional
    public void finalizarTrayectoNoExiste_FALLA() {

        try {
            // Arrange: Prepara la prueba
            UUID idTrayecto = UUID.randomUUID();

            // Act: Ejecuta la operación que se debe probar
            servicio.finalizarTrayecto(idTrayecto, 28.0, 15.0);

            // Assert: Revisa el resultado
            fail("No se lanzó una excepción cuando se esperaba");

        } catch (Exception e) {
            //ok
        }

    }

    @Test
    @Transactional
    public void finalizarTrayectoNoActivo_FALLA() {

        try {
            // Arrange: Prepara la prueba
            UUID idTrayecto = servicio.iniciarTrayecto(27.0, 14.0);
            servicio.finalizarTrayecto(idTrayecto, 28.0, 15.0);

            // Act: Ejecuta la operación que se debe probar
            servicio.finalizarTrayecto(idTrayecto, 28.0, 15.0);

            // Assert: Revisa el resultado
            fail("No se lanzó una excepción cuando se esperaba");

        } catch (Exception e) {
            //ok
        }

    }


}
