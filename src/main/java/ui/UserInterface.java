package ui;

import javax.swing.*;
import java.awt.Dimension;
import management.DataManager;
import management.DataAnalyzer;
import model.DataList;
import model.Pair;
import retrieval.DataRetriever;
import sortsearch.DataSearcher;
import sortsearch.DataSorter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        String[] options = {"Agregar pareja", "Ver parejas", "Eliminar pareja", "Ordenar ventas por precio", "Ordenar ventas por nombre", "Ordenar ventas por fecha", "Buscar nombre", "Salir"};
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 400)); // Ajusta el tamaño del panel a 400x400 pixels
        int selection = JOptionPane.showOptionDialog(panel, "Elige una opción", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (selection) {
            case 0:
                String keyToAdd = getInput("Introduce la clave de la pareja a agregar:");
                Double valueToAdd = Double.valueOf(getInput("Introduce el valor de la pareja a agregar:"));
                String dateToAddStr = getInput("Introduce la fecha de la venta (formato dd/MM/yyyy):");
                Date dateToAdd = null;
                try {
                    dateToAdd = new SimpleDateFormat("dd/MM/yyyy").parse(dateToAddStr);
                } catch (ParseException e) {
                    displayMessage("Fecha inválida. Por favor, introduce la fecha en el formato dd/MM/yyyy.");
                }
                if (dateToAdd != null) {
                    dataManager.addData(new Pair(keyToAdd, valueToAdd, dateToAdd));
                }
                break;
            case 1:
                StringBuilder pairs = new StringBuilder();
                for (Pair pair : dataManager.getData()) {
                    pairs.append("Clave: ").append(pair.getKey()).append(", Valor: ").append(pair.getValue()).append(", Fecha: ").append(pair.getDate()).append("\n");
                }
                displayMessage(pairs.toString());
                break;
            case 2:
                String[] pairKeys = dataManager.getData().stream().map(pair -> pair.getKey().toString()).toArray(String[]::new);
                String keyToRemove = (String) JOptionPane.showInputDialog(null, "Selecciona la pareja a eliminar:", "Eliminar pareja",
                        JOptionPane.QUESTION_MESSAGE, null, pairKeys, pairKeys[0]);
                Pair pairToRemove = dataManager.getData().stream().filter(pair -> pair.getKey().toString().equals(keyToRemove)).findFirst().orElse(null);
                if (pairToRemove != null) {
                    dataManager.removeData(pairToRemove);
                }
                break;
            case 3:
                List<Pair> sortedByPrice = dataAnalyzer.sortSalesByPrice(dataManager.getData());
                StringBuilder sortedPairsByPrice = new StringBuilder();
                for (Pair pair : sortedByPrice) {
                    sortedPairsByPrice.append("Clave: ").append(pair.getKey()).append(", Valor: ").append(pair.getValue()).append(", Fecha: ").append(pair.getDate()).append("\n");
                }
                displayMessage(sortedPairsByPrice.toString());
                break;
            case 4:
                List<Pair> sortedByName = dataAnalyzer.sortSalesByName(dataManager.getData());
                StringBuilder sortedPairsByName = new StringBuilder();
                for (Pair pair : sortedByName) {
                    sortedPairsByName.append("Clave: ").append(pair.getKey()).append(", Valor: ").append(pair.getValue()).append(", Fecha: ").append(pair.getDate()).append("\n");
                }
                displayMessage(sortedPairsByName.toString());
                break;
            case 5:
                List<Pair> sortedByDate = dataAnalyzer.sortSalesByDate(dataManager.getData());
                StringBuilder sortedPairsByDate = new StringBuilder();
                for (Pair pair : sortedByDate) {
                    sortedPairsByDate.append("Clave: ").append(pair.getKey()).append(", Valor: ").append(pair.getValue()).append(", Fecha: ").append(pair.getDate()).append("\n");
                }
                displayMessage(sortedPairsByDate.toString());
                break;
            case 6:
                String nameToSearch = getInput("Introduce el nombre a buscar:");
                boolean found = dataManager.searchName(nameToSearch);
                displayMessage(found ? "El nombre " + nameToSearch + " fue encontrado." : "El nombre " + nameToSearch + " no fue encontrado.");
                break;
            case 7:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}