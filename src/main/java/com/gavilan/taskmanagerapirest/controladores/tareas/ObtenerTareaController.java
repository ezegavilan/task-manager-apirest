package com.gavilan.taskmanagerapirest.controladores.tareas;

import com.gavilan.taskmanagerapirest.modelos.Tarea;
import com.gavilan.taskmanagerapirest.servicios.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ObtenerTareaController {

    private final TareaService tareaService;

    @GetMapping("/topics/{topicId}/tareas")
    public ResponseEntity<List<Tarea>> obtenerTodasTareasDeTopic(@PathVariable Long topicId) {
        List<Tarea> tareasTopic;

        try {
            tareasTopic = this.tareaService.obtenerTareasTopic(topicId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(tareasTopic, HttpStatus.OK);
    }

    @GetMapping("/topics/{topicId}/tareas/{tareaId}")
    public ResponseEntity<Tarea> obtenerTareaDeTopic(@PathVariable Long topicId, @PathVariable Long tareaId) {
        Tarea tarea;

        try {
            tarea = this.tareaService.obtenerTareaTopic(topicId, tareaId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(tarea, HttpStatus.OK);
    }

}
