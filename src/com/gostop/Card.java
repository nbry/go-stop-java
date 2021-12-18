package com.gostop;

public class Card {
    private final CardSuit suit;
    private final CardCategory category;
    private CardSpecial special;

    public Card(CardSuit suit, CardCategory category, CardSpecial special) {
        this.suit = suit;
        this.category = category;
        this.special = special;
    }

    public Card(CardSuit suit, CardCategory type) {
        this.suit = suit;
        this.category = type;
    }

    public String toString() {
        String cardName = this.getSuit() + " - " + this.getCategory();
        if (this.getSpecial() != null) {
            cardName = cardName + "|" + this.getSpecial();
        }
        return cardName;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardCategory getCategory() {
        return category;
    }

    public CardSpecial getSpecial() {
        return special;
    }
}
