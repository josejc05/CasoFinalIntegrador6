import management.DataManager;
import management.DataAnalyzer;
import management.RelationManager;
import model.DataList;
import model.Pair;
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
        RelationManager relationManager = new RelationManager();
        UserInterface userInterface = new UserInterface(dataManager, dataAnalyzer, dataList, dataRetriever, dataSearcher, dataSorter, relationManager);

        // Mostrar el menú al usuario en un bucle infinito
        while (true) {
            userInterface.showMenu();
        }
    }
}