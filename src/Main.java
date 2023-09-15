import javax.swing.*;

public class Main {

    public static JFrame window;
    public static void main(String[] args)
    {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setTitle("HeartStoneClone");

        GameState gameState = GameState.getInstance();

        BoardBackground board = new BoardBackground();
        GamePanel gamePanel = new GamePanel(gameState);
        board.add(gamePanel);
        window.add(board);
        window.pack();

        gamePanel.startGameThread();

        window.setVisible(true);
    }

}
