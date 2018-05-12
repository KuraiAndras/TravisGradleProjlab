package projlabView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageManager {

    private static Image box;
    private static Image boxOnFieldWithHoney;
    private static Image boxOnFieldWithOil;
    private static Image boxOnSwitch;
    private static Image boxOnSwitchWithHoney;
    private static Image boxOnSwitchWithOil;
    private static Image boxOnTarget;
    private static Image boxOnTargetWithHoney;
    private static Image boxOnTargetWithOil;

    private static Image field;
    private static Image fieldWithHoney;
    private static Image fieldWithOil;

    private static Image hole;

    private static Image playerOnField;
    private static Image playerOnFieldWithHoney;
    private static Image playerOnFieldWithOil;
    private static Image playerOnSwitch;
    private static Image playerOnSwitchWithHoney;
    private static Image playerOnSwitchWithOil;
    private static Image playerOnTarget;
    private static Image playerOnTargetWithHoney;
    private static Image playerOnTargetWithOil;

    private static Image switchImage;
    private static Image switchImageWithHoney;
    private static Image switchImageWithOil;

    private static Image target;
    private static Image targetWithHoney;
    private static Image targetWithOil;

    private static Image wall;

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

    public static Image getBoxOnFieldWithHoney() {
        if (boxOnFieldWithHoney == null) {
            try {
                boxOnFieldWithHoney = ImageIO.read(new FileInputStream("graphics/BoxOnFieldWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnFieldWithHoney;
    }

    public static Image getBoxOnFieldWithOil() {
        if (boxOnFieldWithOil == null) {
            try {
                boxOnFieldWithOil = ImageIO.read(new FileInputStream("graphics/BoxOnFieldWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnFieldWithOil;
    }

    public static Image getBoxOnSwitch() {
        if (boxOnSwitch == null) {
            try {
                boxOnSwitch = ImageIO.read(new FileInputStream("graphics/BoxOnSwitch.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnSwitch;
    }

    public static Image getBoxOnSwitchWithHoney() {
        if (boxOnSwitchWithHoney == null) {
            try {
                boxOnSwitchWithHoney = ImageIO.read(new FileInputStream("graphics/BoxOnSwitchWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnSwitchWithHoney;
    }

    public static Image getBoxOnSwitchWithOil() {
        if (boxOnSwitchWithOil == null) {
            try {
                boxOnSwitchWithOil = ImageIO.read(new FileInputStream("graphics/BoxOnSwitchWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnSwitchWithOil;
    }

    public static Image getBoxOnTarget() {
        if (boxOnTarget == null) {
            try {
                boxOnTarget = ImageIO.read(new FileInputStream("graphics/BoxOnTarget.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnTarget;
    }

    public static Image getBoxOnTargetWithHoney() {
        if (boxOnTargetWithHoney == null) {
            try {
                boxOnTargetWithHoney = ImageIO.read(new FileInputStream("graphics/BoxOnTargetWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnTargetWithHoney;
    }

    public static Image getBoxOnTargetWithOil() {
        if (boxOnTargetWithOil == null) {
            try {
                boxOnTargetWithOil = ImageIO.read(new FileInputStream("graphics/BoxOnTargetWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnTargetWithOil;
    }

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

    public static Image getFieldWithHoney() {
        if (fieldWithHoney == null) {
            try {
                fieldWithHoney = ImageIO.read(new FileInputStream("graphics/FieldWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return fieldWithHoney;
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

    public static Image getPlayerOnTarget() {
        if (playerOnTarget == null) {
            try {
                playerOnTarget = ImageIO.read(new FileInputStream("graphics/PlayerOnTarget.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnTarget;
    }

    public static Image getPlayerOnTargetWithHoney() {
        if (playerOnTargetWithHoney == null) {
            try {
                playerOnTargetWithHoney = ImageIO.read(new FileInputStream("graphics/PlayerOnTargetWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnTargetWithHoney;
    }

    public static Image getPlayerOnTargetWithOil() {
        if (playerOnTargetWithOil == null) {
            try {
                playerOnTargetWithOil = ImageIO.read(new FileInputStream("graphics/PlayerOnTargetWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return playerOnTargetWithOil;
    }

    public static Image getSwitchImage() {
        if (switchImage == null) {
            try {
                switchImage = ImageIO.read(new FileInputStream("graphics/SwitchImage.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return switchImage;
    }

    public static Image getSwitchImageWithHoney() {
        if (switchImageWithHoney == null) {
            try {
                switchImageWithHoney = ImageIO.read(new FileInputStream("graphics/SwitchImagewithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return switchImageWithHoney;
    }

    public static Image getSwitchImageWithOil() {
        if (switchImageWithOil == null) {
            try {
                switchImageWithOil = ImageIO.read(new FileInputStream("graphics/SwitchImagewithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return switchImageWithOil;
    }


    public static Image getTarget() {
        if (target == null) {
            try {
                target = ImageIO.read(new FileInputStream("graphics/Target.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return target;
    }

    public static Image gettargetWithHoney() {
        if (targetWithHoney == null) {
            try {
                targetWithHoney = ImageIO.read(new FileInputStream("graphics/TargetWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return targetWithHoney;
    }

    public static Image gettargetWithOil() {
        if (targetWithOil == null) {
            try {
                targetWithOil = ImageIO.read(new FileInputStream("graphics/TargetWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return targetWithOil;
    }

    public static Image getWall() {
        if (wall == null) {
            try {
                wall = ImageIO.read(new FileInputStream("graphics/Wall.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return wall;
    }
}
