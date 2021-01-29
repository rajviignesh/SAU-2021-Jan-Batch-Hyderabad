package com.howtodoinjava.kafka.demo.controller;

import com.howtodoinjava.kafka.demo.model.Assignment;
import com.howtodoinjava.kafka.demo.model.Student;
import com.howtodoinjava.kafka.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.kafka.demo.service.KafKaProducerService;

import java.util.Date;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
	private final KafKaProducerService producerService;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService) {
		this.producerService = producerService;
	}



	@PostMapping(value = "/createStudent")
	public void sendMessageToStudentTopic(@RequestParam("studentId") long studentId,
										@RequestParam("studentName") String studentName,
										@RequestParam("studentStd") String studentStd) {


		Student student = new Student(studentId,studentName,studentStd);
		this.producerService.saveStudent(student);
	}

	@PostMapping(value = "/createTeacher")
	public void sendMessageToTeacher(@RequestParam("teacherId") int teacherId,
										@RequestParam("teacherName") String teacherName,
										@RequestParam("teacherDesg") String teacherDesg) {

		Teacher teacher = new Teacher(teacherId,teacherName,teacherDesg);
		this.producerService.saveTeacher(teacher);
	}

	@PostMapping(value = "/createAssignment")
	public void sendMessageToKafkaTopic(@RequestParam("studentId") int studentId,
										@RequestParam("studentName") String studentName) {
		Assignment assignment = new Assignment(studentId,studentName,new Date());
		this.producerService.saveAssignment(assignment);
	}
}