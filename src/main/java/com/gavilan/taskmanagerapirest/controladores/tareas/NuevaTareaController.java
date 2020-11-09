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
public class NuevaTareaController {

    private final TareaService tareaService;

    @PostMapping("/topics/{topicId}/tareas")
    public ResponseEntity<Tarea> crearNuevaTarea(@PathVariable Long topicId, @RequestBody Tarea tarea) {
        Tarea nuevaTarea;

        try {
            nuevaTarea = this.tareaService.nuevaTarea(topicId, tarea);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

}
