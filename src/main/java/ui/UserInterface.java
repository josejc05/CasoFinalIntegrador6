package ui;

import javax.swing.JOptionPane;
import java.util.Scanner;
import management.DataManager;
import management.DataAnalyzer;
import model.DataList;
import retrieval.DataRetriever;
import sortsearch.DataSearcher;
import sortsearch.DataSorter;

public class UserInterface {
    private Scanner scanner;
    private DataManager dataManager;
    private DataAnalyzer dataAnalyzer;
    private DataList dataList;
    private DataRetriever dataRetriever;
    private DataSearcher dataSearcher;
    private DataSorter dataSorter;

    public UserInterface(DataManager dataManager, DataAnalyzer dataAnalyzer, DataList dataList, DataRetriever dataRetriever, DataSearcher dataSearcher, DataSorter dataSorter) {
        this.scanner = new Scanner(System.in);
        this.dataManager = dataManager;
        this.dataAnalyzer = dataAnalyzer;
        this.dataList = dataList;
        this.dataRetriever = dataRetriever;
        this.dataSearcher = dataSearcher;
        this.dataSorter = dataSorter;
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void showMenu() {
        String[] options = {"Agregar datos", "Analizar datos", "Recuperar datos", "Buscar datos", "Ordenar datos", "Salir"};
        int selection = JOptionPane.showOptionDialog(null, "Elige una opción", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (selection) {
            case 0:
                System.out.println("Introduce los datos a agregar:");
                String dataToAdd = getInput();
                dataManager.addData(dataToAdd);
                break;
            case 1:
                dataAnalyzer.analyzeData(dataManager.getData());
                break;
            case 2:
                System.out.println("Introduce el índice del dato a recuperar:");
                int index = Integer.parseInt(getInput());
                String retrievedData = dataRetriever.retrieveData(dataList.getDataList(), index);
                System.out.println("Dato recuperado: " + retrievedData);
                break;
            case 3:
                System.out.println("Introduce el dato a buscar:");
                String dataToSearch = getInput();
                int foundIndex = dataSearcher.searchData(dataManager.getData(), dataToSearch);
                System.out.println("Índice del dato buscado: " + foundIndex);
                break;
            case 4:
                dataSorter.sortData(dataManager.getData());
                System.out.println("Datos ordenados: " + dataManager.getData());
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}