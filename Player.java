import java.util.*;

public class Player implements Comparable<Player>
{
   protected String playerName;
   protected boolean playerStatus;
   
   public Player(String playerName, boolean playerStatus)
   {
      this.playerName = playerName;
      this.playerStatus = playerStatus;
   }
   
   public Player(String playerName)
   {
      this(playerName, false);
   }
   
   public Player()
   {
      this("", false);
   }
   
   public void setName(String playerName)
   {
      this.playerName = playerName;
   }
   
   public String getName()
   {
      return playerName;
   }
   
   public void setStatus(boolean playerStatus)
   {
      this.playerStatus = playerStatus;  
   }
   
   public boolean getStatus()
   {
      return playerStatus;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Player)
      {
         Player p = (Player) other;
         return (playerName.equals(p.playerName) && playerStatus == p.playerStatus);  
      }
      return false;
   }
   
   public String toString()
   {
      String playerInfo = ("Name: " + playerName + ", Availability: " + playerStatus);
      return playerInfo;
   }
   
   public int compareTo(Player other)
   {
      String otherName = other.getName();
      int otherLength = otherName.length();
      int nameLength = playerName.length();
      if(nameLength == otherLength)
      {
         return 0;
      }
      else if(nameLength > otherLength)
      {
         return 1;
      }
      else
      {
         return -1;
      }
   }
}