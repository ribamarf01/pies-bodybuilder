package DAO;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;

import Entidades.Personal.Treino;
import Entidades.Utils.ClasseDeTreino;

import Conexao.ConexaoMongo;
import com.mongodb.client.MongoCursor;

public class DAOTreino extends ConexaoMongo{
    
    MongoDatabase banco;
    MongoCollection treino;
    
    public DAOTreino() {
        this.banco = ConexaoMongo.getConexao();
        this.treino = banco.getCollection("treino");
    }
    
    public void inserirTreino(Treino t) {
        Document doc = new Document();
        ArrayList<ClasseDeTreino> treinos = t.getTreino();
        for(ClasseDeTreino treino : treinos) {
            doc.append(String.valueOf(treino.getClasse()), new Document("Exercicios", Arrays.asList(treino.getExercicio())).append("Series", Arrays.asList(treino.getSeries())).append("Repeticoes", Arrays.asList(treino.getRepeticoes())).append("Metodologia", treino.getMetodologia()).append("Observacoes", treino.getObservacoes()));
        }
        
        this.treino.insertOne(doc);
        
    }
    
    public void buscarTodos() {
        MongoCursor cursor = this.treino.find().iterator();
        
        while(cursor.hasNext()) {
            System.out.println(cursor.next().toString());
        }
        
        cursor.close();
    }
    
    public void buscarPorId(String id) {
        Document doc = (Document) this.treino.find(eq("_id", new ObjectId(id))).first();
        System.out.println(doc);
    }
    
    public void alterarPorId(String id, Treino t) {
        Document doc = new Document();
        ArrayList<ClasseDeTreino> treinos = t.getTreino();
        for(ClasseDeTreino treino : treinos) {
            doc.append(String.valueOf(treino.getClasse()), new Document("Exercicios", Arrays.asList(treino.getExercicio())).append("Series", Arrays.asList(treino.getSeries())).append("Repeticoes", Arrays.asList(treino.getRepeticoes())).append("Metodologia", treino.getMetodologia()).append("Observacoes", treino.getObservacoes()));
        }
        
        doc = new Document("$set", doc);
        
        this.treino.updateOne(eq("_id", new ObjectId(id)), doc);
    }
    
    public void deletarPorId(String id) {
        this.treino.deleteOne(eq("_id", new ObjectId(id)));
    }
    
}
