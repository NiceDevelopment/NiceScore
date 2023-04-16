package ayo.desistirei.nicescore;

import ayo.desistirei.nicescore.commands.NiceScoreCommand;
import ayo.desistirei.nicescore.scoreboard.api.Assemble;
import ayo.desistirei.nicescore.scoreboard.api.AssembleStyle;
import ayo.desistirei.nicescore.scoreboard.api.adapter.ScoreboardAdapter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.andyreckt.sunset.Sunset;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class NiceScore extends JavaPlugin {

    @Getter @Setter
    public static NiceScore instance;

    @Override
    public void onEnable() {
        // Basic Plugin Stuff
        setInstance(this);
        FileConfiguration config = this.getConfig();
        String assemblestyle = config.getString("misc.assemble-style");

        // Scoreboard API initialization
        Assemble assemble = new Assemble(this, new ScoreboardAdapter());
        assemble.setTicks(2);
        if (assemblestyle == "VIPER") {
            assemble.setAssembleStyle(AssembleStyle.VIPER);
        }
        else if (assemblestyle == "KOHI") {
            assemble.setAssembleStyle(AssembleStyle.KOHI);
        }
        else if (assemblestyle == "MODERN") {
            assemble.setAssembleStyle(AssembleStyle.MODERN);
        } else {
            assemble.setAssembleStyle(AssembleStyle.VIPER);
        }

        // Command Framework initialization
        Sunset sunset = new Sunset(this);
        sunset.registerCommands(new NiceScoreCommand());
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

}
