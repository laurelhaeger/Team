public abstract class TeamOld extends TeamPlayer implements Rankable 
{
   private int MAX_ROSTER_SIZE;
   private int MIN_PLAYER_NUM;
   private Record teamRecord;
   protected Player[] roster;
   private int numPlayers;
   
   public TeamOld(int MAX_ROSTER_SIZE, int MIN_PLAYER_NUM)
   {
      if(MAX_ROSTER_SIZE < 0 || MIN_PLAYER_NUM < 0)
      {
         throw new IllegalArgumentException();
      }
      this.MAX_ROSTER_SIZE = MAX_ROSTER_SIZE;
      this.MIN_PLAYER_NUM = MIN_PLAYER_NUM;
      this.roster = new Player[MAX_ROSTER_SIZE];
      this.teamRecord = teamRecord;
   }
   
   public String toString()
   {
      String teamList = "";
      for(int times = 0; times < numPlayers; times++)
      {
         teamList += roster[times] + "\n";   
      }
      return teamList;
   }
   
   public void addPlayer(Player p)
   {
      if (numPlayers == MAX_ROSTER_SIZE)
      { 
          throw new IllegalArgumentException();
          
      }
      else
      {
         roster[numPlayers] = p;
         numPlayers++;
      }
   }
   
   public boolean removePlayer(String name)
   {
      if(numPlayers == 0)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         for (int times = 0; times <= numPlayers; times++)
         {
            if(roster[times].getName().equals(name))
            {
               roster[times] = null;
               numPlayers--;
               return true;
            }
         }
         return false;
      }
   }
   
   public Player findPlayer(String name)
   {
      for (int times = 0; times <= numPlayers+1; times++)
      {
         if(roster[times] != null)
         {
            if(roster[times].getName().equals(name))
            {
               return roster[times];
            }
         } 
      }
      return null;
   }
   
   public int getRosterSize()
   {
      return numPlayers;
   }
   
   public Player[] getRoster()
   {
      return roster;
   }
   
   public void updatePlayerStatus(String name, boolean newStatus)
   {
      Player p = findPlayer(name);
      p.setStatus(newStatus);
   }
   
   public boolean canFieldATeam()
   {
      if(numPlayers <= MIN_PLAYER_NUM)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   public Record getRecord()
   {
      return teamRecord;
   }
   
   public void setRecord(Record r)
   {
      this.teamRecord = r;
   }
   
   public int isBetterThan(Rankable other)
   {
      Record r = other.getRecord();
      return teamRecord.isBetterThan(r);
   }
   public abstract boolean shouldFieldATeam();
}