package com.gavilan.taskmanagerapirest.repositorios;

import com.gavilan.taskmanagerapirest.modelos.Tarea;
import com.gavilan.taskmanagerapirest.modelos.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {

    List<Tarea> findAllByTopic(Topic topic);

    Tarea findByTopicAndId(Topic topic, Long id);

    void deleteByTopicAndId(Topic topic, Long id);
}
