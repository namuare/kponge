package me.mocha.spongeplugin

import com.google.inject.Inject
import org.slf4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GamePreInitializationEvent
import org.spongepowered.api.plugin.Plugin

@Plugin(
    id = "kponge",
    name = "Kponge",
    version = "1.0-SNAPSHOT",
    description = "kotlin runtime provider for sponge"
)
class Kponge {

    @Inject
    lateinit var logger: Logger

    @Listener
    fun onPreInit(event: GamePreInitializationEvent) {
        logger.info("providing kotlin v${KotlinVersion.CURRENT}")
    }

}