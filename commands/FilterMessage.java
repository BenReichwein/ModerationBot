package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class FilterMessage extends ListenerAdapter {

    public static boolean allowed = false;

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        EmbedBuilder eb = new EmbedBuilder();

        if(FilterOnOff.filterOn) {
            if (e.getMessage().getContentRaw().equalsIgnoreCase("-filtermessage") && !allowed) {
                eb.setColor(Color.GREEN);
                eb.addField("Filter", "Has Been Enabled", true);
                e.getChannel().sendMessage(eb.build()).queue();
                System.out.println("Enabled");
                allowed = true;
            } else if (e.getMessage().getContentRaw().equalsIgnoreCase("-filtermessage") && allowed) {
                eb.setColor(Color.RED);
                eb.addField("Filter", "Has Been Disabled", true);
                e.getChannel().sendMessage(eb.build()).queue();
                System.out.println("Disabled");
                allowed = false;
            }
        }else if(e.getMessage().getContentRaw().equalsIgnoreCase("-filtermessage") && !FilterOnOff.filterOn){
            eb.setColor(Color.ORANGE);
            eb.addField("Filter", "You can't toggle filter response while the filter is off. To turn the filter on, run -togglefilter", true);
            e.getChannel().sendMessage(eb.build()).queue();
        }


    }

}
