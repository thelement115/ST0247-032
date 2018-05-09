import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class dibujar extends JFrame{

    public ArrayList <Vertice> clientes;
    public ArrayList <Vertice> cargas;
    public Vertice deposito;

    public dibujar(ArrayList <Vertice> clientes, ArrayList <Vertice> cargas,Vertice deposito){
        this.clientes = clientes;
        this.deposito = deposito;
        this.cargas = cargas;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("grafo");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize= tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidght = screenSize.width;
        setSize(screenWidght,screenHeight);
        setLocationRelativeTo(null);
        setBackground(Color.black);
        setVisible(true);
    }

    public void paint (Graphics g){
        double a;
        double b;
        int x;
        int y;
        g.setColor(Color.red);
        for (Vertice s: clientes){
                a = s.x;
                b = s.y;
                x = (int) a;
                y = (int) b;
                g.fillOval(x * 15 + 20, y * 8 + 10, 10, 10);
            }
        g.setColor(Color.blue);
        for(Vertice s: cargas){
            a = s.x;
            b = s.y;
            x = (int)a;
            y= (int)b;
            g.fillOval(x*15+20,y*8+10,10,10);
        }
        g.setColor(Color.yellow);
        a = deposito.x;
        b = deposito.y;
        x = (int) a;
        y = (int) b;
        g.fillOval(x*15+20,y*8+10,10,10);
    }

}
