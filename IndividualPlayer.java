public class IndividualPlayer extends Player implements Rankable
{
   private int wins;
   private int losses;
   private Record record;
   
   public IndividualPlayer(String playerName, boolean playerStatus, int wins, int losses)
   {
      this.playerName = playerName;
      this.playerStatus = playerStatus;
      this.wins = wins;
      this.losses = losses;
      record = new Record(wins, losses);
   }
   
   public IndividualPlayer(String playerName)
   {
      this(playerName, false, 0, 0);
   }
   
   public IndividualPlayer()
   {
      this("", false, 0, 0);
   }
  
   public void setWins(int wins)
   {
      this.wins = wins;   
   }
   
   public int getWins()
   {
      return wins;
   }
   
   public void setLosses(int losses)
   {
      this.losses = losses;
   }
   
   public int getLosses()
   {
      return losses;
   }
   
   public void won()
   {
      wins++; 
   }
   
   public void loss()
   {
      losses++;  
   }
   
   public Record getRecord()
   {
      return record;
   }
   
   public String toString()
   {
      Record r = new Record(wins, losses);
      return "Name: " + playerName + ", Availability: " + playerStatus + ", Record: " + r;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof IndividualPlayer)
      {
         IndividualPlayer p = (IndividualPlayer) other;
         return (playerName.equals(p.playerName) && playerStatus == p.playerStatus && wins == p.wins && losses == p.losses);  
      }
      return false;
   }
   
   public int isBetterThan(Rankable other)
   {  
      Record r = other.getRecord();
      return record.isBetterThan(r);
   }
}