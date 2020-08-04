package events;

import java.awt.*;
import java.util.Random;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {
            "**Welcome** [member] **to Brain Buster Discord!**\n\n**Info:**\nDo `-help`\nDo `-Website` to download the BrainBuster App",
            "**Welcome** [member] **to Party!!**\n\n**Info:**\nDo `-help`\nDo `-Website` to download the BrainBuster App",
            "**Welcome** [member] **to Brain Buster Discord!**\n\n**Info:**\nDo `-help`\nDo `-Website` to download the BrainBuster App\n\nGo Introduce yourself in #general!",
    };

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.ORANGE);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

        // Add role
        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Member", true)).complete();
    }
}

