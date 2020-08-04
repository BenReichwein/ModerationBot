package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class Trivia extends ListenerAdapter {

    static String q = null; // Question
    static String a = null; // A
    static String b = null; // B
    static String c = null; // C
    static String d = null; // D
    static String an = null; // Answer
    static String w1 = null; // Wrong Answer
    static String w2 = null; // Wrong Answer
    static String w3 = null; // Wrong Answer
    static boolean run = false;
    static EmbedBuilder eb = new EmbedBuilder();
    static EmbedBuilder m = new EmbedBuilder();
    static EmbedBuilder correctt = new EmbedBuilder();
    static EmbedBuilder wrongt = new EmbedBuilder();
    static boolean correct = false;
    static boolean incorrect = false;
    static int min = 0;
    static int max = 2;
    static int value = -1;
    static int questionNum = -1;


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        Color  orange   = new Color(252, 123, 3);

        correctt.setTitle("Correct! `(+1)`");
        correctt.setColor(Color.GREEN);
        correctt.setFooter("+1 Coin!", e.getGuild().getIconUrl());

        wrongt.setTitle("Wrong! `(-1)`");
        wrongt.setColor(Color.RED);
        wrongt.setFooter("-1 Coin!", e.getGuild().getIconUrl());

        String[] message = e.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("-play") && message.length == 1) {
            eb.setTitle("Games");
            eb.addField("Type `-[game]` to start!", "**Trivia** - Brain Buster mode", true);
            eb.setColor(orange);
            e.getChannel().sendMessage(eb.build()).queue();
            eb.clear();
        }

        if(message[0].equalsIgnoreCase("-trivia") && message.length == 1) {
            eb.setTitle("TRIVIA... Game Starting!");
            eb.setColor(orange);
            eb.addField("How to play", "Type -A, -B, -C, -D... Depending on the answer", true);
            e.getChannel().sendMessage(eb.build()).queue();
            eb.clear();
            questionNum = 0;
            Questions(questionNum, message, e);
        }

        if(message[0].equalsIgnoreCase(an) && message.length <= 2) {
            e.getChannel().sendMessage(correctt.build()).queue();
            correct = true;
        } else if(message[0].equalsIgnoreCase(w1) && message.length <= 2) {
            e.getChannel().sendMessage(wrongt.build()).queue();
            incorrect = true;
        } else if(message[0].equalsIgnoreCase(w2) && message.length <= 2) {
            e.getChannel().sendMessage(wrongt.build()).queue();
            incorrect = true;
        } else if(message[0].equalsIgnoreCase(w3) && message.length <= 2) {
            e.getChannel().sendMessage(wrongt.build()).queue();
            incorrect = true;
        }
        if (correct || incorrect)
        {
            run = false;
            Questions(questionNum, message,e);
        }
    }

    public static void Questions(int questionNum, String[] message, GuildMessageReceivedEvent e)
    {
        incorrect = false;
        correct = false;
        Color  orange   = new Color(252, 123, 3);
        Random rand = new Random();
        if (questionNum == 0)
        {

            value = rand.nextInt(max) + min;

            delay(2000);

            if (value == 0) {
                q = "**Calculate using BEDMAS**:\n (4 x 4) ÷ 2 = ?";
                a = "8";
                b = "2";
                c = "16";
                d = "None";
                an = "-a";
                w1 = "-b";
                w2 = "-c";
                w3 = "-d";
            }
            if (value == 1) {
                q = "**Calculate**:\n 9 x 9 - 10 = ?";
                a = "-81";
                b = "81";
                c = "71";
                d = "91";
                an = "-c";
                w1 = "-b";
                w2 = "-a";
                w3 = "-d";
            }

            if (!run) {
                m.setTitle("TRIVIA");
                m.setColor(orange);
                m.addField("----------------------", q + "\n\n**-A** -️ " + a + "\n**-B** -️ " + b + "\n**-C** -️ " + c + "\n**-D** -️ " + d, true);
                e.getChannel().sendMessage(m.build()).queue();
                m.clear();
                run = true;
            }
        }
    }

    public static void delay(int milli){ //delays
        try{
            Thread.sleep(milli);
        }
        catch(Exception e){
            Thread.interrupted();
        }
    }
}