public class CrewTeam extends Team
{
   private int maxSize;
   private int minRequired;
   private TeamPlayer[] rosterTP = new TeamPlayer[maxSize];
   
   public CrewTeam(int maxSize, int minRequired)
   {
      super(maxSize, minRequired);
   }
   
   public void updatePosition(String name, String newPosition)
   {
      Player p = super.findPlayer(name);
      TeamPlayer tp = (TeamPlayer) p;
      tp.setPosition(newPosition);   
   }
   
   public boolean shouldFieldATeam()
   {
      int cox = 0;
      int star = 0;
      int port = 0;
      int numPlayers = super.getRosterSize();
      for (int times = 0; times < numPlayers; times++)
      {
         if(rosterTP[times] != null)
         {
            if(rosterTP[times].getPosition().equals("Cox"))
            {
               cox++;
            }
            else if(rosterTP[times].getPosition().equals("Port"))
            {
               port++;
            }
            else if(rosterTP[times].getPosition().equals("Starboard"))
            {
               star++;
            }
         }
      }
      if(star >= 2 && port >= 2 && cox >= 1)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}