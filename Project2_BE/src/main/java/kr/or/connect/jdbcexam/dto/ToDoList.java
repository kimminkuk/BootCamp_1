package kr.or.connect.jdbcexam.dto;

import java.sql.Date;
import java.util.Calendar;

public class ToDoList {
    private Integer ToDoId;
    private Date ToDoDate;
    private String ToDoWork;
    private String ToDoWho;
    private Integer ToDoPriority;
    
    public ToDoList() {
    	
    }

	public ToDoList(Integer toDoId, Date toDoDate, String toDoWork, String toDoWho,
			Integer toDoPriority) {
		super();
		ToDoId = toDoId;
		ToDoDate = toDoDate;
		ToDoWork = toDoWork;
		ToDoWho = toDoWho;
		ToDoPriority = toDoPriority;
	}

	@Override
	public String toString() {
		return "ToDoList [ToDoId=" + ToDoId + ", ToDoDate=" + ToDoDate + ", ToDoWork="
				+ ToDoWork + ", ToDoWho=" + ToDoWho + ", ToDoPriority=" + ToDoPriority + "]";
	}

	public Integer getToDoId() {
		return ToDoId;
	}

	public void setToDoId(Integer toDoId) {
		ToDoId = toDoId;
	}

	public Date getToDoDate() {
		return ToDoDate;
	}

	public void setToDoDate(Date toDoDate) {
		ToDoDate = toDoDate;
	}

	public String getToDoWork() {
		return ToDoWork;
	}

	public void setToDoWork(String toDoWork) {
		ToDoWork = toDoWork;
	}

	public String getToDoWho() {
		return ToDoWho;
	}

	public void setToDoWho(String toDoWho) {
		ToDoWho = toDoWho;
	}

	public Integer getToDoPriority() {
		return ToDoPriority;
	}

	public void setToDoPriority(Integer toDoPriority) {
		ToDoPriority = toDoPriority;
	}
    
}
