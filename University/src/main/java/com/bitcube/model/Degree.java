package com.bitcube.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name="degreeIdSeq", initialValue=1, allocationSize=2)
public class Degree {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="degreeIdSeq")
	private long degreeId;
	private String degreeName;
	private int degreeDurationInYears;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Course> courses;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "degrees")
	private Lecturer lecturer;
	
}