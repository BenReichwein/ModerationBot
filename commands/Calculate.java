package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Calculate extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        Color  orange   = new Color(252, 123, 3);

        String[] message = e.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("-calculate") && message.length == 1) {
            eb.setColor(orange);
            eb.addField("To use this command type (without brackets): ", "-calculate [add/sub] [first-num] [second-num]", true);
            e.getChannel().sendMessage(eb.build()).queue();
        } else if(message[0].equalsIgnoreCase("-calculate") && message[1].equalsIgnoreCase(("add"))){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            eb.setColor(Color.GREEN);
            eb.addField("Result: ", " " + (num1 + num2), true);
            e.getChannel().sendMessage(eb.build()).queue();
        } else if(message[0].equalsIgnoreCase("-calculate") && message[1].equalsIgnoreCase("sub")) {
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            eb.setColor(Color.GREEN);
            eb.addField("Result: ", " " + (num1 - num2), true);
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
