package com.example.ravi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "request")
public class Request {

	private Long id;

	@JsonIgnore
	@Column(name = "jsonString")
	private String jsonString;

	@Transient
	private JsonNode json;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Getter and setter for name

	@Transient // This is for Jackson
	public JsonNode getJson() {
		return json;
	}

	public void setJson(JsonNode json) {
		this.json = json;
	}

	@JsonIgnore
	public String getJsonString() { // This is for JPA
		return this.json.toString();
	}

	public void setJsonString(String jsonString) { // This is for JPA
		// parse from String to JsonNode object
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.json = mapper.readTree(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}