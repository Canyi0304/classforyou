package com.my.vo;

import java.util.Date;

public class QNA {
	private int qnaId;
	private String qnaTitle;
	private Date qnaDate;
	private String qnaContent;
<<<<<<< HEAD
	private String qnaComment; //ï¿½Ê±â°ª null ï¿½ï¿½ï¿½ï¿½ï¿½Ì¶ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ú¿ï¿½ ï¿½ï¿½ï¿½ï¿½ X
=======
	private String qnaComment; //ÃÊ±â°ª null °¡´ÉÀÌ¶ó »ý¼ºÀÚ¿¡ º¯¼ö X
>>>>>>> 46ca08275f8b870f43c777dd38650217b687c4e7
	private Student student;
	public QNA(int qnaId, String qnaTitle, Date qnaDate, String qnaContent, Student student) {
		super();
		this.qnaId = qnaId;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.qnaContent = qnaContent;
		this.student = student;
	}
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaComment() {
		return qnaComment;
	}
	public void setQnaComment(String qnaComment) {
		this.qnaComment = qnaComment;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "QNA [qnaId=" + qnaId + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaComment="
				+ qnaComment + "]";
	}
}
