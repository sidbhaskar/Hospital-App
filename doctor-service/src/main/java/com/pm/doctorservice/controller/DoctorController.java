package com.pm.doctorservice.controller;

import com.pm.doctorservice.dto.DoctorRequestDTO;
import com.pm.doctorservice.dto.DoctorResponseDTO;
import com.pm.doctorservice.dto.validator.CreateDoctorValidationGroup;
import com.pm.doctorservice.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctors")
@Tag(name = "Doctors", description = "API for managing Doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    @Operation(summary = "Get Doctors")
    public ResponseEntity<List<DoctorResponseDTO>> getDoctors() {
        List<DoctorResponseDTO> doctors = doctorService.getDoctors();
        return ResponseEntity.ok().body(doctors);
    }

    @PostMapping
    @Operation(summary = "Create a new Doctor")
    public ResponseEntity<DoctorResponseDTO> createDoctor(
            @Validated({Default.class, CreateDoctorValidationGroup.class})
            @RequestBody DoctorRequestDTO  doctorRequestDTO) {
        DoctorResponseDTO doctorResponseDTO = doctorService.createDoctor(doctorRequestDTO);
        return ResponseEntity.ok().body(doctorResponseDTO);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Patient")
    public ResponseEntity<DoctorResponseDTO> deletePatient(@PathVariable UUID id) {
        doctorService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
