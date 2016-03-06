
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class DrinkMachine extends JApplet {
  
  JPanel infoPanel;
  JPanel drinksPanel;
  JPanel buttonsPanel;
  JPanel outputPanel;
  
  public void init() {
    
    /* TODO:
      1. Create 3 panels
        a. Drink Panel (Center)
            -Grid layout = 4 rows, 3 columns
            -Displays drink images and quantity(?)
            -12 labels = 6 drinks with 6 labels
        b. Buttons Panel (West)
            -Grid Layout = two rows by one column containing two panels 
              -Panel 1 = Label with amount left and text field to input money
              -Panel 2 = 6 buttons, one for each drink
        c. Output Panel
            -Displays what drinks were purchased and their quantity
      2. Create button listener
        a. Get money entered
        b. Display error message if not enough money was entered.
        b. Subtract drink amount from money entered
        c. Display total cost of drink
        d. Display remaining total
        c. Dispense change if not enough for another drink
        e. Subtract one from drink stock
        
    */
    
    setLayout(new BorderLayout());
    
    buildInfoPanel();
    buildDrinksPanel();
    buildButtonsPanel();
    //buildOutputPanel();
    
    add(infoPanel, BorderLayout.NORTH);
    add(drinksPanel, BorderLayout.WEST);
    add(buttonsPanel, BorderLayout.CENTER);
    
    //add(outputPanel);
    
  }
  
  private void buildInfoPanel(){
    infoPanel = new JPanel();
    JLabel prices = new JLabel("All Drinks - $0.75");
    prices.setFont(new Font("Serif", Font.BOLD, 25));
    infoPanel.add(prices);
  }
  
  
  private void buildDrinksPanel(){
    
    // general configurations
    drinksPanel = new JPanel();
    drinksPanel.setLayout(new BorderLayout());
    JPanel quantPanel1 = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel quantPanel2 = new JPanel();
    quantPanel1.setLayout(new GridLayout(1,3));
    quantPanel2.setLayout(new GridLayout(1,3));
   
    //Top Quantity Panel
    JLabel sodaQuant = new JLabel("x20");
    JLabel grapeQuant = new JLabel("x20");
    JLabel lemonLimeQuant = new JLabel("x20");
    
    quantPanel1.add(sodaQuant);
    quantPanel1.add(grapeQuant);
    quantPanel1.add(lemonLimeQuant);
    
    // Center Panel
    centerPanel.setLayout(new GridLayout(2,3));
    centerPanel.setBackground(Color.WHITE);
    
    ImageIcon sodaCan = new ImageIcon("CanImages/sodacan.png");
    ImageIcon grapeCan = new ImageIcon("CanImages/grapecan.png");
    ImageIcon lemonLimeCan = new ImageIcon("CanImages/lemonlimecan.png");
    ImageIcon rootBeerCan = new ImageIcon("CanImages/rootbeercan.png");
    ImageIcon orangeCan = new ImageIcon("CanImages/orangecan.png");
    ImageIcon waterBottle = new ImageIcon("CanImages/waterbottle.png");
    
    JLabel soda = new JLabel(sodaCan);
    JLabel grape = new JLabel(grapeCan);
    JLabel lemonLime = new JLabel(lemonLimeCan);
    JLabel rootBeer = new JLabel(rootBeerCan);
    JLabel orange = new JLabel(orangeCan);
    JLabel water = new JLabel(waterBottle);
    
    // Configure and add each drink preview to center panel
    JLabel[] cans = {soda, grape, lemonLime, rootBeer, orange, water};
    for(JLabel label : cans){
      label.setBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray,
              Color.white, Color.darkGray));
      centerPanel.add(label);
    }
   
    //Bottom Quantity Panel
    JLabel rootBeerQuant = new JLabel("x20");
    JLabel orangeQuant = new JLabel("x20");
    JLabel waterQuant = new JLabel("x20");
    
    quantPanel2.add(rootBeerQuant);
    quantPanel2.add(orangeQuant);
    quantPanel2.add(waterQuant);
    
    // Configure Labels
    JLabel[] quantities = {sodaQuant, grapeQuant, lemonLimeQuant, rootBeerQuant,
                        orangeQuant, waterQuant};
    for(JLabel label : quantities){
        label.setFont(new Font("DialogInput", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    //row 1
    drinksPanel.add(quantPanel1, BorderLayout.NORTH);
    drinksPanel.add(centerPanel, BorderLayout.CENTER);
    drinksPanel.add(quantPanel2, BorderLayout.SOUTH);
    
  }
  
  private void buildButtonsPanel(){
    
    buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BorderLayout());
    JPanel topPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel botPanel = new JPanel();
    
    
    // Top Panel
    topPanel.setLayout(new GridLayout(2,1));
    JLabel lblTotal = new JLabel("Total:");
    lblTotal.setFont(new Font("Serif", Font.PLAIN, 20));
    JTextField total = new JTextField("$0.00");
    total.setEditable(false);
    topPanel.add(lblTotal);
    topPanel.add(total);
    
    
    //Middle Panel
    midPanel.setLayout(new GridLayout(2,3));
    JButton sodaButton = new JButton("Soda");
    JButton grapeButton = new JButton("Grape Soda");
    JButton lemonLimeButton = new JButton("Lemon Lime Soda");
    JButton rootBeerButton = new JButton("Root Beer");
    JButton orangeButton = new JButton("Orange Soda");
    JButton waterButton = new JButton("Water");
    
    JButton[] buttons = {sodaButton, grapeButton, lemonLimeButton, rootBeerButton,
                          orangeButton, waterButton};
    
    for(JButton button : buttons){
      button.setFont(new Font("DialogInput", Font.BOLD, 15));
      midPanel.add(button);
    }
    
    
    // Bottom Panel
    botPanel.setLayout(new GridLayout(1,2));
    JTextField moneyAmt = new JTextField(5);
    JButton addFunds = new JButton("Press This Button After Entering Funds");
    botPanel.add(moneyAmt);
    botPanel.add(addFunds);
    
    buttonsPanel.add(topPanel, BorderLayout.NORTH);
    buttonsPanel.add(midPanel, BorderLayout.CENTER);
    buttonsPanel.add(botPanel, BorderLayout.SOUTH);
    
  }
}
