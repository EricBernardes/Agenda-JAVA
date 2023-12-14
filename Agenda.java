/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



import java.util.ArrayList;

/**
 *
 * @author bruno.v.oliveira
 */
public class Agenda {
    
    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }
    
    public boolean add(Contato c){
        return contatos.add(c);
    }
    
    public Contato buscar(String nome){
        Contato result = null;
        for (Contato c : contatos){
            if (c.getNome().equalsIgnoreCase(nome)){
                result = c;
                break;
            }
        }
        return result;
    }
    
    public boolean excluirContato(String nome)
    {
        Contato remover = buscar(nome);
        if(remover != null){
            return contatos.remove(remover);
        }
        return false;
    }
    
    
    public String getListaContatosComoString(){
        if (contatos.isEmpty()){
            return null;
        }
        String listagem = "";
        for (Contato c : contatos){
            listagem += " Nome: " + c.getNome() + " Telefone: " + c.getTelefone() + '\n';
        }
        return listagem;
    }
    
    
}
