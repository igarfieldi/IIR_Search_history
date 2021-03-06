/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;


/**
 * Main class of the application.
 * Stores the UI component and some of the interaction-bound application logic.
 * The {@link #initComponents() initComponents}-method was largely created by Netbeans GUI builder.
 * @author Florian Bethe, Tino Liebusch
 */
public class SearchHistoryUI extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 2900840823572839865L;
	
	/**
     * Creates new form SearchHistoryUI.
     */
    public SearchHistoryUI() {
    	history = new SearchHistory();
    	lastQuery = null;
    	lastRecentSearch = null;
        initComponents();
        this.updateRecentSearches();

        // Add shutdown hook to save the history after application exit
        Runtime.getRuntime().addShutdownHook(new Thread()
		{
		    @Override
		    public void run()
		    {
		    	history.saveHistory();
		    }
		});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	searchButtonGroup = new javax.swing.ButtonGroup();
        sidebarPanel = new javax.swing.JPanel();
        userSelection = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        engineButton = new javax.swing.JRadioButton();
        historyButton = new javax.swing.JRadioButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        recentSearchesPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        quicklinkPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        outerMainPanel = new javax.swing.JPanel();
        collapsiblePanel1 = new core.CollapsiblePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebarPanel.setBackground(new java.awt.Color(231, 247, 255));
        sidebarPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        userSelection.setBackground(new java.awt.Color(203, 234, 255));
        userSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search in:");

        engineButton.setBackground(new java.awt.Color(231, 247, 255));
        engineButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        engineButton.setText("Engine");
        engineButton.setSelected(true);

        historyButton.setBackground(new java.awt.Color(231, 247, 255));
        historyButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        historyButton.setText("History");
        
        searchButtonGroup.add(engineButton);
        searchButtonGroup.add(historyButton);

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	performSearch();
            }
        });

        searchButton.setText("GO");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		performSearch();
        	}
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recent Searches");

        recentSearchesPanel.setBackground(new java.awt.Color(231, 247, 255));

        recentSearchesPanel.setLayout(new javax.swing.BoxLayout(recentSearchesPanel, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quick Links");

        jPanel2.setBackground(new java.awt.Color(149, 212, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(190, 210));

        quicklinkPanel.setBackground(new java.awt.Color(231, 247, 255));
        quicklinkPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout quicklinkPanelLayout = new javax.swing.GroupLayout(quicklinkPanel);
        quicklinkPanel.setLayout(quicklinkPanelLayout);
        quicklinkPanelLayout.setHorizontalGroup(
            quicklinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        quicklinkPanelLayout.setVerticalGroup(
            quicklinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(quicklinkPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(userSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(engineButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(historyButton)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarPanelLayout.createSequentialGroup()
                .addComponent(searchField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(recentSearchesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(engineButton)
                    .addComponent(historyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recentSearchesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(sidebarPanel, java.awt.BorderLayout.EAST);

        jPanel3.setLayout(new java.awt.BorderLayout());

        outerMainPanel.setLayout(new java.awt.BorderLayout());
        jPanel3.add(outerMainPanel, java.awt.BorderLayout.CENTER);
        
        mainPanel = new javax.swing.JPanel();
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));
        mainScrollPane = new javax.swing.JScrollPane(mainPanel);
        mainScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScrollPane.setBorder(null);
        outerMainPanel.add(mainScrollPane, java.awt.BorderLayout.CENTER);
        
        jPanel5 = new javax.swing.JPanel();
        jPanel5.setLayout(new java.awt.BorderLayout());

        optionsPanel = new javax.swing.JPanel();
        optionsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, java.awt.Color.BLACK));
        checkVisitedOnly = new javax.swing.JCheckBox("Show visited pages only");
        checkVisitedOnly.setSelected(true);
        checkVisitedOnly.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Check which was the last history action performed by the user and use that
				// to update the view of the history
				if(lastQuery != null) {
					searchHistory(lastQuery);
				} else if(lastRecentSearch != null) {
					displayRecentSearch(lastRecentSearch);
				}
			}
        });
        optionsPanel.add(checkVisitedOnly);

        outerHistoryPanel = new javax.swing.JPanel();
        outerHistoryPanel.setLayout(new java.awt.BorderLayout());
        
        historyPanel = new javax.swing.JPanel();
        historyPanel.setLayout(new javax.swing.BoxLayout(historyPanel, javax.swing.BoxLayout.Y_AXIS));
        
        historyScrollPane = new javax.swing.JScrollPane(historyPanel);
        historyScrollPane.setBorder(null);
        historyScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outerHistoryPanel.add(historyScrollPane, java.awt.BorderLayout.CENTER);

        jPanel5.add(optionsPanel, java.awt.BorderLayout.WEST);
        jPanel5.add(outerHistoryPanel, java.awt.BorderLayout.CENTER);
        collapsiblePanel1.setContent(jPanel5);
        jPanel3.add(collapsiblePanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);
        
        this.setSize(new java.awt.Dimension(800, 600));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Performs a search for a given query.
     * Whether the history is searched or an engine is used will be
     * determined by the selected radio button.
     */
    private void performSearch() {//GEN-FIRST:event_searchFieldActionPerformed
    	if(!searchField.getText().isEmpty()) {
    		// DEBUG
    		//System.out.println("Performed search for: '" + searchField.getText() + "' in history: " + historyButton.isSelected());
    		if(historyButton.isSelected()) {
    			lastQuery = searchField.getText();
    			lastRecentSearch = null;
    			searchHistory(lastQuery);
    		} else {
    			searchEngine(searchField.getText());
    		}
    	}
    }//GEN-LAST:event_searchFieldActionPerformed

    /**
     * Updates the recent searches panel.
     * The search history is queried for the last x searches, which will then be added as buttons.
     */
    private void updateRecentSearches() {
    	recentSearchesPanel.removeAll();
        recentSearchesPanel.revalidate();
        recentSearchesPanel.repaint();

		// Update the recent search bar
    	List<QuerySearch> recentSearches = history.getRecentSearches(5);
    	
    	// Traverse the recent searches in reverse order
		for(int i = recentSearches.size() - 1; i >= 0; i--) {
			QuerySearch recent = recentSearches.get(i);
			javax.swing.JButton currQueryButton = new javax.swing.JButton(recent.getQuery());
			currQueryButton.addActionListener(new java.awt.event.ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					lastRecentSearch = recent;
					lastQuery = null;
					displayRecentSearch(recent);
				}
				
			});
			
			recentSearchesPanel.add(currQueryButton);
		}
		
		sidebarPanel.validate();
    }
    
    /**
     * Displays the search results of a {@link QuerySearch QuerySearch} in the history panel.
     * @param recent QuerySearch to be used
     */
    private void displayRecentSearch(QuerySearch recent) {
    	historyPanel.removeAll();
        historyPanel.revalidate();
        historyPanel.repaint();
		
        javax.swing.JLabel headLine = new javax.swing.JLabel(" " + recent.getQuery());
        headLine.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
		historyPanel.add(headLine);
		
		for(SearchResult result : recent.getResults()) {
			if((result.getClickCounter() > 0) || !checkVisitedOnly.isSelected())
				historyPanel.add(new ResultLabel(result, SwingConstants.LEADING, false));
		}
		
		collapsiblePanel1.setState(false);
		collapsiblePanel1.revalidate();
		collapsiblePanel1.repaint();
    }
    
    /**
     * Creates a new {@link BingSearch BingSearch} to search for the provided query.
     * Also updates the search history and displays the search results in the main panel.
     * @param query Search query
     */
    private void searchEngine(String query) {
    	// Remove any previous search results / content
		mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
		
		try {
			// Utilize Bing to get the search results
			BingSearch search = new BingSearch(query);
			search.findQuery();
			

			// Some fancy border stuff; simply adds some padding for the result labels
			javax.swing.border.CompoundBorder innerLabelBorder = new javax.swing.border.CompoundBorder(
					javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5),
					javax.swing.BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY, 1));
			javax.swing.border.CompoundBorder outerLabelBorder = new javax.swing.border.CompoundBorder(
					innerLabelBorder,
					javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
			
			// Add the individual results as links to the main panel
			for(SearchResult result : search.getResults()) {
				ResultLabel currLink = new ResultLabel(result, SwingConstants.LEADING);
				currLink.setBorder(outerLabelBorder);
				mainPanel.add(currLink);
			}
			
			history.addEntry(search);
			this.updateRecentSearches();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainPanel.validate();
		mainScrollPane.validate();
    }
    
    /**
     * Searches the history for the given query.
     * Here a simple binary search is done; if the query or result headline contains all the words
     * in the query regardless of order, it is displayed in the history panel.
     * @param query
     */
    private void searchHistory(String query) {
    	historyPanel.removeAll();
        historyPanel.revalidate();
        historyPanel.repaint();
		
		// TODO: apply filters
        javax.swing.JLabel headLine = new javax.swing.JLabel(" " + searchField.getText());
        headLine.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
		historyPanel.add(headLine);

        String searchTerm = searchField.getText();
        List<QuerySearch> historyElements = history.getHistoryDateOrdered();

        // TODO: remove duplicates?
        for(QuerySearch search : historyElements){
            // Filters all history elements containing the search term (case insensitive)
            if(containsWords(searchTerm, search.getQuery())) {
            	javax.swing.JButton queryBtn = new javax.swing.JButton(search.getQuery());
            	queryBtn.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						searchEngine(((JButton)e.getSource()).getText());
					}
            	});
                historyPanel.add(queryBtn);
            }
            
            for(SearchResult result : search.getResults()) {
            	if(containsWords(searchTerm, result.getHeadline())){
            		if((result.getClickCounter() > 0) || !checkVisitedOnly.isSelected())
            			historyPanel.add(new ResultLabel(result, SwingConstants.LEADING, false));
            	}
            }
        }
		
		collapsiblePanel1.setState(false);
		collapsiblePanel1.validate();
		collapsiblePanel1.repaint();
    }
    
    /**
     * Helper method checking whether a text contains all the words in a query.
     * @param query Search query
     * @param text Text to be searched
     * @return Does the text contain all the query words
     */
    private boolean containsWords(String query, String text) {
    	List<String> queryWords = Arrays.asList(query.toLowerCase().split(" "));
    	List<String> textWords = Arrays.asList(text.toLowerCase().split(" "));
    	for(String word : queryWords) {
    		if(!textWords.contains(word))
    			return false;
    	}
    	return true;
    }
    
    /**
     * Main method.
     * @param args The command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        // Add a shutdown hook to save the history in case of application exit

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchHistoryUI().setVisible(true);
            }
        });
    }

    
    private SearchHistory history;
    private String lastQuery;
    private QuerySearch lastRecentSearch;
    
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JPanel outerHistoryPanel;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JPanel outerMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane historyScrollPane;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JCheckBox checkVisitedOnly;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup searchButtonGroup;
    private core.CollapsiblePanel collapsiblePanel1;
    private javax.swing.JRadioButton engineButton;
    private javax.swing.JRadioButton historyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel recentSearchesPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel quicklinkPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JComboBox<String> userSelection;
    // End of variables declaration//GEN-END:variables
}
