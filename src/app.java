import DAO.DAODieta;
import DAO.DAOExames;

import Entidades.Nutricionista.Dieta;
import Entidades.Utils.Refeicao;

import Entidades.Aluno.Exames;

import java.util.ArrayList;

public class app {

    public static void main(String[] args) throws Exception {
        /*
        Refeicao r[] = new Refeicao[6];
        
        String[] al = {"Pao", "geleia"};
        String[] qt = {"50g", "2"};
        for (int i = 0; i<6;i++) {
            r[i] = new Refeicao();
            r[i].setAlimento(al);
            r[i].setNome("Cafe da manha" + i);
            r[i].setQuantidade(qt);
            r[i].setHorario("07h00");
            r[i].setObservacoes("Nenhuma");
        }
        
        Dieta d = new Dieta();
        d.setRefeicoes(r);
        
        new DAODieta().adicionaDieta(d); 
        
        new DAODieta().mostrarTodos();
        new DAODieta().buscarPorId("6042c46d3072b10c38b67aa5");
        new DAODieta().alterarPorId("6042c46d3072b10c38b67aa5", d);
        new DAODieta().deletar("6042c46d3072b10c38b67aa5");
        */
        
        ArrayList<String> le = new ArrayList<>();
        le.add("123");
        le.add("322");
        
        Exames e = new Exames();
        e.setArquivos(le);
        
        //new DAOExames().inserirExame(e);
        new DAOExames().mostrarTodos();
        //new DAOExames().alterarPorId("6042e13fb32cb566eaa6bc08", e);
        //new DAOExames().mostrarTodos();
        
    }
}
