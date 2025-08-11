package com.bansalharshit.springboot.Learning.Rest.APIs.repository;

import com.bansalharshit.springboot.Learning.Rest.APIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
