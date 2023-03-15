package tech.leonam.listando.view.atividades;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import tech.leonam.listando.R;
import tech.leonam.listando.controller.AtravessadorListaEntidade;
import tech.leonam.listando.controller.CadastroController;

public class AdicionarTarefa extends AppCompatActivity {
    private AutoCompleteTextView titulo;
    private AutoCompleteTextView descricao;
    private RadioButton baixa;
    private RadioButton media;
    private RadioButton alta;
    private Button salvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        iniciarComponentes();
        clicks();
    }
    private void clicks() {

        salvar.setOnClickListener(e->{
            try {
               var titulo = this.titulo.getText().toString().trim();
               if (!titulo.isBlank()) {
                    var descricao = this.descricao.getText().toString();
                    String opc;

                    if(baixa.isChecked()){
                        opc = getString(R.string.prioridade_baixa);
                    }else if(media.isChecked()){
                        opc = getString(R.string.prioridade_media);
                    }else if(alta.isChecked()){
                        opc = getString(R.string.prioridade_alta);
                    }else{
                        opc = getString(R.string.sem_prioridade);
                    }

                    var entidade = new AtravessadorListaEntidade();//Encapsulamento
                    entidade.setTitulo(titulo);
                    entidade.setDescricao(descricao);
                    entidade.setPrioridade(opc);

                    new CadastroController(entidade,e.getContext());

                    Toast.makeText(e.getContext(), R.string.criado_com_sucesso, Toast.LENGTH_SHORT).show();
                    setResult(Activity.RESULT_OK);
                    finish();
               } else {
                    Toast.makeText(e.getContext(), getString(R.string.adicione_titulo), Toast.LENGTH_SHORT).show();
               }
            }catch (Exception ex){
                Toast.makeText(e.getContext(), R.string.tente_novamente, Toast.LENGTH_SHORT).show();
                ex.printStackTrace();
            }
        });
    }
    private void iniciarComponentes() {
        titulo = findViewById(R.id.titulo);
        descricao = findViewById(R.id.descricao);
        salvar = findViewById(R.id.salvar);
        baixa = findViewById(R.id.baixa);
        media = findViewById(R.id.media);
        alta = findViewById(R.id.alta);
    }
}