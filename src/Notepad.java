import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Notepad extends JFrame {
    JTextArea area;
    JTextPane pane;

    Notepad(){
        setBounds(0,0,1000,555);
        area = new JTextArea();
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("file");

        JMenuItem newDoc = new JMenuItem("New");
        newDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        JMenuItem save= new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem print= new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));

        file.add(newDoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);




        JMenu edit = new JMenu("edit");

        JMenuItem copy= new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        JMenuItem paste= new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        JMenuItem cut= new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        JMenuItem selectAll= new JMenuItem("SelectAll");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectAll);

        JMenu help = new JMenu("help");
        JMenuItem about = new JMenuItem("about Notepad");
        help.add(about);


        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);


        setJMenuBar(menuBar);

        add(area);
        setLocationRelativeTo(null);
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Notepad.exit();
            }
        });


        save.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String fileContent = area.getText();
                try {
                    FileOutputStream file = new FileOutputStream("NewFile.txt");
                    byte[] a = fileContent.getBytes();
                    file.write(a);
                    file.close();
                } catch (FileNotFoundException fileNotFoundException)
                {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }

            }
        });

    }
    public static void main(String[] args)

    {
        new Notepad().setVisible(true);

    }
    static void exit(){
        System.exit(1);

    }
}
