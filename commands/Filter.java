package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Filter extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();

        if(FilterOnOff.filterOn){
            String[] LIST_OF_BAD_WORDS = {"anal", "anus", "arse", "ass", "motherfucker", "balls", "bastard", "bitch", "blowjob", "blow job", "buttplug","cock","coon","cunt","dildo","fag","dyke","fuck","fucking","nigger","Goddamn","jizz","nigga","pussy","shit","whore","This server sucks","slut"};
            String[] message = e.getMessage().getContentRaw().split(" ");
            for(int i = 0;i < message.length;i++){
                boolean badWord = false;
                //Check each message for each bad word
                for(int b = 0; b < LIST_OF_BAD_WORDS.length;b++){
                    if (message[i].equalsIgnoreCase(LIST_OF_BAD_WORDS[b])){
                        e.getMessage().delete().queue();
                        badWord = true;
                        if(FilterMessage.allowed){ //Prints a message saying watch your language IF enabled by -filtermessage
                            eb.setTitle("Dont Swear! "+ e.getMember().getUser().getName());
                            eb.setColor(Color.RED);
                            eb.setFooter("Do -togglefilter to disable", e.getGuild().getIconUrl());
                            e.getChannel().sendMessage(eb.build()).queue();
                        }
                    }
                }
                System.out.println(message[i] + " " + badWord); //Just a report for console
            }
        }
    }
}
