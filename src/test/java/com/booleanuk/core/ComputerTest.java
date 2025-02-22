package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ComputerTest {
    @Test
    public void shouldTurnOn() {
        PowerSupply myPsu = new PowerSupply();
        Computer myPc = new Computer(myPsu);
        myPc.turnOn();

        Assertions.assertTrue(myPsu.getIsOn());
    }

    @Test
    public void shouldInstallGames() {
        PowerSupply myPsu = new PowerSupply();
        Computer myPc = new Computer(myPsu);


        myPc.installGame(new Game("Final Fantasy XI"));

        Assertions.assertEquals(1, myPc.getInstalledGames().size());
        Assertions.assertEquals("Final Fantasy XI", myPc.getInstalledGames().get(0).getName());
    }

    @Test
    public void shouldPlayGames() {
        PowerSupply myPsu = new PowerSupply();
        Computer myPc = new Computer(myPsu);

        myPc.installGame(new Game("Duck Game"));
        myPc.installGame(new Game("Dragon's Dogma: Dark Arisen"));

        Assertions.assertEquals("Playing Duck Game", myPc.playGame(new Game("Duck Game")));
        Assertions.assertEquals("Playing Dragon's Dogma: Dark Arisen", myPc.playGame(new Game("Dragon's Dogma: Dark Arisen")));
        Assertions.assertEquals("Game not installed", myPc.playGame(new Game("Morrowind")));
    }

    @Test
    public void canPreinstallGames() {
        PowerSupply myPsu = new PowerSupply();
        ArrayList<Game> preInstalled = new ArrayList<>(){{
            add(new Game("Dwarf Fortress"));
            add(new Game("Baldur's Gate"));
        }};

        Computer myPc = new Computer(myPsu, preInstalled);

        Assertions.assertEquals(2, myPc.getInstalledGames().size());
        Assertions.assertEquals("Dwarf Fortress", myPc.getInstalledGames().get(0).getName());
        Assertions.assertEquals("Baldur's Gate", myPc.getInstalledGames().get(1).getName());
    }


}
