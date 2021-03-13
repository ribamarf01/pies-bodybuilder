package DAO;

import Conexao.ConexaoMongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.ArrayList;

import Entidades.Nutricionista.Dieta;
import Entidades.Utils.Refeicao;

public class DAODieta extends ConexaoMongo{
    
    MongoDatabase con;
    MongoCollection<Document> dieta;
    
    public DAODieta() {
        this.con = ConexaoMongo.getConexao();
        this.dieta = this.con.getCollection("dieta");
    }
    
    public void adicionaDieta(Dieta d) {
        ArrayList<Refeicao> refeicoes = d.getRefeicoes();
        /*
        this.dieta.insertOne( new Document(refeicoes[0].getNome(), new Document("Alimentos", Arrays.asList(refeicoes[0].getAlimento())).append("Quantidade", Arrays.asList(refeicoes[0].getQuantidade())).append("Horario", refeicoes[0].getHorario()).append("Observacoes", refeicoes[0].getObservacoes()))
                            .append(refeicoes[1].getNome(), new Document("Alimentos", Arrays.asList(refeicoes[1].getAlimento())).append("Quantidade", Arrays.asList(refeicoes[1].getQuantidade())).append("Horario", refeicoes[1].getHorario()).append("Observacoes", refeicoes[1].getObservacoes()))
                            .append(refeicoes[2].getNome(), new Document("Alimentos", Arrays.asList(refeicoes[2].getAlimento())).append("Quantidade", Arrays.asList(refeicoes[2].getQuantidade())).append("Horario", refeicoes[2].getHorario()).append("Observacoes", refeicoes[2].getObservacoes()))
                            .append(refeicoes[3].getNome(), new Document("Alimentos", Arrays.asList(refeicoes[3].getAlimento())).append("Quantidade", Arrays.asList(refeicoes[3].getQuantidade())).append("Horario", refeicoes[3].getHorario()).append("Observacoes", refeicoes[3].getObservacoes()))
                            .append(refeicoes[4].getNome(), new Document("Alimentos", Arrays.asList(refeicoes[4].getAlimento())).append("Quantidade", Arrays.asList(refeicoes[4].getQuantidade())).append("Horario", refeicoes[4].getHorario()).append("Observacoes", refeicoes[4].getObservacoes()))
                            .append(refeicoes[5].getNome(), new Document("Alimentos", Arrays.asList(refeicoes[5].getAlimento())).append("Quantidade", Arrays.asList(refeicoes[5].getQuantidade())).append("Horario", refeicoes[5].getHorario()).append("Observacoes", refeicoes[5].getObservacoes()))
        );
        */
        Document doc = new Document();
        for (Refeicao r : refeicoes) {
            doc.append(r.getNome(), new Document(
                    "Alimentos", Arrays.asList(r.getAlimento())).append("Quantidade", Arrays.asList(r.getQuantidade())).append("Horario", r.getHorario()).append("Observacoes", r.getObservacoes()));
            
        }
        this.dieta.insertOne(doc);
        
    }
    
    public void mostrarTodos() {
        MongoCursor cursor = this.dieta.find().iterator();
        
        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next().toString());
            }
        } finally {
            cursor.close();
        }
    }
    
    public void buscarPorId(String id) {
        Document doc;
        doc = this.dieta.find(eq("_id", new ObjectId(id))).first();
        System.out.println(doc);
    }
    
    public void alterarPorId(String id, Dieta d) {
        ArrayList<Refeicao> refeicoes = d.getRefeicoes();
        Document doc = new Document();
        for (Refeicao r : refeicoes) {
            //doc.append(new Document(r.getNome(), new Document("Alimentos", Arrays.asList(r.getAlimento())).append("Quantidade", Arrays.asList(r.getQuantidade()))).append("Horario", r.getHorario()).append("Observacoes", r.getObservacoes()));
            doc.append(r.getNome(), new Document(
                    "Alimentos", Arrays.asList(r.getAlimento())).append("Quantidade", Arrays.asList(r.getQuantidade()))).append("Horario", r.getHorario()).append("Observacoes", r.getObservacoes());
            
        }
        doc = new Document("$set", doc);
        this.dieta.updateOne(eq("_id", new ObjectId(id)), doc);         
    }
    
    public void deletar(String id) {
        this.dieta.deleteOne(eq("_id", new ObjectId(id)));
    }
}
