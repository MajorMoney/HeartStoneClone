package Game;
import GUI.BoardBackground;
import GUI.GamePanel;
import javax.swing.*;

public class GameStart {

    public static JFrame window;
    public static void main(String[] args)
    {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setTitle("HeartStoneClone");
        window.setVisible(true);

        //TODO Make BoardBackgroud recive JFrame measures instead of the Jframe object
        BoardBackground board = new BoardBackground(window);

        GameState gameState = GameState.getInstance();
        GamePanel gamePanel = new GamePanel(gameState);

        board.add(gamePanel);
        window.add(board);
        window.pack();

        gamePanel.startGameThread();
        gameState.startGameLogic();
    }

}
