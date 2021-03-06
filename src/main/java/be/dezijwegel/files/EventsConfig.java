package be.dezijwegel.files;

import be.dezijwegel.runnables.DateChecker;
import be.dezijwegel.interfaces.Reloadable;
import org.bukkit.plugin.java.JavaPlugin;

public class EventsConfig implements Reloadable {

    private JavaPlugin plugin;
    private ConfigAPI configAPI;

    public EventsConfig(JavaPlugin plugin)
    {
        this.plugin = plugin;
        configAPI = new ConfigAPI(ConfigAPI.FileType.EVENTS, true, plugin);
    }


    /**
     * Check whether a certain event is enabled on this server
     * @return true if enabled, false otherwise
     */
    public boolean isEnabled(DateChecker.EventType type)
    {
        String path = "enable_";
        path += type.toString().toLowerCase();
        return configAPI.getBoolean(path);
    }


    /**
     * Get whether or not a specific option is enabled
     * @param path the path to the option
     * @return the current option of this setting, or default if non-existant
     */
    public boolean getBoolean(String path)
    {
        return configAPI.getBoolean(path);
    }


    @Override
    public void reload() {
        configAPI = new ConfigAPI(ConfigAPI.FileType.EVENTS, true, plugin);
    }
}
