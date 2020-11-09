package com.gavilan.taskmanagerapirest.controladores.topics;

import com.gavilan.taskmanagerapirest.modelos.Topic;
import com.gavilan.taskmanagerapirest.servicios.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NuevoTopicController {

    private final TopicService topicService;

    @PostMapping("/topics")
    public ResponseEntity<Topic> crearNuevoTopic(@RequestBody Topic topic) {
        Topic nuevoTopic;

        try {
            nuevoTopic = this.topicService.nuevoTopic(topic);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(nuevoTopic, HttpStatus.CREATED);
    }

}
