package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class InviteCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        Color  orange   = new Color(252, 123, 3);
        int timeString = 3600;
        String[] message = e.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("-invite") && message.length == 1) {
            eb.addField("To Create An Invite Do", "-Invite Create", true);
            eb.setColor(orange);
            e.getChannel().sendMessage(eb.build()).queue();
        } else if(message.length >- 2 && message[0].equalsIgnoreCase("-invite") &&message[1].equalsIgnoreCase("create")) {
            eb.setTitle("You have created an invite!");
            eb.setColor(Color.GREEN);
            eb.addField("Link:", e.getChannel().createInvite().setMaxAge(timeString).complete().getURL(), true);
            eb.addField("The invite expires in: ", + timeString + " seconds.", true);
            eb.setFooter("Copy and Paste", e.getGuild().getIconUrl());
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
