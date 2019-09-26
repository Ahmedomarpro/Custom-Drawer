package com.ao.drawview;

import android.annotation.SuppressLint;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.turkialkhateeb.materialcolorpicker.ColorChooserDialog;
import com.turkialkhateeb.materialcolorpicker.ColorListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


	@BindView(R.id.customCanvasX)
	CustomCanvasForDraw customCanvasForDraw;

	@BindView(R.id.resetButton)
	Button resetButton;

	@BindView(R.id.sizeMinusButton)
	Button sizeMinusButton;

	@BindView(R.id.sizePlusButton)
	Button sizePlusButton;

	@BindView(R.id.colorButton)
	Button colorButton;

	@BindView(R.id.undoButton)
	Button undoButton ;

	@SuppressLint("ClickableViewAccessibility")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ButterKnife.bind(this);

//		customCanvasForDraw.setDebugEnabled(true);

		listeners();

	}

	private void listeners() {
		resetButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				resetView();
			}
		});

		sizeMinusButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				customCanvasForDraw.increaseWidth(true);
			}
		});

		sizePlusButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				customCanvasForDraw.increaseWidth(false);
			}
		});

		colorButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				ColorChooserDialog dialog = new ColorChooserDialog(MainActivity.this);
				dialog.setTitle("Select Color");
				dialog.setColorListener(new ColorListener() {
					@Override
					public void OnColorClick(View v, int color) {
						//do whatever you want to with the values
						customCanvasForDraw.changeColor(color);
					}
				});
				//customize the dialog however you want
				dialog.show();
			}
		});

		undoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				customCanvasForDraw.undoView();
			}
		});
	}

	private void resetView() {
		customCanvasForDraw.resetView();
	}


}
