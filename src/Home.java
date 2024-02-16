import javax.swing.*;
import java.awt.*;

public class Home extends JDialog{
    private JButton btLogin;
    private JButton btAdd;
    private JPanel jpHome;

    public  Home (JDialog parent){
        //surcharger la méthode
        super(parent);
        //Donner un titre à la fenêtre
        setTitle("Home");
        //setter le container
        setContentPane(jpHome);
        //sélectionner la taille de la fenêtre en pixel
        setMinimumSize(new Dimension(1200 , 800));
        //choisir si c'est un modal
        setModal(false);
        setVisible(true);
    }
}
