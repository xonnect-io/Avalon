package com.ruse.world.content.teleport;

import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.model.Skill;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.content.transportation.TeleportType;
import com.ruse.world.entity.impl.player.Player;

/**
 * @author Snz
 * @date 2020
 */
public class NewTeleportInterfaceHandler {

	/** idk why the fuck that was protected lmfao **/
	private Player player;

	public NewTeleportInterfaceHandler(Player player) {
		this.player = player;
	}

	/* This cache's enum values to prevent it from constantly using arraysOnCopy */
	public final TeleportData data[] = TeleportData.values();

	public void open() {
		player.getPacketSender().resetItemsOnInterface(28229 + 20, 20);
		player.setTeleportType(TeleportType1.MONSTERS);
		switchTab(28215);
		player.getPA().sendInterface(28200);
	}

	public void open(TeleportType1 type) {
		player.setTeleportType(type);
		switchTab(28215);
		player.getPA().sendInterface(28200);
	}

	public void switchTab(int buttonid) {
		switch (buttonid) {
		case 28215:
			player.setTeleportType(TeleportType1.MONSTERS);
			switchData();
			player.getPA().sendString(28205, "Monsters");
			break;
		case 28216:
			player.setTeleportType(TeleportType1.BOSSES);
			switchData();
			player.getPA().sendString(28205, "Bosses");
			break;
		case 28217:
			player.setTeleportType(TeleportType1.MINIGAMES);
			switchData();
			player.getPA().sendString(28205, "Minigames");
			break;
		case 28218:
			player.setTeleportType(TeleportType1.DUNGEONS);
			switchData();
			player.getPA().sendString(28205, "Dungeons");
			break;
		case 28219:
			player.setTeleportType(TeleportType1.CITIES);
			switchData();
			player.getPA().sendString(28205, "Cities");
			break;
		case 28220:
			player.setTeleportType(TeleportType1.GLOBALS);
			switchData();
			player.getPA().sendString(28205, "Globals");
			break;
		default:
			break;
		}
	}

	public void switchData() {
		int count = 28307;
		for (int i = 28307; i < 28382; i++) {
			player.getPA().sendString(i, "");
		}
		for (TeleportData data : data) {
			if (data.getType() == player.getTeleportType()) {
				player.getPA().sendString(count++, data.getName());
			}
		}
	}


	public static void sendDrops(Player player, Box[] drops) {
		try {
			if (drops != null) {
				int length = drops.length;
				if (length >= 160)
					length = 160;

				length += 5 - (length % 5);
				for (int i = 0; i < length + 5; i++) {
					if (drops.length > i)
						player.getPacketSender().sendItemOnInterface1(28229, drops[i].getId(), i,
								drops[i].getAmount());
					else
						player.getPacketSender().sendItemOnInterface1(28229, -1, i,
								0);
				}
				int scroll = 7 + (length / 5) * 35;
				if (scroll <= 43)
					scroll = 43;
				player.getPacketSender().setScrollBar(122060, scroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendItemsOnInterface(TeleportData data1) {
		player.getPA().sendScrollableItemsOnInterface(28229, data1.getItems());
	}

	public void button(int buttonId) {
		for (TeleportData data : data) {
			if (data.getType() == player.getTeleportType()) {
				if (buttonId == data.getTextButtonId() || buttonId == data.getBackgroundButtonId()) {
					player.setCurrentTeleport(data);
					sendItemsOnInterface(data);
					if (!data.getFullName().isEmpty()) {
						player.getPA().sendString(28209, data.getFullName());
					} else {
						player.getPA().sendString(28209, data.getName());
					}
					player.getPA().sendString(64112, data.getDescription());
					player.getPA().sendString(64113, data.getReq1());
					player.getPA().sendString(64114, data.getReq2());
					player.getPA().sendNpcOnInterface(28214, data.getNpcId(), data.getAdjustedZoom());
					System.err.println("" + data.getNpcId());
				}
			}
		}
	}

	public void teleport() {
		
		 if (player.getCurrentTeleport().getNpcId() == 9011) {
			if(player.getMiniLucifer() == true) {
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
			player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
			}  else if (player.getInventory().contains(10506, 10_000_000) &&	player.getInventory().contains(20400, 1) &&
			player.getInventory().contains(19888, 1) && player.getInventory().contains(18823, 1) && player.getMiniLucifer() != true) {
			player.getInventory().delete(10506, 10_000_000);
			player.getInventory().delete(20400,  1);
			player.getInventory().delete(19888,  1);
			player.getInventory().delete(18823,  1);
			player.getPacketSender().sendMessage("@red@You completed the sacrifice and have unlocked Mini Lucifer teleport!");
			player.setMiniLucifer(true);
			return;
			} else if (player.getMiniLucifer() == false) {
			player.getPacketSender().sendMessage("You do not have the requirements to unlock Mini Lucifer!");
			player.getPacketSender().sendMessage("Must Sacrfice 10m Upgrade tokens, Rage wings, Coll Ring II , and Coll neck II");
			player.getPacketSender().sendMessage("@red@Try again with these items in your inventory!");
			return;
			}
		
		 }  else 
			 if (player.getCurrentTeleport().getNpcId() == 438) {
				if(player.getDarkSupreme() == true) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
				player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
				}  else if (player.getInventory().contains(5011, 1) &&	player.getInventory().contains(12537, 1) &&
				player.getInventory().contains(17013, 1) &&  !player.getDarkSupreme()) {
				player.getInventory().delete(5011,  1);
				player.getInventory().delete(12537,  1);
				player.getInventory().delete(17013,  1);
				player.getPacketSender().sendMessage("@red@You completed the sacrifice and have unlocked Dark Supreme teleport!");
				player.setDarkSupreme(true);
				return;
				} else if (player.getDarkSupreme() == false) {
				player.getPacketSender().sendMessage("You do not have the requirements to unlock Dark Supreme");
				player.getPacketSender().sendMessage("Must Sacrfice Light Twisted bow, vitur scythe, and sang. staff!");
				player.getPacketSender().sendMessage("@red@Try again with these items in your inventory!");
				return;
				}
		 }  else  if (player.getCurrentTeleport().getNpcId() == 9012) {
				if (player.getPointsHandler().getMiniLuciferkillcount() <= 4999 ) {
				player.getPacketSender().sendMessage(
						"You need to have killed 5k Mini Lucifers to go here.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			
		 }  else  if (player.getCurrentTeleport().getNpcId() == 2012) {
			 
				if (player.getPointsHandler().getNPCKILLCount() < 20000) {
				DialogueManager.sendStatement(player, "@red@You  need 20,000 total KC to visit Raids!");
				return;
				}
			if (player.getSkillManager().getCombatLevel() < 100) {
				player.getPacketSender().sendMessage(
						"You need a combat level of @blu@126@bla@ and level @blu@50@bla@ on all non-combat skills.@red@no dungeoneering.");
				return;
			}

			for (int i = 7; i < Skill.values().length; i++) {
						if (i == 21 ||i == 25 || i == 24 || i == 23 || i == 18)
							continue;
						if (player.getSkillManager().getMaxLevel(i) < 49) {
						
								player.getPacketSender().sendMessage(
										"@red@You must be at least level 50 in every non-combat skill to do Infernal raids.");
							return;
						}
					}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
		}
		else if (player.getCurrentTeleport().getNpcId() == 219) {
			if (player.getPointsHandler().getZEUSKILLCount() < 20000) {
				DialogueManager.sendStatement(player, "You need 20,000 Zeus Killcount to access Bleach Raids!");
							return;
						}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
		}
		if (player.getCurrentTeleport() != null) {
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
		} else {
			player.getPA().sendMessage("Please select a teleport destination first!");
		}
	}
}