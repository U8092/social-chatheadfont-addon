package ovh.mythmc.social.addons.chatheadfont.listeners;

import ovh.mythmc.gestalt.annotations.FeatureListener;
import ovh.mythmc.gestalt.features.FeatureEvent;
import ovh.mythmc.social.addons.chatheadfont.placeholders.ChatHeadFontPlaceholder;
import ovh.mythmc.social.api.Social;

public final class GestaltSocialListener {

    private final ChatHeadFontPlaceholder placeholder = new ChatHeadFontPlaceholder();

    @FeatureListener(group = "social", identifier = "BOOTSTRAP", events = FeatureEvent.ENABLE)
    public void enable() {
        Social.get().getTextProcessor().registerParser(placeholder);
    }

    @FeatureListener(group = "social", identifier = "BOOTSTRAP", events = FeatureEvent.DISABLE)
    public void disable() {
        Social.get().getTextProcessor().unregisterParser(placeholder);
    }

}
