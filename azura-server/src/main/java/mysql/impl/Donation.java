package mysql.impl;

import com.ruse.GameSettings;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Donation extends Database {

    public static final String HOST = "195.179.236.205";
    public static final String USER = "u189330247_Store";
    public static final String PASS = "8ytqy63zYrAUGWz";
    public static final String DATABASE = "u189330247_Store";


    private Player player;
    private Connection conn;

    private ResultSet rs;

    public Donation(Player player) {
        super(HOST,USER,PASS,DATABASE);
        this.player = player;
    }


    public static final int SAPPHIRE_DONATION_AMOUNT = 10;
    public static final int EMERALD_DONATION_AMOUNT = 50;
    public static final int RUBY_DONATION_AMOUNT = 250;
    public static final int DIAMOND_DONATION_AMOUNT = 500;
    public static final int ONYX_DONATION_AMOUNT = 2500;
    public static final int ZENYTE_DONATION_AMOUNT = 5000;
    public static final int TANZANITE_DONATION_AMOUNT = 10000;
     final String generateQuery() {
        String name = player.getUsername().replace("_", " ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM payments WHERE player_name='"+name+"' AND status='complete' AND claimed=0");

        return sb.toString();
    }

    public void run(){
        try {
            if (!init()) {
                return;
            }
            player.lastDonationClaim = System.currentTimeMillis() + 30000;
            String name = player.getUsername().replace("_", " ");
            executeQuery("SELECT * FROM payments WHERE player_name='"+name+"' AND status='Complete' AND claimed=0");
            stmt = prepare(generateQuery());
      //      stmt.setString(1, player.playerName);
            stmt.execute();


            rs = stmt.executeQuery();

            if(rs.next()) {

            //while (stmt.getMoreResults()) {
               int id = rs.getInt("id");
                int item_number = rs.getInt("item_number");
                double paid = rs.getDouble("paid");
                int quantity = rs.getInt("quantity");


                if (GameSettings.B2GO) {
                    if (quantity >= 2) {
                        quantity += (quantity / 2);
                    }
                }
                if (GameSettings.BOGO) {
                    quantity *= 2;
                }


                switch (item_number) {
                    //Bronze Card Pack
                    case 1:
                        player.getInventory().add(23276, quantity);
                        break;
                    //Silver Card Pack
                    case 2:
                        player.getInventory().add(23277, quantity);
                        break;
                    //Gold Card Pack
                    case 3:
                        player.getInventory().add(23278, quantity);
                        break;
                    //Diamond Card Pack
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
                        player.getInventory().add(23255, quantity);
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

//                PlayerLogs.logPlayerDonations(player.getUsername(), "Donated: $" + paid
//                        + ", Item: " + ItemDefinition.forId(id).getName() + ", Amount: " + item_number + ", ID: " + id + ", item_number: " + item_number);

                player.getInventory().add(23174, (int) paid);
                player.sendMessage("Thanks for donating!");
                player.sendMessage("You are rewarded " + paid + "High-Tier Tickets!");
                if (paid > 250) {
                    player.getInventory().add(23174, (int) paid * 2);
                    player.sendMessage("You are rewarded x2 High-Tier tickets for donating more than $250");
                }
                if (GameSettings.ELITE_DONO_DEAL && paid > 75) {
                    player.getInventory().add(3578, 1);
                    player.sendMessage("You received an Owner cape Goodiebag for donating 75+");
                    World.sendMessage( "@red@<shad=1>" + player.getUsername() + "</shad>@bla@Donated 75+ and received @red@<shad=1>x1 Owner cape Goodiebag");
                    }
                if (paid >= 5) {
                    World.sendMessage("<img=5><shad=1>@yel@Donation: @blu@" + player.getUsername()
                            + "@or2@ has donated! @red@::Donate@or2@ now to show support for @red@Avalon!");
                } else {
                    player.sendMessage("Your donation message is only displayed for purchases over $5");
                }
/*
                if (paid >= 25 && paid <= 99) {
                    player.getInventory().add(23002, (int) (paid / 25));
                    player.sendMessage("You received some extra rewards for donating!");
                }
                if (paid >= 100) {
                    player.getInventory().add(22121, (int) (paid / 100));
                    player.sendMessage("You received some extra rewards for donating!");
                }*/

              /* if (paid >= 10 && paid <= 19){
                    player.getInventory().add(15003, 1);
                }else if (paid >= 20 && paid <= 49){
                    player.getInventory().add(15004, 1);
                }else if (paid >= 50 && paid <= 99){
                    player.getInventory().add(15004, 1);
                }else if (paid >= 100 && paid <= 249){
                    player.getInventory().add(15004, 1);
                    player.getInventory().add(15002, 1);
                    player.getInventory().add(15003, 1);
                }else if (paid >= 250 && paid <= 499){
                    player.getInventory().add(15004, 5);
                }else if (paid >= 500){
                    player.getInventory().add(15004, 5);
                    player.getInventory().add(10943, 1);
                }
*/

                rs.updateInt("claimed", 1);
                rs.updateRow();

            }
            destroyAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}

