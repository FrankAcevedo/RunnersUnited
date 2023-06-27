package com.upao.runnersunited.controller;
import com.upao.runnersunited.domain.Progreso;
import com.upao.runnersunited.repository.ProgresoRepository;
import com.upao.runnersunited.validators.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progreso")
public class ProgresoController {
    @Autowired
    private ProgresoRepository progresoRepository;

    @GetMapping
    public List<Progreso> obtenerProgresos() {
        return progresoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Progreso obtenerProgresoPorId(@PathVariable Long id) {
        return progresoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Progreso no encontrado"));
    }

    @PostMapping
    public Progreso crearProgreso(@RequestBody Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    @PutMapping("/{id}")
    public Progreso actualizarProgreso(@PathVariable Long id, @RequestBody Progreso progresoActualizado) {
        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Progreso no encontrado"));

        progreso.setUsuario(progresoActualizado.getUsuario());
        progreso.setRutina(progresoActualizado.getRutina());
        progreso.setFechaInicio(progresoActualizado.getFechaInicio());
        progreso.setFechaFin(progresoActualizado.getFechaFin());
        progreso.setProgreso(progresoActualizado.getProgreso());

        return progresoRepository.save(progreso);
    }

    @DeleteMapping("/{id}")
    public void eliminarProgreso(@PathVariable Long id) {
        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Progreso no encontrado"));

        progresoRepository.delete(progreso);
    }
}

