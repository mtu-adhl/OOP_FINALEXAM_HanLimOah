package finalexam.shapeapp2022;

/*This GUI application uses the inheritance hierarchy created by you in the first part of the exam
and requires you to fill in some of the missing code*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ShapeGUI extends JPanel implements ActionListener {

	private ArrayList<Oval> ovals; //uncomment this when you have the Oval class written
	private ArrayList<Rectangle> rectangles; //uncomment this when you have the Rectangle class written
	private JMenu shapeMenu;
	private JRadioButton filledRadioButton, unfilledRadioButton;
	private JColorChooser colourChooser;
	private Color chosenColour;
	private boolean filled = true;
	private JFrame choicesframe;
	private String activeShape;


	public ShapeGUI() {
		setBackground(Color.WHITE);

		JFrame frame = new JFrame("Shape Drawing App");
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		createShapeMenu();

		menuBar.add(shapeMenu);

		frame.add(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 400);
		frame.setLocation(300, 300);
		frame.setVisible(true);

		ovals = new ArrayList<>(); //uncomment this when you have the Oval class written
		rectangles = new ArrayList<>(); //uncomment this when you have the Rectangle class written
	}

	private void createShapeMenu() {

		shapeMenu = new JMenu("Shape");

		createShapeAddSubMenu();

		JMenuItem removeItem = new JMenuItem("Remove");
		removeItem.addActionListener(this);
		shapeMenu.add(removeItem);
	}

	private void createShapeAddSubMenu() {

		/*You must add the code here for this method to create the "Add" menu*/
		JMenu addShapes = new JMenu("Add");

		JMenuItem rectangle = new JMenuItem("Rectangle");
		rectangle.addActionListener(this);

		JMenuItem oval = new JMenuItem("Oval");
		oval.addActionListener(this);

		addShapes.add(rectangle);
		addShapes.add(oval);

		shapeMenu.add(addShapes);

	}

	public static void main(String args[]) {

		ShapeGUI panel = new ShapeGUI();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//uncomment the code below when you have written the Oval and Rectangle classes

		for(Oval oval : ovals)
			oval.draw(g);

		for(Rectangle rectangle : rectangles)
			rectangle.draw(g);

	}

	private void choicesGUI() {

		JPanel radioButtonPanel = new JPanel();

		filledRadioButton = new JRadioButton("Filled",true);
		unfilledRadioButton = new JRadioButton("Unfilled",false);

		filled = true;

		radioButtonPanel.add(filledRadioButton);
		radioButtonPanel.add(unfilledRadioButton);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());

		topPanel.add(radioButtonPanel,BorderLayout.NORTH);

		FillSelectionHandler handler = new FillSelectionHandler();

		filledRadioButton.addItemListener(handler);
		unfilledRadioButton.addItemListener(handler);

		ButtonGroup rbGroup = new ButtonGroup();

		rbGroup.add(filledRadioButton);
		rbGroup.add(unfilledRadioButton);

		colourChooser = new JColorChooser();
		colourChooser.getSelectionModel().addChangeListener(new ColourSelectionHandler());

		topPanel.add(colourChooser,BorderLayout.SOUTH);

		JButton confirmButton = new JButton("Confirm Selections");
		confirmButton.addActionListener(this);

		choicesframe = new JFrame("Shape Fill and Colour");

		choicesframe.add(topPanel,BorderLayout.NORTH);
		choicesframe.add(confirmButton,BorderLayout.SOUTH);

		choicesframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		choicesframe.setVisible(true);
		choicesframe.pack();
	}

	private class ColourSelectionHandler implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			chosenColour = colourChooser.getColor();
		}
	}

	private class FillSelectionHandler implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			if (e.getSource() == filledRadioButton)
				filled = true;
			else if (e.getSource() == unfilledRadioButton)
				filled = false;

			validate();
		}
	}


	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Rectangle")) {

			activeShape = "Rectangle";

			/*You need to add code here to display the message-dialog which displays that
			the user is adding a new rectangle and then call the choicesGUI() method in order
			to make the "Shape Fill and Colour" JFrame appear*/

			JOptionPane.showMessageDialog(null, "Adding new rectangle", "Adding Rectangle", JOptionPane.INFORMATION_MESSAGE);
			choicesGUI();

		} else if (e.getActionCommand().equals("Oval")) {

			activeShape = "Oval";

			/*The  same code added above needs to be added here also, except you will be indicating an
		    oval on the dialog*/
			JOptionPane.showMessageDialog(null, "Adding new oval", "Adding Oval", JOptionPane.INFORMATION_MESSAGE);
			choicesGUI();

		} else if (e.getActionCommand().equals("Remove")) {

			JOptionPane.showMessageDialog(null, "Removing last shape added",
					"Removing Last Shape Added", JOptionPane.INFORMATION_MESSAGE);

		} else if (e.getActionCommand().equals("Confirm Selections")) {

			/*You need to add code here to dictate the sequence of events that will take place when the
			"Confirm Selections" button is pressed on the "Shape Fill And Colour" JFrame*/
			JOptionPane.showMessageDialog(null, "Colour and fill selections confirmed", "Selections Confirmed", JOptionPane.INFORMATION_MESSAGE);
			choicesframe.dispose();

			int topLeftX = (int)Math.floor(Math.random()*200)+1;
			int topLeftY = (int)Math.floor(Math.random()*200)+1;
			int bottomRightX = (int)Math.floor(Math.random()*200)+1;
			int bottomRightY = (int)Math.floor(Math.random()*200)+1;

			if (activeShape.equalsIgnoreCase("Rectangle")){
				rectangles.add(new Rectangle(topLeftX, topLeftY, bottomRightX, bottomRightY, chosenColour, filled));
			} else if (activeShape.equalsIgnoreCase("Oval")) {
				ovals.add(new Oval(topLeftX, topLeftY, bottomRightX, bottomRightY, chosenColour, filled));
			}

			repaint();
		}
	}
}








