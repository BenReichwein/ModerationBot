package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class Unscrambling extends ListenerAdapter {

    static String q = null; // Question
    static String a = null; // Answer

    static int value;
    static int qmin = 0;
    static int qmax = 1;

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        if(UnscrambleOnOff.unscrambleOn){
            EmbedBuilder eb = new EmbedBuilder();
            EmbedBuilder s = new EmbedBuilder();
            EmbedBuilder correct = new EmbedBuilder();
            EmbedBuilder wrong = new EmbedBuilder();
            Random rand = new Random();
            Color  orange   = new Color(252, 123, 3);
            String[] message = e.getMessage().getContentRaw().split(" ");

            correct.setTitle("Correct!");
            correct.setColor(Color.GREEN);

            wrong.setTitle("Wrong :/");
            wrong.setColor(Color.RED);

            value = rand.nextInt(qmax) + qmin;

            if (value == 0) {
                q = "dRe";
                a = "-red";
            }
            if (value == 1) {
                q = "ppAle";
                a = "-apple";
            }

            s.setTitle("Unscramble");
            s.setColor(orange);
            s.addField("Unscramble by typing `-unscramble [word]`", "Word: **" + q + "**", true);
            s.setFooter("+100 Reward!", e.getGuild().getIconUrl());
            //e.getChannel().sendMessage(s.build()).queue();

            if(message[0].equalsIgnoreCase(q) && message.length <= 2) {
                e.getChannel().sendMessage(correct.build()).queue();
            } else if(message[0].equalsIgnoreCase(a) && message.length <= 2) {
                e.getChannel().sendMessage(wrong.build()).queue();
            }
        }
    }
}

