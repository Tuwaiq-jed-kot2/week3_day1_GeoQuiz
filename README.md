# week3_day1_GeoQuiz
Part1: 
In the GeoQuize app:
1- change the text size, New text size is set to 21sp
2 -text color, New text color is set to purple_700
3- give margin to the buttons, trueButton right-margin is 10dp, falseButton left margin is 10dp
---------------------------------------------
Part2: 
Customizing the Toast 
For this challenge, customize the toast to show at the top instead of the bottom of the screen.
To change how the toast is displayed, use the Toast class’s setGravity function. Use Gravity.TOP for the gravity value. 
Refer to the developer documentation at developer.android.com/reference/kotlin/android/widget/Toast#setgravity for more details.

As it said in Android documentation about Toast setGravity method, this method doesn't work anymore for devices
running API30 or higher.