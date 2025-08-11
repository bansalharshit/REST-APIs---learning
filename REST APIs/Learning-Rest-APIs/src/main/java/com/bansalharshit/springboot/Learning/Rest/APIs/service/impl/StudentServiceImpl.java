package com.bansalharshit.springboot.Learning.Rest.APIs.service.impl;

import com.bansalharshit.springboot.Learning.Rest.APIs.dto.AddStudentRequestDto;
import com.bansalharshit.springboot.Learning.Rest.APIs.dto.StudentDTO;
import com.bansalharshit.springboot.Learning.Rest.APIs.entity.Student;
import com.bansalharshit.springboot.Learning.Rest.APIs.repository.StudentRepository;
import com.bansalharshit.springboot.Learning.Rest.APIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> StudentsList = students
                .stream()
                .map(student -> modelMapper.map(student,StudentDTO.class))
                .toList();
        return StudentsList;
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No Student Found with Id "+id));
        StudentDTO studentById = modelMapper.map(student,StudentDTO.class);
        return studentById;
    }

    @Override
    public StudentDTO crateNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id))
            throw new IllegalArgumentException("Student does not exist by id "+ id);
        studentRepository.deleteById(id);
    }
}
