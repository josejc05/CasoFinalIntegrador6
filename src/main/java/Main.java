import management.DataManager;
import management.DataAnalyzer;
import model.DataList;
import retrieval.DataRetriever;
import sortsearch.DataSearcher;
import sortsearch.DataSorter;
import ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        DataList dataList = new DataList();
        DataRetriever dataRetriever = new DataRetriever();
        DataSearcher dataSearcher = new DataSearcher();
        DataSorter dataSorter = new DataSorter();
        UserInterface userInterface = new UserInterface(dataManager, dataAnalyzer, dataList, dataRetriever, dataSearcher, dataSorter);

        // Mostrar el menú al usuario
        userInterface.showMenu();
    }
}