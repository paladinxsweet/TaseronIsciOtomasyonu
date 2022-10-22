package application;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabaniUtil;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SampleController {

//VERÝTABANI BAÐLANTISI VE TANIMLAMALARI-------------------------------------------------------------------------------------------------------------------------------------------------------------- 1
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	public SampleController() {	//veritabný baðlantýsý
		baglanti=VeritabaniUtil.Baglan();
	}

//TANIMLAMALAR-------------------------------------------------------------------------------------------------------------------------------------------------------------- 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField alanAD;

    @FXML
    private TextField alanADRES;

    @FXML
    private TextField alanBULUNDUGUPROJE;

    @FXML
    private TextField alanCALISMASURESI;

    @FXML
    private TextField alanFIRMA;

    @FXML
    private TextField alanMEVKI;

    @FXML
    private TextField alanSIGORTA;

    @FXML
    private TextField alanSOYAD;

    @FXML
    private DatePicker alanTARIH;

    @FXML
    private TextField alanTELEFON;

    @FXML
    private TextField alanUCRET;
    
    @FXML
    private TextField alanARA;
    
//TABLO TANIMLAMALARI-------------------------------------------------------------------------------------------------------------------------------------------------------------- 
    @FXML
    private TableColumn<Kisi, String> sutunAD;
    
    @FXML
    private TableColumn<Kisi, String> sutunADRES;

    @FXML
    private TableColumn<Kisi, String> sutunFIRMA;

    @FXML
    private TableColumn<Kisi, String> sutunMEVKI;
    
    @FXML
    private TableColumn<Kisi,String> sutunPROJE;

    @FXML
    private TableColumn<Kisi, Integer> sutunSAAT;

    @FXML
    private TableColumn<Kisi, String> sutunSIGORTA;

    @FXML
    private TableColumn<Kisi, String> sutunSOYAD;
    
    @FXML
    private TableColumn<Kisi, String> sutunTARIH;

    @FXML
    private TableColumn<Kisi, String> sutunTELEFON;

    @FXML
    private TableColumn<Kisi, Integer> sutunUCRET;

    @FXML
    private TableView<Kisi> tabloKISILER;
    
 //TABLO DOLDURMA--------------------------------------------------------------------------------------------------------------------------------------------------------------   
    public void TabloKisilerDoldur(TableView<Kisi> tabloKISILER) {
    	sql = "select * from kisi";
    	ObservableList<Kisi> kisiler = FXCollections.observableArrayList();
    	try
    	{
    		sorguIfadesi=baglanti.prepareStatement(sql);
        	getirilen = sorguIfadesi.executeQuery();
        	while(getirilen.next())
        	{
        		kisiler.add(new Kisi(getirilen.getString("ad").trim(), getirilen.getString("soyad").trim(), getirilen.getDate("tarih"), getirilen.getString("telefon").trim(), 
        				getirilen.getString("adres").trim(), getirilen.getString("firma").trim(), getirilen.getString("mevki").trim(), getirilen.getInt("ucret"), 
        				getirilen.getInt("calisma_suresi"), getirilen.getString("sigorta").trim(), getirilen.getString("bulundugu_proje").trim()));
        	}
        	sutunAD.setCellValueFactory(new PropertyValueFactory<>("ad"));
        	sutunADRES.setCellValueFactory(new PropertyValueFactory<>("adres"));
        	sutunPROJE.setCellValueFactory(new PropertyValueFactory<>("bulundugu_proje"));
        	sutunSAAT.setCellValueFactory(new PropertyValueFactory<>("calisma_suresi"));
        	sutunFIRMA.setCellValueFactory(new PropertyValueFactory<>("firma"));
        	sutunMEVKI.setCellValueFactory(new PropertyValueFactory<>("mevki"));
        	sutunSIGORTA.setCellValueFactory(new PropertyValueFactory<>("sigorta"));
        	sutunSOYAD.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        	sutunTARIH.setCellValueFactory(new PropertyValueFactory<>("tarih"));
        	sutunTELEFON.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        	sutunUCRET.setCellValueFactory(new PropertyValueFactory<>("ucret"));
        		
        	tabloKISILER.setItems(kisiler);
        	tabloKISILER.refresh();
    	}
    	catch (Exception e)
    	{
    		System.out.print(e.getMessage());
    	}
    	
    	FilteredList<Kisi> filtre = new FilteredList<>(kisiler, b -> true);

    	alanARA.textProperty().addListener((observable, oldValue, newValue) -> {
			filtre.setPredicate(employee -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getAd().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true;
				} 
				else  
				return false;
			});
		});
		
		SortedList<Kisi> sortedData = new SortedList<>(filtre);
		

		sortedData.comparatorProperty().bind(tabloKISILER.comparatorProperty());
		
		tabloKISILER.setItems(sortedData);
    }
    
//TABLO TIKLANMA--------------------------------------------------------------------------------------------------------------------------------------------------------------    
  	@FXML
  	void tabloCLICK(MouseEvent event) {	// tablodan seçme modellerinden index seçimini kullan
  		Kisi k = new Kisi();
  		k = (Kisi) tabloKISILER.getItems().get(tabloKISILER.getSelectionModel().getSelectedIndex());
  		alanAD.setText(k.getAd());
  		alanSOYAD.setText(k.getSoyad());
  		alanTARIH.setValue(k.getTarih().toLocalDate());
  		alanTELEFON.setText(k.getTelefon());
  		alanADRES.setText(k.getAdres());
  		alanFIRMA.setText(k.getFirma());
  		alanMEVKI.setText(k.getMevki());
  		alanUCRET.setText("" +k.getUcret());
  		alanCALISMASURESI.setText("" +k .getCalisma_suresi());
  		alanSIGORTA.setText(k.getSigorta());
  		alanBULUNDUGUPROJE.setText(k.getBulundugu_proje());
  	}    
  	
//EKLE--------------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button dugmeEKLE;
    public void dugmeEkleaksiyonu() throws SQLException {
    	
	    try {
	    	 	sql="insert into kisi (ad,soyad,tarih,telefon,adres,firma,mevki,ucret,calisma_suresi,sigorta,bulundugu_proje) values(?,?,?,?,?,?,?,?,?,?,?)";
	    	 
	    	 	sorguIfadesi=baglanti.prepareStatement(sql);
	    	 	sorguIfadesi.setString(1, alanAD.getText().trim());
	    	 	sorguIfadesi.setString(2, alanSOYAD.getText().trim());
	    	 	sorguIfadesi.setString(3, alanTARIH.getValue().toString().trim());
	    	 	sorguIfadesi.setString(4, alanTELEFON.getText().trim());
	            sorguIfadesi.setString(5, alanADRES.getText().trim());
	            sorguIfadesi.setString(6, alanFIRMA.getText().trim());
	            sorguIfadesi.setString(7, alanMEVKI.getText().trim() );
	            sorguIfadesi.setInt(8, Integer.parseInt(alanUCRET.getText()));
	            sorguIfadesi.setInt(9, Integer.parseInt(alanCALISMASURESI.getText()));
	            sorguIfadesi.setString(10, alanSIGORTA.getText().trim());
	            sorguIfadesi.setString(11, alanBULUNDUGUPROJE.getText().trim());
	            sorguIfadesi.executeUpdate();
	                	
	            TabloKisilerDoldur(tabloKISILER);
	            butonlariTEMÝZLE();
  	
    	}catch(NumberFormatException hata)
    {
    		Alert uyari=new Alert(AlertType.ERROR);
		
    		uyari.setTitle("HATA!!");
    		uyari.setHeaderText("ÜCRET VE ÇALIÞMA SÜRESÝ SAYI OLMALIDIR!!!");
    		uyari.setContentText(hata.toString());
    		uyari.showAndWait();		
    }
   
    }

//GÜNCCELLE--------------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button dugmeGUNCELLE;  
    public void dugmeGUNCELLEaksiyonu() throws SQLException {
    	
    	try {
	    		sql="update kisi set tarih=?, telefon=?, adres=?, firma=?, mevki=?, ucret=?, calisma_suresi=?, sigorta=?, bulundugu_proje=? where ad=? and soyad=?";
	    		
	       	 	sorguIfadesi=baglanti.prepareStatement(sql);
	       	 	sorguIfadesi.setString(10, alanAD.getText().trim());
	       	 	sorguIfadesi.setString(11, alanSOYAD.getText().trim());
	       	 	sorguIfadesi.setString(1, alanTARIH.getValue().toString().trim());
	       	 	sorguIfadesi.setString(2, alanTELEFON.getText().trim());   
	       	 	sorguIfadesi.setString(3, alanADRES.getText().trim());
	       	 	sorguIfadesi.setString(4, alanFIRMA.getText().trim());
	       	 	sorguIfadesi.setString(5, alanMEVKI.getText().trim() );
	       	 	sorguIfadesi.setInt(6, Integer.parseInt(alanUCRET.getText()));
	       	 	sorguIfadesi.setInt(7, Integer.parseInt(alanCALISMASURESI.getText()));
	       	 	sorguIfadesi.setString(8, alanSIGORTA.getText().trim());
	       	 	sorguIfadesi.setString(9, alanBULUNDUGUPROJE.getText().trim());       
                sorguIfadesi.executeUpdate();
                   
                TabloKisilerDoldur(tabloKISILER);
                butonlariTEMÝZLE();
       	}catch(NumberFormatException hata)
       {
       		Alert uyari=new Alert(AlertType.ERROR);
   		
       		uyari.setTitle("HATA!!");
       		uyari.setHeaderText("GÜNCELLEME YAPILAMADI BÝR DAHA KONTROL EDÝN!!!");
       		uyari.setContentText(hata.toString());
       		uyari.showAndWait();		
       }
    }
    
//SÝL--------------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button dugmeSIL;
    public void dugmeSILaksiyonu() throws SQLException {
        try {
        		sql="delete from kisi where ad=? and soyad=?";

       	 		sorguIfadesi=baglanti.prepareStatement(sql);
       	 		sorguIfadesi.setString(1, alanAD.getText().trim());
       	 		sorguIfadesi.setString(2, alanSOYAD.getText().trim());
                sorguIfadesi.executeUpdate();    
                
                TabloKisilerDoldur(tabloKISILER);
                butonlariTEMÝZLE();
       	}catch(NumberFormatException hata)
       {
       		Alert uyari=new Alert(AlertType.ERROR);
   		
       		uyari.setTitle("HATA!!");
       		uyari.setHeaderText("KAYIT SÝLÝNEMEDÝ!");
       		uyari.setContentText(hata.toString());
       		uyari.showAndWait();		
       }
        
    }
    
//BUTONLARI TEMÝZLE--------------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button dugmeYENI;    
    public void dugmeYENIaksiyonu() {
    	butonlariTEMÝZLE();
    }
 
//BUTONLARI TEMÝZLEME FONKSÝYONU--------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void butonlariTEMÝZLE() {    	
		alanAD.clear();
		alanSOYAD.clear();
		alanTARIH.setValue(LocalDate.of(2022, 01, 01));
		alanTELEFON.clear();
		alanADRES.clear();
		alanFIRMA.clear();
		alanMEVKI.clear();
		alanUCRET.clear();
		alanCALISMASURESI.clear();
		alanSIGORTA.clear();
		alanBULUNDUGUPROJE.clear();		
		alanARA.clear();
    }    
     
    @FXML
    void initialize() {
    	TabloKisilerDoldur(tabloKISILER);

    }
}
