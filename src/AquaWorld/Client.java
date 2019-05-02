package AquaWorld;

public class Client {
    
    public static void main(String[] args) {
        System.out.println("Test");
        //AquaWorldRoom aqua = AquaWorldRoom.getInstance();
//        AquaWorldRoom newAqua = AquaWorldRoom.getInstance();
//        aqua.addRestrictions("You must wear bathing suits to the pool");
//        System.out.println(newAqua.getRestrictions());  
        
        //Testing PartyRoomFactory class
        PartyRoomFactory roomFactory = new PartyRoomFactory(); 
        roomFactory.aquaFactory(); 
        roomFactory.aquaFactory();
        mediumPartyRoom medRoom1 = roomFactory.mediumFactory();
        mediumPartyRoom medRoom2 = roomFactory.mediumFactory();
        medRoom1.setDescription("First object");
       // medRoom2.setDescription("Second object");
        System.out.println(medRoom1.getDescription());
        System.out.println(medRoom2.getDescription());
        
        
        
    }
}
