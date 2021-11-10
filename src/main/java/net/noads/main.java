package net.noads;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;


public class main implements ModInitializer {

    public static boolean ads = false;

    @Override
    public void onInitialize() {

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("toggleads").executes(context -> {
                if (!ads) {
                    context.getSource().getPlayer().sendMessage(Text.of("[NoAds] Ads are now shown."), false);
                    ads = true;
                } else {
                    context.getSource().getPlayer().sendMessage(Text.of("[NoAds] Ads are now hidden."), false);
                    ads = false;
                }
                return 1;
            }));
        });
        System.out.println("[NoAds] Made by 5EUS.");

    }
}
