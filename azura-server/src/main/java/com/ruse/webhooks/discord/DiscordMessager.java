package com.ruse.webhooks.discord;

import java.awt.Color;
import java.net.URI;

import com.ruse.world.World;
import com.ruse.world.content.serverperks.ServerPerks;
import org.json.JSONObject;

import com.ruse.util.Misc;

import ca.momoperes.canarywebhooks.DiscordMessage;
import ca.momoperes.canarywebhooks.WebhookClient;
import ca.momoperes.canarywebhooks.WebhookClientBuilder;
import ca.momoperes.canarywebhooks.embed.DiscordEmbed;

public class DiscordMessager extends JSONObject {

	public static boolean active = true;

	public static void test1(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					 .withTitle("1. Flaming, Disrespect, Harassment, and Inappropriate Content.") // The title of the embed element
					.withDescription("- The use of inappropriate or disrespectful language towards another player’s (Race, Religion, Beliefs and Harassing) IS NOT TOLERATED.\n - Accusing other players of breaking rules. (Scamming, Hacking, Botting, Fake Giveaways, Fake Drop Parties or anything regarding this). If you have evidence of a rule being broke make a report.\n - Advertising fake giveaways, drop parties and events.\n - Content that is advertised on all chat channels (Discord, In-game and Forums) if deemed inappropriate per staff member’s decision.\n - Harassing and disrespecting staff members, whether it’s asking information or requesting ranks.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test2(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("2. Advertising") // The title of the embed element
					.withDescription("- Known links (YouTube, Social Media, Information) are allowed, links that lead to anything other than Avalon based information/videos etc are NOT allowed.\n - YOU are not allowed to advertise other RSPS related material.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void test3(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("3. Spamming") // The title of the embed element
					.withDescription("- Any act of spamming that will affect the gameplay of other players.\n - You are not allowed to abuse Yell take your time between sending messages\n - Auto-Typers are not allowed to be used.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test4(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("4. Misleading Links, Hacking and Threats") // The title of the embed element
					.withDescription("- Misleading links are NOT allowed. \n - Hacking in any shape/form.\n - Threatening members that will put their life, security and reputation at risk.\n - Sharing private/personal information. WILL not be tolerated")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test5(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("5. Evasions") // The title of the embed element
					.withDescription("- Trying to avoid your punishments, (Mute, Jail, Bans or any kind of punishment) will result in a permanent ban with no appeal.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test6(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("6. Real World Trading") // The title of the embed element
					.withDescription("- Purchasing or Selling any accounts, items, gold, tickets whatever has value in Avalon for ANY payment methods or items on any other server will result in a permanent ban.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test7(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("7. Encouraging Others to Break Rules") // The title of the embed element
					.withDescription("- Abusing bugs, dupes, exploits or any type of offenses that will hurt the game-play of others or Avalon itself.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test8(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("8. Scams, Refunds and Item Lending") // The title of the embed element
					.withDescription("- Different type of scams, (Imposters, deceiving other players).\n - If you were scammed by any other players, we would require SOLID proof that you have been scammed to receive your refund. Yet refunds are not guaranteed depending on the situation. As in if the money was not on the scammers account. Make sure to use staff as a middle man.\n - Account sharing is allowed but it’s under your own risk and the account owner is responsible for whomever commits offenses on the account.\n - Refunds due to bugs/issues will be only refunded if the person has solid proof of the lost items/cash.\n -Lending items is at your own risk. If you lend your items and the other player loses them, they will not be refunded to you.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test9(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("9. Yell Channel") // The title of the embed element
					.withDescription("- Use of Yell to bait, troll, or any abuse is not tolerated and will result in a mute.\n - Advertising over yell for streams, videos is acceptable but within a reasonable amount of time gaps. Being afk and using an auto-typer is not allowed.\n - No speaking or instigating any issues over Politics")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test10(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("10. Voting") // The title of the embed element
					.withDescription("- The use of VPN/3rd party clients to boost your votes is not allowed, this harms the server more than it helps.\n Or use a phone or any other device to vote more per 12 hours. You are only allowed to vote on those 4 sites ONCE per 12 hours.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test11(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("11. Support Clan Chat") // The title of the embed element
					.withDescription("- No Trolling or disruptive behavior.\n - No politics are to be spoke about in our Help or Yell channels.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test12(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("12. Accounts") // The title of the embed element
					.withDescription("- You are permitted to use 3 accounts (1 Main, 2 AFK) or 4 accounts if an Ironman is active (1 Main, Iron Man, 2 AFK)\n - Please note that ONLY 1 MAIN and 2 AFK accounts are permitted. Only exception to the 4th account is an ironman.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test13(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("13. Crashing") // The title of the embed element
					.withDescription("- Crashing other members PVMING any of any sort. Must have solid proof.\n -When in non multi areas (such as Mutated hounds) if it is a full room, please be respectful and claim 2 NPCs to allow others to claim 2 as well. ")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test14(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("14. Macroing") // The title of the embed element
					.withDescription("- You can’t use third party software to gain an advantage over another player (Autoclicker/AHK) etc..")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test15(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("15. Achievement/Account/Coll Log Farming") // The title of the embed element
					.withDescription("You aren't allowed to use multiple account to farm achievements and move the bonds over to your main account.\n - You are not allowed to use multiple accounts to farm battle passes and transfer them over to your main.\n - You are NOT allowed to farm collection log rewards on multiple accounts and transfer over the rewards.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test16(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("16. Afk Pvm") // The title of the embed element
					.withDescription("You are NOT allowed to afk pvm for any reason")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test17(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("17. Gambling") // The title of the embed element
					.withDescription("Gambling of ANY sort is not permitted nor will it be allowed on Avalon. Any use of 3rd party software to gamble will result in a ban from the server.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test18(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985905453101899817/o5DeIqyj_R62E2s7-glwJhB7LJ4fyyH3J5JEKlFLiBa3d1R4VFELYoYJnp1ucy0yb9xv";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withTitle("18. Services") // The title of the embed element
					.withDescription("Offering services for untradeable items of ANY form is not allowed. (I.E selling a part from Golems to create boots and having someone give you money/luci boots to make the set of boots.)\n - You are not allowed to give someone a Season Pass to then receive the items they get from season pass. It is similar to a season pass farming which neither are allowed.\n Note: This is just an example ANY item that must be created with untradeable parts are against the rules to sell.")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Rules")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dono1(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985917713656447017/T2Uge8KQDO43IUO6BNUDAmHNyCxXAlEEghB33KpZ6t2l_7PLTsfEioTIyfPE-10wliLn";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.BLUE)
					.withTitle("Sapphire Donator | [:dollar: 10]") // The title of the embed element
					.withDescription("5% Bonus Drop rate\n 5% Damage Boost\n ::sapphire - Teleports you to Sapphire donator zone\nAccess to ::yell chat\n Access to ::afk")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Donator Benefits")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dono2(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985917713656447017/T2Uge8KQDO43IUO6BNUDAmHNyCxXAlEEghB33KpZ6t2l_7PLTsfEioTIyfPE-10wliLn";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.green)
					.withTitle("Emerald Donator | [:dollar: 50]") // The title of the embed element
					.withDescription("15% Bonus Drop rate\n 10% Damage Boost\n ::emerald - teleports you to Emerald donator zone\n Access to ::pos outside of home\n Access to ::setyellhex\n Access to ::bank\n All benefits from previous rank")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Donator Benefits")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dono3(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985917713656447017/T2Uge8KQDO43IUO6BNUDAmHNyCxXAlEEghB33KpZ6t2l_7PLTsfEioTIyfPE-10wliLn";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.red)
					.withTitle("Ruby Donator | [:dollar: 250]") // The title of the embed element
					.withDescription("20% Bonus Drop rate\n 15% Damage Boost\n ::ruby - teleports you to ruby donator zone\n All the benefits from previous ranks")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Donator Benefits")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dono4(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985917713656447017/T2Uge8KQDO43IUO6BNUDAmHNyCxXAlEEghB33KpZ6t2l_7PLTsfEioTIyfPE-10wliLn";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.cyan)
					.withTitle("Diamond Donator | [:dollar: 500]") // The title of the embed element
					.withDescription("30% Bonus Drop rate\n 25% Damage Boost\n ::diamond/::diamond 2 - teleports you to diamond donator zone\n Unlimited prayer\n 10% bonus skilling experience\n All the benefits from previous ranks")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Donator Benefits")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dono5(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985917713656447017/T2Uge8KQDO43IUO6BNUDAmHNyCxXAlEEghB33KpZ6t2l_7PLTsfEioTIyfPE-10wliLn";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.black)
					.withTitle("Onyx Donator | [:dollar: 1000]") // The title of the embed element
					.withDescription("45% Bonus Drop rate\n 35% Damage Boost\n 20% bonus skilling experience\n Access to ::onyx donator zone\n ::onyx includes the Onyx Global Boss\n All benefits of previous ranks")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Donator Benefits")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dono6(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985917713656447017/T2Uge8KQDO43IUO6BNUDAmHNyCxXAlEEghB33KpZ6t2l_7PLTsfEioTIyfPE-10wliLn";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.orange)
					.withTitle("Zenyte Donator | [:dollar: 5000]") // The title of the embed element
					.withDescription("75% Bonus Drop rate\n 50% Damage Boost\n 30% bonus skilling experience\n Access to ::zenyte donator zone\n ::zenyte includes the Zenyte Global Boss\n 10% Chance of double Isles of Avalon loot\n All benefits of previous ranks")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Donator Benefits")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dono7(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/985917713656447017/T2Uge8KQDO43IUO6BNUDAmHNyCxXAlEEghB33KpZ6t2l_7PLTsfEioTIyfPE-10wliLn";
			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.magenta)
					.withTitle("Tanzanite Donator | [:dollar: 10000]") // The title of the embed element
					.withDescription("100% Bonus Drop rate\n 75% Damage Boost\n 50% bonus skilling experience\n Access to ::tanzanite donator zone\n ::tanzanite includes the Tanzanite Global Boss\n 15% Chance of double Isles of Avalon loot\n All benefits of previous ranks")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Donator Benefits")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendDonationBossLog(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/964275725811216436/76LexWSyaeqVPZQeOztYbZOb8ooloMwMGt5AZQsMvMAtLZfzQPhTqoyGGfyuz2mEVGdY";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.orange)
					.withDescription("The Avalon Guardian has spawned at ::guardian")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Globals")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendNephilimBossLog(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/979831153437573182/AhW0QaaFyvU7NzpzJ2jut2FxfT8cPz0vVsRxppN4RjwzPkTo26PKrx3wmhPHCliJudbM";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
			// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.red)
					.withDescription("The Nephilim Warrior has spawned at ::Nephilim")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					 .withEmbed(embed)
					.withUsername("Globals")
					.build();

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void sendVoteBossLog(String msg) {
		try {

			String webhook = "https://discord.com/api/webhooks/963120303133835334/0y0GdPvBsQcMz8P889Z83R74luopoF9G-wPsJam4hEtuWu5FMB2hMJWS4JPcFvldm_7g";


			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build();
			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("")
					//.withURL("http://Avalon317.com")
					.withColor(Color.BLUE)
					.withDescription("Vote boss has spawned at ::Vboss")
					.build();

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg))
					.withEmbed(embed)
					.withUsername("Globals")
					.build();

			client.sendPayload(message);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void sendAnnouncement(String msg) {
		try {

			String webhook = "https://discordapp.com/api/webhooks/264978407408795648/xEBWbkd51PIrM_Bv8xuYCWnTWonLAbVGcz_mNH62m0xfwSFnc62To2u_Q82vcp2G_oEo";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
																							// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
																								// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Announcement Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendStaffMessage(String msg) {
		try {

			String webhook = "https://discordapp.com/api/webhooks/264978499528294420/XXkZF8s6k3f5MTgvJ8mAiok3W_ushBbSVaFfbo1UULqvmFtYfw0KNJFSpA85gh3Y7gws";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.ORANGE) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
																								// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Staff Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendChatMessage(String msg) {
		try {


			String webhook = "https://discordapp.com/api/webhooks/299740022821879811/73pNXpfq3kMJSR6UNgMZqyWwPebyaYT4A_WAdwihXJNooKzPwdwgbAs8eDb3S2Jf5HAY";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.YELLOW) // The color of the embed. You can leave this at null for no color
					// .withDescription("Remember, you can mute any specific channel by clicking the
					// bell in the top right of Discord.") // The description of the embed object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Chat Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendChatMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendClanMessage(String msg) {
		try {


			String webhook = "https://discordapp.com/api/webhooks/299784483404644353/3M1Z_qzhen3C9FwDQXJeJ5NTzGTIYGkJBUo4jIucIJogJaLmXC8ukLhbloziNisZmiaN";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
					// .withDescription("Remember, you can mute any specific channel by clicking the
					// bell in the top right of Discord.") // The description of the embed object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Clan Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendClanMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendPrivateMessage(String msg) {
		try {


			String webhook = "https://discordapp.com/api/webhooks/299735829218066432/TuAXNO5mgU93wRMEjnCsDiUZD3uco0AlrpPMYWt3yXt4px-X9FvbbxDgTERqFWUBA19l";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.MAGENTA) // The color of the embed. You can leave this at null for no color
					// .withDescription("Remember, you can mute any specific channel by clicking the
					// bell in the top right of Discord.") // The description of the embed object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Privacy Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendPrivateMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendInGameMessage(String msg) {
		try {

			String webhook = "https://discordapp.com/api/webhooks/264978586488930304/09Ondbuw6zvWtH9dltOZq30nLnRYp-y9xMPkPDa1xs4MyELl3kmftdiUFnyHzsx-ciGt";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.BLUE) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("In-Game Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendInGameMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendDebugMessage(String msg) {
		try {

			String webhook = "https://discordapp.com/api/webhooks/264978075513651221/4Qk7idRA2NbAmno_FOSmN8PH9D3_H4Un09eV3sg9Wx2TPOJjumuIFTi4dOprX_7cWmGa";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("Necrotic - RSPS") // The title of the embed
																							// element
					.withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.MAGENTA) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			// DiscordMessage message = new DiscordMessage.Builder(msg)
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
																								// message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Debug Bot") // Override the username of the bot
					.build(); // Build the message

			client.sendPayload(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendYellMessage(String msg) {
		try {

			String webhook = "https://discordapp.com/api/webhooks/265081936165339137/NisWUHGJ8gR-tINeMHMBjQ7H-EJ8b6DznSx75f_NokM5DbIUuo7S874Ah9u3r4FRPYEx";

			WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
																									// client

			DiscordEmbed embed = new DiscordEmbed.Builder()
					// .withTitle("Necrotic - RSPS") // The title of the embed element
					// .withURL("http://necrotic.org/") // The URL of the embed element
					.withColor(Color.WHITE) // The color of the embed. You can leave this at null for no color
					.withDescription(
							"Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The
																																// description
																																// of
																																// the
																																// embed
																																// object
					.build(); // Build the embed element

			String msgToSend = Misc.stripIngameFormat(msg);

			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
					// .withEmbed(embed) // Add our embed object
					.withUsername("Yell Bot") // Override the username of the bot
					.build(); // Build the message

			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendYellMessage, \n" + msgToSend);
			} else {
				client.sendPayload(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
