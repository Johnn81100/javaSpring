import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class listUser extends JDialog {
    private JPanel JpMain;
    private JTextField nom;
    private JTextField prenom;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelMail;
    private JTextField mail;
    private JLabel labelPassword;
    private JTextField password;
    private JButton btClose;

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
        //indiquer si la fenêtre est visible ou pas au chargement
        setVisible(true);

        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
            }
        });

    }
    private void getData(){
        ArrayList<JTextField> jt = new ArrayList<JTextField>();
        jt.add(nom);
        jt.add(prenom);
        jt.add(mail);

        System.out.println(test);
    }
}
