import com.carnetAdresse.model.User;
import com.carnetAdresse.model.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.util.function.Predicate.isEqual;

public class listUser extends JDialog {
    private JPanel JpMain;
    private JTextField nom;
    private JTextField prenom;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelMail;
    private JTextField mail;
    private JLabel labelPassword;
    private JButton btAdd;
    private JButton btClose;
    private JPasswordField passwordField1;

    private Boolean isRedeaySave ;

    public listUser(JDialog parent){

        //surcharger la méthode
        super(parent);
        //Donner un titre à la fenêtre
        setTitle("Ma fenêtre");
        //setter le container
        setContentPane(JpMain);
        //sélectionner la taille de la fenêtre en pixel
        setMinimumSize(new Dimension(450, 600));
        //choisir si c'est un modal
        setModal(false);


        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
            }
        });

        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //indiquer si la fenêtre est visible ou pas au chargement
        setVisible(true);

    }
    private void getData() {
        ArrayList<JTextField> jt = new ArrayList<JTextField>();
        jt.add(nom);
        jt.add(prenom);
        jt.add(mail);
        for (JTextField jTF : jt) {
            if (jTF.getText().isEmpty() && passwordField1.getPassword().toString().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Veuillez remplir tous les champs du formulaire",
                        "Essaie encore",
                        JOptionPane.ERROR_MESSAGE);
                return;

            }
        }
        if (!jt.get(2).getText().matches("^(.+)@(\\S+)$")) {
            JOptionPane.showMessageDialog(this,
                    "caractère du mail incorrecte",
                    "Essaie encore",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else if (passwordField1.getPassword().length <= 12) {
            JOptionPane.showMessageDialog(this,
                    " longueur du pwd trop petit",
                    "Essaie encore",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

            User user = new User(jt.get(0).getText(),jt.get(1).getText(),jt.get(2).getText(), String.valueOf(passwordField1.getPassword()));
            User  userBdd =  UserManager.findUser(user);
            if(userBdd.getNom() == null){
                System.out.println("ok");
                UserManager.addUser(user);
            }
            else {
                JOptionPane.showMessageDialog(this,
                        " Utilisateur déjà enregistré ",
                        "Essaie encore",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }


    }

}
