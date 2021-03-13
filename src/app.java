import DAO.DAODieta;
import DAO.DAOExames;
import DAO.DAOAvFisica;
import DAO.DAOTreino;
import DAO.DAOAnamnese;

import Entidades.Nutricionista.Dieta;
import Entidades.Utils.Refeicao;
import Entidades.Utils.OpcoesAnamnese;
import Entidades.Aluno.FichaAnamnese;
import Entidades.Aluno.Exames;
import Entidades.Aluno.AvaliacaoFisica;
import Entidades.Utils.ClasseDeTreino;
import Entidades.Personal.Treino;

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
            r[i].setNome("Cafe da manhaa" + i);
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
        
        
        ArrayList<String> le = new ArrayList<>();
        le.add("123");
        le.add("322");
        
        Exames e = new Exames();
        e.setArquivos(le);
        
        new DAOExames().inserirExame(e);
        new DAOExames().mostrarTodos();
        new DAOExames().alterarPorId("6042e13fb32cb566eaa6bc08", e);
        new DAOExames().mostrarTodos();
        
        
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        float[] c = {1.2f, 3.2f};
        
        FichaAnamnese f = new FichaAnamnese(170, 65.5f, a, b, c);
        new DAOAnamnese().insertAnamnese(f);
         
        
        new DAOAnamnese().buscarPorId("6043c52d1a3cab43b41fa98e"); 
        Treino t = new Treino();
        ArrayList<ClasseDeTreino> treinos = new ArrayList<>();
        String[] a = {"3", "3", "3"};
        String[] b = {"3", "3", "3"};
        String[] c = {"3", "3", "3"};
        
        ClasseDeTreino treino = new ClasseDeTreino(a, "Nenhuma", 'A', b, c, "Nenhuma");
        treinos.add(treino);
        t.setTreino(treinos);
        
        new DAOTreino().inserirTreino(t);
        new DAOTreino().alterarPorId("6044e98c9e51dd4e9d3a9a58", t);
        */
        
        ArrayList<OpcoesAnamnese> op = new ArrayList();
        int i = 0;
        while(i < 5) {
            OpcoesAnamnese o = new OpcoesAnamnese();
            o.setOpcao("Opcao numero " + (i + 1));
            o.setOpMarcada(true);
            o.setDescricao("desc" + (i + 1));
            i++;
            op.add(o);
        }
        
        FichaAnamnese f = new FichaAnamnese(op);
        new DAOAnamnese().inserirAnamnese(f);
        
    }
}
