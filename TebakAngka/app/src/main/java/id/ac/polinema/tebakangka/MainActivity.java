package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
 import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	int angka_random;
	private EditText inputangka;
	private TextView outputText;
	private Button btn_guess;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		inputangka = findViewById(R.id.number_input);
		btn_guess = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random rand = new Random();

		int n = rand.nextInt(50) + 1;
		angka_random = n;

	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka

		String S_tebak_angka = inputangka.getText().toString();
		int tebak_angka = Integer.parseInt(S_tebak_angka);

		if(tebak_angka < angka_random)
		{
			//outputText.setText("angka terlalu kecil");
			Toast.makeText(this, "angka terlalu kecil", Toast.LENGTH_SHORT).show();
		}
		else if(tebak_angka > angka_random)
		{
			//outputText.setText("angka terlalu besar");
			Toast.makeText(this, "angka terlalu besar", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//outputText.setText("tebakan benar");
			Toast.makeText(this, "tebakan benar", Toast.LENGTH_SHORT).show();
			inputangka.setEnabled(false);
			btn_guess.setEnabled(false);
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		inputangka.setText("");
		initRandomNumber();
		inputangka.setEnabled(true);
		inputangka.setText("");
		btn_guess.setEnabled(true);
	}
}
