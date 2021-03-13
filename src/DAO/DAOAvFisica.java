package DAO;

import Conexao.ConexaoMongo;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

import Entidades.Aluno.AvaliacaoFisica;

import java.util.ArrayList;

public class DAOAvFisica extends ConexaoMongo {
    MongoDatabase banco;
    MongoCollection avFisica;
    
    public DAOAvFisica() {
        this.banco = ConexaoMongo.getConexao();
        this.avFisica = banco.getCollection("avFisica");
    }
    
    public void insertAnamnese(AvaliacaoFisica ficha) {
        Document doc;
        
        int[] p = ficha.getPregasCutaneas();
        int[] c = ficha.getCircunferencias();
        float[] d = ficha.getDiametroOsseo();
        
        ArrayList<Integer> pregasCutaneas = new ArrayList<>();
        ArrayList<Integer> circunferencias = new ArrayList<>();
        ArrayList<Float> diametroOsseo = new ArrayList<>(); 
        
        for(int i : p) pregasCutaneas.add(i);
        for(int i : c) circunferencias.add(i);
        for(float i : d) diametroOsseo.add(i);
        
        doc = new Document(
                "Altura", ficha.getAltura()).append
                ("Peso", ficha.getPeso())
                .append("Medidas", new Document (
                    "PregasCutaneas", pregasCutaneas).append
                    ("Circunferencia", circunferencias).append
                    ("DiametroOsseo", diametroOsseo));
        this.avFisica.insertOne(doc);
    }
    
    public void buscarTodos() {
        MongoCursor cursor = this.avFisica.find().iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next().toString());
        }
        cursor.close();
    }
    
    public void buscarPorId(String id) {
        Document doc;
        doc = (Document) this.avFisica.find(eq("_id", new ObjectId(id))).first();
        System.out.println(doc);
    }
    
    public void alterarPorId(String id, AvaliacaoFisica ficha) {
        Document doc;
        
        int[] p = ficha.getPregasCutaneas();
        int[] c = ficha.getCircunferencias();
        float[] d = ficha.getDiametroOsseo();
        
        ArrayList<Integer> pregasCutaneas = new ArrayList<>();
        ArrayList<Integer> circunferencias = new ArrayList<>();
        ArrayList<Float> diametroOsseo = new ArrayList<>(); 
        
        for(int i : p) pregasCutaneas.add(i);
        for(int i : c) circunferencias.add(i);
        for(float i : d) diametroOsseo.add(i);
        
        doc = new Document("$set", 
                new Document(
                "Altura", ficha.getAltura()).append
                ("Peso", ficha.getPeso())
                .append("Medidas", new Document (
                    "PregasCutaneas", pregasCutaneas).append
                    ("Circunferencia", circunferencias).append
                    ("DiametroOsseo", diametroOsseo)));
        this.avFisica.updateOne(eq("_id", new ObjectId(id)), doc);
    }
    
    public void deletar(String id) {
        this.avFisica.deleteOne(eq("_id", new ObjectId(id)));
    }
    
}
