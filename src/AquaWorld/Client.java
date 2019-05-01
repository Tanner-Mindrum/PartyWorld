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
        
        
        
    }
}
