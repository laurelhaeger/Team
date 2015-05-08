public class Record implements Rankable 
{
   protected int wins;
   protected int losses;
   
   public Record(int wins, int losses)
   {
      this.wins = wins;
      this.losses = losses;
   }
   
   public Record()
   {
      this(0, 0);
   }
   
   public int getWins()
   {
      return wins;
   }
   
   public void setWins(int wins)
   {
      this.wins = wins;
   }
   
   public int getLosses()
   {
      return losses;
   }
   
   public void setLosses(int losses)
   {
      this.losses = losses;
   }
   
   public void won()
   {
      wins++;
   }
   
   public void lost()
   {
      losses++;
   }
   
   public double getPercent()
   {
      int totalGames = wins + losses;
      double percentWins = (100 * (1.0 * wins)/(1.0 * totalGames));
      return percentWins;
   }
   
   public String toString()
   {
      String record = wins + " wins, " + losses + " losses";
      return record;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Record)
      {
         Record r = (Record) other;
         return (wins == r.wins && losses == r.losses); 
      }
      return false;   
   }
   
   public int isBetterThan(Rankable other)
   {
      Record r = other.getRecord();
      int winner = 0;
      
      if (this.getPercent() > r.getPercent())
      {
         winner = 1;
      }
      
      else if (this.getPercent() < r.getPercent())
      {
         winner =  -1;
      }
      else
      {
         winner = 0;
      }
      
      return winner;
   }
   
   public Record getRecord()
   {
      return this;
   }
}