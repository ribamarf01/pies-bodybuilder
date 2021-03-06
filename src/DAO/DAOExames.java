package DAO;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

import Conexao.ConexaoMongo;

import Entidades.Aluno.Exames;

public class DAOExames extends ConexaoMongo {
    
    MongoDatabase con;
    MongoCollection<Document> exames;
    
    public DAOExames() {
        con = ConexaoMongo.getConexao();
        this.exames = con.getCollection("exames");
    }
    
    public void inserirExame(Exames e) {
        this.exames.insertOne( new Document("arquivos", e.getArquivos()) );
    }
    
    public void mostrarTodos() {
        MongoCursor cursor = this.exames.find().iterator();
        while(cursor.hasNext()) {
            System.out.println(cursor.next().toString());
        }
        cursor.close();
    }
    
    public void alterarPorId(String id, Exames e) {
        this.exames.updateOne(eq("_id", new ObjectId(id)), new Document("$set", new Document( "arquivos", e.getArquivos())));
    }
    
    public void excluirExames(String id) {
        this.exames.deleteOne(eq("_id", new ObjectId(id)));
    }
    
}
