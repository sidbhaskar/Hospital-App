package com.pm.doctorservice.mapper;

import com.pm.doctorservice.dto.DoctorRequestDTO;
import com.pm.doctorservice.dto.DoctorResponseDTO;
import com.pm.doctorservice.model.Doctor;

public class DoctorMapper {
    public static DoctorResponseDTO toDTO(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setId(doctor.getId().toString());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setEmail(doctor.getEmail());
        doctorResponseDTO.setSpecialization(doctor.getSpecialization());
        return doctorResponseDTO;
    }

    public static Doctor toEntity(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequestDTO.getName());
        doctor.setEmail(doctorRequestDTO.getEmail());
        doctor.setSpecialization(doctorRequestDTO.getSpecialization());
        return doctor;

    }
}
