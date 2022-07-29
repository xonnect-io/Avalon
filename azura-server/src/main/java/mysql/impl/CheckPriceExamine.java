package mysql.impl;


import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

import java.sql.*;


public class CheckPriceExamine implements Runnable{

    private static int voteCount = 0;

    public static final String HOST = "195.179.236.205";
    public static final String USER = "u189330247_Vote";
    public static final String PASS = "n~Pu^]:8";
    public static final String DATABASE = "u189330247_Vote";
    private Player player;

    private int itemid;


    private Connection conn;
    private Statement stmt;

    public CheckPriceExamine(Player player, int itemId) {
        this.player = player;
        this.itemid = itemId;
    }

    @Override
    public void run() {
        try {

            if (!connect(HOST, DATABASE, USER, PASS)) {
                return;
            }

            ResultSet rs = executeQuery("SELECT * FROM averageprice WHERE itemId='" + itemid + "'");

            if(rs.next()) {

                int theaverageprice =   rs.getInt("avgprice");
                String name = ItemDefinition.forId(itemid).getName();

                player.sendMessage("@bla@<img=30>[PRICE CHECK] <col=5e0606>" + name
                        + ": <col=06195e>Value of this item is : <col=065e16> " + Misc.formatNumber(theaverageprice) + " Upgrade Tokens.");
            } else {
                player.sendMessage("Item has no average price yet.");
            }



            destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean connect(String host, String database, String user, String pass) {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, user, pass);
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
        } catch (Exception e) {
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
