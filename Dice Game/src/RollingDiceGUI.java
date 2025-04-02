import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RollingDiceGUI extends JFrame {
    public RollingDiceGUI() {
        super("Rolling Double Dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 700));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        addGuiComponents();
    }

    private void addGuiComponents() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        // Banner
        JLabel bannerImg = ImgService.loadImage("resources/banner.png");
        assert bannerImg != null;
        bannerImg.setBounds(45, 25, 600, 100);
        jPanel.add(bannerImg);

        // Dices
        JLabel diceOneImg = ImgService.loadImage("resources/dice1.png");
        assert diceOneImg != null;
        diceOneImg.setBounds(100, 200, 200, 200);
        jPanel.add(diceOneImg);

        JLabel diceTwoImg = ImgService.loadImage("resources/dice1.png");
        assert diceTwoImg != null;
        diceTwoImg.setBounds(390, 200, 200, 200);
        jPanel.add(diceTwoImg);

        // Roll Button
        Random random = new Random();
        JButton rollButton = new JButton("Roll!");
        rollButton.setBounds(250, 550, 200, 50);
        rollButton.addActionListener(e -> {
            rollButton.setEnabled(false);

            // roll for 3 seconds
            long startTime = System.currentTimeMillis();
            Thread rollThread = new Thread(() -> {
                long endTime = System.currentTimeMillis();
                try {
                    while ((endTime - startTime)/1000F < 3) {
                        // roll
                        int diceOne = random.nextInt(1, 7);
                        int diceTwo = random.nextInt(1, 7);

                        // update image
                        ImgService.updateImage(diceOneImg, "resources/dice" + diceOne + ".png");
                        ImgService.updateImage(diceTwoImg, "resources/dice" + diceTwo + ".png");

                        repaint();
                        revalidate();

                        Thread.sleep(60);
                        endTime = System.currentTimeMillis();
                    }

                    rollButton.setEnabled(true);
                } catch (InterruptedException e1) {
                    System.out.println("Threading Error: " + e1);
                }
            });
            rollThread.start();
        });
        jPanel.add(rollButton);

        this.getContentPane().add(jPanel);
    }
}
