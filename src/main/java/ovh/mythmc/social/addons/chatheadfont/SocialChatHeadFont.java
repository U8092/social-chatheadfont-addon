package ovh.mythmc.social.addons.chatheadfont;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import ovh.mythmc.gestalt.Gestalt;
import ovh.mythmc.gestalt.loader.BukkitGestaltLoader;
import ovh.mythmc.social.addons.chatheadfont.listeners.GestaltSocialListener;

public final class SocialChatHeadFont extends JavaPlugin {

    private BukkitGestaltLoader gestalt;

    @Override
    public void onEnable() {
        if (!Bukkit.getServer().getOnlineMode()) {
            getLogger().severe("Plugin cannot run if online-mode is set to false!");
            return;
        }

        gestalt = BukkitGestaltLoader.builder()
            .initializer(this)
            .build();

        gestalt.initialize();

        Gestalt.get().getListenerRegistry().register(new GestaltSocialListener(), true);
    }

    @Override
    public void onDisable() {
        gestalt.terminate();
    }

}
