package Conexao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public abstract class ConexaoMongo {

    public static MongoDatabase getConexao() {
        MongoClient conexao = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase banco = conexao.getDatabase("bodybuilder");
        return banco;
    }
}
