import java.util.HashMap;
import java.util.Set;
public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("SuicideboyS", "Kean Dysso");
        trackList.put("Dead Beats", "Mori Calliope");
        trackList.put("Bad Boys", "Juice Wrld");
        trackList.put("Franchise", "Travis Scott");

        String name = trackList.get("Dead Beats");
        System.out.println(name);

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println("Track: " + key + " Artist: " + trackList.get(key));
            // System.out.println(trackList.get(key));
        }
    }
}