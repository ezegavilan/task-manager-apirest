package com.gavilan.taskmanagerapirest.controladores.tareas;

import com.gavilan.taskmanagerapirest.servicios.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EliminarTareaController {

    private final TareaService tareaService;

    @DeleteMapping("/topics/{topicId}/tareas/{tareaId}")
    public ResponseEntity<String> eliminarTareaDeTopic(@PathVariable Long topicId, @PathVariable Long tareaId) {
        String mensaje;

        try {
            this.tareaService.eliminarTarea(topicId, tareaId);
            mensaje = "Tarea: " + tareaId + " eliminado con éxito.";
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
