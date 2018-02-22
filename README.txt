FactApp version 1.0

README

	FactApp is an Android application that pulls and displays random facts from our firebase database.
	Developed using Android Studio version 3.0.1. 
	
	Main funtions for the user are : 
		*view one random fact;
		*add the displayed to favorites;
		*vote for the fact '+' or '-';
		*view his favorite facts;
		*view Top facts based on the rating;
		*add new fatcs to the database for all other users to see. 

AUTHORS
	
	Creators of this code are Anatolij Putimcev, Pēteris Bērziņš, Kiril Putimcev, Mārtiņs Vītols, Helēna Zvirbule

REQUIREMENTS

	For the app to function the device must have an Android API version 24 or higher. It won't work
	on older versions. 

INSTALLATION

	To run this project in your own Android Studio just download the files anywhere on your device 
	where you store your projects and file -> Open and find the folder where you downloaded all of
	the files.

	To connect the app to your own google Firebase in Android Studio under tools there is Firebase - 
	select that and folow the steps provided there. Only play where you manually have to change this
	link is in the class AddFact.java there is a String variable named DBUrl. 

