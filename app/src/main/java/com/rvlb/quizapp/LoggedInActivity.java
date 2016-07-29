package com.rvlb.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LoggedInActivity extends AppCompatActivity {

    private LinearLayout llPickTheme, llAnswerQuestion;
    private ArrayList<Question> questions;
    private int correctAnswers;

    private int qntQuestions;
    private static final int maxQuestions = 4;

    public int getQntQuestions() {
        return this.qntQuestions;
    }

    public int getCorrectAnswers() {
        return this.correctAnswers;
    }

    public void increaseCorrectAnswers() {
        this.correctAnswers++;
    }

    public void resetCorrectAnswers() {
        this.correctAnswers = 0;
    }

    private void loadQuestions() {

        this.questions = new ArrayList<>();

        //Questões de Matemática
        String options[] = {"","","","",""};
        options[0] = "5";
        options[1] = "6";
        options[2] = "3";
        options[3] = "4";
        options[4] = "MOO";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_1),
                "4 + 1 = ?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "24";
        options[1] = "3";
        options[2] = "4";
        options[3] = "5";
        options[4] = "6";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_1),
                "4! = ?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "2";
        options[1] = "0.5";
        options[2] = "1";
        options[3] = "4";
        options[4] = "8";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_1),
                "ln(e^2) = ?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "1";
        options[1] = "0.5";
        options[2] = "2";
        options[3] = "4";
        options[4] = "8";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_1),
                "(ln(e))^2 = ?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "1";
        options[1] = "0";
        options[2] = "3242458242846";
        options[3] = "35126";
        options[4] = "2713";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_1),
                "3242458242846^0",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        //Questões de Filmes
        options[0] = "Curtindo a Vida Adoidado";
        options[1] = "Os Goonies";
        options[2] = "Jumanji";
        options[3] = "Ghostbusters";
        options[4] = "A Lagoa Azul";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_2),
                "Qual o filme?",
                true, R.mipmap.img_ferris,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Star Wars: Episódio I - A Ameaça Fantasma";
        options[1] = "Star Wars: Episódio II - O Ataque dos Clones";
        options[2] = "Star Wars: Episódio III - A Vingança dos Sith";
        options[3] = "Star Wars: Episódio V - O Império Contra-Ataca";
        options[4] = "Star Wars: Episódio VII - O Despertar da Força";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_2),
                "Qual o filme?",
                true, R.mipmap.img_jarjar,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Porco-Aranha";
        options[1] = "Harry Porco";
        options[2] = "Bartman";
        options[3] = "Super Porco";
        options[4] = "Peppa Pig";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_2),
                "Qual super-herói surgiu nesta cena?",
                true, R.mipmap.img_spiderpig,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Harry Potter e as Relíquias da Morte Parte 2";
        options[1] = "Harry Potter e a Câmara Secreta";
        options[2] = "Harry Potter e a Pedra Filosofal";
        options[3] = "Harry Potter e a Ordem da Fênix";
        options[4] = "Harry Potter e o Cálice de Fogo";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_2),
                "Qual o filme?",
                true, R.mipmap.img_harry,
                new ArrayList<>(Arrays.asList(options))
        ));

        //Questões de Computação
        options[0] = "Classes.";
        options[1] = "Ponteiros.";
        options[2] = "Estruturas.";
        options[3] = "Inteiros.";
        options[4] = "Alocação Dinâmica.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_3),
                "A linguagem C não possui o seguinte elemento:",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Toda linguagem pode ser boa dependendo da aplicação.";
        options[1] = "C++.";
        options[2] = "Java.";
        options[3] = "Python.";
        options[4] = "Assembly.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_3),
                "Qual é a melhor linguagem?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "printf(\"Hello World\");";
        options[1] = "println(\"Hello World\");";
        options[2] = "printf(\"Hello World\")";
        options[3] = "print \"Hello World\"";
        options[4] = "cout << \"Hello World\";";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_3),
                "Em C, como fazemos para exibir a mensagem 'Hello World' na tela?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "MacOS.";
        options[1] = "CentOS.";
        options[2] = "Ubuntu.";
        options[3] = "iOS.";
        options[4] = "Windows 10.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_3),
                "Qual o sistema operacional dos computadores Apple?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        //Questões de Jogos
        options[0] = "...is a lie.";
        options[1] = "...is tasty.";
        options[2] = "...is beautiful.";
        options[3] = "...is a secret.";
        options[4] = "...is gone.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_4),
                "The cake...",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "...to everybody.";
        options[1] = "...that is dangerous to go alone.";
        options[2] = "...to me.";
        options[3] = "...to you.";
        options[4] = "...to Zoboomafoo.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_4),
                "It's a secret...",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Or are you a girl?";
        options[1] = "Red.";
        options[2] = "Leaf.";
        options[3] = "Gary was here. Ash is a loser.";
        options[4] = "Erm... what was his name now?.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_4),
                "Are you a boy?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "...smoke.";
        options[1] = "...you.";
        options[2] = "...me.";
        options[3] = "...himself.";
        options[4] = "...water.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_4),
                "Dodongo dislikes...",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "But our princess is in another castle!";
        options[1] = "Your quest is not over!";
        options[2] = "Smell you later!";
        options[3] = "Go home!.";
        options[4] = "I'm Daisy!";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_4),
                "Thank you Mario!",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        //Questões de Música
        options[0] = "Little Child";
        options[1] = "Twist and Shout.";
        options[2] = "Devil in Her Heart.";
        options[3] = "Till There Was You.";
        options[4] = "Please Mister Postman.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_5),
                "Qual destas músicas foi originalmente composta pela banda The Beatles?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "...don't make it bad...";
        options[1] = "...take a sad song and make it better...";
        options[2] = "...na na na na na na...";
        options[3] = "...remember to let her into your heart...";
        options[4] = "...don't carry the world upon your shoulders...";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_5),
                "Hey Jude...",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "...ninguém nunca foi igual...";
        options[1] = "...a minha vida é fazer, o bem vencer o mal...";
        options[2] = "...pelo mundo viajarei...";
        options[3] = "...pegá-los eu tentarei...";
        options[4] = "...temos que pegar, isso eu sei...";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_5),
                "Esse meu jeito de viver...",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Let It Be";
        options[1] = "Please Please Me";
        options[2] = "Yellow Submarine";
        options[3] = "Help!";
        options[4] = "A Hard Day's Night";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_5),
                "Qual o último álbum da banda The Beatles?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        //Questões de Assuntos Gerais
        options[0] = "...devem amar seus inimigos.";
        options[1] = "...devem comprar a licença do WinRar.";
        options[2] = "...devem ser legais.";
        options[3] = "...devem ser gentis.";
        options[4] = "...devem ser agradáveis.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_6),
                "As pessoas boas...",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "O gato.";
        options[1] = "E o Quico?";
        options[2] = "Também.";
        options[3] = "Mas precisa perguntar 'O gato ou Quico'?.";
        options[4] = "Ai, que burro, dá zero pra ele.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_6),
                "Complete a frase: 'O gato ou o Quico?'",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Todos.";
        options[1] = "O elefante.";
        options[2] = "O cachorro.";
        options[3] = "O gato.";
        options[4] = "O Quico.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_6),
                "Qual o animal que come com o rabo?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));

        options[0] = "Kel ama refrigerante de laranja.";
        options[1] = "É verdade?";
        options[2] = "Uhum.";
        options[3] = "Eu amo, eu amo, eu amo, eu amo.";
        options[4] = "Kenan.";
        this.questions.add(new Question(
                getResources().getString(R.string.theme_option_6),
                "Quem ama refrigerante de laranja?",
                false, -1,
                new ArrayList<>(Arrays.asList(options))
        ));
    }

    public void switchLayout(int idHide, int idShow) {
        LinearLayout hideLayout = (LinearLayout) findViewById(idHide);
        LinearLayout showLayout = (LinearLayout) findViewById(idShow);
        hideLayout.setVisibility(View.GONE);
        showLayout.setVisibility(View.VISIBLE);
    }

    public ArrayList<Question> getThemeQuestions(String theme) {
        ArrayList<Question> themeQuestions = new ArrayList<>();
        for(Question q : this.questions) {
            if(q.getTheme().equals(theme)) themeQuestions.add(q);
        }

        ArrayList<Question> selectedQuestions = new ArrayList<>();
        for(int i=0 ; i < maxQuestions && !themeQuestions.isEmpty() ; i++) {
            int rand = Math.abs(new Random().nextInt()) % themeQuestions.size();
            Log.d("rand", ""+rand);
            selectedQuestions.add(themeQuestions.get(rand));
            themeQuestions.remove(rand);
        }
        this.qntQuestions = selectedQuestions.size();
        return selectedQuestions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_checkbox);
        setContentView(R.layout.activity_logged_in);

        this.loadQuestions();
        this.correctAnswers = 0;

        this.llPickTheme = (LinearLayout) findViewById(R.id.llPickTheme);
        this.llAnswerQuestion = (LinearLayout) findViewById(R.id.llAnswerQuestion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.option_home:
                this.llPickTheme.setVisibility(View.VISIBLE);
                this.llAnswerQuestion.setVisibility(View.GONE);
                return true;
            case R.id.option_logout:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
