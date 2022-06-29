package com.ruse.world.content.serverperks;

import ca.momoperes.canarywebhooks.DiscordMessage;
import ca.momoperes.canarywebhooks.WebhookClient;
import ca.momoperes.canarywebhooks.WebhookClientBuilder;
import ca.momoperes.canarywebhooks.embed.DiscordEmbed;
import com.ruse.GameSettings;
import com.ruse.engine.GameEngine;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.util.StringUtils;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ServerPerks {

    private static ServerPerks instance = null;
    private final Map<Perk, Integer> contributions = new HashMap<>();
    private final int TIME = 6000; // 1 hour
    public static final int INTERFACE_ID = 42050;
    public static final int OVERLAY_ID = 42112;
    private final Perk[] PERKS = Perk.values();
    private final Path FILE_PATH = Paths.get("./data/serverperks.txt");
    private static Perk activePerk;
    private int currentTime = 0;
    private boolean active = false;

    private ServerPerks() {

    }

    public static ServerPerks getInstance() {
        if (instance == null) {
            instance = new ServerPerks();
        }
        return instance;
    }

    public Perk getActivePerk() {
        return activePerk;
    }

    public static void discordBroadcast(String msg) {
        try {
            String webhook = "https://discord.com/api/webhooks/983470634304675850/v1rdbrXWCpule0_2fKc1AvGt0V3W-VNCBM5aKuk5kOLTkufAtWLKxu4mIxss9Kk-wIZp";
            WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
            DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("").withColor(Color.orange).withDescription(
                "***[Perk] "+ activePerk.getName() + " has been activated for 1 hour!***").build();
            DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)).withEmbed(embed).withUsername("Globals").build();
            client.sendPayload(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void open(Player player) {
        player.getPacketSender().sendInterface(INTERFACE_ID);
        player.setPerkIndex(0);
        updateInterface(player);
    }

    public void contribute(Player player, int amount) {
        if (active) {
            player.sendMessage("@red@A perk is already active");
            return;
        }
        if (!player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID, amount)) {
            amount = player.getInventory().getAmount(ItemDefinition.UPGRADE_TOKEN_ID);
        }
        int index = player.getPerkIndex();
        Perk perk = PERKS[index];
        int current = contributions.getOrDefault(perk, 0);
        int necessary = perk.getAmount();
        amount = Math.min(amount, necessary - current);

        player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID, amount);
        int total = contributions.merge(perk, amount, Integer::sum);
        updateInterface(player);

        save();
        if (amount >= 1000000) {
            World.sendMessage("<img=16><shad=1>@or2@[" + player.getUsername() + "] @yel@has just donated @gre@" + amount + " @yel@Upgrade tokens to the Server Perk!");
        }
        if (total >= necessary) {
            start(perk);
        }
    }

    public void tick() {
        if (!active) {
            return;
        }

        currentTime--;

        if (currentTime == 0) {
            end();
        }

        if (currentTime % 100 == 0) {
            updateOverlay();
        }
    }

    private void start(Perk perk) {
        currentTime = TIME;
        active = true;

        activePerk = perk;
        updateOverlay();
        World.sendMessage("@red@Server Message: <col=005fbe>[Perk] " + activePerk.getName() + " has just been activated!");

        if (GameSettings.LOCALHOST == false)
        discordBroadcast("");
        //reset();
        // Erase file contents
        deleteTypeFromLog(perk);
    }

    private void end() {
        active = false;
        contributions.put(activePerk, 0);
        World.sendMessage("@red@Server Message: <col=005fbe>[Perk] " + activePerk.getName() + " has ended!");
        discordBroadcast("");
        activePerk = null;
        resetInterface();
    }

    private void updateOverlay() {
        if (activePerk == null) {
            return;
        }
        World.getPlayers().forEach(player -> {
            int minutes = (int) QuickUtils.tickToMin(currentTime);
            player.getPacketSender().sendSpriteChange(OVERLAY_ID + 1, activePerk.getSpriteId());
            player.getPacketSender().sendWalkableInterface(OVERLAY_ID, true);
            player.getPacketSender()
                    .sendString(OVERLAY_ID + 3, StringUtils.usToSpace(activePerk.toString()));
            player.getPacketSender().sendString(OVERLAY_ID + 2, minutes + " min");
        });
    }

    private void resetInterface() {
        World.getPlayers().forEach(player -> {
            player.getPacketSender().sendWalkableInterface(OVERLAY_ID, false);
            player.getPacketSender().updateProgressBar(INTERFACE_ID + 10, 0);
        });
    }

    private void updateInterface(Player player) {
        int index = player.getPerkIndex();
        Perk perk = PERKS[index];
        int current = contributions.getOrDefault(perk, 0);
        int required = perk.getAmount();
        int percentage = getPercentage(current, required);
        player.getPacketSender().updateProgressBar(INTERFACE_ID + 10, percentage);
        player.getPacketSender().sendString(INTERFACE_ID + 11, Misc.formatNumber(current) + " / " + Misc.formatNumber(required) + "");
    }

    private int getPercentage(int n, int total) {
        float proportion = ((float) n) / ((float) total);
        return (int) (proportion * 100f);
    }

    public boolean handleButton(Player player, int id) {
        if (id > -23465 || id < -23470) {
            return false;
        }

        int index = 23470 + id;
        player.setPerkIndex(index);
        updateInterface(player);
        return true;
    }

    public void save() {
        List<String> data = new ArrayList<>();
        contributions.forEach((k, v) -> {
            data.add(k.toString() + ", " + v);
        });

        try {
            Files.write(FILE_PATH, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try (Stream<String> lines = Files.lines(FILE_PATH)) {
            lines.forEach(line -> {
                String[] split = line.split(", ");
                if(split.length == 2)
                contributions.put(Perk.valueOf(split[0]), Integer.parseInt(split[1]));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded: " + contributions);
    }

    public void reset() {
        contributions.clear();
        World.getPlayers().forEach(this::updateInterface);
    }
    public void deleteTypeFromLog(Perk name) {
        GameEngine.submit(() -> {
            try {
                BufferedReader r = new BufferedReader(new FileReader(FILE_PATH.toString()));
                ArrayList<String> contents = new ArrayList<String>();
                while (true) {
                    String line = r.readLine();
                    String lineUser = line;
                    if (line == null) {
                        break;
                    } else {
                        line = line.trim();
                        lineUser = line.substring(0, line.indexOf(","));
                    }
                    if (!lineUser.equalsIgnoreCase(name.name())) {
                        contents.add(line);
                    }
                }
                r.close();
                BufferedWriter w = new BufferedWriter(new FileWriter(FILE_PATH.toString()));
                for (String line : contents) {
                    w.write(line, 0, line.length());
                    w.write(System.lineSeparator());
                }
                w.flush();
                w.close();
            } catch (Exception e) {
            }
        });
    }
    public enum Perk {
        //DOUBLE_BONDS(0, 100000000, 1521), // TO DO
        // NPC_KILLS(2, 25000000, 1523),// DONE
        X2_DMG("2X DMG", 0, 20_000_000, 1523),// DONE
        X2_DR("2X DR", 0, 20_000_000, 1524),// DONE
        X2_DROPS("X2 Drops", 1, 20_000_000, 1525),// DONE
        X2_EXP("x2 EXP", 2, 1000000, 529),// DONE
        X2_SLAYER("X2 Slayer", 3, 10_000_000, 1522),// DONE
        X2_RAIDS("x2 Raid Loot", 3, 25_000_000, 1521),// DONE

        ;

        private final int index;
        private final int amount;
        private final int spriteId;
        @Getter
        private String name;

        Perk(String name, int index, int amount, int spriteId) {
            this.name = name;
            this.index = index;
            this.amount = amount;
            this.spriteId = spriteId;
        }

        public int getIndex() {
            return index;
        }

        public int getAmount() {
            return amount;
        }

        public int getSpriteId() {
            return spriteId;
        }
    }


}