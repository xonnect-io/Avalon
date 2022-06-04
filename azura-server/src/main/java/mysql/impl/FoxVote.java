package mysql.impl; // dont forget to change packaging ^-^

import com.azul.crs.client.Client;
import com.ruse.GameSettings;
import com.ruse.motivote3.doMotivote;
import com.ruse.world.World;
import com.ruse.world.content.VoteBossDrop;
import com.ruse.world.entity.impl.player.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FoxVote implements Runnable {

	public static final String HOST = "195.179.236.205";
	public static final String USER = "u189330247_Vote";
	public static final String PASS = "8ytqy63zYrAUGWz";
	public static final String DATABASE = "u189330247_Vote";

	private Player player;
	private Connection conn;
	private Statement stmt;

	public FoxVote(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		try {
			if (!connect(HOST, DATABASE, USER, PASS)) {
				return;
			}

			String name = player.getUsername().replace("_", " ");
			ResultSet rs = executeQuery("SELECT * FROM fx_votes WHERE username='"+name+"' AND claimed=0 AND callback_date IS NOT NULL");

			int points = 2;
			while (rs.next()) {
				String timestamp = rs.getTimestamp("callback_date").toString();
				String ipAddress = rs.getString("ip_address");
				int siteId = rs.getInt("site_id");


				// Double vote pet
				if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
						&& player.getSummoning().getFamiliar().getSummonNpc().getId() == 8802) {
					points *= 2;
					player.getPacketSender()
							.sendMessage("<shad=1>@yel@You get an extra vote scroll because of your pet!");
				}

				if (GameSettings.DOUBLE_VOTE) {
					points *= 2;
				}

				World.sendMessage("<img=5>" + player.getUsername() + " has voted for " + points
						+ " Vote scrolls! ::vote now to support the server.");
				player.getInventory().add(23020, points);
				player.getPacketSender().sendMessage("Thank you for voting!");
				player.getDailyRewards().handleVote();
				player.lastVoteTime = System.currentTimeMillis();
				player.setVoteCount(doMotivote.getVoteCount() + points);

				if (doMotivote.getVoteCount() >= 60) {
					VoteBossDrop.handleSpawn();
				}


				//	}

				System.out.println("[Vote] Vote claimed by "+name+". (sid: "+siteId+", ip: "+ipAddress+")");

				rs.updateInt("claimed", 1); // do not delete otherwise they can reclaim!
				rs.updateRow();
			}

			destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public boolean connect(String host, String database, String user, String pass) {
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, user, pass);
			return true;
		} catch (SQLException e) {
			System.out.println("Failing connecting to database!");
			return false;
		}
	}

	public void destroy() {
		try {
			conn.close();
			conn = null;
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int executeUpdate(String query) {
		try {
			this.stmt = this.conn.createStatement(1005, 1008);
			int results = stmt.executeUpdate(query);
			return results;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public ResultSet executeQuery(String query) {
		try {
			this.stmt = this.conn.createStatement(1005, 1008);
			ResultSet results = stmt.executeQuery(query);
			return results;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}