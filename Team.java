import java.util.*;

public abstract class Team extends TeamPlayer implements Rankable 
{
   private int MAX_ROSTER_SIZE;
   private int MIN_PLAYER_NUM;
   private Record teamRecord;
   private String teamName;
   protected List<Player> roster;
   
   public Team(int MAX_ROSTER_SIZE, int MIN_PLAYER_NUM)
   {
      if(MAX_ROSTER_SIZE < 0 || MIN_PLAYER_NUM < 0)
      {
         throw new IllegalArgumentException();
      }
      this.MAX_ROSTER_SIZE = MAX_ROSTER_SIZE;
      this.MIN_PLAYER_NUM = MIN_PLAYER_NUM;
      this.roster = new LinkedList<Player>();
      this.teamRecord = teamRecord;
      this.teamName = teamName;
   }
   
   //public coi
   public String toString()
   {
      String teamList = roster.toString();
      return teamList;
   }
   
   public void addPlayer(Player p)
   {
      roster.add(p);
   }
   
   public boolean removePlayer(String name)
   {
      if(this.findPlayer(name) != null)
      {
         roster.remove(this.findPlayer(name));
         return true;
      }
      return false;
   }
   
   public Player findPlayer(String name)
   {
      for (int times = 0; times < roster.size(); times++)
      {
         if(roster.get(times).getName().equals(name))
         {
            return roster.get(times);
         }
      }
      return null;
   }
   
   public int getRosterSize()
   {
      return roster.size();
   }
   
   public List<Player> getRoster()
   {
      return roster;
   }
   
   public void sort()
   {
      Player p = new Player();
      for (int ii = 0; ii < roster.size(); ii++)
      {
         for (int jj = 0; jj < roster.size(); jj++)  
         {
            p = roster.get(ii);
            Player op = roster.get(jj);
            if(p.getName().compareTo(op.getName()) == -1)
            {
               roster.remove(op);
               roster.remove(p);
               roster.add(ii, op);
               roster.add(jj, p);
            }
         } 
      }
   }
   
   public void updatePlayerStatus(String name, boolean newStatus)
   {
      Player p = this.findPlayer(name);
      p.setStatus(newStatus);
   }
   
   public boolean canFieldATeam()
   {
      if(roster.size() <= MIN_PLAYER_NUM)
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