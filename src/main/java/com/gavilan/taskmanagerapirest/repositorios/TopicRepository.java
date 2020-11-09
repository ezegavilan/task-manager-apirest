package com.gavilan.taskmanagerapirest.repositorios;

import com.gavilan.taskmanagerapirest.modelos.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

}
