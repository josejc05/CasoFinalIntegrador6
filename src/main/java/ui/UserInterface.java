package ui;

import javax.swing.JOptionPane;
import management.DataManager;
import management.DataAnalyzer;
import model.DataList;
import model.Pair;
import retrieval.DataRetriever;
import sortsearch.DataSearcher;
import sortsearch.DataSorter;

import java.util.ArrayList;

public class UserInterface {
    private DataManager dataManager;
    private DataAnalyzer dataAnalyzer;
    private DataList dataList;
    private DataRetriever dataRetriever;
    private DataSearcher dataSearcher;
    private DataSorter dataSorter;

    public UserInterface(DataManager dataManager, DataAnalyzer dataAnalyzer, DataList dataList, DataRetriever dataRetriever, DataSearcher dataSearcher, DataSorter dataSorter) {
        this.dataManager = dataManager;
        this.dataAnalyzer = dataAnalyzer;
        this.dataList = dataList;
        this.dataRetriever = dataRetriever;
        this.dataSearcher = dataSearcher;
        this.dataSorter = dataSorter;
    }

    public String getInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showMenu() {
        String[] options = {"Agregar datos", "Modificar datos", "Eliminar datos", "Analizar datos", "Recuperar datos", "Buscar datos", "Ordenar datos", "Salir"};
        int selection = JOptionPane.showOptionDialog(null, "Elige una opción", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (selection) {
            case 0:
                String dataToAdd = getInput("Introduce los datos a agregar:");
                ArrayList<Pair> valueToAdd = new ArrayList<>();
                dataManager.addData(new Pair(dataToAdd, valueToAdd));
                break;
            case 1:
                String dataToModify = getInput("Introduce los datos a modificar:");
                ArrayList<Pair> valueToModify = new ArrayList<>();
                dataManager.removeData(new Pair(dataToModify, valueToModify));
                String newData = getInput("Introduce los nuevos datos:");
                dataManager.addData(new Pair(newData, valueToModify));
                break;
            case 2:
                String dataToRemove = getInput("Introduce los datos a eliminar:");
                ArrayList<Pair> valueToRemove = new ArrayList<>();
                dataManager.removeData(new Pair(dataToRemove, valueToRemove));
                break;
            case 3:
                dataAnalyzer.analyzeData(dataManager.getData());
                break;
            case 4:
                int index = Integer.parseInt(getInput("Introduce el índice del dato a recuperar:"));
                Pair retrievedData = dataRetriever.retrieveData(dataManager.getData(), index);
                displayMessage("Dato recuperado: " + retrievedData.getKey() + ", Value: " + retrievedData.getValue());
                break;
            case 5:
                String dataToSearch = getInput("Introduce el dato a buscar:");
                int foundIndex = dataSearcher.searchData(dataManager.getData(), dataToSearch);
                displayMessage("Índice del dato buscado: " + foundIndex);
                break;
            case 6:
                dataSorter.sortData(dataManager.getData());
                displayMessage("Datos ordenados: " + dataManager.getData());
                break;
            case 7:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}