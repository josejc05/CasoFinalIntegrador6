import management.DataManager;
import management.DataAnalyzer;
import model.DataList;
import model.Pair;
import relation.RelationManager;
import retrieval.DataRetriever;
import sortsearch.DataSearcher;
import sortsearch.DataSorter;
import ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        DataList dataList = new DataList();
        Pair pair = new Pair("key", "value");
        RelationManager relationManager = new RelationManager();
        DataRetriever dataRetriever = new DataRetriever();
        DataSearcher dataSearcher = new DataSearcher();
        DataSorter dataSorter = new DataSorter();
        UserInterface userInterface = new UserInterface(dataManager, dataAnalyzer, dataList, dataRetriever, dataSearcher, dataSorter);

        // Agregar datos a DataManager
        dataManager.addData("dato1");
        dataManager.addData("dato2");

        // Analizar los datos en DataManager
        dataAnalyzer.analyzeData(dataManager.getData());

        // Agregar datos a DataList
        dataList.addData("dato3");
        dataList.addData("dato4");

        // Agregar una relación a RelationManager
        relationManager.addRelation(pair.getKey(), pair.getValue());

        // Recuperar un dato de DataList
        String retrievedData = dataRetriever.retrieveData(dataList.getDataList(), 0);
        userInterface.displayMessage("Dato recuperado: " + retrievedData);

        // Buscar un dato en DataManager
        int index = dataSearcher.searchData(dataManager.getData(), "dato1");
        userInterface.displayMessage("Índice del dato buscado: " + index);

        // Ordenar los datos en DataManager
        dataSorter.sortData(dataManager.getData());

        // Mostrar un mensaje al usuario
        userInterface.displayMessage("Fin del programa.");

        // Mostrar el menú al usuario
        userInterface.showMenu();
    }
}