package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();

        String name = event.getMember().getUser().getName();

        if(messageSent.equalsIgnoreCase("hello")){
            event.getChannel().sendMessage("Hello!! " + name).queue();
        } else if(messageSent.equalsIgnoreCase("Hi")){
            event.getChannel().sendMessage("Hi! " + name).queue();
        } else if(messageSent.equalsIgnoreCase("Hey")){
            event.getChannel().sendMessage("Hey! " + name).queue();
        }
    }
}
