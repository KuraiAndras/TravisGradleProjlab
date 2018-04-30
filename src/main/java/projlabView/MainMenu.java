package projlabView;

import projlabController.PlayMouseListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu extends JFrame {
    private JButton playButton;
    private JComboBox listOfMaps;
    private JPanel jPanel;

    public String getCurrentMap() {
        return (String) listOfMaps.getSelectedItem();
    }

    public MainMenu() {
        playButton = new JButton("Play");
        listOfMaps = new JComboBox<String>();
        jPanel = new JPanel();

        jPanel.add(playButton);
        jPanel.add(listOfMaps);

        listOfMaps.setModel(new DefaultComboBoxModel(CreateMapList().toArray()));


        playButton.addActionListener(new PlayMouseListener(this));


        this.setMinimumSize(new Dimension(800, 600));

        this.add(jPanel, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private ArrayList<String> CreateMapList() {
        String partialMapPath = "maps/playableMaps";
        File directory = new File(partialMapPath);
        ArrayList<String> mapList = new ArrayList<>();

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
