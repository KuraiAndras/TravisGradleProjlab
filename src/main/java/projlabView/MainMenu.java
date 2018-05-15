package projlabView;

import projlabController.PlayButtonListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * <h1>MainMenu</h1>
 * This class extends JFrame,
 * has the components whereby
 * MainMenu's GUI is build.
 */
public class MainMenu extends JFrame {
    /**
     * A JComboBox with list of the available
     * warehouse maps where players can play.
     */
    private JComboBox<String> listOfMaps;
    /**
     * A label for errors.
     * Users can read what caused the error.
     */
    private JLabel errorLabel = new JLabel();
    /**
     * A jpanel.
     */
    private JPanel jPanel = new JPanel();

    /**
     * This method gives back the selected
     * warehouse map from the listOfMaps as string.
     * @return The selected warehouse map as string.
     */
    public String getCurrentMap() {
        return (String) listOfMaps.getSelectedItem();
    }

    /**
     * Default constructor of MainMenu.
     * This method turn up the MainMenu's components.
     */
    public MainMenu() {
        JButton playButton = new JButton("Play");
        listOfMaps = new JComboBox<>();


        jPanel.add(playButton);
        jPanel.add(listOfMaps);

        listOfMaps.setModel(new DefaultComboBoxModel<>(CreateMapList()));

        playButton.addActionListener(new PlayButtonListener());

        this.setMinimumSize(new Dimension(800, 600));
        this.add(jPanel, BorderLayout.CENTER);
        jPanel.add(errorLabel, BorderLayout.SOUTH);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     *This method reads warehouse maps name
     * as String from given directory.
     * @return List of maps whence
     * players can choose warehouse map.
     */
    private Vector<String> CreateMapList() {
        String partialMapPath = "maps/playableMaps";
        File directory = new File(partialMapPath);
        Vector<String> mapList = new Vector<>();

        if (directory.isDirectory()) {
            String[] files = directory.list();
            Pattern pattern = Pattern.compile("^(.*?)\\.txt$");
            assert files != null;

            for (String file : files) {
                Matcher matcher = pattern.matcher(file);
                if (matcher.matches()) {
                    mapList.add(matcher.group(1));
                }
            }
        }
        return mapList;
    }

    /**
     * This method uses error label to show the user
     * the error message and what caused the error
     * after the MainMenu's GUI is updated .
     * @param message An error message as String.
     */
    public void updateErrorMessage(String message){
        errorLabel.setText(message);
        jPanel.updateUI();
    }
}
