package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Website extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        Color  orange   = new Color(252, 123, 3);
        String[] message = e.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("-website") && message.length == 1) {
            eb.setTitle("Website");
            eb.setColor(orange);
            eb.addField("Link:", "http://brainbusters.ca/", true);
            eb.setFooter("Click or Copy", e.getGuild().getIconUrl());
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}

