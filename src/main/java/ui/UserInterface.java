package ui;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.Dimension;
import management.DataManager;
import management.DataAnalyzer;
import management.RelationManager;
import indexing.FileIndexer;
import indexing.FileVisualizer;
import model.DataList;
import model.Pair;
import retrieval.DataRetriever;
import sortsearch.DataSearcher;
import sortsearch.DataSorter;

import java.io.File;
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
    private RelationManager relationManager;
    private FileIndexer fileIndexer;
    private FileVisualizer fileVisualizer;

    public UserInterface(DataManager dataManager, DataAnalyzer dataAnalyzer, DataList dataList, DataRetriever dataRetriever, DataSearcher dataSearcher, DataSorter dataSorter, RelationManager relationManager, FileIndexer fileIndexer, FileVisualizer fileVisualizer) {
        this.dataManager = dataManager;
        this.dataAnalyzer = dataAnalyzer;
        this.dataList = dataList;
        this.dataRetriever = dataRetriever;
        this.dataSearcher = dataSearcher;
        this.dataSorter = dataSorter;
        this.relationManager = relationManager;
        this.fileIndexer = fileIndexer;
        this.fileVisualizer = fileVisualizer;
    }

    public String getInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showMenu() {
        String[] options = {"Agregar pareja", "Ver parejas", "Eliminar pareja", "Ordenar ventas por precio", "Ordenar ventas por nombre", "Ordenar ventas por fecha", "Buscar nombre", "Agregar relación", "Eliminar relación", "Buscar relación", "Indexar archivos", "Visualizar archivos", "Archivos ordenados alfabéticamente"};
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(400, 600)); // Ajusta el tamaño del panel
        panel.setBackground(Color.LIGHT_GRAY); // Cambia el color de fondo del panel

        for (int i = 0; i < options.length; i++) {
            JButton button = new JButton(options[i]);
            button.setBackground(Color.CYAN); // Cambia el color de los botones
            final int selection = i;
            button.addActionListener(e -> {
                switch (selection) {
                    case 0:
                        String keyToAdd = getInput("Introduce la clave de la pareja a agregar:");
                        Double valueToAdd = Double.valueOf(getInput("Introduce el valor de la pareja a agregar:"));
                        String dateToAddStr = getInput("Introduce la fecha de la venta (formato dd/MM/yyyy):");
                        Date dateToAdd = null;
                        try {
                            dateToAdd = new SimpleDateFormat("dd/MM/yyyy").parse(dateToAddStr);
                        } catch (ParseException ex) {
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
                    case 8:
                        String keyToAddRelation = getInput("Introduce la clave de la relación a agregar:");
                        String valueToAddRelation = getInput("Introduce el valor de la relación a agregar:");
                        relationManager.addRelation(keyToAddRelation, valueToAddRelation);
                        break;
                    case 9:
                        String keyToRemoveRelation = getInput("Introduce la clave de la relación a eliminar:");
                        relationManager.removeRelation(keyToRemoveRelation);
                        break;
                    case 10:
                        String keyToSearchRelation = getInput("Introduce la clave de la relación a buscar:");
                        String foundRelation = relationManager.getRelation(keyToSearchRelation);
                        displayMessage(foundRelation != null ? "La relación para " + keyToSearchRelation + " es " + foundRelation : "No se encontró ninguna relación para " + keyToSearchRelation);
                        break;
                    case 11:
                        String directoryPath = getInput("Introduce la ruta del directorio a indexar:");
                        File directory = new File(directoryPath);
                        if (directory.exists() && directory.isDirectory()) {
                            fileIndexer.indexFiles(directory);
                            displayMessage("Los archivos han sido indexados correctamente.");
                        } else {
                            displayMessage("La ruta proporcionada no es un directorio válido.");
                        }
                        break;
                    case 12:
                        String filesInfo = fileVisualizer.visualizeFiles();
                        JOptionPane.showMessageDialog(null, filesInfo);
                        break;
                    case 13:
                        String sortedFilesInfo = fileVisualizer.visualizeFilesSorted();
                        JOptionPane.showMessageDialog(null, sortedFilesInfo);
                        break;
                    default:
                        break;
                }
            });
            panel.add(button);
        }

        // Añade un espacio antes del botón de "Salir"
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton exitButton = new JButton("Salir");
        exitButton.setBackground(Color.RED); // Cambia el color del botón de "Salir"
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        JOptionPane.showOptionDialog(null, panel, "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
    }
}