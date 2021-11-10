package net.noads.mixins;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public abstract class ChatHudMixin {

    @Inject(at = @At("HEAD"), method = "addMessage", cancellable = true)
    private void addMessage(Text message, CallbackInfo info) {
        if (message.asString().contains("[AD]")) {
            info.cancel();
        }
    }

}

