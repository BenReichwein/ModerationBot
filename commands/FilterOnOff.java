package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class FilterOnOff extends ListenerAdapter {

    public static boolean filterOn = true;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();

        if (event.getMessage().getContentRaw().equalsIgnoreCase("-togglefilter") && filterOn){
            filterOn = false;
            eb.setColor(Color.RED);
            eb.addField("Curse-Filter", "has been disabled by " + event.getMember().getUser().getName(), true);
            event.getChannel().sendMessage(eb.build()).queue();
        }else if(event.getMessage().getContentRaw().equalsIgnoreCase("-togglefilter") && !filterOn){
            filterOn = true;
            eb.setColor(Color.GREEN);
            eb.addField("Curse-Filter", "has been enabled by " + event.getMember().getUser().getName(), true);
            event.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
