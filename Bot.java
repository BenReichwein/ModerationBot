import commands.*;
import events.GuildMemberJoin;
import events.GuildMemberLeave;
import events.HelloEvent;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class Bot {

    public static void main(String args[]) throws Exception{

        String TOKEN = "your token goes here";
        JDA jda = new JDABuilder(TOKEN).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setGame(Game.playing("Brain Buster App"));

        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new Calculate());
        jda.addEventListener(new InviteCommand());
        jda.addEventListener(new UserInfo());
        jda.addEventListener(new Filter());
        jda.addEventListener(new FilterMessage());
        jda.addEventListener(new FilterOnOff());
        jda.addEventListener(new Help());
        jda.addEventListener(new Clear());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
        jda.addEventListener(new Trivia());
        jda.addEventListener(new UnscrambleOnOff());
        jda.addEventListener(new Unscrambling());
        jda.addEventListener(new Website());
    }
}
