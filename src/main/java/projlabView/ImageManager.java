package projlabView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageManager {
    private static Image field;
    private static Image box;
    private static Image fieldWithOil;
    private static Image hole;
    private static Image playerOnField;
    private static Image playerOnFieldWithHoney;
    private static Image playerOnFieldWithOil;
    private static Image playerOnSwitch;
    private static Image playerOnSwitchWithHoney;
    private static Image playerOnSwitchWithOil;
    private static Image switchImage;
    private static Image target;
    private static Image wall;

    public static Image getField() {
        if (field == null) {
            try {
                field = ImageIO.read(new FileInputStream("graphics/Field.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return field;
    }

    public static Image getBox() {
        if (box == null) {
            try {
                box = ImageIO.read(new FileInputStream("graphics/Box.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return box;
    }

    public static Image getFieldWithOil() {
        if (fieldWithOil == null) {
            try {
                fieldWithOil = ImageIO.read(new FileInputStream("graphics/FieldWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return fieldWithOil;
    }

    public static Image getHole() {
        if (hole == null) {
            try {
                hole = ImageIO.read(new FileInputStream("graphics/Hole.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return hole;
    }

    public static Image getPlayerOnField() {
        if (playerOnField == null) {
            try {
                playerOnField = ImageIO.read(new FileInputStream("graphics/PlayerOnField.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnField;
    }

    public static Image getPlayerOnFieldWithHoney() {
        if (playerOnFieldWithHoney == null) {
            try {
                playerOnFieldWithHoney = ImageIO.read(new FileInputStream("graphics/PlayerOnFieldWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnFieldWithHoney;
    }

    public static Image getPlayerOnFieldWithOil() {
        if (playerOnFieldWithOil == null) {
            try {
                playerOnFieldWithOil = ImageIO.read(new FileInputStream("graphics/PlayerOnFieldWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnFieldWithOil;
    }

    public static Image getPlayerOnSwitch() {
        if (playerOnSwitch == null) {
            try {
                playerOnSwitch = ImageIO.read(new FileInputStream("graphics/PlayerOnSwitch.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnSwitch;
    }

    public static Image getPlayerOnSwitchWithHoney() {
        if (playerOnSwitchWithHoney == null) {
            try {
                playerOnSwitchWithHoney = ImageIO.read(new FileInputStream("graphics/PlayerOnSwitchWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnSwitchWithHoney;
    }

    public static Image getPlayerOnSwitchWithOil() {
        if (playerOnSwitchWithOil == null) {
            try {
                playerOnSwitchWithOil = ImageIO.read(new FileInputStream("graphics/PlayerOnSwitchWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnSwitchWithOil;
    }

    public static Image getSwitchImage() {
        if (switchImage == null) {
            try {
                switchImage = ImageIO.read(new FileInputStream("graphics/switchImage.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return switchImage;
    }

    public static Image getTarget() {
        if (target == null) {
            try {
                target = ImageIO.read(new FileInputStream("graphics/target.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return target;
    }

    public static Image getWall() {
        if (wall == null) {
            try {
                wall = ImageIO.read(new FileInputStream("graphics/wall.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return wall;
    }
}
