package com.gavilan.taskmanagerapirest.servicios.implementaciones;

import com.gavilan.taskmanagerapirest.modelos.Topic;
import com.gavilan.taskmanagerapirest.repositorios.TopicRepository;
import com.gavilan.taskmanagerapirest.servicios.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Transactional
    @Override
    public Topic nuevoTopic(Topic topic) {
        return this.topicRepository.save(topic);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Topic> obtenerTopics() {
        return (List<Topic>) this.topicRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Topic obtenerTopic(Long topicId) {
        return this.topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("No existe Topic con id: " + topicId));
    }

    @Transactional
    @Override
    public Topic actualizarTopic(Long topicId, Topic topic) {
        Topic topicGuardado = this.topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("No existe Topic con id: " + topicId));

        topicGuardado.setTitulo(topic.getTitulo());

        return this.topicRepository.save(topicGuardado);
    }

    @Transactional
    @Override
    public void eliminarTopic(Long topicId) {
        this.topicRepository.deleteById(topicId);
    }
}
