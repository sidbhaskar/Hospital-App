package com.pm.doctorservice.service;

import com.pm.doctorservice.dto.DoctorRequestDTO;
import com.pm.doctorservice.dto.DoctorResponseDTO;
import com.pm.doctorservice.exception.EmailAlreadyExistsException;
import com.pm.doctorservice.mapper.DoctorMapper;
import com.pm.doctorservice.model.Doctor;
import com.pm.doctorservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorResponseDTO> getDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(DoctorMapper::toDTO).toList();
    }

    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        if(doctorRepository.existsByEmail(doctorRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email"
                    + "already exists" + doctorRequestDTO.getEmail());
        }
        Doctor newDoctor = doctorRepository.save(
                DoctorMapper.toEntity(doctorRequestDTO));
        return DoctorMapper.toDTO(newDoctor);
    }

    public void deletePatient(UUID id) {
        doctorRepository.deleteById(id);
    }
}
