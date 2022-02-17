/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaib_credit.controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import sdaib_credit.modelo.Usuario;

/**
 * @author User
 */
public class UsuarioControlador {
    private Gson gson;
    private String json;
    private final String filePath = "src/Persistencia/Usuarios.json";
    private Usuario[] usuarios;
    
    public UsuarioControlador() {
        gson = new Gson();
        json = "";
        try (BufferedReader bfReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bfReader.readLine()) != null) {
                json += line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        usuarios = gson.fromJson(json, Usuario[].class);
    }
    
    public Usuario getUsuario(String username){
        Usuario aux = null;
        for(Usuario user: usuarios){
            if(user.getUsername().equals(username)) aux = user;
        }
        return aux;
    }
    public Usuario getUsuario(Usuario usuario){
        Usuario aux = null;
        for(Usuario user: usuarios){
            if(user.getIdentificacion().equals(usuario.getIdentificacion())) aux = user;
        }
        return aux;
    }
    
    public boolean registrarUsuario(Usuario usuario) {
        int size = usuarios.length;
        //Usuario[] newList = new Usuario[size + 1];
        gson = new GsonBuilder().setPrettyPrinting().create();
        json = "[";
        for (int i = 0; i < size; i++) {
            json += "\n" + gson.toJson(usuarios[i]) + ",";
            //newList[i] = usuarios[i];
        }
        //newList[size] = usuario;
        //usuarios = newList;
        json += "\n" + gson.toJson(usuario) + "\n]";
        try (BufferedWriter bfWriter = new BufferedWriter(new FileWriter(filePath))) {
            bfWriter.write(json);
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
}
