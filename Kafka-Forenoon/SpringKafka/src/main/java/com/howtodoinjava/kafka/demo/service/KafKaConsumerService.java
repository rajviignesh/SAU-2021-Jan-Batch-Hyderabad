package com.howtodoinjava.kafka.demo.service;

import com.howtodoinjava.kafka.demo.model.Assignment;
import com.howtodoinjava.kafka.demo.model.Student;
import com.howtodoinjava.kafka.demo.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService 
{
	private final Logger logger 
		= LoggerFactory.getLogger(KafKaConsumerService.class);


	@KafkaListener(topics = "${student.topic.name}",
			groupId = "${student.topic.group.id}",
			containerFactory = "studentKafkaListenerContainerFactory")
	public void consume(Student student) {
		logger.info(String.format("Student created -> %s", student));
	}

	@KafkaListener(topics = "${teacher.topic.name}",
			groupId = "${teacher.topic.group.id}",
			containerFactory = "teacherKafkaListenerContainerFactory")
	public void consume(Teacher teacher) {
		logger.info(String.format("Teacher created -> %s", teacher));
	}

	@KafkaListener(topics = "${assignment.topic.name}",
			groupId = "${assignment.topic.group.id}",
			containerFactory = "assignmentKafkaListenerContainerFactory")
	public void consume(Assignment assignment) {
		logger.info(String.format("Assignment created -> %s", assignment));
	}
}
