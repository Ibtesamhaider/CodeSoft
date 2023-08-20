package number_guessing_game;

import javax.swing.*;

import java.io.*;
import java.util.*;

class PersonInfo{
	String name;
	String address;
	String phoneNumber;
	
	//parameterized constructor
	PersonInfo(String n,String a,String p){
		name=n;
		address=a;
		phoneNumber=p;
	}
	//display on GUI
	void display() {
		JOptionPane.showMessageDialog(null, "Name: "+name+"\nAddress: "+address+"\nphone no: "+phoneNumber);
	}
}
class AddressBook{
	ArrayList persons;
	//constructor
	AddressBook(){
		persons=new ArrayList();
		loadPersons();
	}
	//adding a persons object
	void addPerson() {
		String name=JOptionPane.showInputDialog("Enter name:");
		String add=JOptionPane.showInputDialog("Enter address:");
		String pNum=JOptionPane.showInputDialog("Enter phoneNo:");
		//creating object for personInfo
		PersonInfo p=new PersonInfo(name, add, pNum);
		persons.add(p);
	}
	
	//searching a person
	void searchPerson(String n) {
		for(int i=0; i<persons.size();i++) {
			PersonInfo p=(PersonInfo) persons.get(i);
			if(n.equals(p.name)) {
				p.display();
			}
		}
	}
	//deleting a person
	void deletePerson(String n) {
		for(int i=0; i<persons.size();i++) {
			PersonInfo p=(PersonInfo) persons.get(i);
			if(n.equals(p.name)) {
				persons.remove(i);
			}
		}
	}
	//saving record
		void savePersons() {
			try {
				PersonInfo p;
				String Line;
				FileWriter fw=new FileWriter("person.txt");
				PrintWriter pw = new PrintWriter(fw);
				for(int i=0; i<persons.size();i++) {
				    p=(PersonInfo) persons.get(i);
					Line=p.name+","+p.address+","+p.phoneNumber;
					//write line to person.txt
					pw.println(Line);
				}
				pw.flush();
				pw.close();
				fw.close();
			}catch(IOException ioEx) {
				System.out.println(ioEx);
			}
		}
		//loading person record from .txt file
		void loadPersons() {
			String token[]=null;
			String name, add, ph;
			try {
				FileReader fr=new FileReader("person.txt");
				BufferedReader br =new BufferedReader(fr);
				String line=br.readLine();
				while(line!=null) {
					token=line.split(",");
					name=token[0];
					add=token[1];
					ph=token[2];
					PersonInfo p=new PersonInfo(name, add, ph);
					persons.add(p);
					line=br.readLine();
				}
				br.close();
				fr.close();
			}catch(IOException ioEx) {
				System.out.println(ioEx);
			}
			
		}
	
}
public class Address_Book_System {

	public static void main(String[] args) {
		AddressBook ab = new AddressBook();
		String input, st;
		int ch;
		
		while(true) {
			input=JOptionPane.showInputDialog("Enter 1 to add\nEnter 2 to search\nEnter 3 to delete\nEnter 4 to exit");
			ch=Integer.parseInt(input);
			
			switch(ch) {
				case 1:
					ab.addPerson();
					break;
				case 2:
					st=JOptionPane.showInputDialog("Enter name to search:");
					ab.searchPerson(st);
					break;
				case 3:
					st=JOptionPane.showInputDialog("Enter name to delete:");
					ab.deletePerson(st);
					break;
				case 4:
					ab.savePersons();
					System.exit(0);
			}
		}
	}
}
