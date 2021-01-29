package com.howtodoinjava.kafka.demo.service;

import com.howtodoinjava.kafka.demo.model.Assignment;
import com.howtodoinjava.kafka.demo.model.Student;
import com.howtodoinjava.kafka.demo.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafKaProducerService 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(KafKaProducerService.class);
	



	@Value(value = "${student.topic.name}")
	private String studentTopicName;

	@Value(value = "${teacher.topic.name}")
	private String teacherTopicName;

	@Value(value = "${assignment.topic.name}")
	private String assignmentTopicName;


	@Autowired
	private KafkaTemplate<String, Student> studentKafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Teacher> teacherKafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Assignment> assignmentKafkaTemplate;
	

	public void saveStudent(Student student)
	{
		ListenableFuture<SendResult<String, Student>> future
				= this.studentKafkaTemplate.send(studentTopicName, student);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Student>>() {
			@Override
			public void onSuccess(SendResult<String, Student> result) {
				logger.info("Student created: "
						+ student + " with offset: " + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Student created : " + student, ex);
			}
		});
	}

	public void saveTeacher(Teacher teacher)
	{
		ListenableFuture<SendResult<String, Teacher>> future
				= this.teacherKafkaTemplate.send(teacherTopicName, teacher);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Teacher>>() {
			@Override
			public void onSuccess(SendResult<String, Teacher> result) {
				logger.info("Teacher created: "
						+ teacher + " with offset: " + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Teacher created : " + teacher, ex);
			}
		});
	}

	public void saveAssignment(Assignment assignment)
	{
		ListenableFuture<SendResult<String, Assignment>> future
				= this.assignmentKafkaTemplate.send(assignmentTopicName, assignment);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Assignment>>() {
			@Override
			public void onSuccess(SendResult<String, Assignment> result) {
				logger.info("Assignment created: "
						+ assignment + " with offset: " + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Student created : " + assignment, ex);
			}
		});
	}
}
