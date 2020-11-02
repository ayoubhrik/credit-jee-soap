package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.Client;
import model.Credit;

public class CreditService {
	public int addClient(Client user) {
		 String INSERT_CLIENT_SQL = "INSERT INTO tclient" +
		            "  (username , adresse, mail, nom, password, prenom,tel,ville) VALUES " +
		            " (?, ?, ?, ?, ?,?,?,?);";

		        int result = 0;

		       
		        Connection connection = DB.getConnection();
		        try  {		            
		        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
		        	preparedStatement.setString(1, user.getUsername());
		            preparedStatement.setString(2, user.getAdresse());
		            preparedStatement.setString(3, user.getMail());
		            preparedStatement.setString(4, user.getNom());
		            preparedStatement.setString(5, user.getPassword());
		            preparedStatement.setString(6, user.getPrenom());
		            preparedStatement.setString(7, user.getTel());
		            preparedStatement.setString(8, user.getVille());
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            result = preparedStatement.executeUpdate();

		        } catch (SQLException e) {
		            
		        }
		        return result;
	 }

	 
	 public Client find(String username,String password) {
	        boolean status = false;
	        Client client = null;

	        Connection connection = DB.getConnection();
	        try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        try
	        {
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from tclient where username = ? and password = ? ");
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            System.out.println(rs);
	            status = rs.next();
	            if(status) {
	            	client = new Client();
	            	 client.setUsername(rs.getString(1));
	            	 client.setAdresse(rs.getString(2));
	            	 client.setMail(rs.getString(3));
	            	 client.setNom(rs.getString(4));
	            	 client.setPassword(rs.getString(5));
	            	 client.setPrenom(rs.getString(6));
	            	 client.setTel(rs.getString(7));
	            	 client.setVille(rs.getString(8));
	            }else {
	            	client = null;
	            }
	            
	            System.out.println(status);

	        } catch (SQLException e) {

	        }
	        return client;
	    }
	 public double annuelle(double taux) {
			return Math.pow(1+taux, (double)1/12)-1;
		}
		public double annuite(double capital,double t ,int duree) {
			double taux = annuelle(t);
			return (Math.pow(1+taux,duree)*taux*capital)/(Math.pow(1+taux,duree)-1);
		}
		public double capital(double annuite,double t ,int duree) {
			double taux = annuelle(t);
			return (Math.pow(1+taux,duree)*annuite-annuite)/(Math.pow(1+taux,duree)*taux);
		}
		public int duree(double capital,double annuite ,double t) {
			double taux = annuelle(t);
			return (int) ((Math.log(annuite/(annuite-taux*capital))/Math.log(1+taux))+0.5);
		}
		
		public List<Credit> getCreditsByUsername(String username) {
			List<Credit> credits = new ArrayList<Credit>();
			Connection connection = DB.getConnection();
			try {
				String CREDITS_BY_USERNAME = "select * from TCredit where username=?";
				PreparedStatement preparedStatement = connection.prepareStatement(CREDITS_BY_USERNAME);
				preparedStatement.setString(1, username);
				ResultSet result = preparedStatement.executeQuery();
				while (result.next()) {
					Credit credit = new Credit();
					credit.setNumcredit(result.getInt("numcredit"));
					credit.setDatecredit(result.getDate("datecredit"));
					credit.setMontant(result.getDouble("montant"));
					credit.setDuree(result.getInt("duree"));
					credit.setTaux(result.getDouble("taux"));
					credit.setAnnuite(result.getDouble("annuite"));
					credit.setDateprever(result.getDate("dateprever"));
					credit.setUsername(result.getString("username"));
					credits.add(credit);
				}
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return credits;
		}

		public int addCredit(Credit credit) {
			String ADD_CREDIT_SQL = "INSERT INTO tcredit"
					+ "  (datecredit , montant, duree, taux, annuite, dateprever,username) VALUES "
					+ " (?,?, ?, ?, ?, ?,?);";

			int result = 0;
			Connection connection = DB.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(ADD_CREDIT_SQL,Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setDate(1, credit.getDatecredit());
				preparedStatement.setDouble(2, credit.getMontant());
				preparedStatement.setInt(3, credit.getDuree());
				preparedStatement.setDouble(4, credit.getTaux());
				preparedStatement.setDouble(5, credit.getAnnuite());
				preparedStatement.setDate(6,credit.getDateprever());
				preparedStatement.setString(7, credit.getUsername());

				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();
				ResultSet answer = preparedStatement.getGeneratedKeys();
				if(answer.next()) {
					result = answer.getInt(1);
				}
				preparedStatement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		public int saveCredit(Credit credit) {
			String ADD_CREDIT_SQL = "INSERT INTO tcredit"
					+ "  (datecredit , montant, duree, taux, annuite, dateprever,username) VALUES "
					+ " (?, ?, ?, ?, ?,?,?);";

			int result = 0;
			Connection connection = DB.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(ADD_CREDIT_SQL);
				preparedStatement.setDate(1,credit.getDatecredit());
				preparedStatement.setDouble(2, credit.getMontant());
				preparedStatement.setInt(3, credit.getDuree());
				preparedStatement.setDouble(4, credit.getTaux());
				preparedStatement.setDouble(5, credit.getAnnuite());
				preparedStatement.setDate(6, credit.getDateprever());
				preparedStatement.setString(7, credit.getUsername());

				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				ResultSet answer = preparedStatement.getGeneratedKeys();
				if(answer.next()) {
					result = answer.getInt(1);
				}
				preparedStatement.close();
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		public void deleteCredit(int numcredit) {
			Connection connection = DB.getConnection();
			try {
				String DELETE_CREDIT = "DELETE FROM tcredit WHERE numcredit=?";
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CREDIT,Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, numcredit);
				preparedStatement.execute();
				preparedStatement.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
