/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Checkbox;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logic.Animal;
import logic.AnimalManager;
import logic.Food;
import logic.FoodManager;

/**
 *
 * @author TT
 */
public class TierparkManagerGUI extends javax.swing.JFrame {

    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    Checkbox health = new Checkbox();
    Checkbox fed = new Checkbox();
    JTextField field5 = new JTextField();
    JTextField field6 = new JTextField();
    JTextField foodfield1 = new JTextField();
    JTextField foodfield2 = new JTextField();
    JTextField foodfield3 = new JTextField();

    Object[] fields = {
        "Name", field1, "Age", field2, "Healthy?", health, "Fed?", fed, "Gender", field5, "Type", field6

    };
    Object[] fields2 = {
        "Name", foodfield1, "Quantity", foodfield2, "Type", foodfield3

    };

    Object[] options = {"Save",
        "Cancel", "Clear all"};

    /**
     * Creates new form TierparkManager
     */
    public TierparkManagerGUI() {
        initComponents();
        AnimalPanel.setVisible(false);
        FoodPanel.setVisible(false);
        WelcomeLabel.setVisible(true);
        populateTable();
        populateTableFood();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) AnimalTable.getModel();
        ArrayList<Animal> localAnimals = AnimalManager.getAnimals();

        //remove all old rows
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        //add all animals from localAnimals into the table
        Object rowData[] = new Object[7];
        for (int i = 0; i < localAnimals.size(); i++) {
            rowData[0] = localAnimals.get(i).getAnimalID();
            rowData[1] = localAnimals.get(i).getName();
            rowData[2] = localAnimals.get(i).getAge();
            rowData[3] = localAnimals.get(i).getHealth();
            rowData[4] = localAnimals.get(i).getfeeding();
            rowData[5] = localAnimals.get(i).getGender();
            rowData[6] = localAnimals.get(i).getType();
            model.addRow(rowData);
        }

    }

    public void populateTableFood() {
        DefaultTableModel model = (DefaultTableModel) FoodTable.getModel();
        ArrayList<Food> localFoods = FoodManager.getFoods();

        //remove all old rows
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        //add all animals from localAnimals into the table
        Object rowData[] = new Object[7];
        for (int i = 0; i < localFoods.size(); i++) {
            rowData[0] = localFoods.get(i).getFoodID();
            rowData[1] = localFoods.get(i).getName();
            rowData[2] = localFoods.get(i).getQuantity();
            rowData[3] = localFoods.get(i).getType();
            model.addRow(rowData);
        }

    }

    private boolean validInput() {

        try {
            int age = Integer.parseInt(field2.getText());
            if (age < 0) {
                field2.setText("Invalid age input. Please reenter");
                return false;
            }  else {
                return true;
            }
        } catch (NumberFormatException e) {
             if (field2.getText().equals("")) {
                field2.setText("Empty input! Please reenter");
                return false;
            }
             else {field2.setText("Invalid age input. Please reenter");}
            return false;
        }
    }

    private boolean validInput2() {

        try {
            int quantity = Integer.parseInt(foodfield2.getText());
            if (quantity < 0) {
                foodfield2.setText("Invalid quantity input. Please reenter");
                return false;
            }  else {
                return true;
            }
        } catch (NumberFormatException e) {
            if (foodfield2.getText().equals("")) {
                foodfield2.setText("Empty input! Please reenter");
                return false;
            }
            else {foodfield2.setText("Invalid quantity input. Please reenter");}
            
            return false;

        }
    }

    public boolean containsOnlyLetters1(JTextField field1) {//checks if string contains only letters
        String string = field1.getText();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

                return true;
            }
        }
        if (field1.getText().equals("")) {
            field1.setText("Empty input! Please reenter");
        } else {
            field1.setText("Invalid name input. Please reenter!");

        }
        return false;
    }

    public boolean containsOnlyLetters5(JTextField field5) {//checks if string contains only letters
        if (field5.getText().equals("Male")) {

            return true;
        }
        if (field5.getText().equals("male")) {
            field5.setText("Male");
            return true;
        }
        if (field5.getText().equals("Female")) {

            return true;
        }
        if (field5.getText().equals("female")) {
            field5.setText("Female");
            return true;
        }

        if (field5.getText().equals("")) {
            field5.setText("Empty input! Please enter Male or Female!");
        } else {
            field5.setText("Invalid Gender Input. Please enter either Male or Female!");

        }
        return false;
    }

    public boolean containsOnlyLetters6(JTextField field6) {//checks if string contains only letters
        String string = field6.getText();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

                return true;
            }
        }
        if (field6.getText().equals("")) {
            field6.setText("Type Field is empty. Please enter something!");
        } else {
            field6.setText("Invalid Type Input. Please reenter!");

        }
        return false;
    }

    public boolean containsOnlyLettersname(JTextField foodfield1) {//checks if string contains only letters
        String string = foodfield1.getText();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

                return true;
            }
        }
        if (foodfield1.getText().equals("")) {
            foodfield1.setText("Empty input! Please reenter");
        } else {
            foodfield1.setText("Invalid name input. Please reenter!");

        }
        return false;
    }

    public boolean containsOnlyLetterstype(JTextField foodfield3) {//checks if string contains only letters
        String string = foodfield3.getText();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

                return true;
            }
        }
        if (foodfield3.getText().equals("")) {
            foodfield3.setText("Empty input! Please reenter");
        } else {
            foodfield3.setText("Invalid name input. Please reenter!");

        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnimalPanel = new javax.swing.JPanel();
        AnimalLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AnimalTable = new javax.swing.JTable();
        CreateNewAnimalButton = new javax.swing.JButton();
        DeleteAnimalButton = new javax.swing.JButton();
        FoodPanel = new javax.swing.JPanel();
        FoodLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        FoodTable = new javax.swing.JTable();
        CreateNewFoodButton1 = new javax.swing.JButton();
        DeleteFoodButton1 = new javax.swing.JButton();
        WelcomeLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        StartingPage = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        BasicDataMenu = new javax.swing.JMenu();
        ManageAnimals = new javax.swing.JMenuItem();
        ManageFood = new javax.swing.JMenuItem();
        ManageStaff = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        HelpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        AnimalLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        AnimalLabel.setText("Animals at TierparkPforzheim");

        AnimalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Animal ID", "Name", "Age", "Healthy", "Fed", "Gender", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AnimalTable);

        CreateNewAnimalButton.setText("NEW ANIMAL");
        CreateNewAnimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewAnimalButtonActionPerformed(evt);
            }
        });

        DeleteAnimalButton.setText("DELETE ANIMAL");
        DeleteAnimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAnimalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AnimalPanelLayout = new javax.swing.GroupLayout(AnimalPanel);
        AnimalPanel.setLayout(AnimalPanelLayout);
        AnimalPanelLayout.setHorizontalGroup(
            AnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnimalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateNewAnimalButton)
                .addGap(12, 12, 12)
                .addComponent(DeleteAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(AnimalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnimalLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AnimalPanelLayout.setVerticalGroup(
            AnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnimalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnimalLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateNewAnimalButton)
                    .addComponent(DeleteAnimalButton))
                .addGap(0, 44, Short.MAX_VALUE))
        );

        FoodLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        FoodLabel.setText("Food at TierparkPforzheim");

        FoodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Food ID", "Name", "Quantity", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(FoodTable);

        CreateNewFoodButton1.setText("NEW FOOD");
        CreateNewFoodButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewFoodButton1ActionPerformed(evt);
            }
        });

        DeleteFoodButton1.setText("DELETE FOOD");
        DeleteFoodButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteFoodButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FoodPanelLayout = new javax.swing.GroupLayout(FoodPanel);
        FoodPanel.setLayout(FoodPanelLayout);
        FoodPanelLayout.setHorizontalGroup(
            FoodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FoodPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateNewFoodButton1)
                .addGap(12, 12, 12)
                .addComponent(DeleteFoodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(FoodPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FoodLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FoodPanelLayout.setVerticalGroup(
            FoodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FoodLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FoodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateNewFoodButton1)
                    .addComponent(DeleteFoodButton1))
                .addGap(0, 45, Short.MAX_VALUE))
        );

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        WelcomeLabel.setText("Welcome to Tierpark Pforzheim Management System!");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        StartingPage.setText("Starting Page");
        StartingPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartingPageActionPerformed(evt);
            }
        });
        fileMenu.add(StartingPage);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        BasicDataMenu.setMnemonic('e');
        BasicDataMenu.setText("BASIC DATA");

        ManageAnimals.setMnemonic('t');
        ManageAnimals.setText("Manage Animals");
        ManageAnimals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageAnimalsActionPerformed(evt);
            }
        });
        BasicDataMenu.add(ManageAnimals);

        ManageFood.setMnemonic('y');
        ManageFood.setText("Manage Food");
        ManageFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageFoodActionPerformed(evt);
            }
        });
        BasicDataMenu.add(ManageFood);

        ManageStaff.setMnemonic('p');
        ManageStaff.setText("Manage Staff");
        ManageStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageStaffActionPerformed(evt);
            }
        });
        BasicDataMenu.add(ManageStaff);

        menuBar.add(BasicDataMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        HelpMenuItem.setMnemonic('c');
        HelpMenuItem.setText("Help");
        HelpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(HelpMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AnimalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FoodPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(WelcomeLabel)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AnimalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(FoodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(WelcomeLabel)
                    .addContainerGap(173, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        int answer; // What is the click of the user? Yes or NO?
        answer = JOptionPane.showConfirmDialog(this, "Closing the App?", "Please confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.NO_OPTION) {
        }
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void ManageFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageFoodActionPerformed
        WelcomeLabel.setVisible(false);
        AnimalPanel.setVisible(false);
        FoodPanel.setVisible(true);
    }//GEN-LAST:event_ManageFoodActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int answer; // What is the click of the user? Yes or NO?
        answer = JOptionPane.showConfirmDialog(this, "Closing the App?", "Please confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_formWindowClosing

    private void ManageAnimalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageAnimalsActionPerformed
        WelcomeLabel.setVisible(false);
        AnimalPanel.setVisible(true);
    }//GEN-LAST:event_ManageAnimalsActionPerformed

    private void CreateNewAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewAnimalButtonActionPerformed
        boolean choice = true;
        while (choice) {
            int n = JOptionPane.showOptionDialog(this,
                    fields,
                    "Create new animal",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title
            if (n == JOptionPane.YES_OPTION) {
                if (validInput() & containsOnlyLetters1(field1) & containsOnlyLetters5(field5) & containsOnlyLetters6(field6)) {
                    String name = field1.getText();
                    int age = Integer.parseInt(field2.getText());
                    boolean health_status = health.getState();
                    boolean feeding_status = fed.getState();
                    String gender = field5.getText();
                    String specific_type = field6.getText();
                    AnimalManager.addAnimal(new Animal(name, age, health_status, feeding_status, gender, specific_type));
                    populateTable();
                    field1.setText("");
                    field2.setText("");
                    health.setState(false);
                    fed.setState(false);
                    field5.setText("");
                    field6.setText("");

                } else {
                }
            }
            if (n == JOptionPane.NO_OPTION) {
                field1.setText("");
                field2.setText("");
                health.setState(false);
                fed.setState(false);
                field5.setText("");
                field6.setText("");
                choice = false;
            }
            if (n == JOptionPane.CANCEL_OPTION) {
                field1.setText("");
                field2.setText("");
                health.setState(false);
                fed.setState(false);
                field5.setText("");
                field6.setText("");
            }
            if (n == JOptionPane.CLOSED_OPTION) {
                choice = false;
            }
        }
    }//GEN-LAST:event_CreateNewAnimalButtonActionPerformed

    private void DeleteAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAnimalButtonActionPerformed

        if (!AnimalTable.getSelectionModel().isSelectionEmpty()) {
            DefaultTableModel model = (DefaultTableModel) AnimalTable.getModel();
            int row = AnimalTable.getSelectedRow();
            int id = (int) model.getValueAt(row, 0);
            String animalName = (String) model.getValueAt(row, 1);
            int answer; // What is the click of the user? Yes or NO?
            answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete animal " + animalName + "?", "Deleting an animal?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                AnimalManager.deleteAnimal(id);
                populateTable();
            }
            if (answer == JOptionPane.NO_OPTION) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "You have not selected an animal to delete! Please select one.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_DeleteAnimalButtonActionPerformed

    private void ManageStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageStaffActionPerformed
        JOptionPane.showMessageDialog(this, "This section has not yet been implemented!", "Managing Staff", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_ManageStaffActionPerformed

    private void CreateNewFoodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewFoodButton1ActionPerformed
        boolean choice = true;
        while (choice) {
            int n = JOptionPane.showOptionDialog(this,
                    fields2,
                    "Create new food",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title
            if (n == JOptionPane.YES_OPTION) {
                if (validInput2() & containsOnlyLettersname(foodfield1) & containsOnlyLetterstype(foodfield3)) {
                    String name = foodfield1.getText();
                    int quantity = Integer.parseInt(foodfield2.getText());
                    String type = foodfield3.getText();
                    FoodManager.addFood(new Food(name, quantity, type));
                    populateTableFood();
                    foodfield1.setText("");
                    foodfield2.setText("");
                    foodfield3.setText("");

                } else {
                }
            }
            if (n == JOptionPane.NO_OPTION) {
                foodfield1.setText("");
                foodfield2.setText("");
                foodfield3.setText("");
                choice = false;
            }
            if (n == JOptionPane.CANCEL_OPTION) {
                foodfield1.setText("");
                foodfield2.setText("");
                foodfield3.setText("");
            }
            if (n == JOptionPane.CLOSED_OPTION) {
                choice = false;
            }
        }
    }//GEN-LAST:event_CreateNewFoodButton1ActionPerformed

    private void DeleteFoodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteFoodButton1ActionPerformed
        if (!FoodTable.getSelectionModel().isSelectionEmpty()) {
            DefaultTableModel model = (DefaultTableModel) FoodTable.getModel();
            int row = FoodTable.getSelectedRow();
            int id = (int) model.getValueAt(row, 0);
            String foodName = (String) model.getValueAt(row, 1);
            String foodType = (String) model.getValueAt(row, 3);
            int answer; // What is the click of the user? Yes or NO?
            answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + foodType + " " + foodName + "?", "Deleting a food?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                FoodManager.deleteFood(id);
                populateTableFood();
            }
            if (answer == JOptionPane.NO_OPTION) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "You have not selected a food to delete! Please select one.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_DeleteFoodButton1ActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "This programm was created by Jen and Judith! Have fun!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void HelpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "If you have an issue, send a message to jen_judith@web.de", "HELP", JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_HelpMenuItemActionPerformed

    private void StartingPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartingPageActionPerformed
       AnimalPanel.setVisible(false);
        FoodPanel.setVisible(false);
        WelcomeLabel.setVisible(true);
        
    }//GEN-LAST:event_StartingPageActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TierparkManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TierparkManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TierparkManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TierparkManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TierparkManagerGUI().setVisible(true);
            }
        });
        AnimalManager.addAnimal(new Animal("Tina", 5, false, true, "Female", "Tiger"));
        AnimalManager.addAnimal(new Animal("Olli", 13, true, false, "Male", "Lion"));

        FoodManager.addFood(new Food("Meat", 40, "Chicken"));
        FoodManager.addFood(new Food("Plant", 50, "Corn"));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnimalLabel;
    private javax.swing.JPanel AnimalPanel;
    private javax.swing.JTable AnimalTable;
    private javax.swing.JMenu BasicDataMenu;
    private javax.swing.JButton CreateNewAnimalButton;
    private javax.swing.JButton CreateNewFoodButton1;
    private javax.swing.JButton DeleteAnimalButton;
    private javax.swing.JButton DeleteFoodButton1;
    private javax.swing.JLabel FoodLabel;
    private javax.swing.JPanel FoodPanel;
    private javax.swing.JTable FoodTable;
    private javax.swing.JMenuItem HelpMenuItem;
    private javax.swing.JMenuItem ManageAnimals;
    private javax.swing.JMenuItem ManageFood;
    private javax.swing.JMenuItem ManageStaff;
    private javax.swing.JMenuItem StartingPage;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
