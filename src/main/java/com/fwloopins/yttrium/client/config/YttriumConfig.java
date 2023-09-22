package com.fwloopins.yttrium.client.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Yttrium")
public class YttriumConfig implements ConfigData {
    @ConfigEntry.Category("Tweaks")
    @ConfigEntry.Gui.TransitiveObject
    public Tweaks tweaks = new Tweaks();

    public static class Tweaks {
        @ConfigEntry.Gui.Tooltip
        public String clientBrand = "";
        @ConfigEntry.Gui.Tooltip
        public boolean nullMovement = false;
        @ConfigEntry.Gui.Tooltip
        public boolean spectatorCrosshair = false;
        @ConfigEntry.Gui.Tooltip
        public boolean trueXP = false;
    }
}
