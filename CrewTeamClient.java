import java.util.*;
import java.io.*;

public class CrewTeamClient
{
   public static void main(String[] args) throws FileNotFoundException
   {
      CrewTeam ct = new CrewTeam(27, 5);
      File f = new File("Roster.txt");
      Scanner fileScan = new Scanner(f);
      while (fileScan.hasNextLine())
      {
         String name = fileScan.nextLine();
         boolean status = fileScan.nextBoolean();
         String position = fileScan.nextLine();
         TeamPlayer p = new TeamPlayer(name, status, position);
         ct.addPlayer(p);
         System.out.println(p);
      }   
   }
}