/**
 * Creates a GUI to Display 52 playing cards and shuffle button.
 *
 * @author Ian Pontillas, Andrew Mueller, Christian Rodriguez, Momar Shirley 
 * @version 09/22/2025
 */

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CardGUI extends JFrame
{
    // initialize variables for display
    private JPanel cardsPanel;
    private JButton shuffleBtn;
    private DeckManager deckManager;
    
    /**
     * Constructor for the lass CardGUI.
     */
    public CardGUI() 
    {
        setTitle("Playing Cards Shuffle GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // initialize DeckManager
        deckManager = new DeckManager();
        
        // panel for cards
        cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(4, 13, 5, 5));
        displayCards();
        add(new JScrollPane(cardsPanel), BorderLayout.CENTER);
        
        // shuffle button and setup action
        shuffleBtn = new JButton("Shuffle Deck");
        shuffleBtn.addActionListener(e ->
        {
            deckManager.shuffleDeck();
            displayCards();
        });
        
        // places button at bottom of panel
        add(shuffleBtn, BorderLayout.SOUTH);

        // sizes window
        pack();
        
        setVisible(true);
    }
    
    /**
     * Displays playing cards on the panel.
     */
    private void displayCards()
    {
        cardsPanel.removeAll();
        List<ImageIcon> cards = deckManager.getDeck();
        
        // formats cards and adds to the panel
        for (ImageIcon card : cards)
        {
            Image sized = card.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(sized));
            cardsPanel.add(label);
        }
        
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
    
    /**
     * Creates and shows the Playing Cards GUI,
     *
     */
    public static void main (String[] args)
    {
        // put your code here
        SwingUtilities.invokeLater(CardGUI::new);
    }
}
