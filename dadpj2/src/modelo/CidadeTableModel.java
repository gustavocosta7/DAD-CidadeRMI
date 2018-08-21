package modelo;


import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.DataUtil;

public class CidadeTableModel extends AbstractTableModel {

    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public CidadeTableModel(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public int getRowCount() {
        return cidades.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cidade c = cidades.get(linha);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        switch(coluna){
            case 0:
                return c.getNome();
            case 1:
                return c.getEstado().getNome();
            case 2:
                return DataUtil.ConverterDataEmTexto(c.getFundacao());
            case 3:
                return c.getPopulacao();
                
        }
        return null;
    }
    
    @Override
    public String getColumnName(int coluna){
        switch (coluna) {
            case 0:
                return "Cidade";
            case 1:
                return "Estado";
            case 2:
                return "Fundação";
            case 3:
                return "População";
        }
        return null;
    }
}
