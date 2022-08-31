package com.manytoone.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AnswerManyToOne {

	@Id
	@Column(name="answer_id")
	 private int anserId;
	private String answer;
	
	@ManyToOne
	private QuestionsManyToOne que;
	
	 public AnswerManyToOne(int anserId, String answer) {
		super();
		this.anserId = anserId;
		this.answer = answer;
	}
	 
	@Override
	public String toString() {
		return "Answer [anserId=" + anserId + ", answer=" + answer + "]";
	}

	public AnswerManyToOne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAnserId() {
		return anserId;
	}
	public void setAnserId(int anserId) {
		this.anserId = anserId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionsManyToOne getQue() {
		return que;
	}

	public void setQue(QuestionsManyToOne que) {
		this.que = que;
	}

	
	
}
