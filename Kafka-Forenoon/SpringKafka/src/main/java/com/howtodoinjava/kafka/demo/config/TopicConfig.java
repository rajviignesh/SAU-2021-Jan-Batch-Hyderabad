package com.howtodoinjava.kafka.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class TopicConfig 
{
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;


	@Value(value = "${student.topic.name}")
	private String studentTopicName;

	@Value(value = "${teacher.topic.name}")
	private String teacherTopicName;

	@Value(value = "${assignment.topic.name}")
	private String assignmentTopicName;



	@Bean
	public NewTopic studentTopic() {
		return TopicBuilder.name(studentTopicName)
				.partitions(1)
				.replicas(1)
				.build();
	}

	@Bean
	public NewTopic teacherTopic() {
		return TopicBuilder.name(teacherTopicName)
				.partitions(1)
				.replicas(1)
				.build();
	}

	@Bean
	public NewTopic assignmentTopic() {
		return TopicBuilder.name(assignmentTopicName)
				.partitions(1)
				.replicas(1)
				.build();
	}
	//If not using spring boot
	
	@Bean
    public KafkaAdmin kafkaAdmin() 
	{
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
}
