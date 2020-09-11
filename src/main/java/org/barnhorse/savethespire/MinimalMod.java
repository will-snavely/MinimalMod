package org.barnhorse.savethespire;

import basemod.BaseMod;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class MinimalMod implements
        basemod.interfaces.OnStartBattleSubscriber,
        basemod.interfaces.OnCardUseSubscriber {
    public static final Logger logger = LogManager.getLogger(MinimalMod.class.getName());

    public MinimalMod() {
        BaseMod.subscribe(this);
    }

    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("========================= Initializing MinimalMod Mod =========================");
        MinimalMod mod = new MinimalMod();
    }

    @Override
    public void receiveOnBattleStart(AbstractRoom abstractRoom) {
        logger.info("== Entered room");
        logger.info("== Monsters present:");
        abstractRoom.monsters.monsters.forEach((monster) -> {
            logger.info(String.format("\t* %s (%d HP)", monster.name, monster.currentHealth));
        });
    }

    @Override
    public void receiveCardUsed(AbstractCard abstractCard) {
        logger.info(" == Played card: " + abstractCard.name);
    }
}
