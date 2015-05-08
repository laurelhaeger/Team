public class RecordWithTies extends Record
{
   protected int ties;
   
   public RecordWithTies(int wins, int losses, int ties)
   {
      this.wins = wins;
      this.losses = losses;
      this.ties = ties;
   }
   
   public RecordWithTies()
   {
      this(0,0,0);
   }
   
   public int getTies()
   {  
      return ties;
   } 
   
   public void setTies(int ties)
   {
      this.ties = ties;
   } 
   
   public void tied()
   {
      ties++;
   }
   
   public String toString()
   {
      String record = wins + " wins, " + losses + " losses, " + ties + " ties";
      return record;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof RecordWithTies)
      {
         RecordWithTies r = (RecordWithTies) other;
         return (wins == r.wins && losses == r.losses && ties == r.ties); 
      }
      return false;   
   }

}