package com.seleniumexpress.selexplms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lessons")
public class Lesson {

	//lesson_id, lesson_text, link, lesson_name, course_id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int id;

	@Column(name = "lesson_text")
	private String lessonText;

	@Column(name = "link")
	private String link;

	@Column(name = "lesson_name")
	private String lessonName;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLessonText() {
		return lessonText;
	}

	public void setLessonText(String lessonText) {
		this.lessonText = lessonText;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
