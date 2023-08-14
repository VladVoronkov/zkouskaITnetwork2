
package cz.itnetwork.evidence_pojistenych;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Vlad Voronkov
 */
public class Zaznam {

private LinkedList<Databaze> zaznamy = new LinkedList<>();
/**
* Zaznamy
*/

private Scanner sc = new Scanner(System.in);
/**
 * Text zaznamu
 */   

  
  public void Program() {
/**
  * Vyber v menu
*/
      String prikaz = "";

      while (!prikaz.equals("5")) {
          VytiskniMenu();
          
          prikaz = sc.nextLine();

          switch (prikaz) {
              case "1":
                  PridatPojisteneho();
                  break;

              case "2":
                  UkazVsechnyPojistence();
                  Pokracovani();
  
                  break;
                  
              case "3":
                  VyhledatPojisteneho();
                  break;

              case "4":
                   if (zaznamy.size() != 0) {
                      SmazPojistence();
                  } else {
                      System.out.println("\n Neexistuje pojistenec \n");
                  }
                  break;

                case "5":
                  System.out.println();
                  break;
          }
      }

  }
 
  void VytiskniMenu() {
/**
 * Vypsání textu menu
*/
      System.out.println("--------------------------------");
      System.out.println("      Evidence pojistenych     ");
      System.out.println("--------------------------------");
      System.out.println();
      System.out.println("Vyberte si akce:");
      System.out.println("1 - Pridat noveho pojisteneho");
      System.out.println("2 -  Vypsat vsehny pojistene");
      System.out.println("3 -  Vyhledat pojisteneho");
      System.out.println("4 - Smazat pojistence");
      System.out.println("5 - Konec");
     
  }
    
  void PridatPojisteneho() {
/**
* Prida zaznam pojisteneho do LinkedListu
*/      
      System.out.println("------------------------------------------");
      System.out.println("Zadejte jmeno pojisteneho: ");
      System.out.println();

      String text = sc.nextLine();
      
      System.out.println("------------------------------------------");
      System.out.println("Zadejte prijmeni:");
      System.out.println();
      
      String prijmeni = sc.nextLine();
      
      System.out.println("------------------------------------------");
      System.out.println("Zadejte telefonni cislo:");
      System.out.println();
      
      int telCislo = sc.nextInt();
      
      System.out.println("------------------------------------------");
      System.out.println("Zadejte vek:");
      System.out.println();
      
      int vek = sc.nextInt();
      System.out.println("------------------------------------------");
      System.out.println();

      Databaze pojistenec = new Databaze(text, prijmeni, telCislo, vek);
      zaznamy.add(pojistenec);
      
      System.out.println("Data byla ulozena. Pokracujte libovolnou klavesou....");
      String pokracovani = sc.nextLine();
  }
      
  
  void UkazVsechnyPojistence() {
/**
* Vrátí vsehny záznamy z pomoci podminky 
*/
      System.out.println("------------------------------------------");
      System.out.println();
      for (int i = 0; i < zaznamy.size(); i++) {
          System.out.println(zaznamy.get(i).getJmeno() + "  " + zaznamy.get(i).getPrijmeni()+ "   " + zaznamy.get(i).getVek() + "      " + zaznamy.get(i).getTelCislo() + "\n");    
      }
  }
  
  void VyhledatPojisteneho() {
/**
 * Vyhleda pojisteneho dle jmena a prijmeni
*/
      System.out.println("------------------------------------------");
      System.out.println("Zadejte jmeno pojisteneho: ");
      System.out.println();
      
      String jmeno = sc.nextLine();
      
      System.out.println("------------------------------------------");
      System.out.println("Zadejte prijmeni:");
      System.out.println();
      
      String prijmeni = sc.nextLine();
      System.out.println("------------------------------------------");
      System.out.println();
      
      int i = 0;
      String vysledek;
      
      if (jmeno != null && prijmeni != null) {
           for(Databaze result : zaznamy) {
                  if((zaznamy.get(i).getJmeno().equals(jmeno)) && (zaznamy.get(i).getPrijmeni().equals(prijmeni))) { // porovna dve hodnoty uzivatele s hodnotami v Linkedlist
                      vysledek = zaznamy.get(i).getJmeno() + "  " + zaznamy.get(i).getPrijmeni()+ "   " + zaznamy.get(i).getVek() + "      " + zaznamy.get(i).getTelCislo();
                      
                      System.out.println(vysledek);
                       Pokracovani();
                       
                  } else {
                  result = zaznamy.get(i++ );
        }   
      }
    }
      if (i == zaznamy.size()) {
      System.out.println("\n Neexistuje pojistenec \n");
      }
  }
  
   void SmazPojistence() {
/* Bonusova metoda, vymazani zaznamu pojisteneho
 * s pomoci cisla(indexu) radku.
*/
      UkazVsechnyPojistence();
      System.out.println("------------------------------------------");

       boolean nalezen = false;
      // boolean k zadání správného vstupu, 
       while (!nalezen) {
          try {
              System.out.println("Jaký záznam si přejete vymazat?");
              System.out.println("- pro vymazání záznamu zadejte index záznamu, například => 1");
              System.out.print("Záznam k vymazání: ");
              
              int a = Integer.parseInt(sc.nextLine());      
              int id = a - 1;
              
              zaznamy.remove(id); // Vymazání záznamu
              nalezen = true; 
              
              System.out.println("------------------------------------------");
              System.out.println("Pojistenec vymazan");
              UkazVsechnyPojistence();
              Pokracovani();

          } catch (Exception e) {
              System.out.println(
                      "Zadaná hodnota neodpovídá indexu žádného ze záznámů.");
          }
      }
  }
  void Pokracovani() {
            
                      System.out.println("------------------------------------------");
                      System.out.println();
                      System.out.println("Pokracujte libovolnou klavesou....");
                      String pokracovani = sc.nextLine();
  }
}

  