
package com.android.example.eyehub_proto;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;


public class MainFragment extends Fragment implements RecognitionListener {


    private final String TAG = "MainFragment";

    private AlertDialog.Builder alertDialogBuilder;
    private TextView  disleksiHazirText, disleksiTestText;
    private LinearLayout baslaLayout, deleteLayout;
    private TextView micTextView;
    private final int REQ_CODE_SPEECH_INPUT = 155;
    private SpeechRecognizer speech = null;
    boolean performingSpeechSetup = false;
    boolean started = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        disleksiHazirText = view.findViewById(R.id.disleksiHazirText);
        disleksiTestText = view.findViewById(R.id.disleksiTestText);
        baslaLayout = view.findViewById(R.id.baslaLayout);
        micTextView = view.findViewById(R.id.micTextView);
        deleteLayout = view.findViewById(R.id.deleteLayout);

        speech = SpeechRecognizer.createSpeechRecognizer(getContext());
        speech.setRecognitionListener(this);

        mic();

        clearTextView();

    }

    private void clearTextView() {

        deleteLayout.setOnClickListener(view -> {

            if (!disleksiTestText.getText().toString().isEmpty()) {

                alertDialogBuilder = new AlertDialog.Builder(requireContext());

                alertDialogBuilder.setTitle("Metni Sil");
                alertDialogBuilder.setMessage("Sonuç metnini silmek istediğinize emin misiniz?");

                alertDialogBuilder.setPositiveButton("Sil", (dialog, which) -> disleksiTestText.setText(""));

                alertDialogBuilder.setNegativeButton("Vazgeç", (dialog, which) -> dialog.cancel());

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (speech != null) {
            speech.destroy();
            Log.i(TAG, "destroy");
        }
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "getString(R.string.speech_prompt)");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(requireActivity().getApplicationContext(),
                    "Speech not supported!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    assert result != null;
                    Log.e(TAG,"result string: " + result.get(0));

                }
                break;
            }

        }
    }



    @Override
    public void onReadyForSpeech(Bundle bundle) {
        Log.e(TAG,"onReadyForSpeech");
        performingSpeechSetup = true;

    }

    @Override
    public void onBeginningOfSpeech() {
        Log.e(TAG,"onBeginningOfSpeech");

    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {
        Log.e(TAG,"onEndOfSpeech");
        //speech.stopListening();

    }

    @Override
    public void onError(int i) {
        if (!performingSpeechSetup) return;

        Log.e(TAG,"onError: " + i);
    }

    @Override
    public void onResults(Bundle bundle) {
        Log.i(TAG,"onResults");

        ArrayList<String> matches = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        //Log.i(TAG,"matches: " + matches.get(0));

        double acc = BenzerlikHesaplama.jaccardBenzerlik(disleksiTestText.getText().toString(),disleksiHazirText.getText().toString());
        Log.i(TAG,"acc: " + acc);

        showResultDialog(acc);
    }

    private void showResultDialog(double acc) {

        final Dialog dialog = new Dialog(requireActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sonuc_dialog_layout);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView sonucText = dialog.findViewById(R.id.sonucText);
        AppCompatButton gonderButton = dialog.findViewById(R.id.gonderButton);

        DecimalFormat df = new DecimalFormat("#.##");
        String formatliSayi = df.format(acc);
        String sonSonuc = "%" + formatliSayi;

        sonucText.setText(sonSonuc);


        dialog.show();
    }

    private String currentPartialResult = "";

    private void mic() {

        baslaLayout.setOnClickListener(view -> {

            //promptSpeechInput();
            Log.i(TAG,"mic clicked");

            if (ContextCompat.checkSelfPermission(requireActivity(),
                    android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(requireActivity(), new String[]{android.Manifest.permission.RECORD_AUDIO},1);

            } else {

                if (!started){

                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
                    intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

                    //intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 60000);
                    intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 60000);

                    intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");
                    speech.startListening(intent);
                    baslaLayout.setActivated(true);
                    micTextView.setText("Bitir");
                    deleteLayout.setVisibility(View.GONE);

                } else {

                    speech.stopListening();
                    baslaLayout.setActivated(false);
                    micTextView.setText("Başla");
                    deleteLayout.setVisibility(View.VISIBLE);

                }


                started = !started;

            }



        });


    }

    @Override
    public void onPartialResults(Bundle bundle) {
        ArrayList<String> partials = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        /*if (disleksiTestText != null && partials != null && !partials.isEmpty()) {

            Log.i(TAG,"partials-2 partially: " + partials.get(0));
            disleksiTestText.append(partials.get(0));

        }*/

        if (partials != null && !partials.isEmpty()) {
            String partialText = partials.get(0).toLowerCase(Locale.getDefault());
            Log.i(TAG,"partialText: " + partials.get(0));
            Log.i(TAG,"currentPartialResult: " + currentPartialResult);

            if (partialText.contains(currentPartialResult)) {

                String differentPart = partialText.replace(currentPartialResult, "").trim();

                currentPartialResult = partialText;

                Log.i(TAG,"yazdırılan differentPart: " + differentPart);

                if (!differentPart.isEmpty()) {
                    disleksiTestText.append(differentPart + " ");
                }
            } else if (!partialText.isEmpty()){

                Log.i(TAG,"yazdırılan kısım: " + partialText);

                currentPartialResult = partialText;
                disleksiTestText.append(partialText + " ");
            }

            /*else if (!partialText.isEmpty()){
                currentPartialResult = partialText;
                disleksiTestText.append(partialText + " ");
            }*/
        }
    }






    @Override
    public void onEvent(int i, Bundle bundle) {
        Log.e(TAG,"onEvent");

    }
}