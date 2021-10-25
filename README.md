# week3_day1_GeoQuiz
Part1: 
In the GeoQuize app:
1- change the text size 
2 -text color 
3- give margin to the buttons
---------------------------------------------
Part2: 
Customizing the Toast 
For this challenge, customize the toast to show at the top instead of the bottom of the screen.
To change how the toast is displayed, use the Toast class’s setGravity function. Use Gravity.TOP for the gravity value. 
Refer to the developer documentation at developer.android.com/reference/kotlin/android/widget/Toast#setgravity for more details.
////
i did all the requirement in below: +the challenge one
 <Button
            android:id="@+id/true_button"
            style="@style/Widget.AppCompat.Button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="20dp"
            android:layout_weight="1"
            android:shadowColor="#B388FF"
            android:text="@string/true_button"
            android:textColor="#D0D3D5"
            android:textSize="20sp"
            android:textStyle="bold|italic" />