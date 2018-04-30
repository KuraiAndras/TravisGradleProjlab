package projlabView;

import projabModel.Field;
import projabModel.Game;
import projlabController.PlayerInputListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends JFrame {

    JPanel panel = new JPanel();


    public GameWindow() {
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public void load() {
        drawElements();
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.addKeyListener(new PlayerInputListener());
    }

    //TODO: add more cases
    public void drawElements() {
        panel.removeAll();

        ArrayList<ArrayList<Field>> map = Game.getInstance().getMap();
        this.setMaximumSize(new Dimension(map.size() * 20, map.get(0).size() * 20));
        panel.setLayout(new GridLayout(map.size(), map.get(0).size()));

        for (ArrayList<Field> row : map) {
            for (Field item : row) {
                switch (item.toString()) {
                    case "Box":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBox())));
                        break;
                    case "Wall":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getWall())));
                        break;
                    case "Field":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getField())));
                        break;
                    case "Player":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnField())));
                        break;
                    case "Target":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getTarget())));
                        break;
                }
            }
        }

        panel.updateUI();
    }


}
