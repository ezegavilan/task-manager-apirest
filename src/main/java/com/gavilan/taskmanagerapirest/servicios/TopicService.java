package com.gavilan.taskmanagerapirest.servicios;

import com.gavilan.taskmanagerapirest.modelos.Topic;

import java.util.List;

public interface TopicService {

    Topic nuevoTopic(Topic topic);

    List<Topic> obtenerTopics();

    Topic obtenerTopic(Long topicId);

    Topic actualizarTopic(Long topicId, Topic topic);

    void eliminarTopic(Long topicId);
}
