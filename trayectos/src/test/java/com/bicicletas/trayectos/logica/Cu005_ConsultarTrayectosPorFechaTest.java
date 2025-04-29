package com.bicicletas.trayectos.logica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bicicletas.trayectos.dataAccess.TrayectosRepository;
import com.bicicletas.trayectos.dataAccess.UbicacionesRepository;
import com.bicicletas.trayectos.modelo.Trayecto;

import jakarta.transaction.Transactional;

@SpringBootTest
public class Cu005_ConsultarTrayectosPorFechaTest {
    @Autowired
    TrayectosService servicio;

    @Autowired
    TrayectosRepository trayectos;
    
    @Autowired
    UbicacionesRepository ubicaciones;

    @Test
    @Transactional
    public void consultarTrayectosPorFecha_OK() throws Exception {
        try {

            // Arrange: Prepara la prueba
            UUID idTrayecto = servicio.iniciarTrayecto(27.0, 14.0);
            servicio.finalizarTrayecto(idTrayecto, 28.0, 15.0);

            UUID idTrayecto2 = servicio.iniciarTrayecto(30.0, 69.9);
            servicio.finalizarTrayecto(idTrayecto2, 31.0, 70.9);

            // Act: Ejecuta la operación que se debe probar
            List<Trayecto> trayectosFecha = servicio.consultarTrayectosPorFecha(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
            
            // Assert: Revisa el resultado
            assertEquals(2, trayectosFecha.size(), "No se consultaron los trayectos correctamente");

        } catch (Exception e) {
            fail("Generó una excepción cuando no debía");
        }
    }

    @Test
    @Transactional
    public void consultarTrayectosPorFechaInicioMayor_FALLA() throws Exception {
        try {
            // Arrange: Prepara la prueba
            UUID idTrayecto = servicio.iniciarTrayecto(27.0, 14.0);
            servicio.finalizarTrayecto(idTrayecto, 28.0, 15.0);

            // Act: Ejecuta la operación que se debe probar
            List<Trayecto> trayectosFecha = servicio.consultarTrayectosPorFecha(LocalDateTime.now().plusDays(1), LocalDateTime.now());

            // Assert: Revisa el resultado
            fail("Se esperaba una excepción, pero no se lanzó ninguna");

        } catch (Exception e) {
            //ok
        }
    }





}
