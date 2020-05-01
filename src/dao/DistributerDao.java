package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Participant;

public class DistributerDao {

	protected Connection con;

	public DistributerDao(Connection con) {
		this.con = con;
	}

	public Participant getParticipant(int number) throws SQLException {
		String sql =  "SELECT * FROM PARTICIPANT WHERE number = ?";
		Participant participant = new Participant();

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, number);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				participant = new Participant (rs.getInt("NUMBER"), rs.getString("PARTICIPANTNAME"), rs.getString("ROOMNUMBER"));
			}
			return participant;
		}

	}

	public int getNumber( ) throws SQLException {
		String sql =  "SELECT MAX(number) as MAXNUMBER FROM PARTICIPANT";
		int maxNumber = 0;

		try(PreparedStatement ps = con.prepareStatement(sql)){

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				maxNumber  = rs.getInt("MAXNUMBER");
			}
		}
		return maxNumber + 1;
	}

	public int countRoomNumber( String roomNumber) throws SQLException {
		String sql =  "SELECT COUNT(*) AS CRM FROM PARTICIPANT WHERE roomnumber = ?";
		int countRoomNumber = 0;

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, roomNumber);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				countRoomNumber =  rs.getInt("CRM");
			}
		}
		return countRoomNumber;
	}


	public List<Participant> findAll() throws SQLException{
		String sql =  "SELECT * FROM PARTICIPANT";

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			List<Participant> participants = new ArrayList<>();

			while(rs.next()) {
				Participant participant = new Participant (rs.getInt("NUMBER"), rs.getString("PARTICIPANTNAME"), rs.getString("ROOMNUMBER"));

				participants.add(participant);
			}

			return participants;
		}
	}

	public void registerParticipant(Participant participant) throws SQLException {
		String sql =  "INSERT INTO PARTICIPANT VALUES(?, ?, ?)";

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, participant.getNumber());
			ps.setString(2, participant.getParticipantName());
			ps.setString(3, participant.getRoomNumber());

			ps.executeUpdate();

			}
		}

	public void deleteParticipant(int number) throws SQLException {
		String sql =  "DELETE FROM participant WHERE NUMBER = ?";

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, number);
			ps.executeUpdate();
		}
	}

}
