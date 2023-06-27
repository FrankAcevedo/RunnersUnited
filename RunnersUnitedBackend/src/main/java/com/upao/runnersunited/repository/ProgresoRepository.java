package com.upao.runnersunited.repository;

import com.upao.runnersunited.domain.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgresoRepository extends JpaRepository<Progreso,Long> {

}
