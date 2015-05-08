public class TeamPlayer extends Player
{
   private String position;
      
   public TeamPlayer()
   {
   }
   
   public TeamPlayer(String name, boolean status, String position)
   {
      super(name, status);
      setPosition(position);
   }
   
   public TeamPlayer(String name, String position)
   {
      this(name, false, position);
   }
   
   public void setPosition(String position)
   {
      this.position = position;
   }
   
   public String getPosition()
   {
      return position;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Player)
      {
         TeamPlayer p = (TeamPlayer) other;
         return (playerName.equals(p.playerName) && playerStatus == p.playerStatus && position.equals(p.position));  
      }
      return false;
   }
   
   public String toString()
   {
      String playerInfo = ("Name: " + playerName + ", Availability: " + playerStatus + ", Position: " + position);
      return playerInfo;
   }
}