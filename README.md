#Do Re Tone guitar helper
Version 1.2.0

###Description
Swing based application that helps to learn guitar.

###Java version
1.8

#Configuration
No configuration available 

#Usage
###Build and Run 
- Build with IDE to executable jar. 
- Run from command line or double-click using Java SE binary.

###In the application:
- Select time interval after which new random chord will appear
- Press Generate button

####Interval legends table
Shows interval length its name and notation that one can stumble upon in internet or tabulature.

####Guitar neck\fretboard pane
When each chord is generated, notes are colored in the  respective color from Interval legends table, to display intervals from current tonic of the chord.

#Documentation
TBD 

#TODO 
####topic - estimated complexity to implement
- Interval info table - 1 
- Interval neck mapping - 5
- Chord to note breakdown - 3
- Introduce logging
- Move to system of classes that represents Note , Chord, Scale
- Introduce scales 

#Changelog

###1.0.0
- Base implementation. Application can generate random chord with specified time interval

###1.2.0
- Interval legends pane added.
- Guitar neck\fretboard pane is added
- Application now shows intervals from the tonic of a chord on guitar fretboard 