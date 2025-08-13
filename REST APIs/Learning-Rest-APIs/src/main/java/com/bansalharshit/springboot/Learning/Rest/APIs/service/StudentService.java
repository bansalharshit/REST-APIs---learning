package com.bansalharshit.springboot.Learning.Rest.APIs.service;

import com.bansalharshit.springboot.Learning.Rest.APIs.dto.AddStudentRequestDto;
import com.bansalharshit.springboot.Learning.Rest.APIs.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO crateNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}
