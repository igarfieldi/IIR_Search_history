/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * Custom extension of JPanel enabling a collapsible panel.
 * Contains a content panel and a button to collapse and expand the content panel.
 * @author Florian Bethe, Tino Liebusch
 */
public class CollapsiblePanel extends JPanel {
	private static final long serialVersionUID = 5973469035724403418L;
	
	private BasicArrowButton header;
    private JComponent content;
    private boolean isCollapsed;
    
    /**
     * Default constructor.
     * Creates an empty content panel and sets the header location at NORTH.
     */
    public CollapsiblePanel() {
        this(new JPanel(), BorderLayout.NORTH);
    }
    
    /**
     * Constructor.
     * Stores the given content panel and creates the header at the specified location (default
     * NORTH).
     * @param content Panel used as content panel
     * @param headerLocation Location for the header button (from {@link java.awt.BorderLayout BorderLayout})
     */
    public CollapsiblePanel(JPanel content, String headerLocation) {
        switch(headerLocation) {
            case BorderLayout.EAST:
                this.header = new BasicArrowButton(BasicArrowButton.EAST);
                break;
            case BorderLayout.WEST:
                this.header = new BasicArrowButton(BasicArrowButton.WEST);
                break;
            case BorderLayout.SOUTH:
                this.header = new BasicArrowButton(BasicArrowButton.SOUTH);
                break;
            default:
                this.header = new BasicArrowButton(BasicArrowButton.NORTH);
                break;
        }
        
        // Upon clicking the button, the collapsed state will be toggled
        // and the arrow direction inverted
        header.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleState();
            }
            
        });
        
        // Initial state is collapsed
        this.content = content;
        this.content.setVisible(false);
        this.isCollapsed = true;
        
        this.setLayout(new BorderLayout());
        this.add(header, headerLocation);
        this.add(content, BorderLayout.CENTER);
    }
    
    /**
     * Sets the content panel.
     * @param content New content panel
     */
    public void setContent(JComponent content) {
        this.remove(this.content);
        this.content = content;
        this.add(this.content, BorderLayout.CENTER);
        this.content.setVisible(!isCollapsed);
    }
    
    public Dimension getMaximumSize() {
    	// The max. size of this component is half the height of the whole frame (otherwise it'd take as much space as needed)
    	if(SwingUtilities.getRoot(this) == null)
    		return super.getMaximumSize();
    	return new Dimension((int)super.getMaximumSize().getWidth(), SwingUtilities.getRoot(this).getHeight() / 2);
    }
    
    public Dimension getPreferredSize() {
    	// The max. size of this component is half the height of the whole frame (otherwise it'd take as much space as needed)
    	if(SwingUtilities.getRoot(this) == null)
    		return super.getPreferredSize();
    	return new Dimension((int)super.getPreferredSize().getWidth(), Math.min(SwingUtilities.getRoot(this).getHeight() / 2, (int)super.getPreferredSize().getHeight()));
    }
    
    /**
     * Moves the header button to a new border.
     * The location has to be either NORTH, SOUTH, EAST or WEST of the 
     * {@link java.awt.BorderLayout BorderLayout} class, otherwise the location will not be changed.
     * @param headerLocation New header location
     */
    public void setHeaderLocation(String headerLocation) {
        // First set the header arrow direction (assuming collapsed state)
        switch(headerLocation) {
            case BorderLayout.EAST:
                header.setDirection(BasicArrowButton.EAST);
                break;
            case BorderLayout.WEST:
                header.setDirection(BasicArrowButton.WEST);
                break;
            case BorderLayout.SOUTH:
                header.setDirection(BasicArrowButton.SOUTH);
                break;
            case BorderLayout.NORTH:
                header.setDirection(BasicArrowButton.NORTH);
                break;
            default:
                // If no valid location is provided, don't change anything
                return ;
        }
        
        // Then remove the header and re-add it at its new location
        this.remove(header);
        this.add(header, headerLocation);
        
        // Fix the direction if the header wasn't collapsed
        if(!isCollapsed) {
            isCollapsed = true;
            toggleState();
        }
    }
    
    /**
     * Toggles the collapsed state of the panel.
     */
    public void toggleState() {
        switch(header.getDirection()) {
	        case BasicArrowButton.EAST:
	            header.setDirection(BasicArrowButton.WEST);
	            break;
	        case BasicArrowButton.WEST:
	            header.setDirection(BasicArrowButton.EAST);
	            break;
	        case BasicArrowButton.SOUTH:
	            header.setDirection(BasicArrowButton.NORTH);
	            break;
	        default:
	            header.setDirection(BasicArrowButton.SOUTH);
	            break;
	    }
        isCollapsed = !isCollapsed;
        content.setVisible(!isCollapsed);
    }
    
    /**
     * Sets the collapsed state of the panel.
     * @param isCollapsed New collapsed state
     */
    public void setState(boolean isCollapsed) {
    	if(this.isCollapsed != isCollapsed)
    		toggleState();
    }
}
