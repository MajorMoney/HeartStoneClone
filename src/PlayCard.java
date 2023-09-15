import java.awt.*;

public class PlayCard implements PlayerAction{

    private Card card;
    private Point originalLocation;
    private Point destination;

    public PlayCard(Card card, Point originalLocation, Point destination) {
        this.card = card;
        this.originalLocation = originalLocation;
        this.destination = destination;
        validate();
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void resolve() {

    }
}
