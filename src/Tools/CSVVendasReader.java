package Tools;

import Domain.Venda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVVendasReader {

    String filePath;

    public CSVVendasReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Venda> readCSVtoModel() throws FileNotFoundException {
        File file = new File(this.filePath);
        Scanner sc = new Scanner(file);

        String linha = sc.nextLine();

        ArrayList<Venda> arrayVendas = new ArrayList<>();

        while(sc.hasNextLine()){
            linha = sc.nextLine();
            String[] linhaDividida = linha.split(",");

            String tipoProduto = linhaDividida[0];
            String produto = linhaDividida[1];
            double quantidadeVendida = Double.parseDouble(linhaDividida[2]);
            double precoUnitario = Double.parseDouble(linhaDividida[3]);

            Venda vendaAtual = new Venda(tipoProduto, produto, quantidadeVendida, precoUnitario);

            arrayVendas.add(vendaAtual);
        }

        return arrayVendas;
    }
}
