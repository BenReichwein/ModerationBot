package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Help extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        Color  orange   = new Color(252, 123, 3);
        String[] message = e.getMessage().getContentRaw().split(" ");

        if (message[0].equalsIgnoreCase("-help") && message.length == 1) {
            eb.setTitle("All Command Categories");
            eb.setColor(orange);
            eb.addField("Type `-help [name]` for more info", "**Info** - Information Commands\n **Help** - Help Commands\n **Games** - Games Commands\n **Filter** - Filter Commands\n **Extra** - Fun Extra Commands", true);
            e.getChannel().sendMessage(eb.build()).queue();
        } else if(message.length >- 2 && message[0].equalsIgnoreCase("-help") &&message[1].equalsIgnoreCase("info")) {
            eb.setColor(orange);
            eb.addField("**Info Commands**", "**Command** `-Website`\nDisplay's Link For Website\n\n**Command** `-Invite`\nCreates Invite To The Discord\n\n**Command** `-Download`\nDisplay's Link To Download The Brain Buster App", true);
            e.getChannel().sendMessage(eb.build()).queue();
        } else if(message.length >- 2 && message[0].equalsIgnoreCase("-help") &&message[1].equalsIgnoreCase("filter")) {
            eb.setColor(orange);
            eb.addField("**Filter Commands**", "**Command** `-togglefilter`\nToggles The Filter\n\n**Command** `-filtermessage`\nToggles The Filter Message", true);
            e.getChannel().sendMessage(eb.build()).queue();
        } else if(message.length >- 2 && message[0].equalsIgnoreCase("-help") &&message[1].equalsIgnoreCase("games")) {
            eb.setColor(orange);
            eb.addField("**Games Commands**", "**Command** `-trivia`\nPlay Brain Buster Trivia\n\n**Command** `-toggleunscramble`\nUnscramble words ever 20 messages sent in the chat", true);
            e.getChannel().sendMessage(eb.build()).queue();
        } else if(message.length >- 2 && message[0].equalsIgnoreCase("-help") &&message[1].equalsIgnoreCase("extra")) {
            eb.setColor(orange);
            eb.addField("**Extra Commands**", "**Command** `-calculator`\nAccess the calculator\n\n**Command** `-whois [name]`\nSee info on Users", true);
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
