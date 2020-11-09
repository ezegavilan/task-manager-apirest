package com.gavilan.taskmanagerapirest.controladores.tareas;

import com.gavilan.taskmanagerapirest.modelos.Tarea;
import com.gavilan.taskmanagerapirest.servicios.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ActualizarTareaController {

    private final TareaService tareaService;

    @PutMapping("/topics/{topicId}/tareas/{tareaId}")
    public ResponseEntity<Tarea> actualizarTareaDeTopic(@PathVariable Long topicId,
                                                        @PathVariable Long tareaId,
                                                        @RequestBody Tarea tarea) {
        Tarea tareaActualizada;

        try {
            tareaActualizada = this.tareaService.actualizarTareaTopic(topicId, tareaId, tarea);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(tareaActualizada, HttpStatus.CREATED);
    }

}
