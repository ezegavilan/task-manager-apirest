package com.gavilan.taskmanagerapirest.controladores.topics;

import com.gavilan.taskmanagerapirest.modelos.Topic;
import com.gavilan.taskmanagerapirest.servicios.TopicService;
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
public class ObtenerTopicController {

    private final TopicService topicService;

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> obtenerTodosLosTopics() {
        List<Topic> topics;

        try {
            topics = this.topicService.obtenerTopics();
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        if (topics.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/topics/{topicId}")
    public ResponseEntity<Topic> obtenerTopicPorId(@PathVariable Long topicId) {
        Topic topic;

        try {
            topic = this.topicService.obtenerTopic(topicId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

}
