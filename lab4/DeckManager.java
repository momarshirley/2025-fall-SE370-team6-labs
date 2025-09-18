/**
 * This class is responsible for loading all playing card icons and provide 
 * functionality to shuffle the deck.
 *
 * @author Ian Pontillas, Andrew Mueller, Christian Rodriguez, Momar Shirley 
 * @version 09/22/2025
 */

import javax.swing.ImageIcon;
import java.util.*;

public class DeckManager
{
    // path to card icons
    private final String ICONS_PATH = "playing-cards-master/";
    private List<ImageIcon> cards;
    
    /**
     * Constructor for DeckManager
     */
    public DeckManager()
    {
        cards = new ArrayList<>();
        loadDeck();
    }
    
    /**
     * Loads all 52 playing card icons in the card list.
     * Assumes standard naming convention "clubs_2.png", "hearts_A.png", etc
     */
    private void loadDeck()
    {
        // define card object properties: suit and values
        String[] suits = {"spades", "hearts", "clubs", "diamonds",};
        String[] values = {"A", "K", "Q", "J", "10", "9", "8", "7",
            "6", "5", "4", "3", "2", };
        
        // starts with suit
        for(String suit: suits)
        {
            //iterates through each value
            for(String value : values)
            {
                String fileName = ICONS_PATH + suit + "_" + value + ".png";
                ImageIcon card = new ImageIcon(fileName);
                cards.add(card);
            }
        }  
    }

    /**
     * Returns copy of the current deck.
     * 
     * @return returns List of paying card images
     */
    public List<ImageIcon> getDeck()
    {
        return new ArrayList<>(cards);
    }

    /**
     * Shuffles the deck.
     *
     */
    public void shuffleDeck()
    {
        Collections.shuffle(cards);
    }
}