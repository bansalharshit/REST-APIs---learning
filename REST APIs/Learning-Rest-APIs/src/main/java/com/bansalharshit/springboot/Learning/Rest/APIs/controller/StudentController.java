package com.bansalharshit.springboot.Learning.Rest.APIs.controller;

import com.bansalharshit.springboot.Learning.Rest.APIs.dto.AddStudentRequestDto;
import com.bansalharshit.springboot.Learning.Rest.APIs.dto.StudentDTO;
import com.bansalharshit.springboot.Learning.Rest.APIs.entity.Student;
import com.bansalharshit.springboot.Learning.Rest.APIs.repository.StudentRepository;
import com.bansalharshit.springboot.Learning.Rest.APIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents()
    {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.crateNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

}
