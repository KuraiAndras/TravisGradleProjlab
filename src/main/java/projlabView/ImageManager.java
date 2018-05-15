package projlabView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * <h1>ImageManager</h1>
 * This class is responsible
 * for opening the right image
 * for the drawing out the map
 * and the state of the game.
 */
public class ImageManager {

    /**
     * Image of boxOnField.
     */
    private static Image boxOnField;
    /**
     * Image of boxOnFieldWithHoney.
     */
    private static Image boxOnFieldWithHoney;
    /**
     * Image of boxOnFieldWithOil.
     */
    private static Image boxOnFieldWithOil;
    /**
     * Image of boxOnSwitch.
     */
    private static Image boxOnSwitch;
    /**
     * Image of boxOnSwitchWithHoney.
     */
    private static Image boxOnSwitchWithHoney;
    /**
     * Image of boxOnSwitchWithOil.
     */
    private static Image boxOnSwitchWithOil;
    /**
     * Image of boxOnTarget.
     */
    private static Image boxOnTarget;
    /**
     * Image of boxOnTargetWithHoney.
     */
    private static Image boxOnTargetWithHoney;
    /**
     * Image of boxOnTargetWithOil.
     */
    private static Image boxOnTargetWithOil;

    /**
     * Image of field.
     */
    private static Image field;
    /**
     * Image of fieldWithHoney.
     */
    private static Image fieldWithHoney;
    /**
     * Image of fieldWithOil.
     */
    private static Image fieldWithOil;

    /**
     * Image of hole.
     */
    private static Image hole;

    /**
     * Image of playerOnField.
     */
    private static Image playerOnField;
    /**
     * Image of playerOnFieldWithHoney.
     */
    private static Image playerOnFieldWithHoney;
    /**
     * Image of playerOnFieldWithOil.
     */
    private static Image playerOnFieldWithOil;
    /**
     * Image of playerOnSwitch.
     */
    private static Image playerOnSwitch;
    /**
     * Image of playerOnSwitchWithHoney.
     */
    private static Image playerOnSwitchWithHoney;
    /**
     * Image of playerOnSwitchWithOil.
     */
    private static Image playerOnSwitchWithOil;
    /**
     * Image of playerOnTarget.
     */
    private static Image playerOnTarget;
    /**
     * Image of playerOnTargetWithHoney.
     */
    private static Image playerOnTargetWithHoney;
    /**
     * Image of playerOnTargetWithOil.
     */
    private static Image playerOnTargetWithOil;

    /**
     * Image of switchImage.
     */
    private static Image switchImage;
    /**
     * Image of switchImageWithHoney.
     */
    private static Image switchImageWithHoney;
    /**
     * Image of switchImageWithOil.
     */
    private static Image switchImageWithOil;

    /**
     * Image of target.
     */
    private static Image target;
    /**
     * Image of targetWithHoney.
     */
    private static Image targetWithHoney;
    /**
     * Image of targetWithOil.
     */
    private static Image targetWithOil;

    /**
     * Image of wall.
     */
    private static Image wall;

    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnField image.
     */
    public static Image getBoxOnField() {
        if (boxOnField == null) {
            try {
                boxOnField = ImageIO.read(new FileInputStream("graphics/BoxOnField.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return boxOnField;
    }

    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnFieldWithHoney image.
     */
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

    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnFieldWithOil image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnSwitch image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnSwitchWithHoney image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnSwitchWithOil image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnTarget image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnTargetWithHone image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with BoxOnTargetWithOil image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with Field image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with FieldWithHoney image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with FieldWithOi image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with Hole image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnField image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnFieldWithHoney image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnFieldWithOil image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnSwitch image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnSwitchWithHoney image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnSwitchWithOil image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnTarget image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnTargetWithHoney image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with PlayerOnTargetWithOil image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with SwitchImage image.
     */
    public static Image getSwitchImage() {
        if (switchImage == null) {
            try {
                switchImage = ImageIO.read(new FileInputStream("graphics/Switch.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return switchImage;
    }
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with SwitchImageWithHoney image.
     */
    public static Image getSwitchImageWithHoney() {
        if (switchImageWithHoney == null) {
            try {
                switchImageWithHoney = ImageIO.read(new FileInputStream("graphics/SwitchWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return switchImageWithHoney;
    }
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with SwitchImageWithOil image.
     */
    public static Image getSwitchImageWithOil() {
        if (switchImageWithOil == null) {
            try {
                switchImageWithOil = ImageIO.read(new FileInputStream("graphics/SwitchWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return switchImageWithOil;
    }
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with Target image.
     */
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
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with TargetWithHoney image.
     */
    public static Image getTargetWithHoney() {
        if (targetWithHoney == null) {
            try {
                targetWithHoney = ImageIO.read(new FileInputStream("graphics/TargetWithHoney.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return targetWithHoney;
    }
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with TargetWithOil image.
     */
    public static Image getTargetWithOil() {
        if (targetWithOil == null) {
            try {
                targetWithOil = ImageIO.read(new FileInputStream("graphics/TargetWithOil.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return targetWithOil;
    }
    /**
     * Read the Image from given location.
     * And handle the IOException if its start up.
     * @return Return with Wall image.
     */
    public static Image getWall() {
        if (wall == null) {
            try {
                wall = ImageIO.read(new FileInputStream("graphics/WallOnField.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return wall;
    }
}
