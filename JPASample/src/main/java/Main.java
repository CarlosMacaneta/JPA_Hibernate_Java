
import model.Estudante;
import controller.EstudanteDao;

public class Main {

    public static void main(String[] args) {
        Estudante est = new Estudante();//nova instancia de estuadante
        EstudanteDao ed = new EstudanteDao();//intancia dao

        est.setNome("Carlos Macaneta");
        est.setMorada("Laulane");

        //salvando dados do estudante no banco de dado
        ed.create(est);
    }
}
