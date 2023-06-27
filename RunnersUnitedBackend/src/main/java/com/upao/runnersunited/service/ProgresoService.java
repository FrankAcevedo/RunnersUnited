package com.upao.runnersunited.service;

import com.upao.runnersunited.domain.Progreso;

import java.util.List;

public interface ProgresoService {
    List<Progreso> obtenerTodosLosProgresos();
    Progreso obtenerProgresoPorId(Long id);
    Progreso crearProgreso(Progreso progreso);
    Progreso actualizarProgreso(Long id, Progreso progresoActualizado);
    void eliminarProgreso(Long id);
}
