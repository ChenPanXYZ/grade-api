package app.gui;
import app.Config;
import controller.CheckInfoController;
import controller.LoginController;
import org.json.JSONObject;
import use_case.login.LoginUseCase;
import javax.swing.*;
import java.awt.*;
import java.lang.String;

import static use_case.login.LoginUseCase.LoginResult.SUCCESS;

public class GUI {
    public static void main(String[] args) {

        // Initial setup for the program.
        // The config hides the details of which implementation of GradeDB
        // we are using in the program. If we were to use a different implementation
        // of GradeDB, this config is what we would change.
        Config config = new Config();

        LoginController loginController = config.loginController();
        CheckInfoController checkInfoController = config.checkInfoController();

        // this is the code that runs to set up our GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Management System");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(850, 300);

            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            JPanel defaultCard = createDefaultCard();
            JPanel loginUseCaseCard = createLoginUseCaseCard(frame, loginController);
            JPanel checkInfoUseCaseCard = createCheckInfoUseCaseCard(frame, checkInfoController);
            cardPanel.add(defaultCard, "DefaultCard");
            cardPanel.add(loginUseCaseCard, "LoginUseCaseCard");
            cardPanel.add(checkInfoUseCaseCard, "CheckInfoUseCaseCard");



            JButton loginUseCaseButton = new JButton("Login");
            JButton checkInfoUseCaseButton = new JButton("Check Info");


            loginUseCaseButton.addActionListener(e -> cardLayout.show(cardPanel, "LoginUseCaseCard"));
            checkInfoUseCaseButton.addActionListener(e -> {
                // Call the createCheckInfoUseCaseCard function and update the card
                JPanel newCard = createCheckInfoUseCaseCard(frame, checkInfoController);
                checkInfoUseCaseCard.removeAll();
                checkInfoUseCaseCard.add(newCard, BorderLayout.CENTER);
                checkInfoUseCaseCard.revalidate();
                checkInfoUseCaseCard.repaint();

                // Show the updated card
                cardLayout.show(cardPanel, "CheckInfoUseCaseCard");
            });


            JPanel buttonPanel = new JPanel();
            buttonPanel.add(loginUseCaseButton);
            buttonPanel.add(checkInfoUseCaseButton);


            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);

        });
    }

    // utility methods that take care of setting up each JPanel to be displayed
    // in our GUI
    private static JPanel createDefaultCard() {
        JPanel defaultCard = new JPanel();
        defaultCard.setLayout(new BorderLayout());

        JLabel infoLabel = new JLabel("Welcome to the Student Management System (GUI Version)!\n");

        defaultCard.add(infoLabel, BorderLayout.CENTER);

        return defaultCard;
    }


    private static JPanel createCheckInfoUseCaseCard(JFrame jFrame, CheckInfoController checkInfoController) {
        JPanel getGradeCard = new JPanel();
        getGradeCard.setLayout(new BorderLayout());

        JSONObject info = checkInfoController.runCheck();

        JLabel infoLabel = new JLabel("");

        if(info == null) {
            infoLabel = new JLabel("No user is logged in.");
        }
        else {
            infoLabel = new JLabel("User info: " + info.toString());
        }


        getGradeCard.add(infoLabel, BorderLayout.CENTER);

        return getGradeCard;
    }

    private static JPanel createLoginUseCaseCard(JFrame jFrame, LoginController loginController) {
        JPanel getGradeCard = new JPanel();
        getGradeCard.setLayout(new GridLayout(3, 2));

        JTextField usernameField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JButton getButton = new JButton("Enter");

        JLabel resultLabel = new JLabel();

        getButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            try{
                LoginUseCase.LoginResult loginResult = loginController.runLogin(username, password);
                if(loginResult == SUCCESS) {
                    JOptionPane.showMessageDialog(jFrame, String.format("Login Successfully"));
                }
                else {
                    JOptionPane.showMessageDialog(jFrame, String.format("Login Unsuccessfully"));
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(jFrame, ex.getMessage());
            }
        });

        getGradeCard.add(new JLabel("username:"));
        getGradeCard.add(usernameField);
        getGradeCard.add(new JLabel("password:"));
        getGradeCard.add(passwordField);
        getGradeCard.add(getButton);
        getGradeCard.add(resultLabel);

        return getGradeCard;
    }
}