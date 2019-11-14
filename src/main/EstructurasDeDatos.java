/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import data.Dia;
import data.Usuario;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ui.Consola;

/**
 *
 * @author LENOVO
 */
public class EstructurasDeDatos extends Application {
    public static Stage primaryStage;
    public static Scene registro, new_account;
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            Parent root;
            System.out.println("Bien 0");
            root = FXMLLoader.load(getClass().getResource("/GUI/Registro.fxml"));
            registro = new Scene(root);
            System.out.println("Bien 0");
            root = FXMLLoader.load(getClass().getResource("/GUI/New_Account.fxml"));
            new_account = new Scene(root);
            primaryStage = stage;
            System.out.println("Bien 1");
            //Tamaño stage
            //primaryStage.setMaxHeight(530);
            //primaryStage.setMinHeight(530);

            //primaryStage.setMaxWidth(800);
            //primaryStage.setMinWidth(800);
            
            //Titulo primaryStage 
            //primaryStage.setTitle("Teatro");
            //primaryStage.getIcons().add(new Image("/images/compra.png"));
            stage.setScene(registro);
            System.out.println("Bien 2");
            changeScene(1);
            System.out.println("Bien 3");
            primaryStage.show();
        }catch(Exception e){
            System.err.println("ERROR AQUI: "+e.getLocalizedMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Dia> dias= new ArrayList<>();
    
    private static TreeMap<String,Usuario> usuarios = new TreeMap<>();
    
    public static void main(String[] args) {
        launch(args);
        Consola consola = new Consola();
    	//boolean activo=true;
    	
    	//while(activo) {
    	System.out.println("Cuantos ejecuciones?: ");
        Scanner teclado=new Scanner(System.in);
    	int numEjeciones=teclado.nextInt();
    	for(int j=0;j<numEjeciones;j++) {
    	System.out.println("Cuantos casos de prueba?: ");
        
        int numReservas=teclado.nextInt();
        //long millisTotal=0;
        
	        LocalTime inicio = LocalTime.now();
	        long iniciomi=System.currentTimeMillis();
	        
	        for(int i = 0;i<numReservas;i++) {
	        	if(dias.isEmpty()) {
	    			addDia();
	    			addDia();
	    			addDia();
	    		}
	    		Usuario comprador = consola.login();
	    		
	    		boolean activoMenu=true;
	    		while(activoMenu)
	    			activoMenu=consola.menu(comprador);
	    	}
	        
	        long finmi=System.currentTimeMillis();
	        LocalTime fin = LocalTime.now();
	        //System.out.println("Inicio: " + inicio.toString());
	        //System.out.println("Fin: " + fin.toString());
	        System.out.println("Tiempo Transcurrido = "+ (finmi-iniciomi) + " millis");
	        System.out.println("Numero de casos de prueba: "+ numReservas);
	        //System.out.println("Numero de RESERVAS :"+ usuarios.get("").getReservas().size());
	        System.out.println("Usuarios registrados: "+usuarios.size()+"\n");
	        
	        //millisTotal+=finmi-iniciomi;//
	        usuarios.clear();
	        dias.clear();
        }
        //System.out.println("Tiempo Total: "+ millisTotal);
        
    }
    
    public static void changeScene(int i){
            switch(i){
                case 1:
                    primaryStage.setScene(registro);
                    break;
                case 2:
                    primaryStage.setScene(new_account);
                    break;
                default:
                        break;
            }
    
    }
    

    public static void addDia() {
		dias.add(new Dia());
	}
    
    public static ArrayList<Dia> getDias() {
		return dias;
	}

    public static TreeMap<String,Usuario> getUsuarios() {
		return usuarios;
	}
    public static boolean usuarioRegistrado(String cedula){
        return usuarios.containsKey(cedula);
    }

    }
    

