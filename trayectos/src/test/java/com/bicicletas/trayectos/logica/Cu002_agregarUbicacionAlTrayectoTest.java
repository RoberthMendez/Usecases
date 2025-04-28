package com.bicicletas.trayectos.logica;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bicicletas.trayectos.dataAccess.TrayectosRepository;
import com.bicicletas.trayectos.dataAccess.UbicacionesRepository;
import com.bicicletas.trayectos.modelo.Trayecto;
import com.bicicletas.trayectos.modelo.Ubicacion;

import jakarta.transaction.Transactional;

@SpringBootTest
public class Cu002_agregarUbicacionAlTrayectoTest {

    @Autowired
    TrayectosService servicio;

    @Autowired
    TrayectosRepository trayectos;

    @Autowired
    UbicacionesRepository ubicaciones;


    @Test
    @Transactional
    public void agregarUbicacionAlTrayecto_OK(){

        try {
            
            // -- Arrange: Prepara la prueba
            UUID idTrayecto = servicio.iniciarTrayecto(27.0, 14.0);

            // -- Act: Ejecuta la operación que se debe probar
            UUID idUbicacion = servicio.agregarUbicacionAlTrayecto(idTrayecto, 28.0, 15.0);

            // -- Assert: Revisa el resultado
            Trayecto trayecto = trayectos.findById(idTrayecto).get();
            assertEquals(2, trayecto.getUbicaciones().size(),"Debio traer 2 ubicaciones");

            Ubicacion ubicacion = ubicaciones.findById(idUbicacion).get();
            assertEquals(ubicacion.getTrayecto().getId(),idTrayecto, "No se asocio la ubicacion al trayecto");

        } catch (Exception e) {
            fail("Generó una excepción cuando no debía");
        }

    }


    @Test
    @Transactional
    public void agregarUbicacionAlTrayectoNoExiste_FALLA(){

        try {
            
            // -- Arrange: Prepara la prueba
            UUID idTrayecto = UUID.randomUUID();

            // -- Act: Ejecuta la operación que se debe probar
            servicio.agregarUbicacionAlTrayecto(idTrayecto, 28.0, 15.0);

            // -- Assert: Revisa el resultado
            fail("No se lanzó la excepción esperada");

        } catch (Exception e) {
            //ok
        }

    }

    @Test
    @Transactional
    public void agregarUbicacionAlTrayectoNoActivo_FALLA(){

        try {
            
            // -- Arrange: Prepara la prueba
            UUID idTrayecto = servicio.iniciarTrayecto(27.0, 14.0);
            Trayecto trayecto = trayectos.findById(idTrayecto).get();
            trayecto.setEnProceso(false);

            // -- Act: Ejecuta la operación que se debe probar
            servicio.agregarUbicacionAlTrayecto(idTrayecto, 28.0, 15.0);

            // -- Assert: Revisa el resultado
            fail("No se lanzó la excepción esperada");

        } catch (Exception e) {
            //ok
        }

    }

}
