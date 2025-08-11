package com.bansalharshit.springboot.Learning.Rest.APIs.service;

import com.bansalharshit.springboot.Learning.Rest.APIs.dto.AddStudentRequestDto;
import com.bansalharshit.springboot.Learning.Rest.APIs.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO crateNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);
}
