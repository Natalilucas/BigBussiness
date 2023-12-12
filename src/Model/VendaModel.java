package Model;

import Domain.Venda;

import java.util.ArrayList;

public class VendaModel {
    ArrayList<Venda> vendaArrayList;

    public VendaModel(ArrayList<Venda> vendaArrayList) {
        this.vendaArrayList = new ArrayList<>();
    }

    public void addVenda(Venda vendaNova){
        this.vendaArrayList.add(vendaNova);
    }
}
