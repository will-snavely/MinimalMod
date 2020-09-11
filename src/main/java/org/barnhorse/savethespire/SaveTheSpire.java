package org.barnhorse.savethespire;

import basemod.BaseMod;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class SaveTheSpire implements
        basemod.interfaces.OnStartBattleSubscriber,
        basemod.interfaces.OnCardUseSubscriber,
        basemod.interfaces.StartGameSubscriber {
    public static final Logger logger = LogManager.getLogger(SaveTheSpire.class.getName());

    public static void fooBar(int i){}

    public static void main(String args[]) {
        System.out.println("Hello World");
        for(int i = 0; i < 100; i++) {
            fooBar(i);
        }
        System.exit(-1);
    }
    public SaveTheSpire() {
        BaseMod.subscribe(this);
    }

    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("========================= Initializing SaveTheSpire Mod =========================");
        SaveTheSpire mod = new SaveTheSpire();
        logger.info("========================= SaveTheSpire Mod Initialized =========================");
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

    @Override
    public void receiveStartGame() {
        logger.info(" == Game Start");
    }
}
