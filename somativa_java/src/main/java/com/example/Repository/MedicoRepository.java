package com.example.Repository;

import com.example.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    // Aqui você pode adicionar métodos de consulta personalizados, se necessário
}
