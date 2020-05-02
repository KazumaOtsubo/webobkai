package model;

import java.sql.Timestamp;

public class Participant {
	private int id;

	private String password;

	private int number;

	private String participantName;

	private String roomNumber;

	private  int deleteflag;

	private Timestamp updateAt;

	private int grade;

	private int host;


	public Participant() {

	}

	public Participant(int number, String participantName) {
		this.number = number;
		this.participantName = participantName;
	}

	public Participant(int number, String participantName, String roomNumber) {
		this.number = number;
		this.participantName = participantName;
		this.roomNumber = roomNumber;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(int deleteflag) {
		this.deleteflag = deleteflag;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getHost() {
		return host;
	}

	public void setHost(int host) {
		this.host = host;
	}
}
