import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewJFrame extends JFrame {
    private JPanel panel1;
    private JTextField txtInsertAtFront;
    private JButton insertAtFrontBtn;
    private JTextField txtInsertAtBack;
    private JButton insertAtBackBtn;
    private JButton randomListBtn;
    private JButton removeFromFrontBtn;
    private JButton removeFromBackBtn;
    private JButton removeAllBtn;
    private JLabel jLabel3;
    private JTextArea printList;
    private JButton printTheListBtn;


    private List list = new List("My List");

    public NewJFrame() {
        insertAtFrontBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtInsertAtFront.getText();
                list.insertAtFront(str);
                jLabel3.setText("Insert At Front");
            }
        });
        insertAtBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtInsertAtBack.getText();
                list.insertAtBack(str);
                jLabel3.setText("Insert At Back");
            }
        });
        randomListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10;i++) {
                    list.insertAtFront(i*i+i);
                }
            }
        });
        removeFromFrontBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.removeFromFront();
                } catch (EmptyListException e1) {
                    e1.printStackTrace();
                }
            }
        });
        removeFromBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.removeFromBack();
                } catch (EmptyListException e1) {
                    e1.printStackTrace();
                }
            }
        });
        removeAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.removeAll();
            }
        });
        printTheListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printList.setText(list.Print());
            }
        });
    }

    public static void run() {
        JFrame frame = new JFrame("NewJFrame");
        frame.setContentPane(new NewJFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println("Start");
    }
}
