public class RecordWithTiesAndElo extends RecordWithTies
{
   private int elo;
   
   public RecordWithTiesAndElo(int wins, int losses, int ties, int elo)
   {
      this.wins = wins;
      this.losses = losses;
      this.ties = ties;
      this.elo = elo;
   }
   
   public RecordWithTiesAndElo()
   {
      this(0,0,0,0);
   }
   
   public int getElo()
   {
      return elo;
   }
   
   public void setElo(int elo)
   {
      this.elo = elo;
   }
   
   public String toString()
   {
      String record = wins + " wins, " + losses + " losses, " + ties + " ties, " + elo + " Elo rating";
      return record;
   }
   
   public int isBetterThan(RecordWithTiesAndElo otherRecord)
   {
      int winner = 0;
      
      if (this.getElo() > otherRecord.getElo())
      {
         winner = 1;
      }
      
      else if (this.getElo() < otherRecord.getElo())
      {
         winner =  -1;
      }
      else
      {
         winner = 0;
      }
      
      return winner;
   }
   
   public static void updateElo(RecordWithTiesAndElo r1, RecordWithTiesAndElo r2, double outcome)
   {
      double change = EloChangeCalculator.getRatingChange(r1.elo, r2.elo, outcome);
      r1.elo += change;
      r2.elo += change;
   }
}