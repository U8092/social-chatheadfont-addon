package ovh.mythmc.social.addons.chatheadfont.placeholders;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.minso.chathead.API.ChatHeadAPI;
import ovh.mythmc.social.api.context.SocialParserContext;
import ovh.mythmc.social.api.text.parsers.SocialContextualPlaceholder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ChatHeadFontPlaceholder extends SocialContextualPlaceholder {

    private final ChatHeadAPI chatHeadAPI;

    public ChatHeadFontPlaceholder() {
        chatHeadAPI = ChatHeadAPI.getInstance();
    }

    private final Map<UUID, Component> cachedHeads = new HashMap<>();

    @Override
    public String identifier() {
        return "chathead";
    }

    @Override
    public Component get(SocialParserContext context) {
        if (cachedHeads.containsKey(context.socialPlayer().getUuid()))
            return cachedHeads.get(context.socialPlayer().getUuid());

        if (context.socialPlayer().getPlayer() == null)
            return Component.empty();

        String headAsString = chatHeadAPI.getHeadAsString(context.socialPlayer().getPlayer());
        Component head = LegacyComponentSerializer.legacySection().deserialize(headAsString);

        cachedHeads.put(context.socialPlayer().getUuid(), head);
        return head;
    }

}
