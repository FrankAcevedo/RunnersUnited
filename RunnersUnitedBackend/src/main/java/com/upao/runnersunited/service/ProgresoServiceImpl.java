package com.upao.runnersunited.service;
import com.upao.runnersunited.domain.Progreso;
import com.upao.runnersunited.repository.ProgresoRepository;
import com.upao.runnersunited.validators.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProgresoServiceImpl implements ProgresoService {

    private final ProgresoRepository progresoRepository;

    @Autowired
    public ProgresoServiceImpl(ProgresoRepository progresoRepository) {
        this.progresoRepository = progresoRepository;
    }

    @Override
    public List<Progreso> obtenerTodosLosProgresos() {
        return progresoRepository.findAll();
    }

    @Override
    public Progreso obtenerProgresoPorId(Long id) {
        return progresoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Progreso no encontrado"));
    }

    @Override
    public Progreso crearProgreso(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    @Override
    public Progreso actualizarProgreso(Long id, Progreso progresoActualizado) {
        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Progreso no encontrado"));

        progreso.setUsuario(progresoActualizado.getUsuario());
        progreso.setRutina(progresoActualizado.getRutina());
        progreso.setFechaInicio(progresoActualizado.getFechaInicio());
        progreso.setFechaFin(progresoActualizado.getFechaFin());
        progreso.setProgreso(progresoActualizado.getProgreso());

        return progresoRepository.save(progreso);
    }

    @Override
    public void eliminarProgreso(Long id) {
        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Progreso no encontrado"));

        progresoRepository.delete(progreso);
    }
}

