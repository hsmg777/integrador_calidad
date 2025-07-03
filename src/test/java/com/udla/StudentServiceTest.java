package com.udla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void setup() {
        service = new StudentService();
    }

    @Test
    void testAddStudent_ShouldStoreStudentCorrectly() {
        service.addStudent("Andrea", 9.5);

        List<Student> students = service.getAllStudents();
        assertEquals(1, students.size(), "Debe haber un estudiante registrado.");
        assertEquals("Andrea", students.get(0).getName(), "El nombre no coincide.");
        assertEquals(9.5, students.get(0).getGrade(), 0.001, "La calificación no coincide.");
    }

    @Test
    void testGetAllStudents_ReturnsCopyOfList() {
        service.addStudent("Luis", 8.0);
        List<Student> externalList = service.getAllStudents();
        externalList.clear();

        // Asegura que no afecta la lista interna
        assertEquals(1, service.getAllStudents().size(), "La lista interna no debe verse afectada por cambios externos.");
    }

    @Test
    void testAddMultipleStudents() {
        service.addStudent("Pedro", 7.0);
        service.addStudent("Lucía", 9.0);

        List<Student> students = service.getAllStudents();
        assertEquals(2, students.size(), "Deben haberse agregado dos estudiantes.");
        assertEquals("Pedro", students.get(0).getName());
        assertEquals("Lucía", students.get(1).getName());
    }
}