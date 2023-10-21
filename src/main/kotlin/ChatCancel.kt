import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.plugin.java.JavaPlugin

class ChatListener : Listener {
    @EventHandler
    fun onChatEvent(event: AsyncPlayerChatEvent) {
        event.isCancelled = true
    }
}

class ChatCancel : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(ChatListener(), this)
    }
}
