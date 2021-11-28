package com.company;

import java.awt.*;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

class Main {
    private static Map<String, String> PLaF;
    static {
        PLaF = new HashMap<>();

        PLaF.put("System", UIManager.getSystemLookAndFeelClassName());
        PLaF.put("Motif", "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        PLaF.put("Metal", "javax.swing.plaf.metal.MetalLookAndFeel");
        PLaF.put("synth", "javax.swing.plaf.synth.SynthLookAndFeel");
        PLaF.put("nimbus", "javax.swing.plaf.nimbus.NimbusLookAndFeel");


    }

    public static void main(String[] s) {
        SwingUtilities.invokeLater(() -> {
            initGame();
            initGUI();

            Flow flow = new Flow();
            flow.run();
        });
    }


    private static void setPLaF(String clazz) {
        try {
            UIManager.setLookAndFeel(clazz);
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception ex) {
            System.err.println("PLaF fail");
            ex.printStackTrace();
        }
    }

    private static JFrame frame;

    private static JPanel content;
    private static JPanel theme;
    private static ImageIcon icon = new ImageIcon("hohol.jpg");
    private static void initGUI() {

        frame = new JFrame("The Higher Lower Game");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setPLaF(PLaF.get("System"));

        frame.setResizable(true);

        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(0, 0, 0));

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        frame.setSize(1920, 1080);

        theme = new JPanel();
        theme.setLayout(new BoxLayout(theme, BoxLayout.PAGE_AXIS));

        String currentValue = UIManager.getLookAndFeel().getClass().getName();
        ButtonGroup radioGroup = new ButtonGroup();
        PLaF.forEach((key, value) -> {
            JRadioButton radio = new JRadioButton(key);
            radio.setSelected(value.equals(currentValue));
            radio.addActionListener(e -> {
                setPLaF(value);
            });
            radioGroup.add(radio);
            theme.add(radio);
        });

        content = new JPanel();
        content.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        frame.add(content);
        frame.add(theme);

        frame.setVisible(true);
    }

    private static JPanel initScreenInit(Runnable callback) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.updateComponentTreeUI(frame);

        frame.getContentPane().setBackground(new Color(255, 255, 255));
        JPanel screen = new JPanel();
        screen.setLayout(new BoxLayout(screen, BoxLayout.PAGE_AXIS));
        screen.setBorder(BorderFactory.createEmptyBorder(300, 200, 100, 200));
        screen.setBackground(new Color(255, 255, 255));

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);

        JFormattedTextField minField = new JFormattedTextField(formatter);
        JFormattedTextField maxField = new JFormattedTextField(formatter);


        minField.setPreferredSize(new Dimension(10,40));
        minField.setFont(new Font("Dead Kansas",Font.PLAIN, 35));
        minField.setBackground(new Color(0, 0, 0));
        minField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        minField.setForeground(new Color(255, 255, 255));

        maxField.setPreferredSize(new Dimension(10,40));
        maxField.setFont(new Font("Dead Kansas",Font.PLAIN, 35));
        maxField.setBackground(new Color(255, 255, 255));
        maxField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        maxField.setForeground(new Color(0, 0, 0));

        minField.setValue(0);
        maxField.setValue(0);

        minField.setColumns(10);
        maxField.setColumns(10);

        JPanel minGroup = new JPanel();
        JPanel maxGroup = new JPanel();



        minGroup.setBackground(new Color(255, 255, 255));
        maxGroup.setBackground(new Color(0, 0, 0));

        minGroup.setLayout(new BoxLayout(minGroup, BoxLayout.LINE_AXIS));
        maxGroup.setLayout(new BoxLayout(maxGroup, BoxLayout.LINE_AXIS));

        minGroup.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        maxGroup.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JLabel minLabel = new JLabel("Min");
        JLabel maxLabel = new JLabel("Max");

        minLabel.setForeground(new Color(0, 0, 0));
        minLabel.setFont(new Font("Dead Kansas", Font.PLAIN,60));

        maxLabel.setForeground(new Color(255, 255, 255));
        maxLabel.setFont(new Font("Dead Kansas", Font.PLAIN,60));

        minLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 10));
        maxLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        minLabel.setPreferredSize(new Dimension(200, 100));
        maxLabel.setPreferredSize(new Dimension(200, 100));

        minGroup.add(minLabel);
        minGroup.add(minField);

        maxGroup.add(maxLabel);
        maxGroup.add(maxField);

        JPanel labelGroup = new JPanel();
        labelGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        labelGroup.setBackground(new Color(0, 0, 0));

        JLabel errorLabel = new JLabel();
        errorLabel.setFont(new Font("Dead Kansas",Font.BOLD,20));
        errorLabel.setForeground(new Color(255, 255, 255));

        labelGroup.add(errorLabel);



        JPanel buttonGroup = new JPanel();
        buttonGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonGroup.setPreferredSize(new Dimension(400 , 104));
        buttonGroup.setBackground(new Color(255, 255, 255));
        buttonGroup.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        JButton button = new JButton("Start");
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setFont(new Font("Dead Kansas",Font.BOLD,40));

        button.setBorder(BorderFactory.createEtchedBorder());
        button.setForeground(new Color(0, 0, 0));
        button.setPreferredSize(new Dimension(400,102));
        button.setBackground(new Color(255, 255, 255));


        button.addActionListener(e -> {
            Integer min = (Integer) minField.getValue();
            Integer max = (Integer) maxField.getValue();

            if (min == max) {
                errorLabel.setText("Min equals max");
                return;
            }

            if (min > max) {
                errorLabel.setText("Min greater then max");
                return;
            }

            game.setMin(min);
            game.setMax(max);

            game.setState(State.Start);

            callback.run();
        });

        buttonGroup.add(button);

        screen.add(minGroup);
        screen.add(maxGroup);

        screen.add(buttonGroup);
        screen.add(labelGroup);
        return screen;
    }

    private static JPanel initScreenPlay(Runnable callback) {
        JPanel screen = new JPanel();
        screen.setLayout(new BoxLayout(screen, BoxLayout.PAGE_AXIS));
        screen.setBackground(new Color(255, 255, 255));
        screen.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));



        JPanel labelGroup = new JPanel();
        labelGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        labelGroup.setBackground(new Color(255, 255, 255));
        labelGroup.setPreferredSize(new Dimension(750, 100));

        JLabel currentLabel = new JLabel("Your number is " + game.getCurrent() + "? ");

        currentLabel.setForeground(new Color(0, 0, 0));
        currentLabel.setFont(new Font("Dead Kansas", Font.PLAIN,60));


        labelGroup.add(currentLabel);

        JPanel buttonGroup = new JPanel();
        buttonGroup.setBackground(new Color(255, 255, 255));
        buttonGroup.setPreferredSize(new Dimension(500,300));

        JButton buttonLess = new JButton("Less");
        buttonLess.setFocusable(false);
        buttonLess.setBorderPainted(false);
        buttonLess.setOpaque(true);
        buttonLess.setFont(new Font("Dead Kansas",Font.BOLD,40));
        buttonLess.setBorder(BorderFactory.createEtchedBorder());
        buttonLess.setForeground(new Color(255, 255, 255));
        buttonLess.setPreferredSize(new Dimension(300,100));
        buttonLess.setBackground(new Color(0, 0, 0));

        buttonLess.addActionListener(e -> {
            game.setState(State.Less);

            callback.run();
        });
        buttonGroup.add(buttonLess);


        JButton buttonMore = new JButton("More");
        buttonMore.setFocusable(false);
        buttonMore.setBorderPainted(false);
        buttonMore.setOpaque(true);
        buttonMore.setFont(new Font("Dead Kansas",Font.BOLD,40));
        buttonMore.setBorder(BorderFactory.createEtchedBorder());
        buttonMore.setForeground(new Color(255, 255, 255));
        buttonMore.setPreferredSize(new Dimension(300,100));
        buttonMore.setBackground(new Color(0, 0, 0));

        buttonMore.addActionListener(e -> {
            game.setState(State.More);

            callback.run();
        });
        buttonGroup.add(buttonMore);



        JButton buttonEquals = new JButton("Equals");
        buttonEquals.setFocusable(false);
        buttonEquals.setBorderPainted(false);
        buttonEquals.setOpaque(true);
        buttonEquals.setFont(new Font("Dead Kansas",Font.BOLD,40));
        buttonEquals.setBorder(BorderFactory.createEtchedBorder());
        buttonEquals.setForeground(new Color(255, 255, 255));
        buttonEquals.setPreferredSize(new Dimension(300,100));
        buttonEquals.setBackground(new Color(0, 0, 0));

        buttonEquals.addActionListener(e -> {
            game.setState(State.Win);

            callback.run();
        });
        buttonGroup.add(buttonEquals);



        screen.add(labelGroup);
        screen.add(buttonGroup);

        return screen;
    }

    private static JPanel initScreenWin(Runnable callback) {
        JPanel screen = new JPanel();
        screen.setLayout(new BoxLayout(screen, BoxLayout.PAGE_AXIS));
        screen.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        screen.setBackground(new Color(255,255,255));

        JPanel labelGroup = new JPanel();
        labelGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        labelGroup.setBackground(new Color(255, 255, 255));
        JLabel label = new JLabel("");
        label.setForeground(new Color(0, 0, 0));
        labelGroup.add(label);


        ImageIcon image = new ImageIcon("wasserman1.gif");
        JLabel labelCheat = new JLabel();
        labelCheat.setIcon(image);
        labelGroup.add(labelCheat);

        label.setFont(new Font("Dead Kansas", Font.PLAIN,60));
        labelGroup.add(label);

        JPanel buttonGroup = new JPanel();
        buttonGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JButton button = new JButton("New game");
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setFont(new Font("Dead Kansas",Font.BOLD,40));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setForeground(new Color(0, 100, 0));
        button.setPreferredSize(new Dimension(300,100));
        button.setBackground(new Color(240, 240, 240));
        button.addActionListener(e -> {
            game.setState(State.Init);

            callback.run();
        });
        buttonGroup.add(button);

        screen.add(labelGroup);
        screen.add(buttonGroup);

        return screen;
    }

    private static JPanel initScreenCheat(Runnable callback) {
        JPanel screen = new JPanel();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(frame);
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        screen.setLayout(new BoxLayout(screen, BoxLayout.PAGE_AXIS));
        screen.setBorder(BorderFactory.createEmptyBorder(200, 30, 200, 30));
        screen.setBackground(new Color(0, 0, 0));


        JPanel buttonGroup = new JPanel();
        buttonGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonGroup.setBackground(new Color(0, 0, 0));
        JButton button = new JButton("Try again?");
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setFont(new Font("Dead Kansas", Font.PLAIN,60));
        button.setForeground(new Color(255, 0, 0));
        button.setBackground(new Color(0, 0, 0));




        JPanel labelGroup = new JPanel();
        labelGroup.setBackground(new Color(0, 0, 0));
        labelGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));



        JLabel label = new JLabel("You can breathe, you can blink, you can cry...");
        label.setFont(new Font("Dead Kansas", Font.PLAIN,20));
        label.setForeground(new Color(255, 255, 255));
        labelGroup.setLayout(new FlowLayout(FlowLayout.CENTER, -10, 0));
        labelGroup.add(label);


        ImageIcon image = new ImageIcon("negan2.gif");
        JLabel labelCheat = new JLabel();
        labelCheat.setIcon(image);
        labelGroup.add(labelCheat);






        button.addActionListener(e -> {
            game.setState(State.Init);

            callback.run();
        });
        buttonGroup.add(button);
        screen.add(buttonGroup);
        screen.add(labelGroup);


        return screen;
    }


    private static Game game;

    private static void initGame() {
        game = new Game();
    }



    private static class Flow implements Runnable {
        @Override
        public void run() {
            game.next();

            switch (game.getState()) {
                case Init:
                    content.removeAll();
                    try {
                        content.add(initScreenInit(this));
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    content.getParent().revalidate();
                    return;
                case Callback:
                    content.removeAll();
                    content.add(initScreenPlay(this));
                    content.getParent().revalidate();
                    return;
                case Win:
                    content.removeAll();
                    content.add(initScreenWin(this));
                    content.getParent().revalidate();
                    return;
                case Cheat:
                    content.removeAll();
                    content.add(initScreenCheat(this));
                    content.getParent().revalidate();
                    return;
                case Less:
                case More:
                default:
                    this.run();
                    return;
            }
        }
    }
}