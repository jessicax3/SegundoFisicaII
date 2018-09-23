/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author Jess
 */
public class NextPageController implements Initializable {

    @FXML
    private Button btnSalir,btnIngresar,btnBorrar;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private TextField txd, txr,txl,txv;
    @FXML
    private double diametro,longitud;
    @FXML
    private double radio,voltaje,resist,corriente,energiaDis,resultado,area; 
    @FXML
    private final double pr = (1.70)*(Math.pow(10.0,-8)) ; 
    @FXML
    private double res1,res2,res3,res4,res5;
    @FXML
    private String aux1,aux2,aux3,aux4;
    @FXML
    private final double pi = 3.14159;
    @FXML
    private Label lblResult1, lblResult2, lblResult3, lblResult4,lblLo ,lblA;
    @FXML
    private DecimalFormat decFor = new DecimalFormat (". #####");
    @FXML
    private ImageView imgView;


    public String getAux1() {
        return aux1;
    }

    public void setAux1(String aux1) {
        this.aux1 = aux1;
    }

    public String getAux2() {
        return aux2;
    }

    public void setAux2(String aux2) {
        this.aux2 = aux2;
    }

    public String getAux3() {
        return aux3;
    }

    public void setAux3(String aux3) {
        this.aux3 = aux3;
    }

    public String getAux4() {
        return aux4;
    }

    public void setAux4(String aux4) {
        this.aux4 = aux4;
    }

    public double getRes1() {
        return res1;
    }

    public void setRes1(double res1) {
        this.res1 = res1;
    }

    public double getRes2() {
        return res2;
    }

    public void setRes2(double res2) {
        this.res2 = res2;
    }

    public double getRes3() {
        return res3;
    }

    public void setRes3(double res3) {
        this.res3 = res3;
    }

    public double getRes4() {
        return res4;
    }

    public void setRes4(double res4) {
        this.res4 = res4;
    }

    public double getRes5() {
        return res5;
    }

    public void setRes5(double res5) {
        this.res5 = res5;
    }


    ObservableList<String> metales = FXCollections.observableArrayList("Cobre");

    //"Acero","Aluminio","Cobre","Estaño","Hierro","Grafito","Niquel","Oro","Plata","Tungsteno"

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        obtenerValores();
        imgView.setVisible(false);
    }

    @FXML
    private void btnSalirAction(ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/prueba/Problem.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void btnAccionProcesarDatos(ActionEvent event) {
        decFor = new DecimalFormat ("##.####");
        if(validateFields()==false){
            if(validateFieldOne(txd) && validateFieldOne(txl) && 
                    validateFieldOne(txr) && validateFieldOne(txv) != false){
                            String valor1 = txd.getText(); diametro = Double.parseDouble(valor1); 
                            String valor2 = txr.getText(); radio = Double.parseDouble(valor2);
                            String valor3 = txl.getText(); longitud = Double.parseDouble(valor3);
                            String valor4 = txv.getText(); voltaje = Double.parseDouble(valor4);
                            double res1 = areaTotal(pi, radio);
                            lblResult1.setText(String.valueOf(resistencia(pr, longitud, area)));
                            lblResult2.setText(String.valueOf(decFor.format(corriente(voltaje, resist))));
                            lblResult3.setText(String.valueOf(decFor.format(energiaDisipada(resist, corriente))));
                            lblResult4.setText(String.valueOf(decFor.format(consumidaEnHora(energiaDis))));
                            lblLo.setText(String.valueOf(decFor.format(longitud))+"m");
                            lblA.setText(String.valueOf(area)+"mm");
                            imgView.setVisible(true);
                            
            }}
    }


    @FXML
    private void btnAccionEliminarValores(ActionEvent event) {
        txd.setText("");
        txr.setText("");
        txl.setText("");
        txv.setText("");
        lblResult1.setText("");
        lblResult2.setText("");
        lblResult3.setText("");
        lblResult4.setText("");
        lblLo.setText("");
        lblA.setText("");
        imgView.setVisible(false);
        
    }
    
    private boolean validateFields(){
        //tfdiam, tfLong, tfRad, tfVol
        if(txd.getText().isEmpty() | txl.getText().isEmpty() | txr.getText().isEmpty() | txv.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Valida el campo de texto");
            alert.setHeaderText(null);
            alert.setContentText("Rellena el campo de texto");
            alert.showAndWait();
        }
        return false;
    }
    private boolean validateFieldOne(TextField tipo){
        Pattern p = Pattern.compile("[0-9.]+");
        Matcher m = p.matcher(tipo.getText());
        if(m.find() && m.group().equals(tipo.getText())){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Valida el campo de números");
            alert.setHeaderText(null);
            alert.setContentText("Rellena el campo de números");
            alert.showAndWait();
        }
        return false;
    }
    public void obtenerValores(){
        choiceBox.setValue("Cobre");
        choiceBox.setItems(metales);
    }
    private double areaTotal(double pi, double radio){
        area = (pi)*(Math.pow(radio, 2.0));
        System.out.println("ÁREA TOTAL: "+area);
        return area;
    }
    private double resistencia(double pr, double longitud, double area){
        pr = (1.71)*(Math.pow(10.0, -8));
        resist = (pr)*(longitud/area);
        System.out.println("Resistencia: "+resist);
        return resist;
    }
    private double corriente(double voltaje, double resist){
        corriente = (voltaje/resist);
        System.out.println("Corriente: "+corriente);
        return corriente;
    }
    private double energiaDisipada(double resist, double corriente){
        double disipada = (resist*corriente);
        energiaDis = Math.pow(disipada, 2.0);
        System.out.println("Energía disipada: "+energiaDis);
        return energiaDis;
    }
    private double consumidaEnHora(double energiaDis){
        resultado = (energiaDis/(3600*60));
        System.out.println("Consumida en una hora: "+resultado);
        return resultado;
    }

    private void accionBtnNextPag(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/prueba/resultados.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
}
