package com.example.hanikok;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;

public class ProfilePictureActivity extends ImageSelectHelperActivity {

	ActionBar actionBar = null; // 액션바 세팅 시작

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_picture);

		findViewById(R.id.image_upload_btn).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// setImageSizeBoundary(400); // optional. default is
						// 500.
						// setCropOption(1, 1); // optional. default is no crop.
						// setCustomButtons(btnGallery, btnCamera, btnCancel);
						// // you can set these buttons.
						startSelectImage();
					}
				});

		getSelectedImageFile(); // extract selected & saved image file.
	}
}
