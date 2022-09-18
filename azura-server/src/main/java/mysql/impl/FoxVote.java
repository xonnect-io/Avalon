package mysql.impl; // dont forget to change packaging ^-^

import com.ruse.GameSettings;
import com.ruse.motivote3.doMotivote;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.VoteBossDrop;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.entity.impl.player.Player;

import java.sql.*;


public class FoxVote implements Runnable {

	public static final String HOST = "195.179.236.205";
	public static final String USER = "u189330247_Vote";
	public static final String PASS = "n~7u^D:1";
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
			System.out.println("connected to vote database");

			String name = player.getUsername().replace("_", " ");
			ResultSet rs = executeQuery("SELECT * FROM fx_votes WHERE username='"+name+
					"' AND claimed=0 AND callback_date IS NOT NULL");

			int points = 2;
int claimedvote = 0;
			while (rs.next()) {
				String timestamp = rs.getTimestamp("callback_date").toString();
				String ipAddress = rs.getString("ip_address");
				int siteId = rs.getInt("site_id");

				// Double vote pet
				if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
						&& player.getSummoning().getFamiliar().getSummonNpc().getId() == 8802) {
					points *= 2;
				}

				if (GameSettings.DOUBLE_VOTE) {
					points *= 2;
				}
				if (GameSettings.CASES_ACTIVE && Misc.getRandom(1,2) == 2) {
					if (Misc.getRandom(10) > 5) {
						player.getInventory().add(23411, 1);
						player.getPacketSender().sendMessage("@blu@ x1 Seraphic case was added to your inventory from voting");
					} else 	if (Misc.getRandom(10) < 5) {
						player.getInventory().add(23412, 1);
						player.getPacketSender().sendMessage("@blu@ x1 Ethereal case was added to your inventory from voting");
					}
				}
				if (points > 2 &&
						Misc.getRandom(100) == 75 && player.getInventory().getFreeSlots() >= 1) {
					player.getInventory().add(10942, 1);
					player.getPacketSender().sendMessage("Thank you for voting! A $10 Bond was placed in your inventory.");
					World.sendMessage(player.getUsername() + " randomly received a $10 Bond voting for the server!");
					World.sendMessage("Vote on both top-lists for a chance to win a $10 bond when claiming!");
				}
				if (points > 2 &&
						Misc.getRandom(1000) == 750 && player.getInventory().getFreeSlots() >= 1) {
					player.getInventory().add(23240, 1);
					player.getPacketSender().sendMessage("Thank you for voting! an Owner jewelry bag was placed in your inventory.");
					World.sendMessage(player.getUsername() + " randomly received an Owner jewelry bag voting for the server!");
					World.sendMessage("Vote on both top-lists for a chance to win an Owner jewelry bag when claiming!");
				}
				player.getInventory().add(23020, points);
				player.getDailyRewards().handleVote();
				player.lastVoteTime = System.currentTimeMillis();
				player.setVoteCount(doMotivote.getVoteCount() + points);

				if (siteId == 2) {
					World.sendMessage(
							"<img=5>@cya@<shad=1>" + player.getUsername() + "<shad=0><col=bb43df> has just voted for the server");
							World.sendMessage(" Remember you can support us every 12 hours by typing the command ::vote");
				}

				player.getAchievementTracker().progress(AchievementData.SUPPORT_AVALON, 1);
				player.getAchievementTracker().progress(AchievementData.SUPPORTER, 1);
				player.getAchievementTracker().progress(AchievementData.MEGA_SUPPORTER, 1);
				player.getAchievementTracker().progress(AchievementData.VETERAN_VOTER, 1);
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