package com.alura.forohub.forohub.repository;

import com.alura.forohub.forohub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByCurso(String curso);

    List<Topico> findByCursoAndFechaCreacionBetween(String curso, LocalDateTime inicio, LocalDateTime fin);
}

