package com.pm.doctorservice.controller;

import com.pm.doctorservice.service.DoctorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
@Tag(name = "Doctors", description = "API for managing Doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
//
//    @GetMapping
//    @Operation(summary = "Get Doctors")
//    public ResponseEntity<List<Doctor>> getDoctors() {
//        List<Doctor> doctors = doctorService.getDoctors();
//        return ResponseEntity.ok().body(doctors);
//    }
//
//    @PostMapping
//    @Operation(summary = "Create a new Doctor")
//    public ResponseEntity<Doctor> createDoctor(
//            @Validated({Default.class, CreateDoctorValidationGroup.class})
//            @RequestBody Doctor doctor) {
//        Doctor d
//    }
}
