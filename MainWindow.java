import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * MainWindow for definition finder.
 *
 * @author Matthew Gray (mrgray4@ncsu.edu)
 */
public class MainWindow extends JFrame
{
    //component variables
    /** Variable to contain the word data table. */
    private JTable dataTable;
    /** Variable to contain the main file operation menu. */
    private JMenu fileMenu;
    /** Variable to contain the main word operation menu. */
    private JMenu wordMenu;
    /** Variable to contain the about menu. */
    private JMenu aboutMenu;

    /** Field to keep track of the currently opened file*/
    private String filePath;
    /** Field to keep track of whether the currently opened file is saved */
    private boolean isModified;

    /**
     * Main constructor of this window.
     */
    public MainWindow()
    {
        initUi();
        newFile();
    }

    /**
     * Initializes the GUI
     */
    private void initUi()
    {
        setTitle("Definition Finder");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /////////////////////////////////////////////////////////////////////////////////////////////
        //JMenuBar - help from https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html//
        /////////////////////////////////////////////////////////////////////////////////////////////

        //Where the unimportant GUI is created:
        JMenuBar menuBar;
        JMenuItem menuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the file menu.
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(fileMenu);
        //a group of JMenuItems for the file menu
        menuItem = new JMenuItem("New", KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        fileMenu.add(menuItem);
        menuItem = new JMenuItem("Save", KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        fileMenu.add(menuItem);
        menuItem = new JMenuItem("Open", KeyEvent.VK_O);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fileMenu.add(menuItem);
        menuItem = new JMenuItem("Print", KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        //Build the word menu.
        wordMenu = new JMenu("Word");
        wordMenu.setMnemonic(KeyEvent.VK_A);
        wordMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(wordMenu);
        //a group of JMenuItems for the word menu
        menuItem = new JMenuItem("Add Word", KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        wordMenu.add(menuItem);
        menuItem = new JMenuItem("Remove Word", KeyEvent.VK_R);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
        wordMenu.add(menuItem);
        menuItem = new JMenuItem("Get Definitions", KeyEvent.VK_G);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
        wordMenu.add(menuItem);

        //Build about menu in the menu bar.
        aboutMenu = new JMenu("About Application");
        aboutMenu.setMnemonic(KeyEvent.VK_I);
        menuBar.add(aboutMenu);

        this.setJMenuBar(menuBar);

        ///////////////////////////////////////////////////////////////////////////////////////////
        //table - help from https://docs.oracle.com/javase/tutorial/uiswing/components/table.html//
        ///////////////////////////////////////////////////////////////////////////////////////////

        String[] columnNames = {"Word", "Definition"};

        Object[][] data = {{"word1", "definition1"}, {"word2", "definition2"}, {"word3", "definition3"}};

        dataTable = new JTable(data, columnNames);
        //dataTable.setEnabled(false);

        this.setLayout(new BorderLayout());
        this.add(dataTable.getTableHeader(), BorderLayout.PAGE_START);
        this.add(dataTable, BorderLayout.CENTER);
    }

    /**
     * Overloaded from JFrame, manages creation of layout.
     * @param arg JComponent argument to create layout with.
     */
    private void createLayout(JComponent arg)
    {
        //gets the frames content pane and sets it to a grouplayout style
        Container pane = getContentPane();
        GroupLayout groupLayout = new GroupLayout(pane);
        pane.setLayout(groupLayout);

        groupLayout.setAutoCreateContainerGaps(true); //automatically manage gaps between containers
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addComponent(arg)); //manage horizontal addition of components
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addComponent(arg)); //manage vertical layout of components
    }

    /**
     * Entry-point to program.
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        //starts the window events
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }

    //file operations

    private void newFile()
    {
        this.filePath = "";
        this.isModified = false;
    }


    private void openFile()
    {
        
    }


    private void saveFile()
    {

    }

    private void print()
    {
        this.dataTable.print(); //WOW IT'S THIS EASY???!
    }

    //word operations

    private void removeWord(int index)
    {

    }


    private void addWord()
    {

    }


    private void editDefinition(int index)
    {

    }

    //component operations

    //utility functions
    /**
     * Gets whether or not the file has been saved to a path at all.
     * Valid assumption is that it isn't null, set to "" on instantiation.
     * @return True if the file has been saved to a path at all, false otherwise.
     */
    private boolean isSavedAs()
    {
        if (this.filePath.equals("")) {
            return false;
        }
        return true;
    }
}
