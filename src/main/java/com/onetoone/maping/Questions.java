package com.onetoone.maping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Questions {
	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;


	@OneToOne
	@JoinColumn(name = "ans_id")
	private Answer answer;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(int questionId, String question, Answer answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", question=" + question + ", answer=" + answer + "]";
	}
}
