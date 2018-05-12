package projlabView;

import projlabController.PlayButtonListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu extends JFrame {
    private JComboBox<String> listOfMaps;

    public String getCurrentMap() {
        return (String) listOfMaps.getSelectedItem();
    }

    public MainMenu() {
        JButton playButton = new JButton("Play");
        listOfMaps = new JComboBox<>();
        JPanel jPanel = new JPanel();

        jPanel.add(playButton);
        jPanel.add(listOfMaps);

        listOfMaps.setModel(new DefaultComboBoxModel<>(CreateMapList()));

        playButton.addActionListener(new PlayButtonListener());

        this.setMinimumSize(new Dimension(800, 600));
        this.add(jPanel, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


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
}
