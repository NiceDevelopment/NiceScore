package ayo.desistirei.nicescore.commands;

import ayo.desistirei.nicescore.NiceScore;
import me.andyreckt.sunset.annotations.Command;
import me.andyreckt.sunset.annotations.Param;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static java.lang.Thread.sleep;

public class NiceScoreCommand {

    @Command(names = "nicescore", permission = "nicescore.user")
    public void command(CommandSender sender, @Param(name = "help/reload") String args) throws InterruptedException {
        Player player = (Player) sender;
        FileConfiguration config = NiceScore.getInstance().getConfig();

        if (args.equals("help")) {
            for (String line : config.getStringList("messages.help")) {
                line = line.replace("&", "§");
                player.sendMessage(line);
            }
        }
        else if (args.equals("reload")) {
            for (String line : config.getStringList("messages.reload"))
            {
                line = line.replace("&", "§");
                player.sendMessage(line);
            }

            NiceScore.getInstance().reloadConfig();
            sleep(300);

            for (String line : config.getStringList("messages.reloaded"))
            {
                line = line.replace("&", "§");
                player.sendMessage(line);
            }
        }
    }

}
