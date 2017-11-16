package com.example.jsb.ms_lab10_201302476_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    PaintBoard board;
    Button colorBtn, penBtn, eraserBtn, undoBtn;

    LinearLayout addedLayout;
    Button colorLegendBtn;
    TextView sizeLegendTxt;

    int mColor = 0xff000000;
    int mSize = 2;
    int oldColor;
    int oldSize;
    boolean eraserSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout toolsLayout = (LinearLayout) findViewById(R.id.toolsLayout);
        LinearLayout boardLayout = (LinearLayout) findViewById(R.id.boardLayout);
        colorBtn = (Button) findViewById(R.id.colorBtn);
        penBtn = (Button) findViewById(R.id.penBtn);
        eraserBtn = (Button) findViewById(R.id.eraserBtn);
        undoBtn = (Button) findViewById(R.id.undoBtn);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        board = new PaintBoard(this);
        board.setLayoutParams(params);
        board.setPadding(2,2,2,2);

        boardLayout.addView(board);

        LinearLayout.LayoutParams addedParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 48);

        addedLayout = new LinearLayout(this);
        addedLayout.setLayoutParams(addedParams);
        addedLayout.setOrientation(LinearLayout.VERTICAL);
        addedLayout.setPadding(8, 8, 8, 8);
        LinearLayout outlineLayout = new LinearLayout(this);
        outlineLayout.setLayoutParams(buttonParams);
        outlineLayout.setOrientation(LinearLayout.VERTICAL);
        outlineLayout.setBackgroundColor(Color.LTGRAY);
        outlineLayout.setPadding(1, 1, 1, 1);
        colorLegendBtn = new Button(this);
        colorLegendBtn.setLayoutParams(buttonParams);
        colorLegendBtn.setText(" ");
        colorLegendBtn.setBackgroundColor(mColor);
        colorLegendBtn.setHeight(20);
        outlineLayout.addView(colorLegendBtn);
        addedLayout.addView(outlineLayout);
        sizeLegendTxt = new TextView(this);
        sizeLegendTxt.setLayoutParams(buttonParams);
        sizeLegendTxt.setText("Size : " + mSize);
        sizeLegendTxt.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        sizeLegendTxt.setTextSize(12);
        sizeLegendTxt.setTextColor(Color.BLACK);
        addedLayout.addView(sizeLegendTxt);
        toolsLayout.addView(addedLayout);

        colorBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ColorPaletteDialog.listener = new OnColorSelectedListener(){
                    public void onColorSelected(int color){
                        mColor = color;
                        board.updatePaintProperty(mColor, mSize);
                        displayPaintProperty();
                    }
                };
                Intent intent = new Intent(getApplicationContext(), ColorPaletteDialog.class);
                startActivity(intent);
            }

        });

        penBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PenPaletteDialog.listener = new OnPenSelectedListener(){
                    public void onPenSelected(int size){
                        mSize = size;
                        board.updatePaintProperty(mColor, mSize);
                        displayPaintProperty();
                    }
                };
                Intent intent = new Intent(getApplicationContext(), PenPaletteDialog.class);
                startActivity(intent);
            }
        });

        eraserBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                eraserSelected = !eraserSelected;

                if(eraserSelected){
                    colorBtn.setEnabled(false);
                    penBtn.setEnabled(false);
                    undoBtn.setEnabled(false);

                    colorBtn.invalidate();
                    penBtn.invalidate();
                    undoBtn.invalidate();

                    oldColor = mColor;
                    oldSize = mSize;

                    mColor = Color.WHITE;
                    mSize = 15;

                    board.updatePaintProperty(mColor, mSize);
                    displayPaintProperty();
                }

                else{
                    colorBtn.setEnabled(true);
                    penBtn.setEnabled(true);
                    undoBtn.setEnabled(true);

                    colorBtn.invalidate();
                    penBtn.invalidate();
                    undoBtn.invalidate();

                    mColor = oldColor;
                    mSize = oldSize;

                    board.updatePaintProperty(mColor, mSize);
                    displayPaintProperty();
                }
            }
        });

        undoBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                board.undo();
            }
        });
    }

    public int getChosenColor(){return mColor;}
    public int getPenThickness(){return mSize;}
    private void displayPaintProperty(){
        colorLegendBtn.setBackgroundColor(mColor);
        sizeLegendTxt.setText("Size : " + mSize);

        addedLayout.invalidate();
    }
}
