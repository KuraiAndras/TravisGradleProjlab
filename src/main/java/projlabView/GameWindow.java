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
                    case "BoxOnField":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnField())));
                        break;
                    case "BoxOnFieldWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnFieldWithOil())));
                        break;
                    case "BoxOnFieldWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnFieldWithHoney())));
                        break;
                    case "BoxOnSwitch":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnSwitch())));
                        break;
                    case "BoxOnSwitchWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnSwitchWithOil())));
                        break;
                    case "BoxOnSwitchWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnSwitchWithHoney())));
                        break;
                    case "BoxOnTarget":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnTarget())));
                        break;
                    case "BoxOnTargetWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnTargetWithOil())));
                        break;
                    case "BoxOnTargetWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnTargetWithHoney())));
                        break;
                    case "Wall":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getWall())));
                        break;
                    case "Field":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getField())));
                        break;
                    case "FieldWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getFieldWithOil())));
                        break;
                    case "FieldWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getFieldWithHoney())));
                        break;
                    case "PlayerOnField":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnField())));
                        break;
                    case "PlayerOnFieldWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnFieldWithOil())));
                        break;
                    case "PlayerOnFieldWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnFieldWithHoney())));
                        break;
                    case "PlayerOnSwitch":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnSwitch())));
                        break;
                    case "PlayerOnSwitchWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnSwitchWithOil())));
                        break;
                    case "PlayerOnSwitchWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnSwitchWithHoney())));
                        break;
                    case "PlayerOnTarget":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnTarget())));
                        break;
                    case "PlayerOnTargetWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnTargetWithOil())));
                        break;
                    case "PlayerOnTargetWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnTargetWithHoney())));
                        break;
                    case "Target":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getTarget())));
                        break;
                    case "TargetWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getTargetWithOil())));
                        break;
                    case "TargetWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getTargetWithHoney())));
                        break;
                    case "Switch":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getSwitchImage())));
                        break;
                    case "SwitchWithOil":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getSwitchImageWithOil())));
                        break;
                    case "SwitchWithHoney":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getSwitchImageWithHoney())));
                        break;
                    case "Hole":
                        panel.add(new JLabel(new ImageIcon(ImageManager.getHole())));
                        break;

                }
            }
        }

        panel.updateUI();
    }


}
