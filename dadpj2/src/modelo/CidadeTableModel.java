package modelo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CidadeTableModel extends AbstractTableModel {

    Cidade cidade = new Cidade();
    private List<Cidade> cidades = new ArrayList<>();
    
    public CidadeTableModel(List<Cidade>cidades){
        this.cidades = cidades;
    }
    
    @Override
    public int getRowCount() {        
        return cidades.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    public Cidade getCidade(int linha){
        return this.cidades.get(linha);
    }
            
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cidade c = cidades.get(rowIndex);
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        switch(columnIndex){
            case 0: return c.getNome();            
            case 1: return c.getPopulacao();
            case 2: return c.getEstado().getNome();
            case 3: return format.format(c.getFundacao().getTime());
            case 4: return c.getIbge();

        }
        return null;
    }
        
        @Override
    public String getColumnName(int coluna){
        switch (coluna) {
            case 0:
                return "Nome";
            case 1:
                return "População";
            case 2:
                return "Estado";
            case 3:
                return "Fundação";
            case 4:
                return "IBGE";
        }
        return null;
    }
    
}
