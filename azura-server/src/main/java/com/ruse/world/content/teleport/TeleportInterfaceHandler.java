package com.ruse.world.content.teleport;

import com.ruse.model.Item;
import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.world.World;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.progressionzone.ProgressionZone;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.content.transportation.TeleportType;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

/**
 * @author Snz
 * @date 2020
 */
public class TeleportInterfaceHandler {

	/**
	 * idk why the fuck that was protected lmfao
	 **/
	private Player player;

	public TeleportInterfaceHandler(Player player) {
		this.player = player;
	}

	/* This cache's enum values to prevent it from constantly using arraysOnCopy */
	public final TeleportData data[] = TeleportData.values();

	public void open() {
		player.getPacketSender().resetItemsOnInterface(28229 + 20, 20);
		player.setTeleportType(TeleportCategory.BOSSES);
		switchTab(28216);
		player.getPA().sendInterface(28200);
	}

	public void open(TeleportCategory type) {
		player.setTeleportType(type);
		switchTab(28216);
		player.getPA().sendInterface(28200);
	}

	public void switchTab(int buttonid) {
		switch (buttonid) {
			case 28215:
				player.setTeleportType(TeleportCategory.MONSTERS);
				switchData();
				player.getPA().sendString(28205, "Monsters");
				break;
			case 28216:
				player.setTeleportType(TeleportCategory.BOSSES);
				switchData();
				player.getPA().sendString(28205, "Bosses");
				break;
			case 28217:
				player.setTeleportType(TeleportCategory.MINIGAMES);
				switchData();
				player.getPA().sendString(28205, "Minigames");
				break;
			case 28218:
				player.setTeleportType(TeleportCategory.DUNGEONS);
				switchData();
				player.getPA().sendString(28205, "Dungeons");
				break;
			case 28219:
				player.setTeleportType(TeleportCategory.CITIES);
				switchData();
				player.getPA().sendString(28205, "Cities");
				break;
			case 28220:
				player.setTeleportType(TeleportCategory.GLOBALS);
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
		if (player.getCurrentTeleport() == null) {
			player.getPA().sendMessage("Please select a teleport destination first!");
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == 9001) {
			ProgressionZone.teleport(player);
			player.getPacketSender().sendInterfaceRemoval();
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == 9024) {
			player.hov.initArea();
			player.hov.start();
			player.getPacketSender().sendInterfaceRemoval();
			return;
		}
		if (player.getCurrentTeleport().getNpcId() == 9813) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("@red@Your rank allows you to bypass the teleport requirements!");
			if (player.getPointsHandler().getMIDNIGHTKILLCount() >= 10_000 || player.getRights() == PlayerRights.OWNER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			}
			else
				player.sendMessage("@red@You need 10k Midnight Goblin kills to go here!");
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == 9011) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("@red@Your rank allows you to bypass the teleport requirements!");
			if (!player.isUnlockedLucifers() || player.getRights() != PlayerRights.OWNER) {
				Item[] requirements = new Item[]{new Item(ItemDefinition.UPGRADE_TOKEN_ID, 25_000_000), new Item(20400, 1),
						new Item(18823, 3), new Item(19888, 3)};
				if (player.getInventory().containsAll(requirements)) {
					player.getInventory().deleteItemSet(requirements);
					player.setUnlockedLucifers(true);
					player.sendMessage("@red@Congratulations, you have unlocked Fallen Angel's zone!");
					return;
				} else {
					player.sendMessage("You do not have the requirements to unlock Fallen Angels!");
					player.sendMessage("You need an enraged cape + 3 coll rings II, 3 colls necks II to sacrifice!!");
					player.sendMessage("@red@Try again with these items in your inventory!");
					return;
				}
			} else if (player.isUnlockedLucifers()) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
			}

		}

		if (player.getCurrentTeleport().getNpcId() == 9837) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("@red@Your rank allows you to bypass the teleport requirements!");
			if (!player.isUnlockedDarkSupreme()) {
				Item[] requirements = new Item[]{ new Item(5011, 1), new Item(12537, 1), new Item(17013, 1)};
				if (player.getInventory().containsAll(requirements)) {
					player.getInventory().deleteItemSet(requirements);
					player.setUnlockedDarkSupreme(true);
					player.sendMessage("@red@Congratulations, you have unlocked Midnight Goblin's zone!");
					return;
				} else  if (player.getRights() == PlayerRights.OWNER) {
					TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
							player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				}  else
					player.sendMessage(""); player.sendMessage("You do not have the requirements to unlock Midnight Goblins!");
					player.sendMessage("You need to sacrifice a Legends Light bow, sword, and staff!");
					player.sendMessage("@red@Try again with these items in your inventory!");
					return;

			} else if (player.isUnlockedDarkSupreme()) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			}

		}

		if (player.getCurrentTeleport().getNpcId() == 9012) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("@red@Your rank allows you to bypass the teleport requirements!");
			if ((player.isUnlockedLucifers() &&
					player.getPointsHandler().getMiniLuciferkillcount() >= 10_000 ) || player.getRights() == PlayerRights.OWNER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				boolean contains = false;
				for (NPC others : World.getNpcs()) {
					if (others == null) {
						continue;
					}

					if (others.getId() == 9012 && others.getPosition().getRegionId() == 7760 &&
							others.getPosition().getZ() == (player.getIndex() * 4)) {
						contains = true;
					}
				}
				if (!contains) {
					NPC npc_ = new NPC(9012, new Position(1952, 5146, player.getIndex() * 4));
					npc_.setSpawnedFor(player);
					World.register(npc_);
				}
			} else {
				player.sendMessage("You need to have killed 10k Fallen Warriors to go here.");
			}
			return;
		}

		if (player.getCurrentTeleport() != null) {
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
		} else {
			if (player.getCurrentTeleport() == null)
			player.getPA().sendMessage("Please select a teleport destination first!");
		}
	}
}