package com.gostop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollectionOfCards {
    int score;
    boolean sepAnimalIsJunk;
    List<Card> animals;
    List<Card> brights;
    List<Card> junk;
    List<Card> junkAnimal;
    List<Card> ribbons;

    public CollectionOfCards() {
        this.score = 0;
        this.sepAnimalIsJunk = false;
        this.animals = new ArrayList<>();
        this.brights = new ArrayList<>();
        this.junk = new ArrayList<>();
        this.junkAnimal = new ArrayList<>();
        this.ribbons = new ArrayList<>();
    }

    public CollectionOfCards addCards(Stack<Card> cards) {
        while (cards.size() > 0) {
            Card card = cards.pop();
            this.addCard(card);
        }
        this.updateScore();
        return this;
    }

    public void addCard(Card card) {
        switch (card.getCategory()) {
            case ANIMAL:
                this.animals.add(card);
                break;
            case BRIGHT:
                this.brights.add(card);
                break;
            case JUNK:
                this.junk.add(card);
                break;
            case JUNK_ANIMAL:
                this.junkAnimal.add(card);
                break;
            case RIBBON:
                this.ribbons.add(card);
                break;
        }
    }

    public void setSepAnimalIsJunk(boolean isJunk) {
        this.sepAnimalIsJunk = isJunk;
    }

    public void updateScore() {
        int totalPoints = 0;
        totalPoints += this.countAnimalPoints();
        totalPoints += this.countBrightPoints();
        totalPoints += this.countJunkPoints();
        totalPoints += this.countRibbonPoints();

        this.score = totalPoints;
    }

    public int getScore() {
        return this.score;
    }

    private int countAnimalPoints() {
        int animalPoints = 0;
        int animalCount = 0;
        int birdCount = 0;
        int decemberBirdCount = 0;

        if (!this.sepAnimalIsJunk) {
            animalCount += this.junkAnimal.size();
        }
        for (Card card : this.animals) {
            animalCount += 1;
            if (card.getSpecial() == CardSpecial.BIRD) {
                if (card.getSuit() == CardSuit.DEC) {
                    decemberBirdCount++;
                } else {
                    birdCount++;
                }
            }
        }
        if (animalCount >= 5) {
            animalPoints += animalCount - 4;
        }
        if (birdCount == 3) {
            if (decemberBirdCount == 1) {
                animalPoints += 10;
            } else {
                animalPoints += 5;
            }
        }

        return animalPoints;
    }

    private int countBrightPoints() {
        int brightPoints = 0;
        int brightCount = 0;
        int decemberBrightCount = 0;

        for (Card card : this.brights) {
            if (card.getSuit() == CardSuit.DEC) {
                decemberBrightCount++;
            } else {
                brightCount++;
            }
        }
        switch (brightCount + decemberBrightCount) {
            case 3:
                brightPoints += brightCount - decemberBrightCount;
                break;
            case 4:
                brightPoints += 4;
                break;
            case 5:
                brightPoints += 15;
                break;
        }

        return brightPoints;
    }

    private int countJunkPoints() {
        int junkPoints = 0;
        int junkCount = 0;

        if (this.sepAnimalIsJunk) {
            junkCount += this.junkAnimal.size() * 2;
        }
        for (Card card : this.junk) {
            if (card.getSpecial() == CardSpecial.DOUBLE) {
                junkCount += 2;
            } else {
                junkCount++;
            }
        }
        if (junkCount >= 10) {
            junkPoints += junkCount - 9;
        }

        return junkPoints;
    }

    private int countRibbonPoints() {
        int ribbonPoints = 0;
        int ribbonCount = 0;
        int redLabelCount = 0;
        int blueLabelCount = 0;
        int blankRedCount = 0;

        for (Card card : this.ribbons) {
            ribbonCount++;
            if (card.getSpecial() != null) {
                switch (card.getSpecial()) {
                    case RED_LABEL:
                        redLabelCount++;
                        break;
                    case BLUE_LABEL:
                        blueLabelCount++;
                        break;
                    case BLANK_RED:
                        blankRedCount++;
                        break;
                }
            }
        }
        if (ribbonCount >= 5) {
            ribbonPoints += ribbonCount - 4;
        }
        if (redLabelCount == 3) {
            ribbonPoints += 3;
        }
        if (blueLabelCount == 3) {
            ribbonPoints += 3;
        }
        if (blankRedCount == 3) {
            ribbonPoints += 3;
        }

        return ribbonPoints;
    }
}
