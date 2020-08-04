package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfo extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        Color  orange   = new Color(252, 123, 3);
        //Current date and time, used for footer on embededbuilder
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message.length == 1 && message[0].equalsIgnoreCase("-whois")){
            eb.addField("To get a users info, type ", "-whois [name]", true);
            eb.setColor(orange);
            e.getChannel().sendMessage(eb.build()).queue();
        }else if(message.length == 2 && message[0].equalsIgnoreCase("-whois")){
            String userName = message[1];
            User user = e.getGuild().getMembersByName(userName, true).get(0).getUser(); //Gets user as object so we can grab info from it for embed
            String avatar = e.getGuild().getMembersByName(userName, true).get(0).getUser().getAvatarUrl(); //gets url of user avatar so we can put in embed
            EmbedBuilder avatarEmbed = new EmbedBuilder(); //Creates the embed.
            //Sets the contents of the embed
            avatarEmbed.setTitle(userName + "'s Info:", e.getGuild().getIconUrl());
            avatarEmbed.setColor(orange);
            avatarEmbed.addField("Name", user.getName(), true);
            avatarEmbed.addField("Online Status", e.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmbed.addField("Avatar: ", "The Avatar is below, " + e.getMember().getAsMention(), true);
            avatarEmbed.setImage(avatar);
            avatarEmbed.setFooter("Request made @ " + formatter.format(date), e.getGuild().getIconUrl());
            //
            e.getChannel().sendMessage(avatarEmbed.build()).queue(); //Send the embed as a message
        }
    }
}