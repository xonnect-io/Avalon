package mysql.impl;

import com.ruse.GameSettings;
import com.ruse.model.PlayerRights;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.PlayerLogs;
import com.ruse.world.entity.impl.player.Player;

import java.sql.*;

public class Store implements Runnable {

    public static final String HOST = "195.179.236.205";
    public static final String USER = "u189330247_Vote";
    public static final String PASS = "n~7u^D:1";
    public static final String DATABASE = "u189330247_Vote";

    private Player player;
    private Connection conn;
    private Statement stmt;

    /**
     * The constructor
     *
     * @param player
     */
    public Store(Player player) {this.player = player;}

    public static final int SAPPHIRE_DONATION_AMOUNT = 10;
    public static final int EMERALD_DONATION_AMOUNT = 50;
    public static final int RUBY_DONATION_AMOUNT = 250;
    public static final int DIAMOND_DONATION_AMOUNT = 500;
    public static final int ONYX_DONATION_AMOUNT = 2500;
    public static final int ZENYTE_DONATION_AMOUNT = 5000;
    public static final int TANZANITE_DONATION_AMOUNT = 10000;

    public static void checkForRankUpdate(Player player) {
        if (player.getRights().isStaff()) {
            return;
        }
        PlayerRights rights = null;
        if (player.getAmountDonated() >= SAPPHIRE_DONATION_AMOUNT)
            rights = PlayerRights.SAPPHIRE_DONATOR;
        if (player.getAmountDonated() >= EMERALD_DONATION_AMOUNT)
            rights = PlayerRights.EMERALD_DONATOR;
        if (player.getAmountDonated() >= RUBY_DONATION_AMOUNT)
            rights = PlayerRights.RUBY_DONATOR;
        if (player.getAmountDonated() >= DIAMOND_DONATION_AMOUNT)
            rights = PlayerRights.DIAMOND_DONATOR;
        if (player.getAmountDonated() >= ONYX_DONATION_AMOUNT)
            rights = PlayerRights.ONYX_DONATOR;
        if (player.getAmountDonated() >= ZENYTE_DONATION_AMOUNT)
            rights = PlayerRights.ZENYTE_DONATOR;
        if (player.getAmountDonated() >= TANZANITE_DONATION_AMOUNT)
            rights = PlayerRights.TANZANITE_DONATOR;
        if (rights != null && rights != player.getRights()) {
            player.getPacketSender().sendMessage(//so does the pass up here and shit even matter
                    "You've become a " + Misc.formatText(rights.toString().toLowerCase()) + "! Congratulations!");
            player.setRights(rights);
            player.getPacketSender().sendRights();
        }
    }
    @Override
    public void run() {
        try {
            if (!connect(HOST, DATABASE, USER, PASS)) {
                return;
            }
            System.out.println("connected to store database");

            player.lastDonationClaim = System.currentTimeMillis() + 30000;
            String name = player.getUsername().replace("_", " ");
            ResultSet rs = executeQuery("SELECT * FROM payments WHERE player_name='"+name+"' AND status='Completed' AND claimed=0");

            while (rs.next()) {
                int item_number = rs.getInt("item_number");
                double amount = rs.getDouble("amount");
                int quantity = rs.getInt("quantity");


                if (GameSettings.B2GO) {
                    if (quantity >= 2) {
                        quantity += (quantity / 2);
                    }
                }
                if (GameSettings.BOGO) {
                    quantity *= 2;
                }

                int id = -1;
                switch (item_number) {
                    //Starter Card Pack
                    case 1:
                        player.getInventory().add(23276, quantity);
                        break;
                    //Quill's Card Pack
                    case 2:
                        player.getInventory().add(23277, quantity);
                        break;
                    //Celestial's Card Pack
                    case 3:
                        player.getInventory().add(23278, quantity);
                        break;
                    //Avalon's Card Pack
                    case 4:
                        player.getInventory().add(23279, quantity);
                        break;
                    //$5 Bond
                    case 5:
                        player.getInventory().add(6769, quantity);
                        break;
                    //$10 Bond
                    case 6:
                        player.getInventory().add(10942, quantity);
                        break;
                    //$25 Bond
                    case 7:
                        player.getInventory().add(10934, quantity);
                        break;
                    //$50 Bond
                    case 8:
                        player.getInventory().add(10935, quantity);
                        break;
                    //$100 Bond
                    case 9:
                        player.getInventory().add(10943, quantity);
                        break;

                    //Silver casket
                    case 10:
                        player.getInventory().add(15003, quantity);
                        break;
                    //Ruby casket
                    case 11:
                        player.getInventory().add(15002, quantity);
                        break;
                    //Diamond casket
                    case 12:
                        player.getInventory().add(15004, quantity);
                        break;
                    //Owner cape goodiebag
                    case 13:
                        player.getInventory().add(3578, quantity);
                        break;
                    //1.5x DR BOOSTER
                    case 14:
                        player.getInventory().add(4442, quantity);
                        break;
                    //1.5x DMG BOOSTER
                    case 15:
                        player.getInventory().add(23254, quantity);
                        break;
                    //Onyx casket
                    case 16:
                        player.getInventory().add(14999, quantity);
                        break;
                    //Gold Season Pass
                    case 17:
                        player.getInventory().add(23275, quantity);
                        break;
                    //Owner cape goodiebag
                    case 18:
                        player.getInventory().add(23240, quantity);
                        break;
                    //Zenyte casket
                    case 19:
                        player.getInventory().add(23253, quantity);
                        break;
                    //PVM Boxes
                    case 20:
                        player.getInventory().add(7956, quantity * 20_000);
                        break;
                    //Grand mystery box
                    case 21:
                        player.getInventory().add(19114, quantity * 400);
                        break;

                    default:
                        player.sendMessage("No donation was found under your name.");
                        return;
                }

                PlayerLogs.logPlayerDonations(player.getUsername(), "Donated: $" + amount
                        + ", Item: " + ItemDefinition.forId(id).getName() + ", Amount: " + item_number + ", ID: " + id + ", item_number: " + item_number);

                player.incrementAmountDonated((int) amount);
                player.setAmountDonatedToday((int)amount);
                player.getInventory().add(23174, (int) amount);
                player.sendMessage("Thanks for donating!");
                player.sendMessage("You are rewarded " + (int) amount + " Nephilim Tokens!");
                player.sendMessage("Your total amount donated was increased by " + (int) amount + ". your new total is: " + player.getAmountDonated());
                if (amount > 250) {
                    player.getInventory().add(23174, (int) amount);
                    player.sendMessage("You are rewarded an extra" + (int) amount+ " Nephilim Tokens for donating more than $250");
                }
                if (GameSettings.ELITE_DONO_DEAL && amount >= 50) {
                    player.getInventory().add(3578, 1);
                    player.sendMessage("You received an Elite Goodiebag for donating 50+");
                    World.sendMessage( "@red@<shad=1>" + player.getUsername() + "@or2@ Donated 50+ and received @red@<shad=1>x1 Elite Goodiebag!");
                }
                if (GameSettings.OWNER_CAPE_DONO_DEAL && amount >= 50) {
                    player.getInventory().add(3578, 1);
                    player.sendMessage("You received an Owner cape Goodiebag for donating 50+");
                    World.sendMessage( "@red@<shad=1>" + player.getUsername() + "@or2@ Donated 50+ and received @red@<shad=1>x1 Owner cape Goodiebag");
                }
                if (GameSettings.OWNER_JEWELRY_DONO_DEAL && amount >= 50) {
                    player.getInventory().add(23240, 1);
                    player.sendMessage("You received x1 Owner jewelry Goodiebag for donating 50+");
                    World.sendMessage( "@red@<shad=1>" + player.getUsername() + "@or2@ Donated 50+ and received @red@<shad=1>x1 Owner jewelry Goodiebag!");
                }
                if (amount >= 5) {
                    World.sendMessage("<img=5><shad=1>@yel@Donation: @blu@" + player.getUsername()
                            + "@or2@ has donated! @red@::Donate@or2@ now to show support for @red@Avalon!");
                } else {
                    player.sendMessage("Your donation message is only displayed for purchases over $5");
                }
                rs.updateInt("claimed", 1);
                rs.updateRow();
            }
            destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param host     the host ip address or url
     * @param database the name of the database
     * @param user     the user attached to the database
     * @param pass     the users password
     * @return true if connected
     */
    public boolean connect(String host, String database, String user, String pass) {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, user, pass);
            return true;
        } catch (SQLException e) {
            System.out.println("Failing connecting to database!");
            return false;
        }
    }//1sec

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

