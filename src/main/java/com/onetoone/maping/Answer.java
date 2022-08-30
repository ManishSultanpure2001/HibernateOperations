package com.onetoone.maping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@Column(name="answer_id")
	 private int anserId;
	private String answer;
	
	@OneToOne(mappedBy = "answer") 
	private Questions que;
	
	 public Answer(int anserId, String answer) {
		super();
		this.anserId = anserId;
		this.answer = answer;
	}
	 
	@Override
	public String toString() {
		return "Answer [anserId=" + anserId + ", answer=" + answer + "]";
	}

	public Answer() {
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

	public Questions getQue() {
		return que;
	}

	public void setQue(Questions que) {
		this.que = que;
	}

	
	
}
