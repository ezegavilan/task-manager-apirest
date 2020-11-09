package com.gavilan.taskmanagerapirest.controladores.topics;

import com.gavilan.taskmanagerapirest.servicios.TopicService;
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
public class EliminarTopicController {

    private final TopicService topicService;

    @DeleteMapping("/topics/{topicId}")
    public ResponseEntity<String> eliminarTopicPorId(@PathVariable Long topicId) {
        String mensaje;

        try {
            this.topicService.eliminarTopic(topicId);
            mensaje = "Topic: ".concat(topicId.toString()).concat(" eliminado.");
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

}
