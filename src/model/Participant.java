package model;

public class Participant {

	private int number;

	private String participantName;

	private String roomNumber;

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
}
