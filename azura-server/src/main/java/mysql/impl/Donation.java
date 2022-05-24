package mysql.impl;

import com.ruse.GameSettings;
import com.ruse.model.PlayerRights;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.DonationBossSystem;
import com.ruse.world.content.PlayerLogs;
import com.ruse.world.entity.impl.player.Player;

import java.sql.*;

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
//oh lmfao hahahahahahahahaha
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

                    case 1:
                        player.getInventory().add(6769, quantity);
                        break;

                    case 2:
                        player.getInventory().add(10942, quantity);
                        break;

                    case 3:
                        player.getInventory().add(10934, quantity);
                        break;

                    case 4:
                        player.getInventory().add(10935, quantity);
                        break;

                    case 5:
                        player.getInventory().add(10943, quantity);
                        break;
                    case 6:
                        player.getInventory().add(10943, quantity);
                        break;

                    default:
                        player.sendMessage("No donation was found under your name.");
                        return;
                }

//                PlayerLogs.logPlayerDonations(player.getUsername(), "Donated: $" + paid
//                        + ", Item: " + ItemDefinition.forId(id).getName() + ", Amount: " + item_number + ", ID: " + id + ", item_number: " + item_number);

                DonationBossSystem.amntDonated+= paid;
                DonationBossSystem.spawnBoss();
                player.sendMessage("Thanks for donating!");
//why u got 1 eclispe and 1 intellij open lol well i can't get this server to run in eclipes :D ill fix it
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

