
import controller.EstudanteDao;
import javax.swing.JOptionPane;
import model.Estudante;

public class Main {

    public static void main(String[] args) {
        
        boolean online = true;
        
        while(online){
            
            String menu = JOptionPane.showInputDialog("[1] Registar estudante\n"
                +"[2] Listar estudante\n"
                +"[3] Editar estudante\n"
                +"[4] Remover estudante\n"
                +"[5] Sair");
            
            switch(menu){
                case "1":                   
                    Estudante est = new Estudante();
                    EstudanteDao ed = new EstudanteDao();

                    String nome = JOptionPane.showInputDialog("Nome completo");

                    if(!nome.isEmpty() || !nome.isBlank()){
                        est.setNome(nome);

                        String morada = JOptionPane.showInputDialog("Morada");

                        if(!morada.isEmpty() || !morada.isBlank()){
                            est.setMorada(morada);  
                            ed.create(est);
                            JOptionPane.showMessageDialog(null, "Estudante registado com sucesso.");
                        }else{
                            JOptionPane.showMessageDialog(null, "Este campo deve ser preenchido.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Este campo deve ser preenchido.");
                    }
                    break;
                case "2":    
                    if(!new EstudanteDao().list().isEmpty()){  
                        JOptionPane.showMessageDialog(null, new EstudanteDao().list()+"\n");
                    }else{
                        JOptionPane.showMessageDialog(null, "Registe um estudante.");
                    }
                    break;
                case "3":
                    Estudante est_;
                    EstudanteDao ed_ = new EstudanteDao();
                    
                    long id = Long.parseLong(JOptionPane.showInputDialog("Id do estudante"));
                    
                    if(id > 0){                        
                        if(ed_.findEstudante(id) != null){
                            est_ = ed_.findEstudante(id);

                            String nome_ = JOptionPane.showInputDialog("Nome completo");

                            if(!nome_.isEmpty() || !nome_.isBlank()){
                                est_.setNome(nome_);

                                String morada_ = JOptionPane.showInputDialog("Morada");

                                if(!morada_.isEmpty() || !morada_.isBlank()){
                                    est_.setMorada(morada_);  
                                    ed_.edit(est_);
                                    JOptionPane.showMessageDialog(null, "Estudante alterado com sucesso.");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Este campo deve ser preenchido.");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Este campo deve ser preenchido.");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Estudante não encontrado.");
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "O id introduzido é inválido.");
                    } 
                    break;
                case "4":
                    if(!new EstudanteDao().list().isEmpty()){  
                        new EstudanteDao().delete(Long.parseLong(JOptionPane.showInputDialog("Id do estudante")));
                        JOptionPane.showMessageDialog(null, "Estudante removido.");
                    }else{
                        JOptionPane.showMessageDialog(null, "Registe um estudante.");
                    }
                    break;
                case "5":
                    online = false; 
                    break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida.\nSelecione uma opção válida.");
            }
        }
    }
}
