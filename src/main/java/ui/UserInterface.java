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
        String[] options = {"Agregar pareja", "Ver parejas", "Eliminar pareja", "Salir"};
        int selection = JOptionPane.showOptionDialog(null, "Elige una opción", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (selection) {
            case 0:
                String keyToAdd = getInput("Introduce la clave de la pareja a agregar:");
                String valueToAdd = getInput("Introduce el valor de la pareja a agregar:");
                ArrayList<Pair> valueList = new ArrayList<>();
                dataManager.addData(new Pair(keyToAdd, valueList));
                break;
            case 1:
                StringBuilder pairs = new StringBuilder();
                for (Pair pair : dataManager.getData()) {
                    pairs.append("Clave: ").append(pair.getKey()).append(", Valor: ").append(pair.getValue()).append("\n");
                }
                displayMessage(pairs.toString());
                break;
            case 2:
                String keyToRemove = getInput("Introduce la clave de la pareja a eliminar:");
                ArrayList<Pair> valueToRemove = new ArrayList<>();
                dataManager.removeData(new Pair(keyToRemove, valueToRemove));
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}