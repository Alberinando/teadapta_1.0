package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import android.content.Intent;

import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import android.net.Uri;

import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ficha_de_acompanhamento extends AppCompatActivity {

    private AutoCompleteTextView escolha;
    private TextInputEditText inputNome;
    private TextInputEditText RelatorioIdade;
    private TextInputEditText inform;
    private TextInputEditText ad;
    private TextInputEditText aulaRealizado;
    private TextInputEditText aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_de_acompanhamento);

        escolha = findViewById(R.id.escolha);
        inputNome = findViewById(R.id.inputNome);
        RelatorioIdade = findViewById(R.id.RelatorioIdade);
        inform = findViewById(R.id.inform);
        ad = findViewById(R.id.ad);
        aulaRealizado = findViewById(R.id.aulaRealizado);
        aula = findViewById(R.id.aula);

        //Escolha do Gênero
        String[] listaEscolha = getResources().getStringArray(R.array.Genero);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);

        Button enviarButton = findViewById(R.id.enviar);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAndSharePDF();
            }
        });
    }

    private void generateAndSharePDF() {
        try {
            String pdfFilePath = generatePDF(); // Gere o PDF

            File pdfFile = new File(pdfFilePath);
            Uri pdfUri = FileProvider.getUriForFile(this, "com.example.teadapta.fileprovider", pdfFile);

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, pdfUri);
            shareIntent.setType("application/pdf");
            startActivity(Intent.createChooser(shareIntent, "Compartilhar PDF"));

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao gerar o PDF.", Toast.LENGTH_SHORT).show();
        }
    }

    private String generatePDF() throws IOException {
        String pdfFilePath = getExternalFilesDir(null) + "/Relatório TEADAPTA.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(pdfFilePath));
        Document document = new Document(pdfDocument);


        String genero = escolha.getText().toString();
        String nome = inputNome.getText().toString();
        String idade = RelatorioIdade.getText().toString();
        String informacoesGerais = inform.getText().toString();
        String adaptacoes = ad.getText().toString();
        String aulaRealizada = aulaRealizado.getText().toString();
        String sugestoes = aula.getText().toString();

        PdfFont font = PdfFontFactory.createFont();
        Style titleStyle = new Style()
                .setFont(font)
                .setFontSize(24)
                .setBold()
                .setFontColor(DeviceGray.BLACK);
        Paragraph title = new Paragraph("Relatório TEADAPTA")
                .addStyle(titleStyle)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER);

        Style labelStyle = new Style()
                .setFont(font)
                .setFontSize(12) // Tamanho da fonte dos rótulos
                .setBold()
                .setFontColor(DeviceGray.BLACK);

        document.add(title);
        Paragraph nameLabel = new Paragraph()
                .add(new Text("Nome: ").addStyle(labelStyle))
                .add(new Text(nome))
                .setTextAlignment(TextAlignment.LEFT);
        document.add(nameLabel);

        Paragraph generoLabel = new Paragraph()
                .add(new Text("Gênero: ").addStyle(labelStyle))
                .add(new Text(genero))
                .setTextAlignment(TextAlignment.LEFT);
        document.add(generoLabel);

        Paragraph idadeLabel = new Paragraph()
                .add(new Text("Idade: ").addStyle(labelStyle))
                .add(new Text(idade))
                .add(new Text(" anos"))
                .setTextAlignment(TextAlignment.LEFT);
        document.add(idadeLabel);

        Paragraph InfoGeral = new Paragraph()
                .add(new Text("Informações Gerais: ").addStyle(labelStyle))
                .add(new Text(informacoesGerais))
                .setTextAlignment(TextAlignment.JUSTIFIED);
        document.add(InfoGeral);

        Paragraph Adaptacao = new Paragraph()
                .add(new Text("Adaptações: ").addStyle(labelStyle))
                .add(new Text(adaptacoes))
                .setTextAlignment(TextAlignment.JUSTIFIED);
        document.add(Adaptacao);

        Paragraph Aula = new Paragraph()
                .add(new Text("Aula Realizada: ").addStyle(labelStyle))
                .add(new Text(aulaRealizada))
                .setTextAlignment(TextAlignment.JUSTIFIED);
        document.add(Aula);

        Paragraph Sugestao = new Paragraph()
                .add(new Text("Sugestões: ").addStyle(labelStyle))
                .add(new Text(sugestoes))
                .setTextAlignment(TextAlignment.JUSTIFIED);
        document.add(Sugestao);

        document.close();
        return pdfFilePath;
    }

    public void showHelpDialog(View view) {
        // Obtém o texto de ajuda que você deseja exibir
        String textoAjuda = "Identifique os pontos fortes e áreas de desenvolvimento, por exemplo, pode ser útil avaliar as habilidades de comunicação, interação social, comportamento e aprendizagem. Também é importante destacar quaisquer estratégias que foram eficazes no apoio ao aluno.";

        // Cria um AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajuda");
        builder.setMessage(textoAjuda);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        // Exibe o AlertDialog
        dialog.show();
    }

    public void showHelpDialog2(View view) {
        // Obtém o texto de ajuda que você deseja exibir
        String textoAjuda = "Descreva resumidamente qual foi o objetivo da aula, bem como os procedimentos metodológicos utilizados.";

        // Cria um AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajuda");
        builder.setMessage(textoAjuda);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        // Exibe o AlertDialog
        dialog.show();
    }

    public void showHelpDialog3(View view) {
        // Obtém o texto de ajuda que você deseja exibir
        String textoAjuda = "Descreva as adaptações que foram necessárias para a execução da aula.";

        // Cria um AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajuda");
        builder.setMessage(textoAjuda);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        // Exibe o AlertDialog
        dialog.show();
    }

    public void showHelpDialog4(View view) {
        // Obtém o texto de ajuda que você deseja exibir
        String textoAjuda = "Fornecer sugestões para atividades ou estratégias específicas que podem ser implementadas para apoiar o aluno. Além disso, pode ser útil discutir formas de envolver os pais e outros profissionais no processo de apoio ao aluno.";

        // Cria um AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajuda");
        builder.setMessage(textoAjuda);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        // Exibe o AlertDialog
        dialog.show();
    }
}