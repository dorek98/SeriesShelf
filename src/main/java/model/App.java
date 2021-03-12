package model;

public class App {

    public static void main(String[] args) {
        ActorRepository repo = new ActorRepository();
        repo.createNewActor("John", "Wick", 30);
        Actor actor = repo.findById(1);
        System.out.println(actor.getActor_id());
        repo.updateAge(actor, 35);
        repo.delete(actor);
    }


}


