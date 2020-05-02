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

	public Participant getParticipant(String name) throws SQLException {
		String sql =  "SELECT * FROM PARTICIPANT WHERE PARTICIPANTNAME = ?";
		Participant participant = new Participant();

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				participant.setId(rs.getInt("ID"));
				participant.setPassword(rs.getString("PASSWORD"));
				participant.setNumber(rs.getInt("NUMBER"));
				participant.setGrade(rs.getInt("GRADE"));
				participant.setParticipantName(rs.getString("PARTICIPANTNAME"));
				participant.setRoomNumber(rs.getString("ROOMNUMBER"));
				participant.setDeleteflag(rs.getInt("deleteflag"));
				participant.setUpdateAt(rs.getTimestamp("updatedat"));
			}
			return participant;
		}

	}

	public int getId( ) throws SQLException {
		String sql =  "SELECT MAX(ID) as MAXNUMBER FROM PARTICIPANT";
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
		String sql =  "SELECT COUNT(*) AS CRM FROM PARTICIPANT WHERE roomnumber = ? and deleteflag = 0";
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
		String sql =  "SELECT * FROM PARTICIPANT WHERE deleteflag = 0";
		List<Participant> participants = new ArrayList<>();

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Participant participant = new Participant();

				participant.setId(rs.getInt("ID"));
				participant.setPassword(rs.getString("PASSWORD"));
				participant.setNumber(rs.getInt("NUMBER"));
				participant.setGrade(rs.getInt("GRADE"));
				participant.setParticipantName(rs.getString("PARTICIPANTNAME"));
				participant.setRoomNumber(rs.getString("ROOMNUMBER"));
				participant.setDeleteflag(rs.getInt("deleteflag"));
				participant.setUpdateAt(rs.getTimestamp("updatedat"));

				participants.add(participant);
			}

			return participants;
		}
	}

	public void setNumber(Participant participant) throws SQLException {
		String sql =  "UPDATE PARTICIPANT set roomnumber=? where id=?";

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, participant.getRoomNumber());
			ps.setInt(2, participant.getId());
			System.out.println(participant.getRoomNumber());

			ps.executeUpdate();

			}
		}

	public boolean checkName(String name) throws SQLException {
		String sql =  "SELECT * FROM participant WHERE Participantname = ? and deleteflag = 0";
		boolean check = false;
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name2 = (rs.getString("PARTICIPANTNAME"));
				if(name2 != null) {
					check = true;
				}
			}
		}
		return check;
	}


	public boolean checkPassword(String name, String password) throws SQLException {
		String sql =  "SELECT * FROM participant WHERE participantname = ?  AND password = ?";
		boolean check = false;
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			check = rs.next();
			}
		return check;
	}

	public void registerParticipant(Participant participant) throws SQLException {
		String sql =  "INSERT INTO PARTICIPANT (id, password, grade, participantname)VALUES(?, ?, ?, ?)";

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, participant.getId());
			ps.setString(2, participant.getPassword());
			ps.setInt(3, participant.getGrade());
			ps.setString(4, participant.getParticipantName());


			ps.executeUpdate();

			}
		}

	public void deleteParticipant(int id) throws SQLException {
		String sql =  "UPDATE PARTICIPANT SET deleteflag = ? WHERE id = ?";

		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, 1);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
	}

}
