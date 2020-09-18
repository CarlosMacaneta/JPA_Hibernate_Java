
import model.Estudante;
import controller.EstudanteDao;

public class Main {

    public static void main(String[] args) {
        Estudante est = new Estudante();
        EstudanteDao ed = new EstudanteDao();

        est.setNome("Carlos Macaneta");
        est.setMorada("Laulane");

        ed.create(est);
    }
}
