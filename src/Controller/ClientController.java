package Controller;

import Domain.Venda;
import Model.VendaModel;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientController {

    private ArrayList<Venda> todasVendas;

    public ClientController() throws FileNotFoundException {
        VendaModel repo = new VendaModel("Ficheiros/minimercado.csv");
        this.todasVendas = repo.getVendaArray();
    }

    public Venda produtoMaisCaro() {
        double precoMaisCaro = 0;
        Venda vendaProdutoMaisCaro = null;

        for (Venda vendaAtual : this.todasVendas) {
            if (vendaAtual.getPrecoUnitario() > precoMaisCaro) {
                precoMaisCaro = vendaAtual.getPrecoUnitario();
                vendaProdutoMaisCaro = vendaAtual;
            }
        }

        return vendaProdutoMaisCaro;
    }

    public ArrayList<Venda> produtosDisponiveisSemDuplicados() {

        ArrayList<Venda> arrayAuxiliar = new ArrayList<>();
        arrayAuxiliar.add(this.todasVendas.get(0));


        for (Venda vendaAtual : this.todasVendas) {
            boolean encontrado = false;

            for (Venda vendaAtualUnica : arrayAuxiliar) {
                if (vendaAtual.getProduto().equals(vendaAtualUnica.getProduto())) {
                    encontrado = true;
                }
            }

            if (!encontrado) {
                arrayAuxiliar.add(vendaAtual);
            }
        }

        return arrayAuxiliar;
    }


    public ArrayList<Venda> produtosDeCategoria(String categoriaFiltro){
        ArrayList<Venda> arrayProdutos = this.produtosDisponiveisSemDuplicados();
        ArrayList<Venda> arrayProdutosFiltrado = new ArrayList<>();

        for(Venda vendaAtual: arrayProdutos){
            if(vendaAtual.getTipoProduto().equals(categoriaFiltro)){
                arrayProdutosFiltrado.add(vendaAtual);
            }
        }
        return arrayProdutosFiltrado;
    }
}
