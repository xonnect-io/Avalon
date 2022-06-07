package com.ruse.world.content.discordbot.command.impl;

import com.ruse.motivote3.doMotivote;
import com.ruse.world.content.DonationBossSystem;
import com.ruse.world.content.VoteBossDrop;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Rules extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Offical Avalon Rules");
        eb.addField("Toxic Behavior", " \n-Flaming the act of posting insults, often including profanity or other offensive language, on the internet. - Trolling: a malicious online behavior, characterized by aggressive and deliberate provocation of others.\n" +
                "- Racism: prejudice, discrimination, or antagonism directed against a person or people on the basis of their membership in a particular racial or ethnic group, typically one that is a minority or marginalized.\n" +
                "- Sexism: prejudice, stereotyping, or discrimination, typically against women, on the basis of sex.\n" +
                "- Religious Discrimination: the act of making fun of someone for their religious beliefs or lack of.\n" +
                "- Spamming/Caps: spamming one word or short sentences, using capitol letters excessively, or advertising is strictly forbidden.\n" +
                "  - You are not allowed to advertise an other RSPS related material. Known links such as YouTube are allowed unless determined by a staff member that your intention is to sway players to another server.\n" +
                "- Causing drama in any way isn't tolerated. We all hold ourselves to a high standard. If you don't like someone ignore them or block them.\n" +
                "- Toxicity in any fashion will now be taken with 0 tolerance. Toxicity of any kind will get you an instant mute, no warnings. What constitutes as toxicity will be up to the Staff Team's discretion.\n" +
                "- Harassment, Targeting, Baiting, Flame etc are all considered as toxic and will abide by rule #2.",true );
        eb.addField("Real World Trading", " \n- Real World Trading such as selling or buying accounts, in-game items, in-game wealth for real-life money or any other game accounts, money, items is strictly forbidden.\n" +
                "- Buying in-name donations for Avalon is NOT considered Real World Trading and must be facilitated with a server support or greater staff rank.",true );
        eb.addField("Misleading links, Hacking, and/or Threats", " \n- Phishing attempts, links designed to steal passwords and/or information is strictly forbidden.\n" +
                "- Any threat designed to steal personal information is taken seriously, regardless if meant to be jokingly or not.\n" +
                "- Please do not use link shorteners.",true );
        eb.addField("Scamming and Price Manipulation", " \n- Scamming is strongly forbidden, but borrowing or lending items will be at your own risk and no refunds will be issued regardless.\n" +
                "- Price manipulation in any way is not allowed.\n" +
                "- Making new accounts to manipulate, encourage or discourage sales, alter the POS history, or any other means of scamming/manipulating is not allowed.\n" +
                "- If you are loaned items by someone and you do not repay those items in a timely fashion or when the person who loaned, that is a bannable offence and counts as scamming.",true );
        eb.addField("Impersonation", " \n-Do not impersonate any players or staff members.",true );
        eb.addField("Bugs, Exploits and Other Abusing", " \n- You are not allowed to abuse any bug or exploit them in any way. Bugs and exploits must be reported staff, if the bug seems to game breaking dm an owner/admin",true );
        eb.addField("3rd Party Software", " \n We do not allow the use of Autoclickers, Color clickers, Macros, Shortcuts or anything of the sort. Any unauthorized 3rd party software used to give you an unfair advantage will not be tolerated.",true );
        eb.addField("Chargebacks, Fraud", " \n- Chargebacks are strictly forbidden as this is a false claim. A refund will only ever be issued if there is a malfunction where you don’t receive your items! Other than that, any attempt at a chargeback will result in a mass-ban and account wipe.\n" +
                "- Please remember we have all the logs of claimed donations and pos claims.",true );
        eb.addField("Language", " \n- Keep the discord and in game main chat areas English only. Feel free to take conversations in another language to pms.",true );
        eb.addField("VPN, Proxy, and Multi Voting/Multi Claiming YT ", " \n- Using a VPN or a proxy to avoid the vote timers or to vote on multiple accounts is not tolerated.\n" +
                "- Using your mobile data to vote for you is considered multi voting, and this is not tolerated.\n" +
                "- Voting multiple times for 1 account or having someone else vote for you to bypass our system will also not be tolerated\n" +
                "- Any other ways of trying to avoid or bypass our vote systems are also not allowed and will result in swift bans\n" +
                "- Claiming ::yt rewards on more than 1 account is strictly prohibited. Doing this will have your accounts banned.",true );
        eb.addField("Acc Sharing", " \n -Account sharing is allowed, however it is your own responsibility. If the account gets hacked or items are stolen we do not issue refunds.\n" +
                "- However account sharing to purposefully win a giveaway or event is not allowed. ",true );
        eb.addField("Avoiding Rules", " \n -We only allow you to have up to 2 regular accounts , 1 Iron man account, and 1 survivalist account online at any given time. You are allowed to have other accounts. AFK accounts are excluded from this rule. Just ONLINE is the term here.\n" +
                "- We allow 2 accounts at any AFK zone regardless of game mode.\n" +
                "- You are not allowed to use an account to help boost another one of your accounts. That is against the spirit of the game, and against our rules.\n" +
                "- You are also not allowed to be boosted by any other accounts, this includes any minigames, duo slayer, raids and more while the other account does not participate. (Team slayer isn't effected by this rule because it doesn't make sense to expect every player in the team will always be online)",true );
        eb.addField("Gambling", " \n -We do intend on having gambling in the future, for the time being though we don't want players gambling until we can get our systems put into place. Gambling during this time is NOT allowed and will result in actions being taken.",true );
        eb.addField("Sharing Donator Perks", " \n - We do not allow the sharing of donation perks (access to donator areas, donator activities, double donator pets, etc)",true );
        eb.addField("Giveaways", " \n - We host many events here on Avalon and we give out a lot of great rewards. We have an event team who deals with all the biggest giveaways. You are ALLOWED to do giveaways, however you are NOT ALLOWED to do giveaways over 100T Value In-Game!\n" +
                "- If you want to do a giveaway you HAVE to get it verified by a staff member\n" +
                "- Giveaways Include all of the following (Trading, Drop Parties, Gambling, Player Owned Shops aka POS)",true );

        eb.setColor(Color.RED);
        e.getChannel().sendMessage(eb.build()).queue();
    }
}
