 package com.manytoone.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class QuestionsManyToOne {
	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

	@OneToMany(mappedBy = "que",fetch = FetchType.EAGER)
private List<AnswerManyToOne>answerManyToOnes;
	public QuestionsManyToOne() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuestionsManyToOne(int questionId, String question, List<AnswerManyToOne> answerManyToOnes) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answerManyToOnes = answerManyToOnes;
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


	public List<AnswerManyToOne> getAnswerManyToOnes() {
		return answerManyToOnes;
	}


	public void setAnswerManyToOnes(List<AnswerManyToOne> answerManyToOnes) {
		this.answerManyToOnes = answerManyToOnes;
	}


	@Override
	public String toString() {
		return "QuestionsManyToOne [questionId=" + questionId + ", question=" + question + ", answerManyToOnes="
				+ answerManyToOnes + "]";
	}

	
}
