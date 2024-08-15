package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.Student_DTO;
import com.example.service.StudentServiceImple;

@RestController
public class StudentController {

	private StudentServiceImple studentService;
    ///setter injection
    @Autowired
    public void setStudentService(StudentServiceImple studentService) {
        this.studentService = studentService;
    }
	 
    @PostMapping("/add") 
    public Student_DTO add(@RequestBody Student_DTO dt) {
   	 return studentService.add(dt); 
   	 
   	    }
   	   
    @GetMapping("/getAllstudent")
    public List<Student_DTO> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @GetMapping("getStudentById/{id}")
    public Student_DTO getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
       
    
    
    @PutMapping("/updateStudentById/{id}")
    public Student_DTO updateStudentById(@PathVariable int id, @RequestBody Student_DTO studentDto) {
        return studentService.updateStudentById(id, studentDto);
    }
    
    @PatchMapping("/{id}")
    public Student_DTO patchStudentById(@PathVariable int id, @RequestBody Student_DTO studentDto) {
        return studentService.patchStudentById(id, studentDto);
    }
    
    @DeleteMapping("deleteStudentById/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }
    
    
}
