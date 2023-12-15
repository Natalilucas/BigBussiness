package Model;

import Domain.Venda;
import Tools.CSVVendasReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VendaModel {
    private ArrayList<Venda> vendaArray;

    public VendaModel(String filePath) throws FileNotFoundException {
        CSVVendasReader csvVendasReader = new CSVVendasReader(filePath);
        this.vendaArray = csvVendasReader.readCSVtoModel();
    }

    public ArrayList<Venda> getVendaArray(){
        return vendaArray;
    }

}
