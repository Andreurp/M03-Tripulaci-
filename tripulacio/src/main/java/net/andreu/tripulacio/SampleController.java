package net.andreu.tripulacio;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;

public class SampleController implements Initializable{
	@FXML
	private ComboBox<String> cbVaixells;
	@FXML
	private Label lblCapita;
	@FXML
	private ListView<String> lvMariners;
	@FXML
	private ListView<String> lvCaps;
	@FXML
	private Button btnImporta;
	@FXML
	private Button btngenera;
	@FXML
	private CheckBox cbxNavegar;
	
	private String[] noms = { "Yuonne Juckett", "Wanetta Crabill", "Alix Sorrell", "Krysta Fan", "Etsuko Mcveigh",
			"Noemi Burch", "Travis Turrentine", "Penelope Caison", "Irmgard Waggener", "Nam Dustin", "Cher Minelli",
			"Alexandra Kile", "Carrol Kalina", "Caitlin Vann", "Jerrold Harding", "Coreen Ikner", "Fatima Deel",
			"Fredrick Wheelwright", "Allegra Grundy", "Bok Lancon", "Ashlee Fortunato", "Gillian Morningstar",
			"Tina Primo", "Isidra Remley", "Thora Bordner", "Chia Householder", "Margarito Zeitz", "Basilia Mccrary",
			"Delora Ivey", "Clorinda Chatman", "Cassondra Dicus", "Annamarie Boothby", "Sherita Mcintire",
			"Darron Simmerman", "Melony Basler", "Kirby Crockett", "Lakeisha Marth", "Siu Gullick", "Lynelle Sherrick",
			"Lorine Thrasher", "Enda Sykes", "Bertie Klosterman", "Alishia Corder", "Jonathan Iannotti",
			"Reta Rodrique", "Jules Debord", "Gustavo Shultz", "Kerri Seagle", "Robert Pfeiffer", "Karma Berquist",
			"Jeanett Cerrato", "Franklin Currie", "Jayson Hazan", "Deloris Jeske", "Cristi Zeck", "Allen Dollins",
			"Senaida Ashley", "Regan Stansell", "Carmine Drinkard", "Lynwood Ohm", "Sharice Decelles", "Naida Morley",
			"Hermelinda Clinard", "Bettie Ma", "Pearle Marcucci", "Brady Ribeiro", "Elsy Doyon", "Cathey Tyrrell",
			"Faviola Hayashi", "Onie Walmsley", "Stephany Mendelsohn", "Christel Crume", "Sheron Candy",
			"Alane Funston", "Brynn Schultz", "Benedict Carman", "Adelaide Simo", "Meghan Swedberg", "Kathline Foulk",
			"Jannet Sheffler", "Helena Vaughns", "Tammie Zimmermann", "Karon Lizotte", "Versie Chilton", "Moira Julien",
			"Quinton Norred", "Jama Cuomo", "Garnett Edmiston", "Clementine Croft", "Burl Zajac", "Avelina Weibel",
			"Lizeth Hanson", "Lorina Lapoint", "Deann Ingles", "Olive Swinson", "Dia Downie", "Neal Screen",
			"Horace Wolff", "Elliot Sailor", "Tyson Steere", "Alexander Deas", "Toshia Hurlbut", "Clarissa Tames",
			"Cinda Heiman", "Salvador Hughs", "Coralie Villalva", "Dominique Baldwin", "Edgardo Resch",
			"Venetta Hunsberger", "Laurice Payne", "Stacey Newhouse", "Amos Ellery", "Debi Eckman", "Milan Bonney",
			"Carole Ashford", "Mazie Parkhill", "Emerson Clausing", "Jamal Riddles", "Aurelia Stehlik", "Shantel Relf",
			"Josephine Barber", "Shay Simek", "Cheryl Fullenwider", "Carmina Kott", "Adam Lira", "Jacqui Bernardi",
			"Jenni Sprague", "Theodora Sobotka", "Sari Prudhomme", "Valeria Heffernan", "Ardith Morra", "Shawn Honda",
			"Gaynelle Sapien", "Andrea Hartt", "Kimberli Melgoza", "Leonore Soukup", "Mertie Gisi", "Marlon Boots",
			"Meta Seabolt", "Alline Colombo", "Rosana Coan", "Bud Reys", "Lavinia Merchant", "Sherron Ellenberger",
			"Lourdes Yerger", "Johanna Sergio", "Adrienne Millener", "Dorinda Weekes", "Napoleon Messier",
			"Cheyenne Wake", "In Tricarico", "Michelle Branch", "Marleen Palm", "Ciara Ransom", "Candie Baptista",
			"Lana Mcwilliams", "Cortez Krohn", "Alaine Fishback", "Winona Weisinger", "Verdie Danks", "Carline Plemons",
			"Susan Barker", "Merissa Castello", "Markita Lambeth", "Berta Avera", "Harold Camargo", "Deadra Mitten",
			"Jeniffer Feder", "Brittny Baldree", "Kyong Alverson", "Dominic Hunt", "Magdalene Madero",
			"Fredericka Maglio", "Stephnie Amick", "Blake Stanford", "Denice Thoreson", "Shemika Kinyon",
			"Callie Geise", "Danyell Mccree", "Kaye Haran", "Natosha Bellanger", "Toccara Vizcarra", "Annelle Banh",
			"Suellen Krider", "Eleanora Hardiman", "Gaye Bustillos", "Apolonia Daugherty", "Jadwiga Rance",
			"Phil Avila", "Joyce Depew", "Eugena Leamon", "Milan Garvey", "Chantel Burwell", "Keith Penner",
			"Sommer Hendershott", "Antony Mallen", "Violeta Mcbee", "Margarette Mercure", "Simonne Wolfe",
			"Minerva Mower", "Mora Bark", "Fleta Calandra", "Nidia Shouse", "Dudley Luczak", "Georgeann Mudd",
			"Lissa Colangelo", "Samual Mitchell", "Elise Pearcy", "Latarsha Martinek", "Kirk Brennen", "Janett Dell",
			"Sabra Roder", "Charlsie Caudle", "Vilma Hagens", "Monroe Lassiter", "Cortez Brice", "Jeremy Malia",
			"Arianne Lingo", "Pierre Doe", "Kiana Nolette", "Lorette Dunkelberger", "Pei Clagon", "Jerlene Winget",
			"Landon Nelms", "Lorna Kimmer", "Murray Munez", "Lincoln Despres", "Lance Beaston", "Joan Halpin",
			"Yvette Lackey", "Daysi Pastor", "Zane Defrancisco", "Winona Gries", "Leroy Trevizo", "Ciera Milstead",
			"Zaida Lockridge", "Nida Mckinley", "Zandra Ring", "Maire Rivett", "Olen Rentfro", "Joy Pennypacker",
			"Taneka Mertes", "Hillary Petrillo", "Fletcher Jines", "Fran Romaine", "Kathern Fuss", "Marketta Trudell",
			"Shellie Stanton", "Gretchen Mullett", "Donte Sabb", "Laila Mom", "Flora Snell", "Louanne States",
			"Michelina Naff", "Dennis Bullion", "Jaclyn Towner", "Vertie Linch", "Caitlin Herdt", "Evelyne Burtt",
			"Dakota Specht", "Charissa Satterlee", "Leta Landy", "Mindy Joyal", "Slyvia Chacon", "Micah Chillemi",
			"Yolando Tunnell", "Roseline Lohse", "Alden Vannatter", "Tyra Siu", "Anissa Tavera", "Lita Statler",
			"Jene Mahi", "Laurette Delnero", "Wonda Ingenito", "Mildred Salamone", "Archie Mclester", "Geraldine Falbo",
			"Caleb Enright", "Gaynell Gatewood", "Leonore Vale", "Emmaline Adkinson", "Santa Pelc", "Myrna Damm",
			"Pamelia Ishida", "Martha Commodore", "Diedra Dople", "Veronika Harwell", "Blair Bagg", "Luetta Milnes",
			"Erasmo Railsback", "Laticia Besaw", "Benton Kopf", "Tiffanie Casiano", "Josette Saldana", "Marcos Bayless",
			"Kraig Woolford", "Klara Degraff", "Olympia Marston", "Efrain Wolfe", "Kyra Digiovanni", "Pablo Reiff",
			"Carlton Garabedian", "Harris Kindred", "Mandie Haffey", "Kathaleen Bowley", "Paula Keltner", "Shin Sheard",
			"Parthenia Oler", "Dorethea Narvaez", "Moises Pass", "Gerardo Bourque", "Latrice Fultz", "Cami Carol",
			"Giuseppina Tigue", "Santina Craft", "Majorie Headen", "Criselda Michelsen", "Tod Orme", "Alycia Wilds",
			"January Georges", "Magdalene Gregson", "Lovetta Barahona", "Classie Limbaugh", "Tomiko Heikkinen",
			"Merna Cousineau", "Azzie Lintz", "Maria Vang", "Lauryn Towery", "Rachele Rieck", "Amos Seppala",
			"Jenice Devenport", "Tayna Jimison", "Florence Caspers", "Dawne Chaney", "Keeley Flaugher", "Aurora Reulet",
			"Felicidad Malave", "Minta Hazelip", "Kathyrn Levine", "Magdalena Giannone", "Evette Nakagawa",
			"Adaline Warren", "Don Tomczak", "Audie Jarnagin", "Louisa Littles", "Sofia Rost", "Aleta Harrison",
			"Gwyneth Walmsley", "Kelsie Mumm", "Inger Puckett" };
	private String[] vaixells = { "Buccaneer's Dishonor", "Davy Jones' Foul Compass", "Dragon's Mystery",
			"Hades' Pride", "Neptune's Dishonor", "Neptune's Knave", "Neptune's Wandering Lie",
			"Night's Hell-born Gold", "Plunderer's Storm", "The Foul Murderer", "The Horrible Knave",
			"The Horrid Buccaneer", "The Anger of the Sargasso Sea", "The Death of Atlantis", "The Death of the West",
			"The Decietful Raider of the North", "The Disgraceful Barnacle", "The Evil Greed", "The Evil Sword",
			"The Fear of Tortuga", "The Gold Cutlass", "The Horrible Star", "The Mad Privateer of the Sea",
			"The Madness of the West", "The Rage of the Captain", "Calypso's Knave", "Davy Jones' Plague",
			"Dragon's Wandering Cutlass", "Hades' Compass", "Killer's Poison Night", "Posideon's Saber",
			"Satan's Treasure", "The Damned Serpent", "The Morbid Eel", "The Awful Barnacle",
			"The Damnation of the Eel", "The Deciet of the East", "The Dishonor of the Corsair", "The Doom of Hades",
			"The Dreaming Captain of Hell", "The Fall of the Manta", "The Fear of the Caribbean",
			"The Foul Trident of the South", "The Gold Fear", "The Greed of Hell", "The Horrible Hate",
			"The Horror of the Corsair", "The Insanity of the Captain", "The Poison Blade",
			"The Shameful Night of Hell", "Hades' Whore", "Murderer's Howl", "Neptune's Madness",
			"Night's Shameful Storm", "Ocean's Mermaid", "Plunderer's Cry", "Satan's Killer", "Satan's Plunder",
			"Satan's Trident", "The Fearful Manta", "The Vicious Corsair", "The Bloody Servant", "The Cursed Shame",
			"The Deciet of the Executioner", "The Decietful Hangman", "The Dirty Star of the Ocean",
			"The Dreaming Murderer", "The Evil Servant", "The Evil Strumpet", "The Greed of the South",
			"The Greed of the Wolf", "The Horrible Dream", "The Insanity of the Demon",
			"The Poison Gold of the Seven Seas", "The Wandering Coral of Hell", "Devil's Death", "Murderer's Horror",
			"Night's Plunder", "Ocean's Barnacle", "Plunderer's Mermaid", "Privateer's Skull",
			"Satan's Black Nightmare", "Sea's Vile Cutlass", "The Greedy Wolf", "The Scurvy Demon",
			"The Anger of the Privateer", "The Black Fear", "The Cruel Whore", "The Cursed Trident of the Sea",
			"The Death of the Buccaneer", "The Deciet of Hell", "The Dirty Curse of Atlantis", "The Fearful Mermaid",
			"The Foul Servant of the Sargasso Sea", "The Foul Shame", "The Greedy Mermaid",
			"The Horror of the Sargasso Sea", "The Morbid Death", "The Screaming Wolf of the Seven Seas",
			"The Wandering Dagger", "Dragon's Wandering Saber", "Pirate's Cursed Jewel", "Plunderer's Whore",
			"Privateer's Doom", "Privateer's Thunder", "Sea's Coral Doubloon", "Sea's Plague", "The Disgraceful Raider",
			"The Howling Raider", "The Angry Barnacle of the Seven Seas", "The Coral Skull",
			"The Damnation of the Demon", "The Damned Saber of the North", "The Disgrace of the Murderer",
			"The Disgraceful Executioner of Atlantis", "The Fearful Fear", "The Fearful Gold", "The Hellish Sadness",
			"The Horrible Servant of Atlantis", "The Horrid Barnacle", "The Mad Executioner", "The Poison Jewel",
			"The Red Plunder of Hell", "The Sad Killer", "The Shameful Doom", "Buccaneer's Plunder",
			"Captain's Plunder", "Devil's Plunder", "Dragon's Slave", "Hades' Death", "Hades' Deciet", "Hades' Hoard",
			"Killer's Disgrace", "Plunderer's Nightmare", "Sea's Killer", "The Hateful Knave", "The Black Cutlass",
			"The Coral Plague", "The Cry of the Demon", "The Cry of the South", "The Cursed Treasure",
			"The Damned Raider", "The Deciet of the Eel", "The Doom of the South", "The Fallen Hangman",
			"The Gold Howl", "The Greed of the Manta", "The Hate of Hades", "The Madness of the Wolf",
			"The Vile Cutlass" };
	private String[] rang = {"capita","mariner","cap de colla"};
	private Random r = new Random();
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tripulacio");
	private EntityManager e = emf.createEntityManager();
	private List<Vaixell> llistaVaixells=new ArrayList<Vaixell>();
	
	int posicio=0;
	int tripulants=0;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		for(int i=0; i<100;i++){
			//crear vaixell
			posicio=r.nextInt(vaixells.length);
			Vaixell v = new Vaixell(vaixells[posicio]);
			llistaVaixells.add(v);
		}
		for(int i=0; i<llistaVaixells.size(); i++){
			cbVaixells.getItems().addAll(llistaVaixells.get(i).getNom());
		}
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void generar(MouseEvent event) {
		lblCapita.setText(" ");
		lvMariners.getItems().clear();
		lvCaps.getItems().clear();
		cbxNavegar.setSelected(false);
		
		// Crear vaixell
		Vaixell vaixellSeleccionat = new Vaixell(cbVaixells.getValue());
		// Crear un ArrayList de tripulants
		ArrayList<Tripulant> personal = new ArrayList<>();
		tripulants=r.nextInt(8)+3;
		boolean hihaCapita=false;
		for(int i=0; i<tripulants; i++){
			
			Tripulant t = new Tripulant();
			t.setNom(noms[r.nextInt(noms.length)]);
			do{
				t.setRang(rang[r.nextInt(rang.length)]);
			}while(hihaCapita==true && t.getRang().equals("capita"));
			
			if(t.getRang().equals("capita")){
				hihaCapita=true;
				lblCapita.setText(t.getNom());
			}else if(t.getRang().equals("mariner")){
				lvMariners.getItems().add(t.getNom());
			}else if(t.getRang().equals("cap de colla")){
				lvCaps.getItems().add(t.getNom());
			}
			personal.add(t);
		}
		vaixellSeleccionat.setTripulants(personal);
		// persist
		e.getTransaction().begin();
		e.persist(vaixellSeleccionat);
		e.getTransaction().commit();
		
		if(hihaCapita && lvMariners.getItems().size()>=1 && lvCaps.getItems().size()>=1){
			cbxNavegar.setSelected(true);
		}

	}
	
	// Event Listener on Button[#btnImporta].onMouseClicked
	@FXML
	public void importa(MouseEvent event) {
		// TODO Autogenerated
	}
}