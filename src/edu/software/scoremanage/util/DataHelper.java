package edu.software.scoremanage.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import edu.software.scoremanage.model.Curriculum;
import edu.software.scoremanage.model.User;

public class DataHelper implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static DataHelper shelper;
	
	private User user;
	private Curriculum curriculum;
	
	private DataHelper(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AllData.txt"));
			DataHelper recovery = (DataHelper)ois.readObject();
			ois.close();
			User.recover(recovery.user);
			Curriculum.recover(recovery.curriculum);
			this.user = User.getInstance();
			this.curriculum = Curriculum.getInstance();
		} catch(FileNotFoundException e){
			User.initialize();
			Curriculum.initialize();
			this.user = User.getInstance();
			this.curriculum = Curriculum.getInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return;
	}
	
	public static void setUp(){
		shelper = new DataHelper();
	}
	
	public static void saveData(){
		try{
			FileOutputStream fos = new FileOutputStream("AllData.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(shelper);
			oos.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
