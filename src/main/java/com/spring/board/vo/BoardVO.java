package com.spring.board.vo;

public class BoardVO {

	 private int no; // 게시판 번호
	 private String boardNo; //index 번호
	 private String content;
	 private String title;
	 private String writeDate;
	 private String name;
	
	public String getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	 
}
