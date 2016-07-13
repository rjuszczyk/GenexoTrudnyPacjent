package com.mygdx.genexotrudnypacjent;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mygdx.genexotrudnypacjent.model.UserData;
import com.mygdx.genexotrudnypacjent.util.SoundHelper;

public class AndroidLauncher extends AppCompatActivity {
	UserData mUserData;
	SoundHelper mSoundHelper;
	boolean pyt3_ok = false;
	boolean pyt2_ok = false;
	boolean pyt1_ok = false;

	void updateDalej() {
		if(pyt1_ok && pyt2_ok && pyt3_ok) {
			next.setAlpha(1f);
		} else {
			next.setAlpha(0.5f);
		}
	}

	View.OnClickListener mOnClickLisener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.pyt3_1:
					if(!pyt3_ok) {
						pyt3.getHandler().removeCallbacksAndMessages(null);
						pyt3.setImageResource(R.drawable.pyt3_wrong1);
						okbad3.setVisibility(View.VISIBLE);

						pyt3.getHandler().postDelayed(new Runnable() {
							@Override
							public void run() {
								okbad3.setVisibility(View.INVISIBLE);
								pyt3.setImageResource(R.drawable.pyt3);
							}
						}, 2000);
						mSoundHelper.play(R.raw.negative);
					}
					break;
				case R.id.pyt3_2:
					if(!pyt3_ok) {
						pyt3.getHandler().removeCallbacksAndMessages(null);
						pyt3.setImageResource(R.drawable.pyt3_wrong2);
						okbad3.setVisibility(View.VISIBLE);
						pyt3.getHandler().postDelayed(new Runnable() {
							@Override
							public void run() {
								okbad3.setVisibility(View.INVISIBLE);
								pyt3.setImageResource(R.drawable.pyt3);
							}
						}, 2000);
						mSoundHelper.play(R.raw.negative);
					}
					break;
				case R.id.pyt3_3:
					if(!pyt3_ok) {
						pyt3.getHandler().removeCallbacksAndMessages(null);
						pyt3.setImageResource(R.drawable.pyt3_ok);
						pyt3_ok = true;
						okbad3.setVisibility(View.VISIBLE);
						okbad3.setImageResource(R.drawable.brawo);
						img3.setImageResource(R.drawable.brawo3);
						mSoundHelper.play(R.raw.positive);
						updateDalej();
					}
					break;


				case R.id.pyt2_1:
					if(!pyt2_ok) {
						pyt2.getHandler().removeCallbacksAndMessages(null);
						pyt2.setImageResource(R.drawable.pyt2_wrong1);
						okbad2.setVisibility(View.VISIBLE);
						pyt2.getHandler().postDelayed(new Runnable() {
							@Override
							public void run() {
								okbad2.setVisibility(View.INVISIBLE);
								pyt2.setImageResource(R.drawable.pyt2);
							}
						}, 2000);
						mSoundHelper.play(R.raw.negative);
					}
					break;
				case R.id.pyt2_2:
					if(!pyt2_ok) {
						pyt2.getHandler().removeCallbacksAndMessages(null);
						pyt2.setImageResource(R.drawable.pyt2_wrong2);
						okbad2.setVisibility(View.VISIBLE);
						pyt2.getHandler().postDelayed(new Runnable() {
							@Override
							public void run() {
								okbad2.setVisibility(View.INVISIBLE);
								pyt2.setImageResource(R.drawable.pyt2);
							}
						}, 2000);
						mSoundHelper.play(R.raw.negative);
					}
					break;
				case R.id.pyt2_3:
					if(!pyt2_ok) {
						pyt2.getHandler().removeCallbacksAndMessages(null);
						pyt2.setImageResource(R.drawable.pyt2_ok);
						pyt2_ok = true;
						okbad2.setVisibility(View.VISIBLE);
						okbad2.setImageResource(R.drawable.brawo);
						img2.setImageResource(R.drawable.brawo2);
						mSoundHelper.play(R.raw.positive);
						updateDalej();
					}
					break;

				case R.id.pyt1_1:
					if(!pyt1_ok) {
						pyt1.getHandler().removeCallbacksAndMessages(null);
						pyt1.setImageResource(R.drawable.pyt1_wrong1);
						okbad1.setVisibility(View.VISIBLE);
						pyt1.getHandler().postDelayed(new Runnable() {
							@Override
							public void run() {
								okbad1.setVisibility(View.INVISIBLE);
								pyt1.setImageResource(R.drawable.pyt1);
							}
						}, 2000);
						mSoundHelper.play(R.raw.negative);
					}
					break;
				case R.id.pyt1_2:
					if(!pyt1_ok) {
						pyt1.getHandler().removeCallbacksAndMessages(null);
						okbad1.setVisibility(View.VISIBLE);
						pyt1.setImageResource(R.drawable.pyt1_wrong2);
						pyt1.getHandler().postDelayed(new Runnable() {
							@Override
							public void run() {
								okbad1.setVisibility(View.INVISIBLE);
								pyt1.setImageResource(R.drawable.pyt1);
							}
						}, 2000);
						mSoundHelper.play(R.raw.negative);
					}
					break;
				case R.id.pyt1_3:
					if(!pyt1_ok) {
						pyt1.getHandler().removeCallbacksAndMessages(null);
						pyt1.setImageResource(R.drawable.pyt1_ok);
						okbad1.setVisibility(View.VISIBLE);
						okbad1.setImageResource(R.drawable.brawo);
						pyt1_ok = true;
						img1.setImageResource(R.drawable.brawo1);
						mSoundHelper.play(R.raw.positive);
						updateDalej();
					}
					break;
			}
		}
	};

	private ImageView img3;
	private ImageView img2;
	private ImageView img1;
	
	private ImageView pyt3;
	private ImageView pyt2;
	private ImageView pyt1;

	private ImageView prosimy3;
	private ImageView prosimy2;
	private ImageView prosimy1;

	private ImageView okbad1;
	private ImageView okbad2;
	private ImageView okbad3;
	
	private View next;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mSoundHelper = SoundHelper.getInstance(this);
		mSoundHelper.load(R.raw.positive);
		mSoundHelper.load(R.raw.negative);

		mSoundHelper.load(R.raw.brawo);
		setContentView(R.layout.question_activity);



		pyt3 = (ImageView) findViewById(R.id.pyt3);
		pyt2 = (ImageView) findViewById(R.id.pyt2);
		pyt1 = (ImageView) findViewById(R.id.pyt1);

		prosimy3 = (ImageView) findViewById(R.id.prosimy3);
		prosimy2 = (ImageView) findViewById(R.id.prosimy2);
		prosimy1 = (ImageView) findViewById(R.id.prosimy1);

		prosimy1.setVisibility(View.INVISIBLE);
		prosimy2.setVisibility(View.INVISIBLE);
		prosimy3.setVisibility(View.INVISIBLE);


		img3 = (ImageView) findViewById(R.id.img3);
		img2 = (ImageView) findViewById(R.id.img2);
		img1 = (ImageView) findViewById(R.id.img1);

		okbad3 = (ImageView) findViewById(R.id.okbad3);
		okbad2 = (ImageView) findViewById(R.id.okbad2);
		okbad1 = (ImageView) findViewById(R.id.okbad1);
		okbad1.setVisibility(View.INVISIBLE);
		okbad2.setVisibility(View.INVISIBLE);
		okbad3.setVisibility(View.INVISIBLE);

		next = findViewById(R.id.next);
		next.setAlpha(0.5f);

		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(pyt1_ok && pyt2_ok && pyt3_ok) {
					gotoNext();
				} else {
					prosimy1.setVisibility(View.VISIBLE);
					prosimy2.setVisibility(View.VISIBLE);
					prosimy3.setVisibility(View.VISIBLE);
					next.getHandler().postDelayed(new Runnable() {
						@Override
						public void run() {
							prosimy1.setVisibility(View.INVISIBLE);
							prosimy2.setVisibility(View.INVISIBLE);
							prosimy3.setVisibility(View.INVISIBLE);
						}
					}, 2000);
				}

			}
		});

		findViewById(R.id.pyt3_1).setOnClickListener(mOnClickLisener);
		findViewById(R.id.pyt3_2).setOnClickListener(mOnClickLisener);
		findViewById(R.id.pyt3_3).setOnClickListener(mOnClickLisener);

		findViewById(R.id.pyt2_1).setOnClickListener(mOnClickLisener);
		findViewById(R.id.pyt2_2).setOnClickListener(mOnClickLisener);
		findViewById(R.id.pyt2_3).setOnClickListener(mOnClickLisener);

		findViewById(R.id.pyt1_1).setOnClickListener(mOnClickLisener);
		findViewById(R.id.pyt1_2).setOnClickListener(mOnClickLisener);
		findViewById(R.id.pyt1_3).setOnClickListener(mOnClickLisener);

		if(getIntent()!=null) {
			mUserData = (UserData) getIntent().getSerializableExtra("user_data");
		//	Log.d("user data", mUserData.toString());
		}

//		MyGdxGame.Sex sex;
//		if(mUserData.getImie().endsWith("a")) {
//			sex = MyGdxGame.Sex.FEMALE;
//		} else {
//			sex = MyGdxGame.Sex.MALE;
//		}


	}


	@Override
	protected void onResume() {
		super.onResume();
	}

	private void gotoNext() {
		Intent intent = new Intent(this, SendingDataActivity.class);
		intent.putExtra("user_data", mUserData);
		finish();
		startActivity(intent);
	}
}
