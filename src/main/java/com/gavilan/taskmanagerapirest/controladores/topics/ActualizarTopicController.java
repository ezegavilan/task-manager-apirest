package com.gavilan.taskmanagerapirest.controladores.topics;

import com.gavilan.taskmanagerapirest.modelos.Topic;
import com.gavilan.taskmanagerapirest.servicios.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ActualizarTopicController {

    private final TopicService topicService;

    @PutMapping("/topics/{topicId}")
    public ResponseEntity<Topic> actualizarTopic(@PathVariable Long topicId, @RequestBody Topic topic) {
        Topic topicActualizado;

        try {
            topicActualizado = this.topicService.actualizarTopic(topicId, topic);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(topicActualizado, HttpStatus.CREATED);
    }

}
