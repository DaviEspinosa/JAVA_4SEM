package com.example.Service;

import com.example.Repository.MedicoRepository;
import com.example.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Método para salvar um médico
    public Medico saveMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Método para buscar todos os médicos
    public List<Medico> findAllMedicos() {
        return medicoRepository.findAll();
    }

    // Método para buscar um médico por ID
    public Medico findMedicoById(int id) {
        return medicoRepository.findById(id).orElse(null);
    }

    // Método para deletar um médico
    public void deleteMedico(int id) {
        medicoRepository.deleteById(id);
    }
}
