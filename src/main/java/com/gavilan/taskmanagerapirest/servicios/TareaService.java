package com.gavilan.taskmanagerapirest.servicios;

import com.gavilan.taskmanagerapirest.modelos.Tarea;

import java.util.List;

public interface TareaService {

    Tarea nuevaTarea(Long topicId, Tarea tarea);

    List<Tarea> obtenerTareasTopic(Long topicId);

    Tarea obtenerTareaTopic(Long topicId, Long tareaId);

    Tarea actualizarTareaTopic(Long topicId, Long tareaId, Tarea tarea);

    void eliminarTarea(Long topicId, Long tareaId);
}
