package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logic.Compare;
import Pojos.Directory;
import Models.SaveRead;
import neoredun.TopDownMenu;
import Views.ui;

public class Controller implements ActionListener {
    private ui ui;
    private SaveRead saveRead;
    private TopDownMenu tpm ;

    public Controller (ui view, SaveRead model) {
        tpm = new TopDownMenu();
        ui = view;
        saveRead = model;
        ui.setVisible(true);
        initializeButtons();

    }
    /**
     * Initialize buttons listeners
     */
    private void initializeButtons() {
        ui.getFromButton().addActionListener(this);
        ui.getFromButton().setActionCommand("From");

        ui.getDestinationButton().addActionListener(this);
        ui.getDestinationButton().setActionCommand("To");

        ui.getStartButton().addActionListener(this);
        ui.getStartButton().setActionCommand("Start");


    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Start":
                Directory a = new Directory(saveRead.getA());
                Directory b = new Directory(saveRead.getB());
                Compare c = new Compare(a,b);
                try{
                    c.compara();
                }catch(Exception e){
                    System.out.println("Introduce una direccion valida");//Change for popup
                }
                break;
            case "From":
                saveRead.saveVariables(tpm.topDown(0).toString(), saveRead.getB());
                ui.getjLabel4().setText(String.valueOf(saveRead.getA()));
                break;
            case "To":
                saveRead.saveVariables(saveRead.getA(), tpm.topDown(1).toString());
                ui.getjLabel3().setText(String.valueOf(saveRead.getB()));
                break;
        }

    }
}
