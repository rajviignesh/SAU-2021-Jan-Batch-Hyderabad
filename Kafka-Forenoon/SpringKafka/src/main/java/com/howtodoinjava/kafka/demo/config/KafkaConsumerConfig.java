package com.howtodoinjava.kafka.demo.config;

import java.util.HashMap;
import java.util.Map;

import com.howtodoinjava.kafka.demo.model.Assignment;
import com.howtodoinjava.kafka.demo.model.Student;
import com.howtodoinjava.kafka.demo.model.Teacher;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig 
{
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;


	@Value(value = "${student.topic.group.id}")
	private String studentGroupId;

	@Value(value = "${teacher.topic.group.id}")
	private String teacherGroupId;

	@Value(value = "${assignment.topic.group.id}")
	private String assignmentGroupId;


	public ConsumerFactory<String, Student> studentConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, studentGroupId);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(props,
				new StringDeserializer(),
				new JsonDeserializer<>(Student.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Student>
	studentKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Student> factory
				= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(studentConsumerFactory());
		return factory;
	}

	public ConsumerFactory<String, Teacher> teacherConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, teacherGroupId);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(props,
				new StringDeserializer(),
				new JsonDeserializer<>(Teacher.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Teacher>
	teacherKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Teacher> factory
				= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(teacherConsumerFactory());
		return factory;
	}

	public ConsumerFactory<String, Assignment> assignmentConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, assignmentGroupId);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(props,
				new StringDeserializer(),
				new JsonDeserializer<>(Assignment.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Assignment>
	assignmentKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Assignment> factory
				= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(assignmentConsumerFactory());
		return factory;
	}
}
