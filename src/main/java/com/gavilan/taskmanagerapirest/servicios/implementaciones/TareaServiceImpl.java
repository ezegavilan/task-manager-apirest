package com.gavilan.taskmanagerapirest.servicios.implementaciones;

import com.gavilan.taskmanagerapirest.modelos.Tarea;
import com.gavilan.taskmanagerapirest.modelos.Topic;
import com.gavilan.taskmanagerapirest.repositorios.TareaRepository;
import com.gavilan.taskmanagerapirest.repositorios.TopicRepository;
import com.gavilan.taskmanagerapirest.servicios.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TareaServiceImpl implements TareaService {

    private final TopicRepository topicRepository;
    private final TareaRepository tareaRepository;

    @Transactional
    @Override
    public Tarea nuevaTarea(Long topicId, Tarea tarea) {
        Topic topic = this.obtenerTopic(topicId);
        tarea.setTopic(topic);
        return this.tareaRepository.save(tarea);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tarea> obtenerTareasTopic(Long topicId) {
        Topic topic = this.obtenerTopic(topicId);

        return this.tareaRepository.findAllByTopic(topic);
    }

    @Transactional(readOnly = true)
    @Override
    public Tarea obtenerTareaTopic(Long topicId, Long tareaId) {
        Topic topic = this.obtenerTopic(topicId);

        return this.tareaRepository.findByTopicAndId(topic, tareaId);
    }

    @Transactional
    @Override
    public Tarea actualizarTareaTopic(Long topicId, Long tareaId, Tarea tarea) {
        Topic topic = this.obtenerTopic(topicId);
        Tarea tareaGuardada = this.tareaRepository.findByTopicAndId(topic, tareaId);
        tareaGuardada.setTitulo(tarea.getTitulo());

        return this.tareaRepository.save(tareaGuardada);
    }

    @Transactional
    @Override
    public void eliminarTarea(Long topicId, Long tareaId) {
        Topic topic = this.obtenerTopic(topicId);

        this.tareaRepository.deleteByTopicAndId(topic, tareaId);
    }

    private Topic obtenerTopic(Long topicId) {
        return this.topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic: " + topicId + " no encontrado."));
    }
}
