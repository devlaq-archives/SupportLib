package supportlib;

import org.bukkit.plugin.java.JavaPlugin;
import supportlib.util.Log;

public final class SupportLib extends JavaPlugin {

    public int protocolVersion = 0;

    @Override
    public void onEnable() {
        Log.infoTag("SupportLib", "Enabling SupportLib (protocol version " + protocolVersion + ")");

        Log.infoTag("SupportLib", "Enabled SupportLib (protocol version " + protocolVersion + ")");
    }

    @Override
    public void onDisable() {
        Log.infoTag("SupportLib", "Disabling SupportLib (protocol version " + protocolVersion + ")");

        Log.infoTag("SupportLib", "Disabling SupportLib (protocol version " + protocolVersion + ")");
    }
}
