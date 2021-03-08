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

import Entidades.Aluno.FichaAnamnese;
import Entidades.Utils.OpcoesAnamnese;

public class DAOAnamnese {
    
    MongoDatabase con;
    MongoCollection<Document> anamnese;
    
    public DAOAnamnese() {
        this.con = ConexaoMongo.getConexao();
        this.anamnese = con.getCollection("anamnese");
    }
    
    public void inserirAnamnese(FichaAnamnese f) {
        ArrayList<OpcoesAnamnese> opcoes = f.getOpcoes();
        Document doc = new Document();
        for(OpcoesAnamnese opcao : opcoes) {
            doc.append(opcao.getOpcao(), new Document("opcao", opcao.isOpMarcada()).append("descricao", opcao.getDescricao()));
        }
        this.anamnese.insertOne(doc);
    }
    
    public void buscarTodos() {
        MongoCursor cursor = this.anamnese.find().iterator();
        while(cursor.hasNext()) {
            System.out.println(cursor.next().toString());
        }
        cursor.close();
    }
    
    public void buscarPorId(String id, FichaAnamnese f) {
        Document doc = (Document) this.anamnese.find(eq("_id", new ObjectId(id))).first();
        System.out.println(doc);
    }
    
    public void alterarPorId(String id, FichaAnamnese f) {
        ArrayList<OpcoesAnamnese> opcoes = f.getOpcoes();
        Document doc = new Document();
        for(OpcoesAnamnese opcao : opcoes) {
            doc.append(opcao.getOpcao(), new Document("opcao", opcao.isOpMarcada()).append("descricao", opcao.getDescricao()));
        }
        doc = new Document("$set", doc);
        this.anamnese.updateOne(eq("_id", new ObjectId(id)), doc);
    }
    
    public void deletar(String id) {
        this.anamnese.deleteOne(eq("_id", new ObjectId(id)));
    }
    
    public void teste(String id) {
        Document doc = (Document) this.anamnese.find("")
    }
    
}
