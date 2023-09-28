package GameObjects;

import GameObjects.Cards.Card;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.LinkedList;

public class Board {

    private Point location;
    private int height;
    private int width;
    private int screenWidth;
    private int screenHeight;
    private LinkedList<Card> playerOneCards;
    private LinkedList<Card> playerTwoCards;


    public Board(int x, int y, int screenWidth, int screenHeight) {
        location = new Point(x, y);
        width = screenWidth - 575;
        height = screenHeight / 2;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        playerOneCards = new LinkedList<>();
        playerTwoCards = new LinkedList<>();
    }

    public Point getLocation() {
        return location;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //TODO reefactor as an  enum player1 and player2
    public LinkedList<Card> getPlayereCards(int targetPlayer) {
        if (targetPlayer == 1)
            return playerOneCards;
        if (targetPlayer == 2)
            return playerTwoCards;
        throw new InvalidParameterException("Invalid input parameter.\n\n" +
                "getPlayerCard(int targetPlayer) method must take an int from the closed interval[1:2]" +
                "but " + targetPlayer + " was given");
    }


    public void drawBoardCards(Graphics2D g2) {
        drawPlayerCards(g2, playerOneCards);
        drawPlayerCards(g2, playerTwoCards);
    }

    public void addCard(Card card, Point destination, int currentPlayer) {
        LinkedList<Card> playerBoard = getPlayereCards(currentPlayer);
        for (int i = 0; i < playerBoard.size(); i++) {
            if (playerBoard.get(i).location.x > destination.x) {
                playerBoard.add(i, card);
                updateCardPositions(playerBoard);
                return;
            }
        }
        playerBoard.addLast(card);
        updateCardPositions(playerBoard);
    }

    public void removeCard() {

    }


    private void drawPlayerCards(Graphics2D g2, LinkedList<Card> list) {
        list.forEach((card -> card.draw(g2)));
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= location.x && x <= location.x + width && y >= location.y && y <= location.y + height;
    }

    public void updateCardPositions(LinkedList<Card> list) {
        int startingIndex = 3 - list.size() / 2;
        double remainder = (double) list.size() / 2.0 - list.size() / 2;

        for (int i = 0; i < +list.size(); i++) {
            list.get(i).getLocation().setLocation(roundBoardHorizontalPositionByIndex(startingIndex + i + 1 - remainder), location.y + height * 3 / 4);
        }
    }

    private double roundBoardHorizontalPositionByIndex(double boardIndex) {
        return (275 + (screenWidth - 575) / 7 * (boardIndex));
    }

    private int getBoardIndex(Point destination) {
        return (destination.x - 275) / ((screenWidth - 575) / 7);
    }

}


